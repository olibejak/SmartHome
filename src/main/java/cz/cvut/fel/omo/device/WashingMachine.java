package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;

public class WashingMachine extends StorageDevice<WashingMachine.Wash> {

    private boolean isClean;

    public WashingMachine(int id, DeviceDocumentation documentation, Consumption consumption, int durability,
                           int maxLoad) {
        super(id, documentation, consumption, durability, maxLoad);
        this.isClean = false;
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
        logger.info(this + " started washing ");
        super.turnOn();
        this.isClean = true;
        // todo generate event to empty the washing machine
    }

    @Override
    public void turnOff() {
        super.turnOff();
        isClean = true;
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitWashingMachine(this);
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
        items.add(new Wash(name, load));
        this.currentLoad += load;
        logger.info(this + " wash " + name + " added");
        if (this.currentLoad == this.maxLoad) {
            // todo generate event
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
    public void removeItem(Wash item) {
        items.remove(item);
        logger.info(this + " wash " + item.getName() + " removed");
    }

    @Override
    public String toString() {
        return "Washing machine " + id;
    }

    public class Wash extends StorageItem {
        private Wash(String name, double load) {
            super(name, load);
        }
    }
}
