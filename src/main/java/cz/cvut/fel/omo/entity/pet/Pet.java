package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.entity.Entity;
import cz.cvut.fel.omo.entity.pet.PetVisitor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Pet extends Entity {
    public Pet(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    public abstract String accept(PetVisitor visitor);
}
