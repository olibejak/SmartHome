package cz.cvut.fel.omo.device.state;

import cz.cvut.fel.omo.device.Device;

/**
 * State pattern class.
 * Plugged out device state.
 */
public class OffDeviceState extends DeviceState{

    public OffDeviceState(Device device) {
        super(device);
    }


    @Override
    public void plugIn() {
        logger.info(device.toString() + " is plugged in");
        device.changeState(new IdleDeviceState(device));
    }

    @Override
    public void plugOut() {
        // already plugged out
        logger.info(device.toString() + " already plugged out");
    }

    @Override
    public void turnOn() {
        logger.info(device.toString() + " is turned on");
        device.changeState(new ActiveDeviceState(device));
    }

    @Override
    public void turnOff() {
        // cannot turn off plugged out device
        logger.info(device.toString() + " cannot turn off plugged out device");
    }

    @Override
    public void calculateConsumption() {
        // no consumption in off state
    }

    @Override
    public void calculateDurability() {
        device.setDurability(device.getDurability() - 1);
    }
}
