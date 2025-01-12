package cz.cvut.fel.omo.entity;

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
