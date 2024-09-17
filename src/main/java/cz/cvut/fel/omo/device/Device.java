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

    public void plugIn() {}
    public void plugOut() {}
    public void turnOn() {}
    public void turnOff() {}
}
