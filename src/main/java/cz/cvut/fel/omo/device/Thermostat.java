package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;

public class Thermostat extends Device{

    /**
     * Temperature is in Celsius degrees
     */
    private double temperature;

    public Thermostat(int id, DeviceDocumentation documentation, Consumption consumption, int durability, double temperature) {
        super(id, documentation, consumption, durability);
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        logger.info(this.toString() + " temperature set to " + temperature + "°C");
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visitThermostat(this);
    }

    @Override
    public String toString() {
        return "Thermostat " + id;
    }
}
