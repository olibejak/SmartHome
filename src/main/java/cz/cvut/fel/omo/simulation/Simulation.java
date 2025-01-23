package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.event.eventManager.EventQueue;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.logger.GlobalLogger;
import cz.cvut.fel.omo.utils.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        populateHouseRandomly();
    }

    public Simulation(House house, ArrayList<Person> family, ArrayList<Pet> pets, EventQueue eventQueue, int cycleCount) {
        this.house = house;
        this.family = family;
        this.pets = pets;
        this.eventQueue = eventQueue;
        this.cycleCount = cycleCount;
        this.logger = GlobalLogger.getInstance();
        populateHouseRandomly();
    }

    public void nextCycle() {
        cycleCount++;
        logger.info("CURRENT CYCLE: " + cycleCount);

        // todo separate into functions when finished - for each loop

        // 1. family and pets react to global events
        logger.info("GLOBAL EVENTS:"); // todo implement

        // 2. family and pets actions
        //   2.1. find what people, pets, equipment, vehicles, devices and events are in the current room

        for (Person person : family) { // todo maybe shuffle family each cycle?
            logger.info("CURRENT PERSON: " + person.toString());
            CurrentRoomPayload currentRoomPayload = getCurrentRoomPayloadByRoomId(person.getRoomID());
            logger.info(currentRoomPayload.getRoomDetailsLog());
            currentRoomPayload.removePerson(person); // Person cannot interact with itself

            logger.info("LOCAL EVENTS:");
            // todo reaction to local events

            // interaction with person
            if (!currentRoomPayload.getCurrentPeople().isEmpty()) {
                logger.info("PERSON WITH PERSON INTERACTION:");
                person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentPeople()));
            }
            // interaction with pet
            if (!currentRoomPayload.getCurrentPets().isEmpty()) {
                logger.info("PERSON WITH PET INTERACTION:");
                person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentPets()));
            }
            // todo implement more sophistical choice of interaction between equipment/vehicle/device - 50/25/25
            // interaction with sport equipment
            if (!currentRoomPayload.getCurrentEquipment().isEmpty()) {
                logger.info("PERSON WITH SPORT EQUIPMENT INTERACTION:");
                person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableEquipment()));
            }
            // interaction with vehicle
            if (!currentRoomPayload.getCurrentVehicles().isEmpty()) {
                logger.info("PERSON WITH VEHICLE INTERACTION:");
                person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableVehicles()));
            }
            // interaction with device
            if (!currentRoomPayload.getCurrentDevices().isEmpty()) {
                logger.info("PERSON WITH DEVICE INTERACTION:");
                person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentDevices()));
            }
        }

        for (Pet pet : pets) {
            logger.info("CURRENT PET: " + pet.toString());
            CurrentRoomPayload currentRoomPayload = getCurrentRoomPayloadByRoomId(pet.getRoomID());
            logger.info(currentRoomPayload.getRoomDetailsLog());
            currentRoomPayload.removePet(pet); // Pet cannot interact with itself

            logger.info("LOCAL EVENTS:");
            // todo reaction to local events

            // interaction with person - random one
            if (!currentRoomPayload.getCurrentPeople().isEmpty()) {
                logger.info("PET WITH PERSON INTERACTION:");
                pet.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentPeople()));
            }
            // interaction with pet - random one
            if (!currentRoomPayload.getCurrentPets().isEmpty()) {
                logger.info("PET WITH PET INTERACTION:");
                pet.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentPets()));
            }
            // interaction with sport equipment
            if (!currentRoomPayload.getCurrentEquipment().isEmpty()) {
                logger.info("PET WITH SPORT EQUIPMENT INTERACTION:");
                pet.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableEquipment()));
            }
            // interaction with vehicle
            if (!currentRoomPayload.getCurrentVehicles().isEmpty()) {
                logger.info("PET WITH VEHICLE INTERACTION:");
                pet.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableVehicles()));
            }
        }
        //   2.2. react to local events from CurrentRoomPayload
        //   2.3. interact with people and pets from CurrentRoomPayload - with just one or all ??
        //   2.4. interact with sport equipment, vehicles or devices from CurrentRoomPayload
        //   2.5. make all equipment and vehicles available again

        // 3. device actions // todo
        //   3.1. increase consumption based on the current state
        // todo implement function in house that updates all devices

        // 4. family and pets movement
        logger.info("FAMILY MOVEMENT:");
        for (Person person : family) {
            person.moveToRoomRandomly(house.getRoomIds());
        }
        logger.info("PETS MOVEMENT:");
        for (Pet pet : pets) {
            pet.moveToRoomRandomly(house.getRoomIds());
        }

        house.makeAllVehiclesAndEquipmentAvailable();
    }

    public void nextCycles(int count) {
        for (int i = 0; i < count; i++) {
            nextCycle();
        }
    }

    public void populateHouseRandomly() {
        for (Person person : family) {
            person.setInitialRoomRandomly(house.getRoomIds());
        }
        for (Pet pet : pets) {
            pet.setInitialRoomRandomly(house.getRoomIds());
        }
    }

    public ArrayList<Person> getFamilyByRoomId(int roomId) {
        return family.stream()
                .filter(person -> person.getRoomID() == roomId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Pet> getPetsByRoomId(int roomId) {
        return pets.stream()
                .filter(pet -> pet.getRoomID() == roomId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public CurrentRoomPayload getCurrentRoomPayloadByRoomId(int roomId) {
        CurrentRoomPayload payload = new CurrentRoomPayload();
        payload.setCurrentRoomId(roomId);
        payload.setCurrentRoomType(house.getRoomTypeByRoomId(roomId));

        // Set family members in the room
        payload.setCurrentPeople(getFamilyByRoomId(roomId));
        // Set pets in the room
        payload.setCurrentPets(getPetsByRoomId(roomId));
        // Set sports equipment in the room
        payload.setCurrentEquipment(house.getSportEquipmentByRoomId(roomId));
        // Set vehicles in the room
        payload.setCurrentVehicles(house.getVehiclesByRoomId(roomId));
        // Set devices in the room
        payload.setCurrentDevices(house.getDevicesByRoomId(roomId));
        // Set events in the room
        payload.setCurrentEvents(eventQueue.getEventsByRoomId(roomId));

        return payload;
    }



    // todo run method - next cycle every specified interval ??
}
