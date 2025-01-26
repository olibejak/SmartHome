package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod;

import cz.cvut.fel.omo.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.event.eventManager.EventManager;

/**
 * Interface for creating devices and consumptions.
 * Part of the Factory Method design pattern.
 * @param <D> type of device
 */
public interface DeviceFactory<D extends Device> {

    /**
     * Creates device instance based on data from json config file.
     * @param deviceDTO data for device creation
     * @param roomID id of the room where the device is placed - needed for easier event dispatch
     * @param eventManager event queue distributor and for observer for event listeners
     * @return particular device object
     */
     D createDevice(DeviceDTO deviceDTO, ConsumptionDTO consumptionDTO, int roomID, EventManager eventManager);

    /**
     * Creates consumption instance for device.
     * @param consumptionDTO data for consumption creation
     * @return consumption object
     */
    Consumption createConsumption(ConsumptionDTO consumptionDTO);
}
