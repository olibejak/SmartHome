package main;

import cz.cvut.fel.omo.BobTheBuilder.HouseBuilderFacade;
import cz.cvut.fel.omo.event.eventManager.EventManager;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.simulation.Simulation;

public class Main {
    public static void main(String[] args) {

        // Event manager is used to manage events in the simulation
        EventManager eventManager = new EventManager();

        // HouseBuilderFacade is used to build a house from a JSON file
        House house = new HouseBuilderFacade(eventManager)
                .buildHouseFromJson("src/main/resources/house.json");

        // EntityInitialization is used to initialize the family and pets
        EntityInitialization entityInitialization = new EntityInitialization();

        // Simulation is used to run the simulation
        Simulation simulation = new Simulation(house, entityInitialization.getFamily(),
                entityInitialization.getPets(), eventManager);

        // Run the simulation
        simulation.run();
    }
}
