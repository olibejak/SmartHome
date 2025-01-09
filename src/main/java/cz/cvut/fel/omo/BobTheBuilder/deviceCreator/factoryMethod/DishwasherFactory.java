package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder.DishwasherBuilder;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder.stateSetter.OffStateSetter;
import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DishwasherFactory extends BaseDeviceFactory<Dishwasher> {

    @Override
    public Dishwasher createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new DishwasherBuilder(), deviceDTO.getId(), roomID)
                .id(deviceDTO.getId())
                .state(new OffStateSetter())
                .consumption(createConsumption())
                .build();
    }

    @Override
    public Consumption createConsumption() {
        return null;
    }
}
