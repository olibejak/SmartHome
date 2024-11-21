package cz.cvut.fel.omo.device.state;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.logger.GlobalLogger;

/**
 * State pattern class.
 * Parent class.
 */
public abstract class DeviceState {

    public DeviceState(Device device) {
        this.device = device;
        this.deviceConsumption = device.getConsumption();
        this.logger = GlobalLogger.getInstance();
    }

    protected Device device;
    protected Consumption deviceConsumption;
    protected GlobalLogger logger;


    /**
     * Change state to idle
     */
    public abstract void plugIn();

    /**
     * Change state to off
     */
    public abstract void plugOut();

    /**
     * Change state to Active
     */
    public abstract void turnOn();

    /**
     * Change state to idle
     */
    public abstract void turnOff();

    public abstract void calculateConsumption();

    public abstract void calculateDurability ();
}
