package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.state.OffDeviceState;

public class OffStateSetter implements StateSetter {

        public void setState(Device device) {
            device.setState(new OffDeviceState(device));
        }
}
