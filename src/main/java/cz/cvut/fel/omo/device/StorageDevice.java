package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public abstract class StorageDevice<T> extends Device {

    protected final ArrayList<T> items;
    protected final double maxLoad;
    protected double currentLoad;

    public StorageDevice(int id, DeviceDocumentation documentation, Consumption consumption, int durability,
                         double maxLoad) {
        super(id, documentation, consumption, durability);
        this.maxLoad = maxLoad;
        this.currentLoad = 0;
        this.items = new ArrayList<>();
    }

    public abstract void addItem(String name, double load);
    public abstract void removeAllItems();
    public abstract void removeItem(T item);

}
