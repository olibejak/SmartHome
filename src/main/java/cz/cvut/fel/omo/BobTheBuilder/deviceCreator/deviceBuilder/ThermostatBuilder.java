package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder;

import cz.cvut.fel.omo.device.Thermostat;

public class ThermostatBuilder extends DeviceBuilder<ThermostatBuilder, Thermostat> {

    public ThermostatBuilder() {
        reset();
    }

    public ThermostatBuilder temperature(double temperature) {
        device.setTemperature(temperature);
        return self();
    }

    public ThermostatBuilder minTemperature(double minTemperature) {
        device.setMinTemperature(minTemperature);
        return self();
    }

    public ThermostatBuilder maxTemperature(double maxTemperature) {
        device.setMaxTemperature(maxTemperature);
        return self();
    }

    public ThermostatBuilder currentTemperature(double currentTemperature) {
        device.setCurrentTemperature(currentTemperature);
        return self();
    }

    @Override
    public ThermostatBuilder self() {
        return this;
    }

    @Override
    public ThermostatBuilder reset() {
        device = new Thermostat();
        return self();
    }

    @Override
    public Thermostat build() {
        Thermostat result = device;
        reset();
        return result;
    }


}
