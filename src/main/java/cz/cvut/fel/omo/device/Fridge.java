package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;

public class Fridge extends StorageDevice<Fridge.Food> {

    private final double minTemperature;
    private final double maxTemperature;
    private double currentTemperature;

    public Fridge(int id, DeviceDocumentation documentation, Consumption consumption, int durability, double maxLoad
            , double minTemperature, double maxTemperature) {
        super(id, documentation, consumption, durability, maxLoad);
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = ( minTemperature + maxTemperature ) / 2;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visitFridge(this);
    }

    @Override
    public void addItem(String name, double load) {

    }

    @Override
    public void removeAllItems() {

    }

    @Override
    public void removeItem(Food item) {

    }

    public void setTemperature(double temperature) {
        if (temperature < minTemperature || temperature > maxTemperature) {
            logger.info(this.toString() + " :Temperature " + temperature + " out of range " +
                    minTemperature + " - " + maxTemperature);
        }
        this.currentTemperature = temperature;
        logger.info(this.toString() + " :Setting temperature to " + temperature + "°C");
    }

    @Override
    public String toString() {
        return "Fridge " + id;
    }

    protected class Food extends StorageItem {
        public Food(String name, int load) {
            super(name, load);
        }
    }
}
