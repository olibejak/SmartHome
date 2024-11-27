package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;

public class WashingMachine extends StorageDevice<WashingMachine.Wash> {

    private boolean isFinished;

     public WashingMachine(int id, DeviceDocumentation documentation, Consumption consumption, int durability,
                           int maxLoad) {
        super(id, documentation, consumption, durability, maxLoad);
        this.isFinished = false;
    }

    public void startWash(Wash wash) {
        if (wash != null) {
            logger.info(this.toString() + " started washing " + wash.getName());
        } else {
            logger.info(this.toString() + " cannot start washing, no wash selected");
        }
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visitWashingMachine(this);
    }

    @Override
    public void addItem(String name, double load) {
        items.add(new Wash(name, load));
        logger.info(this.toString() + " wash " + name + " added");
    }

    @Override
    public void removeAllItems() {
        items.clear();
        logger.info(this.toString() + " all washes removed");
    }

    @Override
    public void removeItem(Wash item) {
        items.remove(item);
        logger.info(this.toString() + " wash " + item.getName() + " removed");
    }

    @Override
    public String toString() {
        return "Washing machine " + id;
    }

        public class Wash extends StorageItem {
        public Wash(String name, double load) {
            super(name, load);
        }
    }
}
