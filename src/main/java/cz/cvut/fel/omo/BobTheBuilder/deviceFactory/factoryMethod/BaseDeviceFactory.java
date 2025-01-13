package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.DeviceBuilder;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.ActiveStateSetter;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.IdleStateSetter;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.OffStateSetter;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder.stateSetter.StateSetter;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseDeviceFactory<D extends Device> implements DeviceFactory<D> {

    protected enum StateType{
        ACTIVE, IDLE, OFF
    }

    protected HashMap<StateType, StateSetter> stateStrategies = new HashMap<>();

    public BaseDeviceFactory() {
        stateStrategies.put(StateType.ACTIVE, new ActiveStateSetter());
        stateStrategies.put(StateType.IDLE, new IdleStateSetter());
        stateStrategies.put(StateType.OFF, new OffStateSetter());
    }

    @Override
    public abstract D createDevice(DeviceDTO deviceDTO, int roomID, EventQueue eventQueue, Map<String, Object> config);

    protected <T extends DeviceBuilder<T, D>> T setupBuilder(T builder, int deviceID, int roomID) {
        return builder
                .id(deviceID)
                .consumption(createConsumption())
                .roomID(roomID);
    }

    protected abstract void deviceConfigValidator(Map<String, Object> config, String[] requiredFields);

    protected Consumption validateConsumption(Map<String, Object> config) {
        if (config.containsKey("consumption")) {
            return createConsumption((Map<String, Object>) config.get("consumption"));
        } else {
            throw new IllegalArgumentException("Consumption is missing in device configuration");
        }
    }

    @Override
    public Consumption createConsumption(Map<String, Object> config) {
        return null;
    }

    @Override
    public DeviceDocumentation createDocumentation(Map<String, Object> config) {
        return null;
    }
}
