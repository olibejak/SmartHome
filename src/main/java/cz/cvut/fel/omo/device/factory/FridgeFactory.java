package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Fridge;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

import java.util.ArrayList;

public class FridgeFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        Fridge fridge = new Fridge(
                ID++,
                null,
                createConsumption(),
                10,
                20,
                0,
                10
        );
        fridge.changeState(new OffDeviceState(fridge));
        return fridge;
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                0.1,
                0.5,
                0.1,
                0.5);
    }

    @Override
    public DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "Fridge",
                "Bosch",
                10,
                "Manual",
                true,
                "Warranty");
    }
}
