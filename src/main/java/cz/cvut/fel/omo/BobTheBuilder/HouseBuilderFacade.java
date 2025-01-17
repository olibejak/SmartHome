package cz.cvut.fel.omo.BobTheBuilder;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.FloorDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.RoomDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.*;
import cz.cvut.fel.omo.BobTheBuilder.houseBuilder.FloorBuilder;
import cz.cvut.fel.omo.BobTheBuilder.houseBuilder.HouseBuilder;
import cz.cvut.fel.omo.BobTheBuilder.houseBuilder.RoomBuilder;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.NonNull;

import java.io.IOException;
import java.util.ArrayList;

import static cz.cvut.fel.omo.BobTheBuilder.HouseLoader.populateDeviceFactoryRegistry;
import static java.util.Objects.nonNull;

/**
 * Facade for building a house using house, floor, room builders and device factory
 */
public class HouseBuilderFacade {

    private final EventQueue eventQueue;
    private final DeviceFactoryRegistry deviceFactoryRegistry;
    private final GlobalLogger logger;

    public HouseBuilderFacade(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        this.deviceFactoryRegistry = new DeviceFactoryRegistry(eventQueue);
        populateDeviceFactoryRegistry(deviceFactoryRegistry);
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
        int roomId = (floorNumber * 100) - 1;
        ArrayList<Room> rooms = new ArrayList<>();
        for (RoomDTO roomDTO : floorDTO.getRooms()) {
                rooms.add(
                    new RoomBuilder().reset(roomId++)
                            .setRoomType(roomDTO.getType())
                            .addDevices(buildDevices(roomId, roomDTO))
                            .build()
            );
        }
        return rooms;
    }

    /**
     * Builds devices from a room DTO
     * @param roomDTO room DTO
     * @return list of devices
     */
    private ArrayList<Device> buildDevices(int roomId, @NonNull RoomDTO roomDTO) {
        ArrayList<Device> devices = new ArrayList<>();
        for (DeviceDTO deviceDTO : roomDTO.getDevices()) {
            Device device = createDevice(deviceDTO, roomId);
            if (nonNull(device)) {
                devices.add(device);
            }
        }
        return devices;
    }

    /**
     * Creates a device from a device DTO
     * @param deviceDTO device DTO
     * @param roomId ID of the room were the device is placed
     * @return device
     */
    private Device createDevice(@NonNull DeviceDTO deviceDTO, int roomId) {
        if (deviceDTO.getType() == null) {
            logger.info("DeviceDTO type is null, skipping to next device");
            return null;
        }
        return deviceFactoryRegistry.createDevice(deviceDTO, roomId);
    }
}
