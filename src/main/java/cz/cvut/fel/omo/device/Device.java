package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.state.IdleDeviceState;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.device.visitor.EmptyDeviceVisitor;
import cz.cvut.fel.omo.device.visitor.FinishedDeviceVisitor;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.house.ConfigurationReport;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static cz.cvut.fel.omo.event.EventFactory.createEvent;

/**
 * Abstract class representing a device.
 * Part of the Composite design pattern.
 */
@Getter
@Setter
public abstract class Device implements ConfigurationReport {

    protected GlobalLogger logger = GlobalLogger.getInstance();
    protected EventQueue eventQueue;

    protected final UUID id;
    private DeviceState state;
    private Consumption consumption;
    private DeviceDocumentation documentation;
    private int durability;
    private int roomID;

    public Device(UUID id) {
        this.id = id;
    }

    /**
     * Change state of the device
     * @param state new state
     */
    public void changeState(DeviceState state) {
        this.state = state;
    }

    public void plugIn() {
        state.plugIn();
    }
    public void plugOut() {
        state.plugOut();
    }
    public void turnOn() {
        state.turnOn();
    }
    public void turnOff() {
        state.turnOff();
    }

    /**
     * Update the device after a cycle.
     */
    public void update() {
        state.calculateConsumption();
        state.calculateDurability();
    }

    /**
     * Accept a visitor.
     * @param visitor visitor
     * @return visitor result
     */
    public abstract String acceptDeviceVisitor(DeviceVisitor visitor);

//    public abstract String acceptEmptyDeviceVisitor(EmptyDeviceVisitor visitor);

    public boolean acceptEmptyDeviceVisitor(EmptyDeviceVisitor visitor) {
        logger.info(this + " does not accept this visitor");
        return false;
    }

    public boolean acceptFinishedDeviceVisitor(FinishedDeviceVisitor visitor) {
        logger.info(this + " does not accept this visitor");
        return false;
    }

    /**
     * Lazy load documentation for the device.
     * @return documentation
     */
    protected abstract DeviceDocumentation loadDocumentation();

    /**
     * Change the current durability of a device.
     * Handle breakage if durability is 0.
     * @param durability durability
     */
    public void setDurability(int durability) {
        if (durability <= 0) {
            this.durability = 0;
            handleBreakage();
        }
        else {
            this.durability = durability;
        }
    }

    /**
     * Handle breakage of a device.
     * Change state to off and create an event.
     */
    private void handleBreakage() {
        logger.info(this + " is broken");
        changeState(new OffDeviceState(this));
        createEvent(EventType.DEVICE_BROKEN, roomID, id);
    }

    /**
     * Get the documentation for the device.
     * Load documentation when null.
     * @return documentation
     */
    public DeviceDocumentation getDocumentation() {
        if (this.documentation == null) {
            this.documentation = loadDocumentation();
            logger.info("Looking for DOCUMENTATION for " + this + '\n' + this.documentation);
        }
        return this.documentation;
    }

    /**
     * Repair the device according to the documentation.
     */
    public boolean repair() {
        getDocumentation();
        if (documentation.getIsFixable()) {
            logger.info(this + " is repaired");
            changeState(new IdleDeviceState(this));
            setDurability(100);
            return true;
        }
        else {
            logger.info(this + " is not repairable");
            return false;
        }
    }
}
