package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Thermostat;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class ThermostatFactory implements DeviceFactory {

    @Override
    public Device createDevice(int id) {
        return new Thermostat(
                id,
                createDocumentation(),
                createConsumption(),
                100,
                15,
                25
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
