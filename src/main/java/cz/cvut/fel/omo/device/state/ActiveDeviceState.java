package cz.cvut.fel.omo.device.state;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
                OffDeiceState.builder()
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
