package cz.cvut.fel.omo.activity.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class SportEquipment {
    protected boolean isAvailable;
    protected int usageCount;

    public abstract String accept(SportEquipmentVisitor visitor);
}
