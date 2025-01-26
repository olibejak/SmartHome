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
import cz.cvut.fel.omo.event.eventManager.EventManager;
import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

import static cz.cvut.fel.omo.BobTheBuilder.HouseLoader.*;
import static cz.cvut.fel.omo.event.EventType.*;
import static java.util.Objects.nonNull;

/**
 * Facade for building a house using house, floor, room builders and room object factories.
 */
@Log4j2
public class HouseBuilderFacade {

    private final EventManager eventManager;
    private final DeviceFactoryRegistry deviceFactoryRegistry;
    private final EquipmentFactoryRegistry sportEquipmentFactoryRegistry;
    private final VehicleFactoryRegistry vehicleFactoryRegistry;
    private final GlobalLogger logger;

    public HouseBuilderFacade(EventManager eventManager) {
        this.eventManager = eventManager;
        this.deviceFactoryRegistry = populateDeviceFactoryRegistry(new DeviceFactoryRegistry(eventManager));
        this.sportEquipmentFactoryRegistry = populateSportEquipmentFactoryRegistry(new EquipmentFactoryRegistry());
        this.vehicleFactoryRegistry = populateVehicleFactoryRegistry(new VehicleFactoryRegistry());
        logger = GlobalLogger.getInstance();
    }


    /**
     * Builds a house from a JSON file.
     * If the file is not found or is invalid, default house is built.
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

        House house = new HouseBuilder().reset()
                .addFloors(buildFloors(houseDTO.getFloors()))
                .build();

        logger.info(house.reportConfiguration());

        return house;

    }

    /**
     * Builds floors from floor DTOs
     * @param floorDTOs array of floor DTOs
     * @return list of floors
     */
    private ArrayList<Floor> buildFloors(@NonNull FloorDTO[] floorDTOs) {
        int floorNumber = 0;
        ArrayList<Floor> floors = new ArrayList<>();
        for (FloorDTO floorDTO : floorDTOs) {
            floors.add(
                    new FloorBuilder().reset(floorNumber)
                    .addRooms(buildRooms(floorDTO.getRooms(), floorNumber++))
                    .build()
            );
        }
        return floors;
    }

    /**
     * Builds rooms from room DTOs
     * @param roomDTOs array of room DTOs
     * @param floorNumber number of the floor
     * @return list of rooms
     */
    private ArrayList<Room> buildRooms(@NonNull RoomDTO[] roomDTOs, int floorNumber) {
        int baseRoomId = (floorNumber * 100);
        ArrayList<Room> rooms = new ArrayList<>();
        for (RoomDTO roomDTO : roomDTOs) {
            int roomId = ++baseRoomId;
            if (roomId >= (floorNumber + 1) * 100) {
                logger.warn("Maximum rooms on a floor reached, skipping rest of the rooms on the floor.");
                break;
            }
            Room room = new RoomBuilder().reset(roomId)
                    .setRoomType(roomDTO.getType())
                    .addDevices(
                            buildItems(roomDTO.getDevices(),
                                    deviceDTO -> createRoomObject(roomId, deviceDTO, deviceFactoryRegistry)
                            ))
                    .addVehicles(
                            buildItems(roomDTO.getVehicles(),
                                    vehicleDTO -> createRoomObject(roomId, vehicleDTO, vehicleFactoryRegistry)
                            ))
                    .addSportEquipment(
                            buildItems(
                                    roomDTO.getEquipment(),
                                    equipmentDTO -> createRoomObject(roomId, equipmentDTO, sportEquipmentFactoryRegistry)
                            ))
                    .build();
            eventManager.subscribe(DEVICE_EMPTY, room);
            eventManager.subscribe(DEVICE_FULL, room);
            eventManager.subscribe(DEVICE_BROKEN, room);
            eventManager.subscribe(DEVICE_FINISHED, room);
            rooms.add(room);
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
     * Creates a room object from a DTO
     * @param dto room object DTO
     * @param roomId ID of the room were the object is placed
     * @return room object instance
     * @param <T> Room object type
     */
    private <T, D> T createRoomObject(Integer roomId, @NonNull D dto, @NonNull FactoryRegistry<T,D> factoryRegistry) {
        return factoryRegistry.createObject(dto, roomId);
    }
}