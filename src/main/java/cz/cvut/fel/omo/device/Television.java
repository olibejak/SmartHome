package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.device.visitor.EmptyDeviceVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Television device class.
 * For general information see {@link Device}.
 */
@Setter
@Getter
public class Television extends Device{

    private int channel;

    public Television(UUID id) {
        super(id);
    }

    /**
     * Set the channel of the television.
     * @param channel int representing the channel to be set
     */
    public void setChannel(int channel) {
        this.channel = channel;
        logger.debug(this + " channel set to channel " + channel);
    }

    @Override
    public String acceptDeviceVisitor(DeviceVisitor visitor) {
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
