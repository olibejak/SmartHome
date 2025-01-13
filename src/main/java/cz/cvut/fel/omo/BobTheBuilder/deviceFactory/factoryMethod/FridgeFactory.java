package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Fridge;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FridgeFactory extends BaseDeviceFactory<Fridge> {

    @Override
    public Fridge createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue) {
        return null;
    }
}
