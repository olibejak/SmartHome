package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.strategy;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder.DishwasherBuilder;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DishwasherFactory implements DeviceFactory {

    @Override
    public Device createDevice(DeviceDTO deviceDTO) {
        return new DishwasherBuilder()
                .id(deviceDTO.getId())
                .consumption(createConsumption())
                .documentation(createDocumentation())

                .build();
    }

        @Override
        public Consumption createConsumption() {
            return new Consumption(
                    0.1,
                    0.5,
                    0.1,
                    0.5);
        }

        @Override
        public DeviceDocumentation createDocumentation() {
            return new DeviceDocumentation(
                    "DishWasher",
                    "Bosch",
                    5,
                    "Manual",
                    true,
                    "Warranty");
        }
}
