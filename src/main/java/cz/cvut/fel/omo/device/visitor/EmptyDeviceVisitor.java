package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.Fridge;

/**
 * Visitor pattern interface for handling devices that are empty.
 * This interface defines interactions for when a device reaches an empty state.
 */
public interface EmptyDeviceVisitor {
    boolean visitEmptyFridge(Fridge fridge);
}
