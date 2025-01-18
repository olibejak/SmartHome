package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.StorageDevice;
import cz.cvut.fel.omo.device.StorageItem;

import java.util.ArrayList;

/**
 * Abstract builder for StorageDevice.
 * Part of the Builder design pattern.
 */
public abstract class StorageDeviceBuilder<T extends StorageDeviceBuilder<T, D>, D extends StorageDevice>
        extends DeviceBuilder<T, D> {

    public StorageDeviceBuilder() {
        reset();
    }

    public T items(ArrayList<StorageItem> items) {
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
