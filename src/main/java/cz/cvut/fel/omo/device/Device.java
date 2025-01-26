package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.state.IdleDeviceState;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.house.ConfigurationReport;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

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

    public void update() {
        state.calculateConsumption();
        state.calculateDurability();
    }

    public abstract String accept(DeviceVisitor visitor);

    protected abstract DeviceDocumentation loadDocumentation();

    public void setDurability(int durability) {
        if (durability <= 0) {
            this.durability = 0;
            handleBreakage();
        }
        else
           this.durability = durability;
    }

    private void handleBreakage() {
        logger.info(this + " is broken");
        changeState(new OffDeviceState(this));
    }

    public DeviceDocumentation getDocumentation() {
        if (this.documentation == null) {
            this.documentation = loadDocumentation();
            logger.info("Looking for DOCUMENTATION for " + this + '\n' + this.documentation);
        }
        return this.documentation;
    }

    public void repair() {
        getDocumentation(); 
        if (documentation.getIsFixable()) {
            logger.info(this + " is repaired");
            changeState(new IdleDeviceState(this));
        }
        else {
            logger.info(this + " is not repairable");
        }
    }
}
