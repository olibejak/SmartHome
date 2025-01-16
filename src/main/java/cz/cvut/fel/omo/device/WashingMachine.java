package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WashingMachine extends StorageDevice {

    private boolean isClean;

    @Override
    public void turnOn() {
        if (isClean) {
            logger.info(this + " cannot start washing, washing machine is already clean");
            return;
        }
        if (this.currentLoad > 0) {
            logger.info(this + " started washing ");
            super.turnOn();
            return;
        }
        logger.info(this + " cannot start washing, no wash selected");
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
        items.add(new StorageItem(name, load));
        logger.info(this + " wash " + name + " added");
    }

    @Override
    public void removeAllItems() {
        items.clear();
        logger.info(this + " all washes removed");
    }

    @Override
    public void removeItem(StorageItem item) {
        items.remove(item);
        logger.info(this + " wash " + item.getName() + " removed");
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.WASHING_MACHINE);
    }

    @Override
    public String toString() {
        return "Washing machine " + id;
    }
}
