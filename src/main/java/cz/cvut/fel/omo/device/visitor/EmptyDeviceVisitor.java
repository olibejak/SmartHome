package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.Fridge;

public interface EmptyDeviceVisitor {
    boolean visitEmptyFridge(Fridge fridge);
}
