package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.type.StateType;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.DeviceBuilder;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.ActiveStateSetter;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.IdleStateSetter;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.OffStateSetter;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.StateSetter;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import java.util.HashMap;
import java.util.UUID;

public abstract class BaseDeviceFactory<T extends DeviceBuilder<T, D>, D extends Device> implements DeviceFactory<D> {

    protected HashMap<StateType, StateSetter> stateStrategies = new HashMap<>();

    public BaseDeviceFactory() {
        stateStrategies.put(StateType.ACTIVE, new ActiveStateSetter());
        stateStrategies.put(StateType.IDLE, new IdleStateSetter());
        stateStrategies.put(StateType.OFF, new OffStateSetter());
    }

    @Override
    public abstract D createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventQueue eventQueue);

    protected T setupBuilder(T builder, int roomID, DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, EventQueue eventQueue) {
        return builder
                .id(UUID.randomUUID())
                .consumption(createConsumption(consumptionDTO))
                .roomID(roomID)
                .state(stateStrategies.get(deviceDTO.getState()))
                .durability(deviceDTO.getDurability())
                .eventQueue(eventQueue)
                .documentation(null);
    }

    @Override
    public Consumption createConsumption(ConsumptionDTO consumptionDTO) {
        return new Consumption(
                consumptionDTO.getElectricityIdleRate(),
                consumptionDTO.getElectricityActiveRate(),
                consumptionDTO.getGasRate(),
                consumptionDTO.getWaterRate()
        );
    }
}
