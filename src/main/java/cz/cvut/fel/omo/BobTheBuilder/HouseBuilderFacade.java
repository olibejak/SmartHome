package cz.cvut.fel.omo.BobTheBuilder;

import cz.cvut.fel.omo.BobTheBuilder.DTO.FloorDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.RoomDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.*;
import cz.cvut.fel.omo.BobTheBuilder.equipmentFactory.EquipmentFactoryRegistry;
import cz.cvut.fel.omo.BobTheBuilder.houseBuilder.FloorBuilder;
import cz.cvut.fel.omo.BobTheBuilder.houseBuilder.HouseBuilder;
import cz.cvut.fel.omo.BobTheBuilder.houseBuilder.RoomBuilder;
import cz.cvut.fel.omo.BobTheBuilder.vehicleFactory.VehicleFactoryRegistry;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

import static cz.cvut.fel.omo.BobTheBuilder.HouseLoader.*;
import static java.util.Objects.nonNull;

/**
 * Facade for building a house using house, floor, room builders and device factory
 */
public class HouseBuilderFacade {

    private final EventQueue eventQueue;
    private final DeviceFactoryRegistry deviceFactoryRegistry;
    private final EquipmentFactoryRegistry sportEquipmentFactoryRegistry;
    private final VehicleFactoryRegistry vehicleFactoryRegistry;
    private final GlobalLogger logger;

    public HouseBuilderFacade(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        this.deviceFactoryRegistry = populateDeviceFactoryRegistry(new DeviceFactoryRegistry(eventQueue));
        this.sportEquipmentFactoryRegistry = populateSportEquipmentFactoryRegistry(new EquipmentFactoryRegistry());
        this.vehicleFactoryRegistry = populateVehicleFactoryRegistry(new VehicleFactoryRegistry());
        logger = GlobalLogger.getInstance();
    }


    /**
     * Builds a house from a JSON file
     * @param filePath path to the JSON file
     * @return house built from the JSON file
     */
    public House buildHouseFromJson(@NonNull String filePath) {
        HouseDTO houseDTO;

        try {
            houseDTO = HouseLoader.loadHouseDTOFromJson(filePath);
        } catch (IOException e) {
            logger.error("Error while building house from JSON file: " + e.getMessage());
            houseDTO = HouseLoader.getDefaultHouseDTO();
        }

        return new HouseBuilder().reset()
                .addFloors(buildFloors(houseDTO))
                .build();

    }

    /**
     * Builds floors from a house DTO
     * @param houseDTO house DTO
     * @return list of floors
     */
    private ArrayList<Floor> buildFloors(@NonNull HouseDTO houseDTO) {
        int floorNumber = -1;
        ArrayList<Floor> floors = new ArrayList<>();
        for (FloorDTO floorDTO : houseDTO.getFloors()) {
            floors.add(
                    new FloorBuilder().reset(floorNumber++)
                    .addRooms(buildRooms(floorDTO, floorNumber))
                    .build()
            );
        }
        return floors;
    }

    /**
     * Builds rooms from a floor DTO
     * @param floorDTO floor DTO
     * @param floorNumber number of the floor
     * @return list of rooms
     */
    private ArrayList<Room> buildRooms(@NonNull FloorDTO floorDTO, int floorNumber) {
        int baseRoomId = (floorNumber * 100) - 1;
        ArrayList<Room> rooms = new ArrayList<>();
        for (RoomDTO roomDTO : floorDTO.getRooms()) {
            int roomId = ++baseRoomId;
                rooms.add(
                    new RoomBuilder().reset(roomId)
                            .setRoomType(roomDTO.getType())
                            .addDevices(
                                    buildItems(roomDTO.getDevices(),
                                    deviceDTO -> createObject(roomId, deviceDTO, deviceFactoryRegistry)
                                    ))
                            .addVehicles(
                                    buildItems(roomDTO.getVehicles(),
                                    vehicleDTO -> createObject(roomId, vehicleDTO, vehicleFactoryRegistry)
                                    ))
                            .addSportEquipment(
                                    buildItems(
                                            roomDTO.getEquipment(),
                                            equipmentDTO -> createObject(roomId, equipmentDTO, sportEquipmentFactoryRegistry)
                                    ))
                            .build()
            );
        }
        return rooms;
    }

    /**
     * Builds items from an array of DTOs
     * @param dtoArr array of DTOs
     * @param createItem function to create an item from a DTO
     * @return list of items
     * @param <D> DTO type
     * @param <T> returned item type
     */
    private <D, T> ArrayList<T> buildItems(D[] dtoArr, Function<D, T> createItem) {
        if (dtoArr == null || dtoArr.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<T> items = new ArrayList<>();
        for (D dto : dtoArr) {
            T item = createItem.apply(dto);
            if (nonNull(item)) {
                items.add(item);
            }
        }
        return items;
    }

    /**
     * Creates a device from a device DTO
     * @param dto device DTO
     * @param roomId ID of the room were the device is placed
     * @return device
     */
    private <T, D> T createObject(Integer roomId, @NonNull D dto, @NonNull FactoryRegistry<T,D> factoryRegistry) {
        return factoryRegistry.createObject(dto, roomId);
    }
}
