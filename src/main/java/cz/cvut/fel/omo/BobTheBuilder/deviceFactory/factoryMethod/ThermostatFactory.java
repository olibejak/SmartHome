package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.ThermostatBuilder;
import cz.cvut.fel.omo.device.Thermostat;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.eventManager.EventManager;

public class ThermostatFactory extends BaseDeviceFactory<ThermostatBuilder, Thermostat> {

    @Override
    public Thermostat createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager) {
        Thermostat thermostat = setupBuilder(new ThermostatBuilder(), roomID, deviceDTO, consumptionDTO, eventManager.getEventQueue())
                .minTemperature(18)
                .maxTemperature(26)
                .currentTemperature(20)
                .build();
        eventManager.subscribe(EventType.TEMPERATURE_CHANGE, thermostat);
        return thermostat;
    }
}
