package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.eventManager.EventManager;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.logger.GlobalLogger;
import cz.cvut.fel.omo.simulation.command.CommandContext;
import cz.cvut.fel.omo.simulation.command.InputHandler;
import cz.cvut.fel.omo.utils.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class Simulation implements Runnable{
    protected GlobalLogger logger;

    private House house;
    private ArrayList<Person> family;
    private ArrayList<Pet> pets;

    private EventManager eventManager;

    private GlobalEventGenerator globalEventGenerator;

    private int cycleCount;

    public Simulation(House house, ArrayList<Person> family, ArrayList<Pet> pets, EventManager eventManager) {
        this.house = house;
        this.family = family;
        this.pets = pets;
        this.eventManager = eventManager;
        this.cycleCount = 0;
        this.logger = GlobalLogger.getInstance();
        populateHouseRandomly();
    }

    public void nextCycle() {
        // todo separate into functions when finished - for each loop
        cycleCount++;
        logger.info("======================= START OF CYCLE: " + cycleCount + " =======================");

        // todo remove after testing
        logger.info("Current Local Events:");
        for (Event event : house.getAllDeviceEvents()) {
            logger.info(event.toString());
        }
        logger.info("");


        // 1. family and pets react to global events
        Event globalEvent = GlobalEventGenerator.generateEvent();
        if (globalEvent != null) {
            logger.info("============= NEW GLOBAL EVENT: " + globalEvent + " =============");
            eventManager.getEventQueue().addEvent(globalEvent);
        }

        // 1.1. Dispatch events
        eventManager.dispatchAll();

        // 2. family actions
        for (Person person : family) {
            logger.info("============= CURRENT PERSON: " + person.toString() + " =============");
            //   2.1. find what people, pets, equipment, vehicles, devices and events are in the current room
            CurrentRoomPayload currentRoomPayload = getCurrentRoomPayloadByRoomId(person.getRoomID());
            logger.info("============= CURRENT ROOM LOG =============\n" + currentRoomPayload.getRoomDetailsLog());
            currentRoomPayload.removePerson(person); // Person cannot interact with itself

            logger.info("============= LOCAL EVENTS: " + currentRoomPayload.getCurrentEvents().toString()+ " =============");
            for (Event event : currentRoomPayload.getCurrentEvents()) {
                // todo implement correctly
                logger.debug(event.toString());
                Device tmpDevice = house.getDeviceByID(event.getPayload());
                if (tmpDevice != null) {
                    logger.debug("PERSON REACTS TO LOCAL EVENT:");
                    if (person.reactToEvent(event.getType(), tmpDevice)) {
                        house.getRoomByID(person.getRoomID()).ifPresent(room -> room.removeEvent(event));
                    }
                }
            }

            if (!currentRoomPayload.getCurrentPeople().isEmpty()) {
                logger.info("============= PERSON WITH PERSON INTERACTION =============");
                person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentPeople()));
            }
            if (!currentRoomPayload.getCurrentPets().isEmpty()) {
                logger.info("============= PERSON WITH PET INTERACTION =============");
                person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentPets()));
            }
            if (RandomUtils.coinFLip()) {
                if (RandomUtils.coinFLip()) {
                    if (!currentRoomPayload.getCurrentAvailableEquipment().isEmpty()) {
                        logger.info("============= PERSON WITH SPORT EQUIPMENT INTERACTION =============");
                        person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableEquipment()));
                    }
                } else {
                    if (!currentRoomPayload.getCurrentAvailableVehicles().isEmpty()) {
                        logger.info("============= PERSON WITH VEHICLE INTERACTION =============");
                        person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableVehicles()));
                    }
                }
            } else {
                if (!currentRoomPayload.getCurrentDevices().isEmpty()) {
                    logger.info("============= PERSON WITH DEVICE INTERACTION =============");
                    person.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentDevices()));
                }
            }
        }

        // 3. pet actions
        for (Pet pet : pets) {
            logger.info("CURRENT PET: " + pet.toString());
            CurrentRoomPayload currentRoomPayload = getCurrentRoomPayloadByRoomId(pet.getRoomID());
            logger.info(currentRoomPayload.getRoomDetailsLog());
            currentRoomPayload.removePet(pet); // Pet cannot interact with itself

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
            if (RandomUtils.coinFLip()) {
                // interaction with sport equipment
                if (!currentRoomPayload.getCurrentAvailableEquipment().isEmpty()) {
                    logger.info("PET WITH SPORT EQUIPMENT INTERACTION:");
                    pet.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableEquipment()));
                }
            } else {
                // interaction with vehicle
                if (!currentRoomPayload.getCurrentAvailableVehicles().isEmpty()) {
                    logger.info("PET WITH VEHICLE INTERACTION:");
                    pet.interactWith(RandomUtils.getRandomElement(currentRoomPayload.getCurrentAvailableVehicles()));
                }
            }
        }
        //   2.2. react to local events from CurrentRoomPayload
        //   2.3. interact with people and pets from CurrentRoomPayload - with just one or all ??
        //   2.4. interact with sport equipment, vehicles or devices from CurrentRoomPayload
        //   2.5. make all equipment and vehicles available again

        // 3. device actions
        //   3.1. increase consumption based on the current state
        house.updateAllDevices();

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
        shuffleFamily(); // family shuffles for different interaction order
        shufflePets(); // pets shuffle for different interaction order

        logger.info("======================= END OF CYCLE: " + cycleCount + " =======================\n\n");
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

    public void shuffleFamily() {
        Collections.shuffle(family);
    }

    public void shufflePets() {
        Collections.shuffle(pets);
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
        if (house.getRoomByID(roomId).isPresent()) {
            payload.setCurrentEvents(new ArrayList<>(house.getRoomByID(roomId).get().getEvents()));
        }

        return payload;
    }

    /**
     * Run the simulation.
     * The simulation is controlled by the user input handled in {@link InputHandler}.
     */
    @Override
    public void run() {
        InputHandler inputHandler = new InputHandler();
        inputHandler.getHelp();
        try (Scanner scanner = new Scanner(System.in)) {
            CommandContext context = new CommandContext(house, this);

            while (context.isRunning()) {
                System.out.println("Enter a command:");
                String input = scanner.nextLine().toUpperCase().trim();
                inputHandler.handleInput(input, context);
            }
        } catch (Exception e) {
            logger.error("An error occurred while running the simulation: " + e.getMessage());
        }
    }
}
