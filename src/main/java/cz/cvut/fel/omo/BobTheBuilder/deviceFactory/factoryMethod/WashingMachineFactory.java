package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.WashingMachine;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class WashingMachineFactory extends BaseDeviceFactory<WashingMachine> {

    @Override
    public WashingMachine createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return null;
    }
}
