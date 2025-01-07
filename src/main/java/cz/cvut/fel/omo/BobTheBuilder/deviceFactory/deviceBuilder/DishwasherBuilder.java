package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.Dishwasher;

public class DishwasherBuilder extends StorageDeviceBuilder<DishwasherBuilder, Dishwasher> {

    public DishwasherBuilder() {
        reset();
    }

    public DishwasherBuilder isClean(boolean isClean) {
        device.setClean(isClean);
        return self();
    }

    @Override
    public DishwasherBuilder self() {
        return this;
    }

    @Override
    public DishwasherBuilder reset() {
        device = new Dishwasher();
        return self();
    }

    @Override
    public Dishwasher build() {
        Dishwasher result = device;
        reset();
        return result;
    }
}
