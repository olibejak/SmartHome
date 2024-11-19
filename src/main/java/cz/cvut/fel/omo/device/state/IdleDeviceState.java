package cz.cvut.fel.omo.device.state;

import lombok.experimental.SuperBuilder;

/**
 * State pattern class.
 * Stand by device state.
 */
@SuperBuilder
public class IdleDeviceState extends DeviceState {

    @Override
    public void plugIn() {
        // Already plugged in
        logger.info(device.toString() + " is already plugged in");
    }

    @Override
    public void plugOut() {
        logger.info(device.toString() + " is plugged out");
        device.changeState(
                OffDeviceState.builder()
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
    public void turnOff() {
        // already idle
        logger.info(device.toString() + " is already idle");
    }

    @Override
    public void calculateConsumption() {
        deviceConsumption.addIdleElectricityConsumed();
    }

    @Override
    public void calculateDurability() {
        device.setDurability(device.getDurability() - 2);
    }
}
