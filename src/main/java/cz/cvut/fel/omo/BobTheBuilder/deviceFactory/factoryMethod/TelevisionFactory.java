package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.TelevisionBuilder;
import cz.cvut.fel.omo.device.Television;
import cz.cvut.fel.omo.event.eventManager.EventManager;

public class TelevisionFactory extends BaseDeviceFactory<TelevisionBuilder, Television> {

    @Override
    public Television createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager) {
        return setupBuilder(new TelevisionBuilder(), roomID, deviceDTO, consumptionDTO, eventManager.getEventQueue())
                .channel(1)
                .build();
    }
}
