package cz.cvut.fel.omo.entity;

import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.person.PersonVisitor;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.entity.pet.PetVisitor;
import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.equipment.SportEquipmentVisitor;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.activity.vehicle.VehicleVisitor;
import cz.cvut.fel.omo.logger.GlobalLogger;
import cz.cvut.fel.omo.utils.RandomUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Represents an entity in the smart home simulation.
 * This class is an abstract base for both people and pets and implements the Visitor pattern
 * to facilitate interactions between different entity types.
 * Implements:
 * - {@link PersonVisitor} for visiting person entities.
 * - {@link PetVisitor} for visiting pet entities.
 * - {@link VehicleVisitor} for visiting vehicle entities.
 * - {@link SportEquipmentVisitor} for visiting sport equipment entities.
 */
@Getter
@Setter
public abstract class Entity implements PersonVisitor, PetVisitor, VehicleVisitor, SportEquipmentVisitor {
    protected GlobalLogger logger;

    protected String name;
    protected int age;
    protected int roomID;

    public Entity(String name, int age, int roomID) {
        this.name = name;
        this.age = age;
        this.roomID = roomID;
        this.logger = GlobalLogger.getInstance();
    }

    /**
     * Moves the entity to a specified room.
     *
     * @param roomID The ID of the destination room.
     */
    public void moveToRoom(int roomID) {
        this.roomID = roomID;
    }

    /**
     * Assigns the entity to a random initial room from the available room list.
     *
     * @param roomIds The list of available room IDs.
     */
    public void setInitialRoomRandomly(ArrayList<Integer> roomIds) {
        this.roomID = RandomUtils.getRandomElement(roomIds);
    }

    /**
     * Moves the entity to a random room from the available room list and logs the movement.
     *
     * @param roomIds The list of available room IDs.
     */
    public void moveToRoomRandomly(ArrayList<Integer> roomIds) {
        int currentRoomId = this.roomID;
        this.roomID = RandomUtils.getRandomElement(roomIds);
        logger.info(this + " moved from Room #" + currentRoomId + " to Room #" + this.roomID);
    }

    /**
     * Allows interaction between this entity and a person.
     * Uses the Visitor pattern to facilitate interaction logic.
     *
     * @param person The person entity to interact with.
     */
    public void interactWith(Person person) {
        logger.info(person.accept(this));
    }

    /**
     * Allows interaction between this entity and a pet.
     * Uses the Visitor pattern to facilitate interaction logic.
     *
     * @param pet The pet entity to interact with.
     */
    public void interactWith(Pet pet) {
        logger.info(pet.accept(this));
    }

    /**
     * Allows interaction between this entity and a vehicle.
     * Uses the Visitor pattern to facilitate interaction logic.
     *
     * @param vehicle The vehicle to interact with.
     */
    public void interactWith(Vehicle vehicle) {
        logger.info(vehicle.accept(this));
    }

    /**
     * Allows interaction between this entity and sport equipment.
     * Uses the Visitor pattern to facilitate interaction logic.
     *
     * @param sportEquipment The sport equipment to interact with.
     */
    public void interactWith(SportEquipment sportEquipment) {
        logger.info(sportEquipment.accept(this));
    }
}
