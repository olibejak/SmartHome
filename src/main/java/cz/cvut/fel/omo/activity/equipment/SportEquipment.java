package cz.cvut.fel.omo.activity.equipment;

import cz.cvut.fel.omo.house.ConfigurationReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class SportEquipment implements ConfigurationReport {
    protected boolean isAvailable;
    protected int usageCount;

    /**
     * Accept method for visitor pattern.
     * @param visitor concrete visitor
     * @return result of visiting
     */
    public abstract String accept(SportEquipmentVisitor visitor);
}
