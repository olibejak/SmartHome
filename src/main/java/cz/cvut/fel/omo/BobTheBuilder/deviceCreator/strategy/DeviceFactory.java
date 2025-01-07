package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.strategy;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Dishwasher;

public class DeviceFactory {

//    abstract Device createDevice(DeviceDTO deviceDTO);
//    abstract Consumption createConsumption();
//    abstract DeviceDocumentation createDocumentation();
//
//    Device createDevice(int id, Map<String, Object> specificConfig);

    public Dishwasher createDishwasher(DeviceDTO deviceDTO) {
        return new Dishwasher(
                deviceDTO.getId(),
                null,
                createConsumption(),
                10,
                20,
                0,
                10
        );

    }
}
