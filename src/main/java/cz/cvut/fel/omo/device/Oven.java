package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;

public class Oven extends Device{

    private RangeSettingType setting;
    private final int maxTemperature;
    private int currentTemperature;

    public Oven(int id, DeviceDocumentation documentation, Consumption consumption, int durability,
                RangeSettingType setting, int maxTemperature) {
        super(id, documentation, consumption, durability);
        this.setting = setting;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = 0;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        // todo generate event empty out the oven when finished
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitOven(this);
    }

    public void setTemperature(int temperature) {
        if (temperature < 0 || temperature > maxTemperature) {
            logger.info(this + " :Temperature " + temperature + " out of range 0 - " + maxTemperature);
            return;
        }
        this.currentTemperature = temperature;
        logger.info(this + " :Setting temperature to " + temperature + "°C");
    }

    public void setSetting(RangeSettingType setting) {
        this.setting = setting;
        logger.info(this + " :Setting to " + setting);
    }

    @Override
    public String toString() {
        return "Range " + id;
    }

    public enum RangeSettingType {
        BAKE, BROIL, CONVECTION, DEFROST, WARM,
    }
}
