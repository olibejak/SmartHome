package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.strategy;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Television;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class TelevisionFactory implements DeviceFactory {

    public TelevisionFactory(EventQueue eventQueue) {
        super(eventQueue);
    }

    @Override
    public Device createDevice(int id) {
        Television television = new Television(
                id,
                null,
                createConsumption(),
                10,
                1
        );
        television.changeState(new OffDeviceState(television));
        return television;
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

    @Override
    public DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "model",
                "manufacturer",
                0,
                "manualContent",
                false,
                "warrantyCertificate");
    }


}
