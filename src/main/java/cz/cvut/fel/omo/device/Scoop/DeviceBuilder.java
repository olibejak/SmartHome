package cz.cvut.fel.omo.device.Scoop;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.logger.GlobalLogger;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.UserManual;

public interface DeviceBuilder {

    void reset();

    void setName(String name);
    void setEssential(boolean isEssential);
    void setWarrantyCertificate(String warrantyCertificate);
    void setDurability(int durability);
    void setConsumption(Consumption consumption);
    void setManual(UserManual manual);
    void setLogger(GlobalLogger logger);
    void setState(DeviceState state);
    Device build();
}
