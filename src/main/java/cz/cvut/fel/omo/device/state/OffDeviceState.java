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
    }

    @Override
    public void turnOn() {
        device.changeState(
                ActiveDeviceState.builder()
                        .device(device)
                        .build()
        );
    }

    @Override
    public void standBy() {
        device.changeState(
                IdleDeviceState.builder()
                        .device(device)
                        .build()
        );
    }
}
