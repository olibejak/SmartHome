package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.eventManager.EventListener;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Window extends Device implements EventListener {

    private boolean hasOpenedCurtain;
    private boolean isOpen;

    public Window(UUID id) {
        super(id);
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            logger.debug(this + " window is opened");
        }
        logger.debug(this + " window is already opened");
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            logger.debug(this + " window is closed");
        }
        logger.debug(this + " window is already closed");
    }

    public void openCurtain() {
        if (!hasOpenedCurtain) {
            hasOpenedCurtain = true;
            logger.debug(this + " curtain is opened");
        }
        logger.debug(this + " curtain is already opened");
    }

    public void closeCurtain() {
        if (hasOpenedCurtain) {
            hasOpenedCurtain = false;
            logger.debug(this + " curtain is closed");
        }
        logger.debug(this + " curtain is already closed");
    }

    @Override
    public String reportConfiguration() {
        return "Window: " + id;
    }

    @Override
    public String toString() {
        return "Window " + id;
//        return "Window " + id + ", durability: " + getDurability();
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitWindow(this);
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.WINDOW);
    }

    @Override
    public void handleEvent(Event event) {
        if (event.getPayload().getRoomID() != null && event.getPayload().getRoomID() != this.getRoomID()) {
            return;
        }
        if (event.getType() == EventType.RAIN) {
            handleWindChange();
        }
    }

    public void handleWindChange() {
        if (isOpen) {
            logger.info(this + " closing due to rain");
            close();
        }
    }
}
