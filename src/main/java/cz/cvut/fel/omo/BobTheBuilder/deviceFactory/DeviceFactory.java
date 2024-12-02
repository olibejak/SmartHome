package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public interface DeviceFactory {

    Device createDevice(int id);
    Consumption createConsumption();
    DeviceDocumentation createDocumentation();

}
