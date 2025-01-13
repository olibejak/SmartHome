package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Television extends Device{

    private int channel;

    public void changeChannel(int channel) {
        this.channel = channel;
        logger.info(this.toString() + " channel set to " + channel);
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitTelevision(this);
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.TELEVISION);
    }

    @Override
    public String toString() {
        return "Television " + id;
    }
}
