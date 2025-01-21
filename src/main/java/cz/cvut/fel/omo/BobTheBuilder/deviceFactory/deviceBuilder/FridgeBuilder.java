package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.Fridge;

import java.util.UUID;

/**
 * Builder for Fridge.
 * Part of the Builder design pattern.
 */
public class FridgeBuilder extends StorageDeviceBuilder<FridgeBuilder, Fridge> {

    public FridgeBuilder() {
        reset();
    }

    public FridgeBuilder minTemperature(double minTemperature) {
        device.setMinTemperature(minTemperature);
        return self();
    }

    public FridgeBuilder maxTemperature(double maxTemperature) {
        device.setMaxTemperature(maxTemperature);
        return self();
    }

    public FridgeBuilder currentTemperature(double currentTemperature) {
        device.setCurrentTemperature(currentTemperature);
        return self();
    }

    @Override
    public FridgeBuilder self() {
        return this;
    }

    @Override
    public FridgeBuilder reset() {
        device = new Fridge(UUID.randomUUID());
        return self();
    }

    @Override
    public Fridge build() {
        Fridge result = device;
        reset();
        return result;
    }
}
