package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.WashingMachineBuilder;
import cz.cvut.fel.omo.device.WashingMachine;
import cz.cvut.fel.omo.event.eventManager.EventManager;

import java.util.ArrayList;

public class WashingMachineFactory extends BaseDeviceFactory<WashingMachineBuilder, WashingMachine> {

    @Override
    public WashingMachine createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager) {
        return setupBuilder(new WashingMachineBuilder(), roomID, deviceDTO, consumptionDTO, eventManager.getEventQueue())
                .isClean(false)
                .maxLoad(30)
                .currentLoad(0)
                .items(new ArrayList<>())
                .build();

    }
}
