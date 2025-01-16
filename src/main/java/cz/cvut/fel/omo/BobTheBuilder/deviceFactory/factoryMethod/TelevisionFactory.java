package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.TelevisionBuilder;
import cz.cvut.fel.omo.device.Television;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class TelevisionFactory extends BaseDeviceFactory<TelevisionBuilder, Television> {

    @Override
    public Television createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new TelevisionBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .channel(1)
                .build();
    }
}
