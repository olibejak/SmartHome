package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.BobTheBuilder.HouseLoader;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod.DeviceFactory;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeviceFactoryRegistry {

    private final GlobalLogger logger = GlobalLogger.getInstance();

    private final Map<DeviceType, DeviceFactory<?>> factoryMethods;
    private final EventQueue eventQueue;
    private final Map<DeviceType, Map<String, Object>> deviceConfig;
    private final Map<DeviceType, Map<String, Integer>> deviceConsumptionConfig;

    public DeviceFactoryRegistry(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        factoryMethods = new HashMap<>();
        deviceConfig = loadDeviceConfig("src/main/resources/devices.json");
        deviceConsumptionConfig = loadDeviceConsumptionConfig("src/main/resources/device_consumption.json");
    }

    private Map<DeviceType, Map<String, Object>> loadDeviceConfig(@NonNull String path) {
        try {
            return HouseLoader.loadDeviceConfig(path);
        } catch (IOException e) {
            logger.error("Could not find a corresponding device config file, using default values.\n" + e.getMessage());
            return new HashMap<>();
        }
    }

    private Map<DeviceType, Map<String, Integer>> loadDeviceConsumptionConfig(@NonNull String path) {
        try {
            return HouseLoader.loadDeviceConsumptionConfig(path);
        } catch (IOException e) {
            logger.error("Could not find a corresponding device consumption config file, using default values.\n" + e.getMessage());
            return new HashMap<>();
        }
    }

    public void registerFactory(DeviceType type, DeviceFactory<?> factoryMethod) {
        factoryMethods.put(type, factoryMethod);
    }

    public Device createDevice(DeviceDTO deviceDTO, int roomID) {
        DeviceFactory<?> factory = factoryMethods.get(deviceDTO.getType());
        Map<String, Object> config = deviceConfig.get(deviceDTO.getType());
        Map<String, Integer> consumptionConfig = deviceConsumptionConfig.get(deviceDTO.getType());

        return factory.createDevice(deviceDTO, roomID, eventQueue, config);
    }
}
