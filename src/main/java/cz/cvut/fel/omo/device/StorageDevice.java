package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public abstract class StorageDevice<T> extends Device {

    protected ArrayList<T> items;
    protected double maxLoad;
    protected double currentLoad;

    public abstract void addItem(String name, double load);
    public abstract void removeAllItems();
    public abstract void removeItem(T item);

}
