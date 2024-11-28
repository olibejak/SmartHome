package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.*;

public interface DeviceVisitor {

    String visitDishwasher(Dishwasher dishwasher);
    String visitFridge(Fridge fridge);
    String visitOven(Oven oven);
    String visitRecordPlayer(RecordPlayer recordPlayer);
    String visitTelevision(Television television);
    String visitThermostat(Thermostat thermostat);
    String visitWashingMachine(WashingMachine washingMachine);
    String visitWindow(Window window);
}
