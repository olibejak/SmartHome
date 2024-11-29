package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;

public class Thermostat extends Device{

    /**
     * Temperature is in Celsius degrees
     */
    private final double minTemperature;
    private final double maxTemperature;
    @Getter
    private double currentTemperature;

    public Thermostat(int id, DeviceDocumentation documentation, Consumption consumption, int durability,
                      double minTemperature, double maxTemperature) {
        super(id, documentation, consumption, durability);
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = (maxTemperature - minTemperature) / 2;
    }

    public void setTemperature(double temperature) {
        if (temperature < minTemperature || temperature > maxTemperature) {
            logger.info(this + " temperature " + temperature + " out of range " +
                    minTemperature + " - " + maxTemperature);
            return;
        }
        this.currentTemperature = temperature;
        logger.info(this + " temperature set to " + temperature + "°C");
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitThermostat(this);
    }

    @Override
    public String toString() {
        return "Thermostat " + id;
    }
}
