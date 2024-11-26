package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.*;

public interface DeviceVisitor {

    String visit(Dishwasher dishwasher);
    String visit(Fridge fridge);
    String visit(Range range);
    String visit(RecordPlayer recordPlayer);
    String visit(Television television);
    String visit(Thermostat thermostat);
    String visit(WashingMachine washingMachine);
    String visit(Window window);
}
