package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public interface DeviceFactory<D extends Device> {

    /**
     * Creates device instance based on data from json config file.
     * @param deviceDTO object with device data from json config file
     * @param roomID id of the room where the device is placed - needed for easier event dispatch
     * @param eventQueue queue for pushing events created by devices
     * @return particular device object
     */
     D createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue);

    /**
     * Creates consumption instance for device.
     * @return consumption object
     */
    Consumption createConsumption();
}
