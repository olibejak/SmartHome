package cz.cvut.fel.omo.device.visitor;

import cz.cvut.fel.omo.device.*;

public class ConsumptionReportVisitor implements DeviceVisitor{

    @Override
    public String visit(Dishwasher dishwasher) {
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
    public String visit(Fridge fridge) {
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
    public String visit(Range range) {
        return new StringBuilder()
                .append("Device: ")
                .append(range.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(range.getConsumption().getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(range.getConsumption().getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(range.getConsumption().getGasConsumed())
                .append(" m3")
                .toString();

    }

    @Override
    public String visit(RecordPlayer recordPlayer) {
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
    public String visit(Television television) {
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
    public String visit(Thermostat thermostat) {
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
    public String visit(WashingMachine washingMachine) {
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
    public String visit(Window window) {
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
