package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Window;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class WindowFactory extends DeviceFactory {

    public WindowFactory(EventQueue eventQueue) {
        super(eventQueue);
    }

    @Override
    public Device createDevice(int id) {
        return new Window(
                id,
                createDocumentation(),
                createConsumption(),
                100,
                false,
                false
        );
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                0,
                0,
                0,
        0
        );
    }

    @Override
    public DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "Window",
                "Window",
                100,
                "Window manual",
                false,
                "Window warranty"
        );
    }


}
