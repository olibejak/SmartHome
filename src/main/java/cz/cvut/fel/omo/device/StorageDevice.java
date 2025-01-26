package cz.cvut.fel.omo.device;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Abstract class representing storage device.
 * For general information see {@link Device}.
 */
@Getter
@Setter
public abstract class StorageDevice extends Device {

    protected ArrayList<StorageItem> items;
    protected double maxLoad;
    protected double currentLoad;

    public StorageDevice(UUID id) {
        super(id);
    }

    /**
     * Add item to the storage device.
     */
    public abstract void addItem(String name, double load);

    /**
     * Remove all items from the storage device.
     */
    public abstract void removeAllItems();

    /**
     * Remove item from the storage device.
     */
    public abstract void removeItem(StorageItem item);

}
