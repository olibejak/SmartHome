package cz.cvut.fel.omo.device.state;

import cz.cvut.fel.omo.device.Device;

/**
 * State pattern class.
 * Stand by device state.
 */
public class IdleDeviceState extends DeviceState {

    public IdleDeviceState(Device device) {
        super(device);
    }

    @Override
    public void plugIn() {
        // Already plugged in
        logger.info(device.toString() + " is already plugged in");
    }

    @Override
    public void plugOut() {
        logger.info(device.toString() + " is plugged out");
        device.changeState(new OffDeviceState(device));
    }

    @Override
    public void turnOn() {
        logger.info(device.toString() + " is turned on");
        device.changeState(new ActiveDeviceState(device));
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
