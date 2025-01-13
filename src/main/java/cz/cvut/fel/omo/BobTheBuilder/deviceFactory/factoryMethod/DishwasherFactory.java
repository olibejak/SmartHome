package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.DishwasherBuilder;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.OffStateSetter;
import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class DishwasherFactory extends BaseDeviceFactory<Dishwasher> {

    @Override
    public Dishwasher createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue, Map<String, Object> config) {
        return setupBuilder(new DishwasherBuilder(), deviceDTO.getId(), roomID)
                .state(stateStrategies.get((StateType) config.get("state")))
                .isClean((boolean) config.get("isClean"))
                .maxLoad((int) config.get("maxLoad"))
                .currentLoad((int) config.get("currentLoad"))
                .consumption(createConsumption())
                .build();
    }
}
