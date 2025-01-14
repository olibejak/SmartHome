package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.house.House;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Simulation {
    private House house;
    private ArrayList<Person> family;
    private ArrayList<Pet> pets;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<SportEquipment> equipment;

    private int cycleCount = 0;

    public void nextCycle() {
        cycleCount++;
        System.out.println(cycleCount);
    }

    public void nextCycles(int count) {
        for (int i = 0; i < count; i++) {
            nextCycle();
        }
    }
}
