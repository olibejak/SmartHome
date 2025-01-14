package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Simulation {
    protected GlobalLogger logger;

    private House house;
    private ArrayList<Person> family;
    private ArrayList<Pet> pets;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<SportEquipment> equipment;

    private int cycleCount;

    public Simulation(House house, ArrayList<Person> family, ArrayList<Pet> pets, ArrayList<Vehicle> vehicles, ArrayList<SportEquipment> equipment) {
        this.house = house;
        this.family = family;
        this.pets = pets;
        this.vehicles = vehicles;
        this.equipment = equipment;
        this.cycleCount = 0;
        this.logger = GlobalLogger.getInstance();
    }

    public Simulation(House house, ArrayList<Person> family, ArrayList<Pet> pets, ArrayList<Vehicle> vehicles, ArrayList<SportEquipment> equipment, int cycleCount) {
        this.house = house;
        this.family = family;
        this.pets = pets;
        this.vehicles = vehicles;
        this.equipment = equipment;
        this.cycleCount = cycleCount;
        this.logger = GlobalLogger.getInstance();
    }

    public void nextCycle() {
        cycleCount++;
        logger.info("Current cycle:" + cycleCount);
    }

    public void nextCycles(int count) {
        for (int i = 0; i < count; i++) {
            nextCycle();
        }
    }
}
