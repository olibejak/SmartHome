package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.event.EventType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static cz.cvut.fel.omo.event.EventFactory.createEvent;

/**
 * Oven device class.
 * For general information see {@link Device}.
 */
@Setter
@Getter
public class Oven extends Device{

    private RangeSettingType setting;
    private double maxTemperature;
    private double currentTemperature;

    public Oven(UUID id) {
        super(id);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        logger.info(this + " : Oven is turned on - GENERATE EVENT");
        createEvent(EventType.DEVICE_JOB_DONE, getRoomID(), getId());
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitOven(this);
    }

    public void setTemperature(int temperature) {
        if (temperature < 0 || temperature > maxTemperature) {
            logger.debug(this + " :Temperature " + temperature + " out of range 0 - " + maxTemperature);
            return;
        }
        this.currentTemperature = temperature;
        logger.debug(this + " :Setting temperature to " + temperature + "°C");
    }

    public void setSetting(RangeSettingType setting) {
        this.setting = setting;
        logger.debug(this + " :Setting to " + setting);
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.OVEN);
    }

    @Override
    public String reportConfiguration() {
        return "Oven: " + id;
    }

    @Override
    public String toString() {
        return "Oven " + id + " set to " + setting + ", " + currentTemperature + "°C";
    }

    public enum RangeSettingType {
        BAKE, BROIL, CONVECTION, DEFROST, WARM,
    }
}
