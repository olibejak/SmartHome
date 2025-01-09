package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Television;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class TelevisionFactory extends BaseDeviceFactory<Television> {

    @Override
    public Television createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return null;
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                1,
                2,
                0,
                0
        );
    }
}
