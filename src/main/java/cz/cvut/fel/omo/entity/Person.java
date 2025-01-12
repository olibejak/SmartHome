package cz.cvut.fel.omo.entity;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person extends Entity implements DeviceVisitor {
    public Person(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    public abstract String accept(PersonVisitor visitor);

    public void interactWith(Device device) {}
}
