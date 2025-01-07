package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.StorageDevice;

import java.util.ArrayList;

public abstract class StorageDeviceBuilder<T extends StorageDeviceBuilder<T, D>, D extends StorageDevice>
        extends DeviceBuilder<T, D> {

    protected StorageDevice<D> device;

    public StorageDeviceBuilder() {
        reset();
    }

    public T items(ArrayList<D> items) {
        device.setItems(items);
        return self();
    }

    public T maxLoad(double maxLoad) {
        device.setMaxLoad(maxLoad);
        return self();
    }

    public T currentLoad(double currentLoad) {
        device.setCurrentLoad(currentLoad);
        return self();
    }

}
