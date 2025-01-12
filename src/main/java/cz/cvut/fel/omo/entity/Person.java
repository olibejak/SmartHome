package cz.cvut.fel.omo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person extends Entity {
    public Person(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    public abstract String accept(PersonVisitor visitor);
}
