package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.device.WashingMachine;

public interface FinishedDeviceVisitor {
    String visitFinishedDishwasher(Dishwasher dishwasher);
    String visitFinishedWashingMachine(WashingMachine washingMachine);
}
