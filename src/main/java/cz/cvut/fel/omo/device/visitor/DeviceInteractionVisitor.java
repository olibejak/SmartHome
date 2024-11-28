package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.*;

public class DeviceInteractionVisitor implements DeviceVisitor {

    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        if (dishwasher.isClean()) {
            dishwasher.removeAllItems();
            return dishwasher.getId() + " dishes removed";
        }
        else if (dishwasher.getCurrentLoad() < dishwasher.getMaxLoad()) {
            dishwasher.addItem("Plate", 4);
            return dishwasher.getId() + " added plate";
        }
        else {
            dishwasher.wash();
            return dishwasher.getId() + " washing dishes";
        }
    }

    @Override
    public String visitFridge(Fridge fridge) {
        return "";
    }

    @Override
    public String visitRange(Range range) {
        return "";
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        return "";
    }

    @Override
    public String visitTelevision(Television television) {
        return "";
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        return "";
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        return "";
    }

    @Override
    public String visitWindow(Window window) {
        return "";
    }
}
