package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.WashingMachine;

import java.util.UUID;

/**
 * Builder for WashingMachine.
 * Part of the Builder design pattern.
 */
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
        return this;
    }

    @Override
    public WashingMachineBuilder reset() {
        device = new WashingMachine(UUID.randomUUID());
        return self();
    }

    @Override
    public WashingMachine build() {
        WashingMachine result = device;
        reset();
        return result;
    }
}
