package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;

public abstract class Device {

    private DeviceState state;
//    private UserManual manual;
    private boolean isEssential;
    private boolean isBroken;
    private String warrantyCertificate;
//    private Consumption consumption;

//    public Event generateEvent() {
//
//    }

    public void changeState(DeviceState state) {
        this.state = state;
    }

    public void plugIn() {
        state.standBy();
    }
    public void plugOut() {
        state.plugOut();
    }
    public void turnOn() {
        state.turnOn();
    }
    public void turnOff() {
        state.standBy();
    }
}
