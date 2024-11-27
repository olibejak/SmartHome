package cz.cvut.fel.omo.device.factory;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Television;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;

public class TelevisionFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        Television television = new Television(
                ID++,
                null,
                createConsumption(),
                10,
                1
        );
        television.changeState(new OffDeviceState(television));
        return television;
    }

    @Override
    public Consumption createConsumption() {
        return new Consumption(
                1,
                2,
                0,
                0
        );
    }

    @Override
    public DeviceDocumentation createDocumentation() {
        return new DeviceDocumentation(
                "model",
                "manufacturer",
                0,
                "manualContent",
                false,
                "warrantyCertificate");
    }


}
