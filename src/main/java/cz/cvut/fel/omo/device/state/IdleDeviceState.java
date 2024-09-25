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
        logger.info(device.toString() + " is plugged out");
        device.changeState(
                OffDeiceState.builder()
                        .device(device)
                        .build()
        );
    }

    @Override
    public void turnOn() {
        logger.info(device.toString() + " is turned on");
        device.changeState(
                ActiveDeviceState.builder()
                        .device(device)
                        .build()
        );
    }

    @Override
    public void standBy() {
        // already idle
        logger.info(device.toString() + " is already standing by");
    }
}
