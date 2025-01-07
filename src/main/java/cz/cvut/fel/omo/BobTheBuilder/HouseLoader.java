package cz.cvut.fel.omo.BobTheBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.DeviceFactoryRegistry;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.strategy.*;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;

/**
 * Class for loading house and utility from different sources
 */
public class HouseLoader {

    /**
     * Load house from JSON file
     * @param filePath path to JSON file
     * @return HouseDTO object
     * @throws IOException if file is not found
     */
    public static HouseDTO loadHouseDTOFromJson(@NonNull String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), HouseDTO.class);
    }

    public static DeviceFactoryRegistry loadDeviceFactoryRegistry(EventQueue eventQueue) throws IOException {
        DeviceFactoryRegistry deviceFactoryRegistry = new DeviceFactoryRegistry(eventQueue);
        deviceFactoryRegistry.registerFactory(DeviceType.DISHWASHER, new DishwasherFactory());
        deviceFactoryRegistry.createDevice(DeviceType.FRIDGE, new FridgeFactory());
        deviceFactoryRegistry.createDevice(DeviceType.OVEN, new OvenFactory());
        deviceFactoryRegistry.createDevice(DeviceType.RECORD_PLAYER, new RecordPlayerFactory());
        deviceFactoryRegistry.createDevice(DeviceType.TELEVISION, new TelevisionFactory());
        deviceFactoryRegistry.createDevice(DeviceType.THERMOSTAT, new ThermostatFactory());
        deviceFactoryRegistry.createDevice(DeviceType.WASHING_MACHINE, new WashingMachineFactory());
        deviceFactoryRegistry.createDevice(DeviceType.WINDOW, new WindowFactory());
    }
}
