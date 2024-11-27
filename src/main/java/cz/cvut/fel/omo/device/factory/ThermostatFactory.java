package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Thermostat;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class ThermostatFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        return new Thermostat(
                ID,
                createDocumentation(),
                createConsumption(),
                10,
                20
        );
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                100,
                100,
                5,
                0
        );
    }

    @Override
    public DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "Thermostat",
                "Honeywell",
                10,
                "Thermostat manual",
                true,
                "Thermostat warranty");
    }
}
