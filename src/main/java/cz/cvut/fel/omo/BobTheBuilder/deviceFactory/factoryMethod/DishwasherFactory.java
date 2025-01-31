package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.DishwasherBuilder;
import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.event.eventManager.EventManager;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Factory for creating Dishwasher devices.
 * Part of the Factory Method design pattern.
 */
@NoArgsConstructor
public class DishwasherFactory extends BaseDeviceFactory<DishwasherBuilder, Dishwasher> {

    @Override
    public Dishwasher createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager) {
        return setupBuilder(new DishwasherBuilder(), roomID, deviceDTO, consumptionDTO, eventManager.getEventQueue())
                .isClean(false)
                .maxLoad(2) // change to 5
                .currentLoad(0)
                .items(new ArrayList<>())
                .build();
    }
}
