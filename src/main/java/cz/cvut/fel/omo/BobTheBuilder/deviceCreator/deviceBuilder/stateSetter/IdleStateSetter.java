package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder.stateSetter;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.IdleDeviceState;

public class IdleStateSetter implements StateSetter {

    public void setState(Device device) {
        device.setState(new IdleDeviceState(device));
    }
}
