package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.WindowBuilder;
import cz.cvut.fel.omo.device.Window;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class WindowFactory extends BaseDeviceFactory<WindowBuilder, Window> {

    @Override
    public Window createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue) {
        return setupBuilder(new WindowBuilder(), roomID, deviceDTO, consumptionDTO, eventQueue)
                .hasOpenedCurtain(false)
                .isOpen(false)
                .build();

    }
}
