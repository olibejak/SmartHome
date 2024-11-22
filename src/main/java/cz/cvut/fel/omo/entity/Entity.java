package cz.cvut.fel.omo.entity;

import cz.cvut.fel.omo.equipment.SportEquipment;
import cz.cvut.fel.omo.equipment.Vehicle;
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

    public void goToRoom(int roomID) {
        // TODO check if room exists
        this.roomID = roomID;
    }

    public void interactWith(Person person) {

    }

    public void interactWith(Pet pet) {

    }

    public void interactWith(Vehicle vehicle) {

    }

    public void interactWith(SportEquipment sportEquipment) {

    }
}
