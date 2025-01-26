package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.device.visitor.EmptyDeviceVisitor;
import cz.cvut.fel.omo.device.visitor.FinishedDeviceVisitor;
import cz.cvut.fel.omo.entity.Entity;
import cz.cvut.fel.omo.entity.strategy.EventStrategy;
import cz.cvut.fel.omo.event.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person extends Entity implements DeviceVisitor, EmptyDeviceVisitor, FinishedDeviceVisitor {
    protected boolean hasDriversLicense;
    private EventStrategy eventStrategy;

    public Person(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID);
        this.hasDriversLicense = hasDriversLicense;
    }

    public abstract String accept(PersonVisitor visitor);

    public void interactWith(Device device) {
        logger.info(device.acceptDeviceVisitor(this));
    }

    public abstract boolean reactToBrokenDevice(Device device);

    public boolean reactToEvent(EventType eventType, Device device) {
        // TODO HashMap

        if (eventType == EventType.DEVICE_EMPTY) {
            return device.acceptEmptyDeviceVisitor(this);
//            setEventStrategy(new DeviceEmptyStrategy());
        }
        if (eventType == EventType.DEVICE_FULL) {
            device.turnOn(); // test if it really works like this
            return true;
//            setEventStrategy(new DeviceFullStrategy());
        }
        if (eventType == EventType.DEVICE_FINISHED) {
            return device.acceptFinishedDeviceVisitor(this);
//            setEventStrategy(new DeviceFinishedStrategy());
        }
        if (eventType == EventType.DEVICE_BROKEN) {
            return reactToBrokenDevice(device);
//            setEventStrategy(new DeviceBrokenStrategy());
        }

        // TODO error if other event type

        return eventStrategy.reactToEvent(device);
    }

//    // every device
//    private class DeviceBrokenStrategy implements EventStrategy {
//        @Override
//        public boolean reactToEvent(Device device) {
//            // template method
//            return reactToBrokenDevice(device);
//        }
//    }

//    // fridge - visitor to call device specific method
//    private class DeviceEmptyStrategy implements EventStrategy {
//        @Override
//        public boolean reactToEvent(Device device) {
//            ;
//            return true;
//        }
//    }

//    // dishwasher, washing machine - visitor to call device specific method
//    private class DeviceFullStrategy implements EventStrategy {
//        @Override
//        public boolean reactToEvent(Device device) {
//            device.turnOn(); // test if it really works like this
//            return true;
//        }
//    }

//    // dishwasher, washing machine - visitor to call device specific method
//    private class DeviceFinishedStrategy implements EventStrategy {
//        @Override
//        public boolean reactToEvent(Device device) {
//            return true;
//        }
//    }
}
