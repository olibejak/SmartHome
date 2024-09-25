package cz.cvut.fel.omo.device.state;

import cz.cvut.fel.omo.device.Device;
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
    public abstract void standBy();
}
