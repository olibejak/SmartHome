package cz.cvut.fel.omo.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SportEquipment {
    private boolean isAvailable;
    private int usageCount;

    public SportEquipment() {
        this.isAvailable = true;
        this.usageCount = 0;
    }

    public abstract String accept(SportEquipmentVisitor visitor);
}
