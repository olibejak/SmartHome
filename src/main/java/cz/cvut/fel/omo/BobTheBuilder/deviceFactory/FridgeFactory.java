package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Fridge;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class FridgeFactory extends DeviceFactory {

    @Override
    public Device createDevice(int id) {
        Fridge fridge = new Fridge(
                id,
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
