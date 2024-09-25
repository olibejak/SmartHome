package cz.cvut.fel.omo.device.state;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * State pattern class.
 * Stand by device state.
 */
@SuperBuilder
public class IdleDeviceState extends DeviceState {

    @Override
    public void plugOut() {
        device.changeState(
                OffDeiceState.builder()
                        .device(device)
                        .build()
        );
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
        // already idle
    }
}
