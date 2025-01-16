package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;

public class Television extends Device{

    private int channel;

    public Television(int id, DeviceDocumentation documentation, Consumption consumption, int durability, int channel) {
        super(id, documentation, consumption, durability);
        this.channel = channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        logger.info(this + " channel set to " + channel);
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitTelevision(this);
    }

    @Override
    public String toString() {
        return "Television " + id;
    }
}
