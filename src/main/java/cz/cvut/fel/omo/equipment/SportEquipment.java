package cz.cvut.fel.omo.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class SportEquipment {
    protected boolean isAvailable;
    protected int usageCount;

    public SportEquipment() {
        this.isAvailable = true;
        this.usageCount = 0;
    }

    public abstract String accept(SportEquipmentVisitor visitor);
}
