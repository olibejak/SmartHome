package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
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
    private final Map<DeviceType, ConsumptionDTO> deviceConsumptionConfig;
    private final EventQueue eventQueue;

    public DeviceFactoryRegistry(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        factoryMethods = new HashMap<>();
        deviceConsumptionConfig = loadDeviceConsumptionConfig("src/main/resources/device_consumption.json");
    }

    private Map<DeviceType, ConsumptionDTO> loadDeviceConsumptionConfig(@NonNull String path) {
        try {
            return HouseLoader.loadDeviceConsumptionConfig(path);
        } catch (IOException e) {
            logger.error(
                    "Could not find a corresponding device consumption config file, using default values.\n"
                            + e.getMessage()
            );
            return new HashMap<>();
        }
    }

    public void registerFactory(DeviceType type, DeviceFactory<?> factoryMethod) {
        factoryMethods.put(type, factoryMethod);
    }

    public Device createDevice(DeviceDTO deviceDTO, int roomID) {
        DeviceFactory<?> factory = factoryMethods.get(deviceDTO.getType());
        if (factory == null) {
            logger.error("No factory found for device type " + deviceDTO.getType());
            return null;
        }
        ConsumptionDTO consumptionDTO = deviceConsumptionConfig.getOrDefault(
                deviceDTO.getType(), getDefaultConsumptionDTO()
        );
        return factory.createDevice(deviceDTO, consumptionDTO, roomID, eventQueue);
    }

    private ConsumptionDTO getDefaultConsumptionDTO() {
        return new ConsumptionDTO(
                2,
                5,
                2,
                2
        );
    }
}
