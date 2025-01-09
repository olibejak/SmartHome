package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Oven;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class OvenFactory extends BaseDeviceFactory<Oven> {

    @Override
    public Oven createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return null;
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                0.5,
                1,
                1,
                1);
    }
}
