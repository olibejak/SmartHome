package cz.cvut.fel.omo.entity;

import cz.cvut.fel.omo.house.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Entity {
    private String name;
    private int age;
    private int roomID;


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
