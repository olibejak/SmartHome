package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import java.util.Map;

public interface DeviceFactory<D extends Device> {

    /**
     * Creates device instance based on data from json config file.
     * @param deviceDTO object with device data from json config file
     * @param roomID id of the room where the device is placed - needed for easier event dispatch
     * @param eventQueue queue for pushing events created by devices
     * @param config configuration for device
     * @return particular device object
     */
     D createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue, Map<String, Object> config);


    /**
     * Creates consumption instance for device.
     * @param config configuration for consumption
     * @return consumption object
     */
    Consumption createConsumption(Map<String, Object> config);

    /**
     * Creates documentation instance for device.
     * @param config configuration for documentation
     * @return documentation object
     */
    DeviceDocumentation createDocumentation(Map<String, Object> config);
}
