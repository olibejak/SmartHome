package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.device.visitor.EmptyDeviceVisitor;
import cz.cvut.fel.omo.device.visitor.FinishedDeviceVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static cz.cvut.fel.omo.event.EventFactory.createEvent;

@Setter
@Getter
public class WashingMachine extends StorageDevice {

    private boolean isClean;

    public WashingMachine(UUID id) {
        super(id);
    }

    @Override
    public void turnOn() {
        if (items.isEmpty()) {
            logger.info(this + " :Cannot wash, washing machine is empty");
            return;
        }
        if (isClean) {
            logger.info(this + " Cannot start washing, washing machine is already clean");
            return;
        }
        super.turnOn();
        logger.info(this + " started washing");
        this.isClean = true;
        logger.debug(this + " is clean - GENERATE EVENT");
        eventQueue.addEvent(createEvent(EventType.DEVICE_JOB_DONE, getRoomID(), getId()));
    }

    @Override
    public void turnOff() {
        super.turnOff();
        isClean = true;
    }

    @Override
    public String acceptDeviceVisitor(DeviceVisitor visitor) {
        return visitor.visitWashingMachine(this);
    }

    @Override
    public boolean acceptFinishedDeviceVisitor(FinishedDeviceVisitor visitor) {
        return visitor.visitFinishedWashingMachine(this);
    }

    @Override
    public void addItem(String name, double load) {
        if (isClean) {
            logger.info(this + " :Cannot add " + name + ", washing machine is clean");
            return;
        }
        if (this.currentLoad + load > this.maxLoad) {
            logger.info(this + " :Cannot add the whole load of " + name + ", washing machine would be full");
            return;
        }
        items.add(new StorageItem(name, load));
        this.currentLoad += load;
        logger.info(this + " " + name + " added");
        if (this.currentLoad == this.maxLoad) {
            logger.debug(this + " is full - GENERATE EVENT");
            eventQueue.addEvent(createEvent(EventType.DEVICE_FULL, getRoomID(), getId()));
        }
    }

    @Override
    public void removeAllItems() {
        items.clear();
        this.currentLoad = 0;
        isClean = false;
        logger.info(this + " all washes removed");
    }

    @Override
    public void removeItem(StorageItem item) {
        items.remove(item);
        logger.info(this + " wash " + item.name() + " removed");
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.WASHING_MACHINE);
    }

    @Override
    public String reportConfiguration() {
        return "Washing Machine: " + id;
    }

    @Override
    public String toString() {
        return "Washing machine " + id + ": " + items;
    }
}
