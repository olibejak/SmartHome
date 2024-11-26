package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class Thermostat extends Device{

    private int temperature;

    public Thermostat(int id, DeviceDocumentation documentation, Consumption consumption, int durability) {
        super(id, documentation, consumption, durability);
    }

    @Override
    public String toString() {
        return "Thermostat " + id;
    }
}
