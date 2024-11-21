package cz.cvut.fel.omo.device.state;

import cz.cvut.fel.omo.device.Device;

/**
 * State pattern class.
 * Active device state.
 */
public class ActiveDeviceState extends DeviceState {

    public ActiveDeviceState(Device device) {
        super(device);
    }

    @Override
    public void plugIn() {
        // Already plugged in
        logger.info(device.toString() + " is already plugged in");
    }

    @Override
    public void plugOut() {
        logger.info(device.toString() + " active device cannot be plugged out");
    }

    @Override
    public void turnOn() {
        // Already turned on
       logger.info(device.toString() + " is already turned on");
    }

    @Override
    public void turnOff() {
        logger.info(device.toString() + " is set to idle");
        device.changeState(new IdleDeviceState(device));
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
