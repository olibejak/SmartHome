package cz.cvut.fel.omo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends Entity {

    private PersonType type;

    public Person(String name, int age, int roomID, PersonType type) {
        super(name, age, roomID);
        this.type = type;
    }
}
