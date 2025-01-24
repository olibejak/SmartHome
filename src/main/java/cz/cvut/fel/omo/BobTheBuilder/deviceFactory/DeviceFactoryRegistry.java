package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.BobTheBuilder.HouseLoader;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod.DeviceFactory;
import cz.cvut.fel.omo.BobTheBuilder.FactoryRegistry;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.eventManager.EventManager;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Registry for device factories.
 */
public class DeviceFactoryRegistry implements FactoryRegistry<Device, DeviceDTO> {

    private final GlobalLogger logger = GlobalLogger.getInstance();

    private final Map<DeviceType, DeviceFactory<?>> factoryMethods;
    private final Map<DeviceType, ConsumptionDTO> deviceConsumptionConfig;
    private final EventManager eventManager;

    public DeviceFactoryRegistry(EventManager eventManager) {
        this.eventManager = eventManager;
        factoryMethods = new HashMap<>();
        deviceConsumptionConfig = loadDeviceConsumptionConfig("src/main/resources/device_consumption.json");
    }

    /**
     * Loads device consumption config from a file.
     * @param path path to the file
     * @return map of device types and their consumption values
     */
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

    /**
     * Registers a factory method for a device type.
     * @param type device type
     * @param factoryMethod factory method
     */
    public void registerFactory(DeviceType type, DeviceFactory<?> factoryMethod) {
        factoryMethods.put(type, factoryMethod);
    }

    /**
     * Returns default consumption values.
     * @return default consumption values
     */
    private ConsumptionDTO getDefaultConsumptionDTO() {
        return new ConsumptionDTO(
                2,
                5,
                2,
                2
        );
    }

    @Override
    public Device createObject(DeviceDTO dto, int roomId) {
        if (dto.getType() == null) {
            logger.error("DeviceDTO type is null");
            return null;
        }
        DeviceFactory<?> factory = factoryMethods.get(dto.getType());
        if (factory == null) {
            logger.error("No factory found for device type " + dto.getType());
            return null;
        }
        ConsumptionDTO consumptionDTO = deviceConsumptionConfig.getOrDefault(
                dto.getType(), getDefaultConsumptionDTO()
        );
        return factory.createDevice(dto, consumptionDTO, roomId, eventManager);
    }
}
