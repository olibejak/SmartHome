package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.entity.Entity;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.eventManager.EventListener;
import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.Stack;

@Getter
@Setter
public abstract class Person extends Entity implements DeviceVisitor {
    protected boolean hasDriversLicense;

    public Person(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID);
        this.hasDriversLicense = hasDriversLicense;
    }

    public abstract String accept(PersonVisitor visitor);

    public void interactWith(Device device) {
        logger.info(device.accept(this));
    }
}
