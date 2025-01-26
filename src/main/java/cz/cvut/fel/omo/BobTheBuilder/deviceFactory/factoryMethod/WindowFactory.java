package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.WindowBuilder;
import cz.cvut.fel.omo.device.Window;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.eventManager.EventManager;

public class WindowFactory extends BaseDeviceFactory<WindowBuilder, Window> {

    @Override
    public Window createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager) {
        Window window = setupBuilder(new WindowBuilder(), roomID, deviceDTO, consumptionDTO, eventManager.getEventQueue())
                .hasOpenedCurtain(false)
                .isOpen(false)
                .build();
        eventManager.subscribe(EventType.RAIN, window);
        return window;

    }
}
