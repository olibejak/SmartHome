package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder.stateSetter;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.ActiveDeviceState;

public class ActiveStateSetter implements StateSetter{

    public void setState(Device device) {
        device.setState(new ActiveDeviceState(device));
    }
}
