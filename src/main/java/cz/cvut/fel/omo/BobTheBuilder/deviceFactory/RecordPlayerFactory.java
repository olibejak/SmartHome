package cz.cvut.fel.omo.BobTheBuilder.deviceFactory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.RecordPlayer;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class RecordPlayerFactory extends DeviceFactory {

    @Override
    public Device createDevice(int id) {
        RecordPlayer recordPlayer = new RecordPlayer(
                id,
                null,
                createConsumption(),
                10
        );
        recordPlayer.insertRecord("Weezer", "Weezer");
        recordPlayer.changeState(new OffDeviceState(recordPlayer));
        return recordPlayer;
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                0.1,
                1,
                0,
                0);
    }

    @Override
    public DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "Model",
                "Manufacturer",
                10,
                "Manual",
                true,
                "Warranty");
    }


}
