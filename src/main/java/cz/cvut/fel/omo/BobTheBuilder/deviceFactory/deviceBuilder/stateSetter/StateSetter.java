package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter;

import cz.cvut.fel.omo.device.Device;

/**
 * Interface for setting state of device.
 * Part of the State design pattern.
 */
public interface StateSetter {
    void setState(Device device);
}
