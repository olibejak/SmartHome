package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Fridge extends StorageDevice<Fridge.Food> {

    private double minTemperature;
    private double maxTemperature;
    private double currentTemperature;

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

    public void setTemperature(double temperature) {
        if (temperature < minTemperature || temperature > maxTemperature) {
            logger.info(this + " :Temperature " + temperature + " out of range " +
                    minTemperature + " - " + maxTemperature);
        }
        this.currentTemperature = temperature;
        logger.info(this + " :Setting temperature to " + temperature + "°C");
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.FRIDGE);
    }

    @Override
    public String toString() {
        return "Fridge " + id;
    }

    public class Food extends StorageItem {
        public Food(String name, double load) {
            super(name, load);
        }
    }
}
