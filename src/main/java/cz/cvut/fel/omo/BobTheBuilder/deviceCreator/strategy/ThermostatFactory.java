package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.strategy;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Thermostat;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class ThermostatFactory implements DeviceFactory {

    public ThermostatFactory(EventQueue eventQueue) {
        super(eventQueue);
    }

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
