package cz.cvut.fel.omo.BobTheBuilder.deviceCreator;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.factoryMethod.DeviceFactory;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import java.util.HashMap;
import java.util.Map;

public class DeviceFactoryRegistry {
    private final Map<DeviceType, DeviceFactory<?>> factoryMethods = new HashMap<>();
    private final EventQueue eventQueue;

    public DeviceFactoryRegistry(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    public void registerFactory(DeviceType type, DeviceFactory<?> factoryMethod) {
        factoryMethods.put(type, factoryMethod);
    }

    public Device createDevice(DeviceDTO deviceDTO, int roomID) {
        DeviceFactory<?> factory = factoryMethods.get(deviceDTO.getType());
        if (factory == null) {
            throw new IllegalArgumentException("No factory registered for type: " + deviceDTO.getType());
        }
        return factory.createDevice(deviceDTO, roomID, eventQueue);
    }
}
