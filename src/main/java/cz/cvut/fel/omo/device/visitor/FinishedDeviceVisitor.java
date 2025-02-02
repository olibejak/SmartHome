package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.device.WashingMachine;

/**
 * Visitor pattern interface for handling devices that have completed their operations.
 * This interface defines interactions for when a device finishes its task.
 */
public interface FinishedDeviceVisitor {
    boolean visitFinishedDishwasher(Dishwasher dishwasher);
    boolean visitFinishedWashingMachine(WashingMachine washingMachine);
}
