package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Dishwasher;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

import java.util.ArrayList;

public class DishwasherFactory extends DeviceFactory {

        @Override
        public Device createDevice() {
            Dishwasher dishwasher = new Dishwasher(
                    ID++,
                    null,
                    createConsumption(),
                    5,
                    new ArrayList<>()
            );
            dishwasher.changeState(new OffDeviceState(dishwasher));
            return dishwasher;
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
