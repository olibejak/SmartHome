package cz.cvut.fel.omo.device;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public abstract class StorageDevice extends Device {

    protected ArrayList<StorageItem> items;
    protected double maxLoad;
    protected double currentLoad;

    public StorageDevice(UUID id) {
        super(id);
    }

    public abstract void addItem(String name, double load);
    public abstract void removeAllItems();
    public abstract void removeItem(StorageItem item);

}
