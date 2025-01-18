package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.IdleDeviceState;

/**
 * Class for setting state of device to Idle.
 * Part of the State design pattern.
 */
public class IdleStateSetter implements StateSetter {

    public void setState(Device device) {
        device.setState(new IdleDeviceState(device));
    }
}
