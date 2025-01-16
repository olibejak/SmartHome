package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.ThermostatBuilder;
import cz.cvut.fel.omo.device.Thermostat;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class ThermostatFactory extends BaseDeviceFactory<ThermostatBuilder, Thermostat> {

    @Override
    public Thermostat createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new ThermostatBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .minTemperature(18)
                .maxTemperature(26)
                .currentTemperature(20)
                .build();

    }
}
