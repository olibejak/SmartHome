package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.device.WashingMachine;

public interface FinishedDeviceVisitor {
    boolean visitFinishedDishwasher(Dishwasher dishwasher);
    boolean visitFinishedWashingMachine(WashingMachine washingMachine);
}
