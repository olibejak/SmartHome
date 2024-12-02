package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.WashingMachine;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

import java.util.ArrayList;

import java.util.UUID;

public class WashingMachineFactory extends DeviceFactory {

    @Override
    public Device createDevice(int id) {
        WashingMachine washingMachine = new WashingMachine(
                id,
                null,
                createConsumption(),
                100,
                20
        );
        washingMachine.changeState(new OffDeviceState(washingMachine));
        return washingMachine;
    }

    @Override
    Consumption createConsumption() {
        return new Consumption(
                0.1,
                0.5,
                0.1,
                0.1
        );
    }

    @Override
    DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "WM-2023",
                "WashingTech",
                10,
                "This is the user manual for the WashingTech WM-2023 washing machine.",
                true,
                "Standard 2-year warranty"
        );
    }
}
