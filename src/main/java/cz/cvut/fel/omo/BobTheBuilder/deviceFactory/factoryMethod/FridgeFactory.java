package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.FridgeBuilder;
import cz.cvut.fel.omo.device.Fridge;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class FridgeFactory extends BaseDeviceFactory<FridgeBuilder, Fridge> {

    @Override
    public Fridge createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new FridgeBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .minTemperature(0)
                .maxTemperature(10)
                .currentTemperature(5)
                .maxLoad(26)
                .currentLoad(0)
                .items(new ArrayList<>())
                .build();
    }

}
