package cz.cvut.fel.omo.device;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class StorageItem {

    protected final String name;
    protected final double load;
}
