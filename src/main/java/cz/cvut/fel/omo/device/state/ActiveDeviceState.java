package cz.cvut.fel.omo.device.state;

import lombok.experimental.SuperBuilder;

/**
 * State pattern class.
 * Active device state.
 */
@SuperBuilder
public class ActiveDeviceState extends DeviceState {

    @Override
    public void plugOut() {
        logger.info(device.toString() + "is plugged out.");
        device.changeState(
                OffDeviceState.builder()
                        .device(device)
                        .build()
        );
    }

    @Override
    public void turnOn() {
        // Already turned on
       logger.info(device.toString() + " is already turned on");
    }

    @Override
    public void standBy() {
        logger.info(device.toString() + " is standing by");
        device.changeState(
                IdleDeviceState.builder()
                        .device(device)
                        .build());
    }
}
