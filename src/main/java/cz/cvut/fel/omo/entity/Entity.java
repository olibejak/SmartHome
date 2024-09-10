package cz.cvut.fel.omo.entity;

import cz.cvut.fel.omo.house.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity {
    private String name;
    private int age;
    private Room room;

    public void goTo(Room room) {

    }

//    public boolean handle(Event event) {
//        return false;
//    }

    public void performActivity() {

    }

//    public Event generate() {
//        return null;
//    }

    public void interactWith(Person person) {

    }

    public void interactWith(Pet pet) {

    }
}
