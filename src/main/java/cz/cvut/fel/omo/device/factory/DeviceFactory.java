package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

import java.util.UUID;

public abstract class DeviceFactory {

    protected int ID = 0;

    abstract Device createDevice(int id);
    abstract Consumption createConsumption();
    abstract DeviceDocumentation createDocumentation();

}
