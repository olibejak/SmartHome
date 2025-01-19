package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.OvenBuilder;
import cz.cvut.fel.omo.device.Oven;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

/**
 * Factory for creating Oven devices.
 * Part of the Factory Method design pattern.
 */
public class OvenFactory extends BaseDeviceFactory<OvenBuilder, Oven> {

    @Override
    public Oven createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new OvenBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .setting(Oven.RangeSettingType.BAKE)
                .maxTemperature(300)
                .currentTemperature(0)
                .build();
    }
}
