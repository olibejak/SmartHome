package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.*;

/**
 * Visitor that collects current device consumption.
 */
public class DeviceConsumptionReportVisitor implements DeviceVisitor{

    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        return new StringBuilder()
                .append("Device: ")
                .append(dishwasher.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(dishwasher.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(dishwasher.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(dishwasher.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }

    @Override
    public String visitFridge(Fridge fridge) {
        return new StringBuilder()
                .append("Device: ")
                .append(fridge.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(fridge.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(fridge.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(fridge.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }

    @Override
    public String visitOven(Oven oven) {
        return new StringBuilder()
                .append("Device: ")
                .append(oven.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(oven.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(oven.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(oven.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        return new StringBuilder()
                .append("Device: ")
                .append(recordPlayer.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(recordPlayer.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(recordPlayer.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(recordPlayer.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }

    @Override
    public String visitTelevision(Television television) {
        return new StringBuilder()
                .append("Device: ")
                .append(television.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(television.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(television.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(television.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        return new StringBuilder()
                .append("Device: ")
                .append(thermostat.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(thermostat.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(thermostat.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(thermostat.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        return new StringBuilder()
                .append("Device: ")
                .append(washingMachine.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(washingMachine.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(washingMachine.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(washingMachine.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }

    @Override
    public String visitWindow(Window window) {
        return new StringBuilder()
                .append("Device: ")
                .append(window.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(window.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(window.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(window.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();
    }
}
