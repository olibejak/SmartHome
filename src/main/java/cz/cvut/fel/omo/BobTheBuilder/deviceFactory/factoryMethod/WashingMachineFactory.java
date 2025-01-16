package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.FridgeBuilder;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.WashingMachineBuilder;
import cz.cvut.fel.omo.device.WashingMachine;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import java.util.ArrayList;

public class WashingMachineFactory extends BaseDeviceFactory<WashingMachineBuilder, WashingMachine> {

    @Override
    public WashingMachine createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new WashingMachineBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .isClean(false)
                .maxLoad(30)
                .currentLoad(0)
                .items(new ArrayList<>())
                .build();

    }
}
