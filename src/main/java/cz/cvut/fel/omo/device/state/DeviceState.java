package cz.cvut.fel.omo.device.state;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * State pattern class.
 * Parent class.
 */
@AllArgsConstructor
@SuperBuilder
public abstract class DeviceState {

    protected Device device;
    protected GlobalLogger logger = GlobalLogger.getInstance();


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

    public void calculateConsumption() {

    }

    public void calculateDurability () {

    }
}
