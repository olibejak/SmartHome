package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public abstract class DeviceFactory {

    protected int ID = 0;

    abstract Device createDevice(int id);
    abstract Consumption createConsumption();
    abstract DeviceDocumentation createDocumentation();

}
