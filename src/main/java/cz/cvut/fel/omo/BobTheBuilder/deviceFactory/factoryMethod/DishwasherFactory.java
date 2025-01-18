package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.DishwasherBuilder;
import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Factory for creating Dishwasher devices.
 * Part of the Factory Method design pattern.
 */
@NoArgsConstructor
public class DishwasherFactory extends BaseDeviceFactory<DishwasherBuilder, Dishwasher> {

    @Override
    public Dishwasher createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new DishwasherBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .isClean(false)
                .maxLoad(26)
                .currentLoad(0)
                .items(new ArrayList<>())
                .build();
    }
}
