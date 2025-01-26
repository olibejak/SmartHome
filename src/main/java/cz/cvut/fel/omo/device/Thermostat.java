package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.eventManager.EventListener;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Thermostat extends Device implements EventListener {

    /**
     * Temperature is in Celsius degrees
     */
    private double minTemperature;
    private double maxTemperature;
    private double currentTemperature;

    public Thermostat(UUID id) {
        super(id);
    }

    public void setTemperature(double temperature) {
        if (temperature < minTemperature || temperature > maxTemperature) {
            logger.debug(this + " temperature " + temperature + " out of range " +
                    minTemperature + " - " + maxTemperature);
            return;
        }
        this.currentTemperature = temperature;
        logger.debug(this + " temperature set to " + temperature + "°C");
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
    public String reportConfiguration() {
        return "Thermostat: " + id;
    }

    @Override
    public String toString() {
        return "Thermostat " + id + ": " + currentTemperature + "°C";
    }

    @Override
    public void handleEvent(Event event) {
        // Ignore the event if it is not global (roomID = null) and not for this room
        if (event.getPayload().getRoomID() != null && event.getPayload().getRoomID() != this.getRoomID()) {
            return;
        }
        if (event.getType() == EventType.TEMPERATURE_CHANGE) {
            handleTemperatureChange();
        }
    }

    public void handleTemperatureChange() {
        logger.info(this + " handling temperature change event.");
        double randomTemperature = minTemperature + (maxTemperature - minTemperature) * new java.util.Random().nextDouble();
        setTemperature(randomTemperature);
    }
}
