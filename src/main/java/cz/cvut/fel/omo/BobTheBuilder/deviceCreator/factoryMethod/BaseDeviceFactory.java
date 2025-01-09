package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder.DeviceBuilder;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

public abstract class BaseDeviceFactory<D extends Device> implements DeviceFactory<D> {

    @Override
    public abstract D createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue);

    protected <T extends DeviceBuilder<T, D>> T setupBuilder(T builder, int deviceID, int roomID) {
        return builder
                .id(deviceID)
                .consumption(createConsumption())
                .roomID(roomID);
    }

    @Override
    public abstract Consumption createConsumption();
}
