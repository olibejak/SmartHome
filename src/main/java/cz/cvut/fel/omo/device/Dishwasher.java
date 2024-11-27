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

    public void addDish(String name, int load) {
        items.add(new Dish(name, load));
        this.currentLoad += load;
    }

    public void removeDishes() {
        items.clear();
        this.currentLoad = 0;
    }

    public void wash() {
        logger.info(this.toString() + " :Washing dishes...");
    }

    @Override
    public String toString() {
        return "DishWasher " + id;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visitDishwasher(this);
    }

    @Override
    public void addItem(String name, double load) {

    }

    @Override
    public void removeAllItems() {
        items.clear();
        this.currentLoad = 0;
    }

    @Override
    public void removeItem(Dish item) {
        items.remove(item);
        this.currentLoad =- item.getLoad();
    }

    public class Dish extends StorageItem {
        public Dish(String name, int load) {
            super(name, load);
        }
    }
}
