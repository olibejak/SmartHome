package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Window;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public class WindowFactory extends BaseDeviceFactory<Window> {

    @Override
    public Window createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return null;
    }
}
