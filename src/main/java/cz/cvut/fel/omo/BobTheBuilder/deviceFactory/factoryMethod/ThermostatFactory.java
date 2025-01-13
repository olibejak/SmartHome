package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Thermostat;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class ThermostatFactory extends BaseDeviceFactory<Thermostat> {

    @Override
    public Thermostat createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return null;
    }
}
