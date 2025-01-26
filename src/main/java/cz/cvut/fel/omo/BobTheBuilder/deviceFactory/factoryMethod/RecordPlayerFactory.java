package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.RecordPlayerBuilder;
import cz.cvut.fel.omo.device.RecordPlayer;
import cz.cvut.fel.omo.event.eventManager.EventManager;

public class RecordPlayerFactory extends BaseDeviceFactory<RecordPlayerBuilder, RecordPlayer> {

    @Override
    public RecordPlayer createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager) {
        return setupBuilder(new RecordPlayerBuilder(), roomID, deviceDTO, consumptionDTO, eventManager.getEventQueue())
                .currentRecord("Nowhere To Go", "Bad Omens")
                .build();
    }
}
