package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Device implements DeviceInterface{

    private DeviceState state;
    private UserManual manual;
    private boolean isEssential;
    private boolean isBroken;
    private String warrantyCertificate;
    private Consumption consumption;
    @Setter
    private int durability;

//    public Event generateEvent() {
//
//    }

    public String reportConsumption(){
        return "";
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
}
