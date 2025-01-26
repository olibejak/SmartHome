package cz.cvut.fel.omo.entity.strategy;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.EventType;

public interface EventStrategy {
    boolean reactToEvent(Device device);
}
