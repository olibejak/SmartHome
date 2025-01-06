package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Oven;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class OvenFactory extends DeviceFactory {

    public OvenFactory(EventQueue eventQueue) {
        super(eventQueue);
    }

    @Override
    public Device createDevice(int id) {
        Oven oven = new Oven(
                id,
                createDocumentation(),
                createConsumption(),
                10,
                null,
                400
        );
        oven.changeState(new OffDeviceState(oven));
        return oven;
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                0.5,
                1,
                1,
                1);
    }

    @Override
    public DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "Model",
                "Manufacturer",
                10,
                "Manual",
                true,
                "Warranty");
    }
}
