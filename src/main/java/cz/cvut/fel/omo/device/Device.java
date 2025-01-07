package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Device {

    protected GlobalLogger logger = GlobalLogger.getInstance();
    protected EventQueue eventQueue;

    protected int id;
    private DeviceState state;
    private DeviceDocumentation documentation;
    private Consumption consumption;
    private int durability;

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

}
