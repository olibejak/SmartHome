package cz.cvut.fel.omo.BobTheBuilder.deviceCreator;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.strategy.DeviceFactory;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DeviceFactoryRegistry {
    private final Map<DeviceType, Function<EventQueue, DeviceFactory>> factoryMethods = new HashMap<>();
    private final EventQueue eventQueue;

    public DeviceFactoryRegistry(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    public void registerFactory(DeviceType type, Function<EventQueue, DeviceFactory> factoryMethod) {
        factoryMethods.put(type, factoryMethod);
    }

    public Device createDevice(DeviceDTO deviceDTO) {
        Function<EventQueue, DeviceFactory> factoryMethod = factoryMethods.get(deviceDTO.getType());
        if (factoryMethod == null) {
            throw new IllegalArgumentException("No factory registered for type: " + deviceDTO.getType());
        }

        DeviceFactory factory = factoryMethod.apply(eventQueue);
        return factory.createDevice(deviceDTO.getId(), deviceDTO.getSpecificConfig());
    }
}
