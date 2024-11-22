package cz.cvut.fel.omo.device.Scoop;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.UserManual;
import cz.cvut.fel.omo.logger.GlobalLogger;

public class CommonDeviceBuilder implements DeviceBuilder{

    private Device device;

    @Override
    public void reset() {
        this.device = new Device();
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setEssential(boolean isEssential) {

    }

    @Override
    public void setWarrantyCertificate(String warrantyCertificate) {

    }

    @Override
    public void setDurability(int durability) {

    }

    @Override
    public void setConsumption(Consumption consumption) {

    }

    @Override
    public void setManual(UserManual manual) {

    }

    @Override
    public void setLogger(GlobalLogger logger) {

    }

    @Override
    public void setState(DeviceState state) {

    }

    @Override
    public Device build() {
        Device product = device;
        this.reset();
        return product;
    }
}
