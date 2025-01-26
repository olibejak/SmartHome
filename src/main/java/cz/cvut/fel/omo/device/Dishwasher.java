package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.event.EventFactory;
import cz.cvut.fel.omo.event.EventType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Dishwasher extends StorageDevice {

    private boolean isClean;

    public Dishwasher(UUID id) {
        super(id);
    }

    public void wash() {
        if (items.isEmpty()) {
            logger.info(this + " :Cannot wash, no dishes in dishwasher");
            return;
        }
        if (isClean) {
            logger.info(this + " :Cannot wash, dishwasher is already clean");
            return;
        }
        turnOn();
        this.isClean = true;
        logger.info(this + " : Dishwasher is clean - GENERATE EVENT");
        eventQueue.addEvent(EventFactory.createEvent(EventType.DEVICE_JOB_DONE, getRoomID(), getId()));
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitDishwasher(this);
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.DISHWASHER);
    }

    @Override
    public void addItem(String name, double load) {
        if (isClean) {
            logger.info(this + " :Cannot add " + name + ", dishwasher is clean");
            return;
        }
        if (this.currentLoad + load > this.maxLoad) {
            logger.info(this + " :Cannot add the whole load of " + name + ", dishwasher would be full");
            return;
        }
        items.add(new StorageItem(name, load));
        this.currentLoad += load;
        if (this.currentLoad == this.maxLoad) {
            logger.info(this + " : Dishwasher is full - GENERATE EVENT");
            eventQueue.addEvent(EventFactory.createEvent(EventType.DEVICE_FULL, getRoomID(), getId()));
        }
    }

    @Override
    public void removeAllItems() {
        items.clear();
        this.currentLoad = 0;
        isClean = false;
    }

    @Override
    public void removeItem(StorageItem item) {
        items.remove(item);
        this.currentLoad =- item.load();
        if (currentLoad == 0 || currentLoad < 0) {
            this.currentLoad = 0;
            isClean = false;
        }
    }

    @Override
    public String reportConfiguration() {
        return "Dishwasher: " + id;
    }

    @Override
    public String toString() {
        return "Dishwasher " + id + ": " + items;
    }
}
