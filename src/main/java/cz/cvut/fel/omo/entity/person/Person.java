package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.device.visitor.EmptyDeviceVisitor;
import cz.cvut.fel.omo.device.visitor.FinishedDeviceVisitor;
import cz.cvut.fel.omo.entity.Entity;
import cz.cvut.fel.omo.event.EventType;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a person entity in the smart home simulation.
 * This class extends {@link Entity} and implements the Visitor pattern to interact with devices.
 * Implements:
 * - {@link DeviceVisitor} for visiting and interacting with devices.
 * - {@link EmptyDeviceVisitor} for handling empty device states.
 * - {@link FinishedDeviceVisitor} for handling completed device operations.
 */
@Getter
@Setter
public abstract class Person extends Entity implements DeviceVisitor, EmptyDeviceVisitor, FinishedDeviceVisitor {
    protected boolean hasDriversLicense;

    public Person(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID);
        this.hasDriversLicense = hasDriversLicense;
    }

    /**
     * Allows the person to interact with a device using the Visitor pattern.
     *
     * @param device The device to interact with.
     */
    public void interactWith(Device device) {
        logger.info(device.acceptDeviceVisitor(this));
    }

    /**
     * Accepts a visitor for interaction with another person.
     *
     * @param visitor The visitor interacting with this person.
     * @return A message describing the interaction.
     */
    public abstract String accept(PersonVisitor visitor);

    /**
     * Defines how the person reacts when encountering a broken device.
     *
     * @param device The broken device.
     * @return {@code true} if the person successfully reacts to the broken device, {@code false} otherwise.
     */
    public abstract boolean reactToBrokenDevice(Device device);

    /**
     * Determines how the person reacts to different types of events related to a device.
     *
     * @param eventType The type of event occurring.
     * @param device The affected device.
     * @return {@code true} if the reaction was successful, {@code false} otherwise.
     */
    public boolean reactToEvent(EventType eventType, Device device) {
        if (eventType == EventType.DEVICE_EMPTY) {
            return device.acceptEmptyDeviceVisitor(this);
        }
        if (eventType == EventType.DEVICE_FULL) {
            device.turnOn();
            return true;
        }
        if (eventType == EventType.DEVICE_FINISHED) {
            return device.acceptFinishedDeviceVisitor(this);
        }
        if (eventType == EventType.DEVICE_BROKEN) {
            return reactToBrokenDevice(device);
        }

        return false;
    }
}
