package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.StateSetter;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import java.util.UUID;

/**
 * Abstract class for building devices.
 * Part of the Builder design pattern.
 */
public abstract class DeviceBuilder<T extends DeviceBuilder<T,D>, D extends Device> {

    protected D device;

    public DeviceBuilder() {
        reset();
    }

    public T eventQueue(EventQueue eventQueue) {
        device.setEventQueue(eventQueue);
        return self();
    }

    public T state(StateSetter stateSetter) {
        stateSetter.setState(device);
        return self();
    }

    public T roomID(int roomID) {
        device.setRoomID(roomID);
        return self();
    }

    public T consumption(Consumption consumption) {
        device.setConsumption(consumption);
        return self();
    }

    public T durability(int durability) {
        device.setDurability(durability);
        return self();
    }

    public T documentation(DeviceDocumentation documentation) {
        device.setDocumentation(documentation);
        return self();
    }

    public abstract T self();
    public abstract T reset();
    public abstract D build();
}
