package cz.cvut.fel.omo;

import cz.cvut.fel.omo.BobTheBuilder.HouseBuilderFacade;
import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.activity.vehicle.EngineType;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.device.state.IdleDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.entity.person.*;
import cz.cvut.fel.omo.entity.pet.Cat;
import cz.cvut.fel.omo.entity.pet.Dog;
import cz.cvut.fel.omo.entity.pet.Hamster;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.eventManager.EventManager;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.simulation.Simulation;

import java.util.ArrayList;

import static java.util.Objects.nonNull;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Main {
    public static void main(String[] args) {

        // Family
        Mom mom = new Mom("Jane", 39, 1, true);
        Dad dad = new Dad("John", 41, 1, true);
        Son son = new Son("Jake", 9, 1, false);
        Daughter daughter = new Daughter("Jessica", 7, 1, false);
        Grandma grandma = new Grandma("Janet", 68, 1, false);
        Grandpa grandpa = new Grandpa("Joe", 71, 1, true);

        ArrayList<Person> family = new ArrayList<>();
        family.add(mom);
        family.add(dad);
        family.add(daughter);
        family.add(son);
        family.add(grandma);
        family.add(grandpa);

        // Pets
        Dog dog = new Dog("Max", 4, 1);
        Cat cat = new Cat("Coots", 3, 1);
        Hamster hamster = new Hamster("Jerry", 2, 1);

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(dog);
        pets.add(cat);
        pets.add(hamster);

        EventManager eventManager = new EventManager();

        HouseBuilderFacade HouseBuilder = new HouseBuilderFacade(eventManager);

        House house = HouseBuilder.buildHouseFromJson("src/main/resources/house_big.json");

                if (nonNull(house)) {
            // Iterate over all devices in the house and get documentation
            house.getFloors().forEach(floor ->
                    floor.getRooms().forEach(room ->
                            room.getDevices().forEach(Device::getDocumentation)
                    )
            );
        }

//        if(nonNull(house)) {
////           System.out.println(house);
////           System.out.println();
////           System.out.println(house.reportConfiguration());
////           System.out.println(ConsumptionReport.getConsumptionReport(house));
//       }

        Simulation simulation = new Simulation(house, family, pets, eventManager.getEventQueue());
//        simulation.run();
//        simulation.nextCycle();
//        System.out.println();
//        simulation.nextCycle();
//        System.out.println();
//        simulation.nextCycle();
    }
}
