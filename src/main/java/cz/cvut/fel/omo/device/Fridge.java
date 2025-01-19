package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;

public class Fridge extends StorageDevice<Fridge.Food> {

    private final double minTemperature;
    private final double maxTemperature;
    @Getter
    private double currentTemperature;

    public Fridge(int id, DeviceDocumentation documentation, Consumption consumption, int durability, double maxLoad,
                  double minTemperature, double maxTemperature) {
        super(id, documentation, consumption, durability, maxLoad);
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = ( minTemperature + maxTemperature ) / 2;
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitFridge(this);
    }

    @Override
    public void addItem(String name, double load) {
        if (this.currentLoad + load > this.maxLoad) {
            logger.info(this + " :Cannot add " + name + ", fridge is full");
            return;
        }
        items.add(new Food(name, load));
        this.currentLoad += load;
        logger.info(this + " :Food " + name + " added");
    }

    @Override
    public void removeAllItems() {
        items.clear();
        this.currentLoad = 0;
        logger.info(this + " :All food removed");
    }

    @Override
    public void removeItem(Food item) {
        items.remove(item);
        this.currentLoad -= item.getLoad();
        logger.info(this + " :Food " + item.getName() + " removed");
    }

    public String removeFirstItem() {
        if (!items.isEmpty()) {
            String firstItem = items.removeFirst().name;
            if (items.isEmpty()) {
                logger.info(this + " : Fridge is empty - GENERATE EVENT");
                // todo generate event - empty fridge
            }
            return firstItem;
        }
        logger.info(this + " : Fridge is empty");
        return "";
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void setTemperature(double temperature) {
        if (temperature < minTemperature || temperature > maxTemperature) {
            logger.info(this + " :Temperature " + temperature + " out of range " +
                    minTemperature + " - " + maxTemperature);
        }
        this.currentTemperature = temperature;
        logger.info(this + " :Setting temperature to " + temperature + "°C");
    }

    @Override
    public String toString() {
        return "Fridge " + id + ": " + items;
    }

    public class Food extends StorageItem {
        public Food(String name, double load) {
            super(name, load);
        }

        @Override
        public String toString() {
            return name + ": " + load;
        }
    }
}
