package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public abstract class DeviceFactory {

    protected EventQueue eventQueue;

    public DeviceFactory(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    abstract Device createDevice(int id);
    abstract Consumption createConsumption();
    abstract DeviceDocumentation createDocumentation();

}
