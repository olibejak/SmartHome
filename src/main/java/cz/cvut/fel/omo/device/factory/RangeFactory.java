package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Range;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

import java.util.UUID;

public class RangeFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        Range range = new Range(
                ID++,
                createDocumentation(),
                createConsumption(),
                10);
        range.changeState(new OffDeviceState(range));
        return range;
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
