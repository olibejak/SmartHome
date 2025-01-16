package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.RecordPlayerBuilder;
import cz.cvut.fel.omo.device.RecordPlayer;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class RecordPlayerFactory extends BaseDeviceFactory<RecordPlayerBuilder, RecordPlayer> {

    @Override
    public RecordPlayer createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new RecordPlayerBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .currentRecord("Nowhere To Go", "Bad Omens")
                .build();
    }
}
