package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.entity.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a pet entity in the smart home simulation.
 * This class extends {@link Entity} and implements the Visitor pattern for interaction with other entities.
 */
@Setter
@Getter
public abstract class Pet extends Entity {
    public Pet(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    /**
     * Accepts a visitor for interaction with the pet.
     *
     * @param visitor The visitor interacting with this pet.
     * @return A message describing the interaction.
     */
    public abstract String accept(PetVisitor visitor);
}
