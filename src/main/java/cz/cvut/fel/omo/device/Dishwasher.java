package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;

@Getter
public class Dishwasher extends StorageDevice<Dishwasher.Dish> {

    private boolean isClean;

    public Dishwasher(int id, DeviceDocumentation documentation, Consumption consumption, int durability, int maxLoad) {
        super(id, documentation, consumption, durability, maxLoad);
        this.isClean = false;
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
        logger.info(this + " :Washing dishes...");
        this.isClean = true;
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitDishwasher(this);
    }

    @Override
    public void addItem(String name, double load) {
        if (this.currentLoad + load > this.maxLoad) {
            logger.info(this + " :Cannot add " + name + ", dishwasher is full");
            return;
        }
        if (isClean) {
            logger.info(this + " :Cannot add " + name + ", dishwasher is clean");
            return;
        }
        items.add(new Dish(name, load));
        this.currentLoad += load;
    }

    @Override
    public void removeAllItems() {
        items.clear();
        this.currentLoad = 0;
        isClean = false;
    }

    @Override
    public void removeItem(Dish item) {
        items.remove(item);
        this.currentLoad =- item.getLoad();
        if (currentLoad == 0) {
            isClean = false;
        }
    }

    @Override
    public String toString() {
        return "DishWasher " + id;
    }

    public class Dish extends StorageItem {
        public Dish(String name, double load) {
            super(name, load);
        }
    }
}
