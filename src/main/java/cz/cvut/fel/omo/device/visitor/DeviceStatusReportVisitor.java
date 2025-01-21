package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.*;

/**
 * Visitor for device status report.
 */
public class DeviceStatusReportVisitor implements DeviceVisitor {
    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        return "";
    }

    @Override
    public String visitFridge(Fridge fridge) {
        return "";
    }

    @Override
    public String visitOven(Oven oven) {
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

    public void visitDevice(WashingMachine washingMachine) {
        return;
    }

    public void visitDevice(Thermostat thermostat) {
        return;
    }
}
