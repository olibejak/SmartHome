package cz.cvut.fel.omo.device.state;

import lombok.experimental.SuperBuilder;

/**
 * State pattern class.
 * Plugged out device state.
 */
@SuperBuilder
public class OffDeviceState extends DeviceState{

    @Override
    public void plugOut() {
        // already plugged out
        logger.info(device.toString() + " already plugged out");
    }

    @Override
    public void turnOn() {
        logger.info(device.toString() + " turned on");
        device.changeState(
                ActiveDeviceState.builder()
                        .device(device)
                        .build()
        );
    }

    @Override
    public void standBy() {
        logger.info(device.toString() + " standby");
        device.changeState(
                IdleDeviceState.builder()
                        .device(device)
                        .build()
        );
    }
}
