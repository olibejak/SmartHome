package cz.cvut.fel.omo.device.state;

import lombok.experimental.SuperBuilder;

/**
 * State pattern class.
 * Active device state.
 */
@SuperBuilder
public class ActiveDeviceState extends DeviceState {

    @Override
    public void plugIn() {
        // Already plugged in
        logger.info(device.toString() + " is already plugged in");
    }

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
    public void turnOff() {
        logger.info(device.toString() + " is set to idle.");
        device.changeState(
                IdleDeviceState.builder()
                        .device(device)
                        .build());
    }

    @Override
    public void calculateConsumption() {
        deviceConsumption.addGasConsumed();
        deviceConsumption.addWaterConsumed();
        deviceConsumption.addActiveElectricityConsumed();
    }

    @Override
    public void calculateDurability() {
        device.setDurability(device.getDurability() - 5);
    }
}
