package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.FridgeBuilder;
import cz.cvut.fel.omo.device.Fridge;
import cz.cvut.fel.omo.event.eventManager.EventManager;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Factory for creating Fridge devices.
 * Part of the Factory Method design pattern.
 */
@NoArgsConstructor
public class FridgeFactory extends BaseDeviceFactory<FridgeBuilder, Fridge> {

    @Override
    public Fridge createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager) {
        return setupBuilder(new FridgeBuilder(), roomID, deviceDTO, consumptionDTO, eventManager.getEventQueue())
                .minTemperature(0)
                .maxTemperature(10)
                .currentTemperature(5)
                .maxLoad(2) // change later
                .currentLoad(0)
                .items(new ArrayList<>())
                .build();
    }

}
