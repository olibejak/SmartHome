package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.Oven;

public class OvenBuilder extends DeviceBuilder<OvenBuilder, Oven> {

    public OvenBuilder() {
        reset();
    }

    public OvenBuilder setting(Oven.RangeSettingType setting) {
        device.setSetting(setting);
        return self();
    }

    public OvenBuilder maxTemperature(double maxTemperature) {
        device.setMaxTemperature(maxTemperature);
        return self();
    }

    public OvenBuilder currentTemperature(double currentTemperature) {
        device.setCurrentTemperature(currentTemperature);
        return self();
    }

    @Override
    public OvenBuilder self() {
        return this;
    }

    @Override
    public OvenBuilder reset() {
        device = new Oven();
        return self();
    }

    @Override
    public Oven build() {
        return null;
    }
}
