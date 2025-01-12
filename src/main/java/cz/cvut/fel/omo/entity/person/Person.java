package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.entity.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person extends Entity implements DeviceVisitor {
    public Person(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    public abstract String accept(PersonVisitor visitor);

    public void interactWith(Device device) {
        logger.info(device.accept(this));
    }
}
