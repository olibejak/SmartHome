package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class Range extends Device{
    public Range(int id, DeviceDocumentation documentation, Consumption consumption, int durability) {
        super(id, documentation, consumption, durability);
    }
}
