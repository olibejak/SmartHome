package cz.cvut.fel.omo.device;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public abstract class StorageDevice extends Device {

    protected ArrayList<StorageItem> items;
    protected double maxLoad;
    protected double currentLoad;

    public abstract void addItem(String name, double load);
    public abstract void removeAllItems();
    public abstract void removeItem(StorageItem item);

}
