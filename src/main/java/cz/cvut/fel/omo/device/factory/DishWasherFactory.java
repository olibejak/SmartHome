package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.DishWasher;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

import java.util.ArrayList;
import java.util.UUID;

public class DishWasherFactory extends DeviceFactory {

        @Override
        public Device createDevice() {
            DishWasher dishWasher = new DishWasher(
                    ID++,
                    null,
                    createConsumption(),
                    5,
                    new ArrayList<>()
            );
            dishWasher.changeState(new OffDeviceState(dishWasher));
            return dishWasher;
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
