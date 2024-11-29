package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Device {

    protected GlobalLogger logger;

    protected final int id;
    private DeviceState state;
    private DeviceDocumentation documentation;
    private Consumption consumption;
    private int durability;

    public Device(int id, DeviceDocumentation documentation, Consumption consumption, int durability) {
        this.id = id;
        this.documentation = documentation;
        this.consumption = consumption;
        this.durability = durability;
    }

//    public Event generateEvent() {
//
//    }

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

}
