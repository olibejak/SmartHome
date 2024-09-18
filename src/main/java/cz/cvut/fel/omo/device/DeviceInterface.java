package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;

public interface DeviceInterface {

//    Event generateEvent();

    String reportConsumption();

    void changeState(DeviceState state);

    void plugIn();

    void plugOut();

    void turnOn();

    void turnOff();
}
