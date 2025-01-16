package cz.cvut.fel.omo.device;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StorageItem {

    protected final String name;
    protected final double load;

    @Override
    public String toString() {
        return "name: " + name + ", load: " + load;
    }
}
