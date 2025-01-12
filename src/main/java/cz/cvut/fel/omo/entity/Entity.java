package cz.cvut.fel.omo.entity;

import cz.cvut.fel.omo.equipment.SportEquipment;
import cz.cvut.fel.omo.equipment.Vehicle;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity implements PersonVisitor, PetVisitor {
    protected GlobalLogger logger;

    private String name;
    private int age;
    private int roomID;

    public Entity(String name, int age, int roomID) {
        this.name = name;
        this.age = age;
        this.roomID = roomID;
        this.logger = GlobalLogger.getInstance();
    }

    public void goToRoom(int roomID) {
        // TODO check if room exists
        this.roomID = roomID;
    }

    public void interactWith(Person person) {
        logger.info(person.accept(this));
    }

    public void interactWith(Pet pet) {
        logger.info(pet.accept(this));
    }

    public void interactWith(Vehicle vehicle) {}

    public void interactWith(SportEquipment sportEquipment) {}
}
