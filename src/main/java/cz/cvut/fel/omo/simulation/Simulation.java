package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
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

    private EventQueue eventQueue;

    private int cycleCount;

    public Simulation(House house, ArrayList<Person> family, ArrayList<Pet> pets, EventQueue eventQueue) {
        this.house = house;
        this.family = family;
        this.pets = pets;
        this.eventQueue = eventQueue;
        this.cycleCount = 0;
        this.logger = GlobalLogger.getInstance();
    }

    public Simulation(House house, ArrayList<Person> family, ArrayList<Pet> pets, EventQueue eventQueue, int cycleCount) {
        this.house = house;
        this.family = family;
        this.pets = pets;
        this.eventQueue = eventQueue;
        this.cycleCount = cycleCount;
        this.logger = GlobalLogger.getInstance();
    }

    public void nextCycle() {
        cycleCount++;
        logger.info("Current cycle:" + cycleCount);

        // 1. family and pets react to global events

        // 2. family and pets actions
        // - for each person and pet - two loops
        for (Person person : family) {
            logger.info(person.toString());
        }
        //   2.1. find what people, pets, equipment, vehicles and events are in the current room
        //   - special class CurrentRoomPayload with all of the above?? - findCurrentRoomPayloadByRoomID()
        //   2.2. react to local events from CurrentRoomPayload
        //   2.3. interact with people and pets from CurrentRoomPayload - with just one or all ??
        //   2.4. interact with sport equipment, vehicles or devices from CurrentRoomPayload - probably with just one
        //   2.5. make all equipment and vehicles available again
        // 3. device actions
        //   3.1. increase consumption based on the current state
        // 4. family and pets movement
        // - random choice?? probability tables??
    }

    public void nextCycles(int count) {
        for (int i = 0; i < count; i++) {
            nextCycle();
        }
    }

    // todo run method - next cycle every specified interval ??
}
