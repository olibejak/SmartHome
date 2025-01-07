package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public abstract class DeviceBuilder<T extends DeviceBuilder <T,D>, D extends Device> {

    protected D device;

    public DeviceBuilder() {
        reset();
    }

    public T id(int id) {
        device.setId(id);
        return self();
    }

    public T state(DeviceState state) {
        device.setState(state);
        return self();
    }

    public T documentation(DeviceDocumentation documentation) {
        device.setDocumentation(documentation);
        return self();
    }

    public T consumption(Consumption consumption) {
        device.setConsumption(consumption);
        return self();
    }

    public T durability(int durability) {
        device.setDurability(durability);
        return self();
    }

    public abstract T self();
    public abstract T reset();
    public abstract D build();
}
