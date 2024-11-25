package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Window;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class WindowFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        return new Window(
                ID,
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
