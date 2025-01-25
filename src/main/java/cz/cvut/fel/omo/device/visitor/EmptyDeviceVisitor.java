package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.Fridge;

public interface EmptyDeviceVisitor {
    String visitEmptyFridge(Fridge fridge);
}
