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
        device.changeState(
                OffDeviceState.builder()
                        .device(device)
                        .build()
        );
    }

    @Override
    public void turnOn() {
        // Already turned on
    }

    @Override
    public void standBy() {
        device.changeState(
                IdleDeviceState.builder()
                        .device(device)
                        .build());
    }
}
