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
import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.NonNull;

import java.io.IOException;
import java.util.ArrayList;

import static java.util.Objects.nonNull;

public class HouseBuilderFacade {

    private final HouseLoader houseLoader = new HouseLoader();

    GlobalLogger logger = GlobalLogger.getInstance();

    public House buildHouseFromJson(@NonNull String filePath) {
        HouseDTO houseDTO;

        try {
            houseDTO = houseLoader.loadHouseDTOFromJson(filePath);
        } catch (IOException e) {
            logger.error("Error while building house from JSON file: " + e.getMessage());
            return null;
        }

        return new HouseBuilder().reset()
                .addFloors(buildFloors(houseDTO))
                .build();

    }

    private ArrayList<Floor> buildFloors(HouseDTO houseDTO) {
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

    private ArrayList<Room> buildRooms(FloorDTO floorDTO, int floorNumber) {
        int roomId = (floorNumber * 100) - 1;
        ArrayList<Room> rooms = new ArrayList<>();
        for (RoomDTO roomDTO : floorDTO.getRooms()) {
                rooms.add(
                    new RoomBuilder().reset(roomId++)
                            .setRoomType(roomDTO.getType())
                            .addDevices(buildDevices(roomDTO))
                            .build()
            );
        }
        return rooms;
    }

    private ArrayList<Device> buildDevices(RoomDTO roomDTO) {
        ArrayList<Device> devices = new ArrayList<>();
        for (DeviceDTO deviceDTO : roomDTO.getDevices()) {
            Device device = createDevice(deviceDTO);
            if (nonNull(device)) {
                devices.add(device);
            }
        }
        return devices;
    }

    private Device createDevice(DeviceDTO deviceDTO) {
        switch (deviceDTO.getType()){
            case DISHWASHER -> {
                return new DishwasherFactory().createDevice(deviceDTO.getId());
            }
            case FRIDGE -> {
                return new FridgeFactory().createDevice(deviceDTO.getId());
            }
            case OVEN -> {
                return new OvenFactory().createDevice(deviceDTO.getId());
            }
            case RECORD_PLAYER -> {
                return new RecordPlayerFactory().createDevice(deviceDTO.getId());
            }
            case TELEVISION -> {
                return new TelevisionFactory().createDevice(deviceDTO.getId());
            }
            case THERMOSTAT -> {
                return new ThermostatFactory().createDevice(deviceDTO.getId());
            }
            case WASHING_MACHINE -> {
                return new WashingMachineFactory().createDevice(deviceDTO.getId());
            }
            case WINDOW -> {
                return new WindowFactory().createDevice(deviceDTO.getId());
            }
            default -> {
                logger.error("Unsupported device type");
                return null;
            }
        }
    }
}
