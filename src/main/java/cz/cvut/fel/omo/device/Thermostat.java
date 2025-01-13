package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Thermostat extends Device{

    /**
     * Temperature is in Celsius degrees
     */
    private double minTemperature;
    private double maxTemperature;
    private double currentTemperature;

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
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.THERMOSTAT);
    }

    @Override
    public String toString() {
        return "Thermostat " + id;
    }
}
