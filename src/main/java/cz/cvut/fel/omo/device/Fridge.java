package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Fridge extends StorageDevice {

    private double minTemperature;
    private double maxTemperature;
    private double currentTemperature;

    public Fridge(UUID id) {
        super(id);
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
        items.add(new StorageItem(name, load));
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
    public void removeItem(StorageItem item) {
        items.remove(item);
        this.currentLoad -= item.load();
        logger.info(this + " :Food " + item.name() + " removed");
    }

    public String removeFirstItem() {
        if (!items.isEmpty()) {
            String firstItem = items.removeFirst().name();
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
            logger.debug(this + " :Temperature " + temperature + " out of range " +
                    minTemperature + " - " + maxTemperature);
        }
        this.currentTemperature = temperature;
        logger.debug(this + " :Setting temperature to " + temperature + "°C");
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.FRIDGE);
    }

    @Override
    public String reportConfiguration() {
        return "Fridge: " + id;
    }

    @Override
    public String toString() {
        return "Fridge " + id + ": " + items;
    }
}
