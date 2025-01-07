package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder;

import cz.cvut.fel.omo.device.WashingMachine;

public class WashingMachineBuilder extends StorageDeviceBuilder<WashingMachineBuilder, WashingMachine> {

    public WashingMachineBuilder() {
        reset();
    }

    public WashingMachineBuilder isClean(boolean isClean) {
        device.setClean(isClean);
        return self();
    }

    @Override
    public WashingMachineBuilder self() {
        return self();
    }

    @Override
    public WashingMachineBuilder reset() {
        device = new WashingMachine();
        return self();
    }

    @Override
    public WashingMachine build() {
        WashingMachine result = device;
        reset();
        return result;
    }
}
