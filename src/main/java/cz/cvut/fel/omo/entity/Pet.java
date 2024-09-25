package cz.cvut.fel.omo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pet extends Entity {

    private PetType type;

    public Pet(String name, int age, int roomID, PetType type) {
        super(name, age, roomID);
        this.type = type;
    }
}
