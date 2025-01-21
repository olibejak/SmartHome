package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Television extends Device{

    private int channel;

    public Television(UUID id) {
        super(id);
    }

    public void setChannel(int channel) {
        this.channel = channel;
        logger.info(this + " channel set to channel " + channel);
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
    public String reportConfiguration() {
        return "Television: " + id;
    }

    @Override
    public String toString() {
        return "Television " + id;
    }
}
