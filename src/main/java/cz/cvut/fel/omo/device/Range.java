package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;

public class Range extends Device{
    public Range(int id, DeviceDocumentation documentation, Consumption consumption, int durability) {
        super(id, documentation, consumption, durability);
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visitRange(this);
    }

    @Override
    public String toString() {
        return "Range " + id;
    }
}
