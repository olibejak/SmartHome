package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Oven;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class OvenFactory extends BaseDeviceFactory<Oven> {

    @Override
    public Oven createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return null;
    }
}
