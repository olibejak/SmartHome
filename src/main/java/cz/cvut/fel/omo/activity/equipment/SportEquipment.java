package cz.cvut.fel.omo.activity.equipment;

import cz.cvut.fel.omo.house.report.ConfigurationReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a sport equipment item in the smart home simulation.
 * Implements the Visitor pattern to allow interaction with different types of sport equipment.
 * Implements {@link ConfigurationReport} to support configuration reporting.
 */
@AllArgsConstructor
@Getter
@Setter
public abstract class SportEquipment implements ConfigurationReport {
    protected boolean isAvailable;
    protected int usageCount;

    /**
     * Accepts a visitor to interact with this sport equipment.
     * Part of the Visitor pattern.
     *
     * @param visitor The visitor interacting with the equipment.
     * @return A string describing the interaction result.
     */
    public abstract String accept(SportEquipmentVisitor visitor);
}
