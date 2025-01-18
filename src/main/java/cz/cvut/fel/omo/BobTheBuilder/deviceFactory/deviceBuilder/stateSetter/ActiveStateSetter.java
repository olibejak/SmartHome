package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.ActiveDeviceState;

/**
 * Class for setting state of device to Active.
 * Part of the State design pattern.
 */
public class ActiveStateSetter implements StateSetter{

    public void setState(Device device) {
        device.setState(new ActiveDeviceState(device));
    }
}
