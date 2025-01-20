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

//       ConsumptionReport ConsumptionReport = new ConsumptionReport();
//       HouseBuilderFacade HouseBuilder = new HouseBuilderFacade();
//
//       House house = HouseBuilder.buildHouseFromJson("src/main/resources/house.json");
//
//       if(nonNull(house)) {
//           System.out.println(house);
//           System.out.println();
////           System.out.println(house.reportConfiguration());
////           System.out.println(ConsumptionReport.getConsumptionReport(house));
//       }

//        System.out.println(house);
//        System.out.println();
//        System.out.println(house.reportConfiguration());
//        System.out.println(ConsumptionReport.getConsumptionReport(house));
//        for (Device device: kitchen.getDevices()) {
//            device.changeState(new OffDeviceState(device));
//            device.update();
//        }System.out.println(ConsumptionReport.getConsumptionReport(house));
//        for (Device device: kitchen.getDevices()) {
//            device.turnOn();
//            device.update();
//        }System.out.println(ConsumptionReport.getConsumptionReport(house));
//        for (Device device: kitchen.getDevices()) {
//            device.update();
//            device.turnOff();
//        }for (Device device: kitchen.getDevices()) {
//            device.update();
//        }
//        System.out.println(ConsumptionReport.getConsumptionReport(house));
//        System.out.println(house.getFloorNumbers());
//        System.out.println(house.getRoomIds());


        // version 1 - user input
//        Scanner scanner = new Scanner(System.in);
//        int userInput = 0;
//
//        while (true) {
//            System.out.print("Enter an integer greater than 0 and less or equal to 5: ");
//
//            if (scanner.hasNextInt()) {  // Check if input is an integer
//                userInput = scanner.nextInt();
//
//                if (userInput > 0 && userInput <= 5) {  // Validate the range
//                    house.nextCycles(userInput);
//                } else {
//                    System.out.println("Invalid input");
//                    break;
//                }
//            } else {
//                System.out.println("Invalid input");
//                break;
//            }
//        }
//        scanner.close();  // Close the scanner

        // version 2 - timed output
//        for (int i = 0; i < 5; i++) {
//            try {
//                house.nextCycle();
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("An interruption occurred.");
//                break;
//            }
//        }

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

//        Skis skis = new Skis(true, 0, "Blue");
//        Weights weights = new Weights(true, 0);
//
//        Bicycle bicycle = new Bicycle("Wheels", 2012, "Red", 6);
//        Car car = new Car("Skoda", 2008, "White", EngineType.PETROL);

        // devices interactions
//        DeviceDocumentation documentation = new DeviceDocumentation("blank", "blank", 10, "blank", true, "blank");
//        Consumption consumption = new Consumption(10, 10 ,10, 10);

//        Dishwasher dishwasher = new Dishwasher(1, documentation, consumption, 100, 7);
//        mom.interactWith(dishwasher);
//        dad.interactWith(dishwasher);
//        son.interactWith(dishwasher);
//        daughter.interactWith(dishwasher);
//        grandma.interactWith(dishwasher);
//        grandpa.interactWith(dishwasher);

//        Fridge fridge = new Fridge(1, documentation, consumption, 100, 5, 0, 8);
//        fridge.addItem("snack 1", 1);
//        fridge.addItem("snack 2", 1);
//        fridge.addItem("snack 3", 1);
//        fridge.addItem("snack 4", 1);
//        fridge.addItem("snack 5", 1);
//        fridge.addItem("snack 6", 1);
//        mom.interactWith(fridge);
//        dad.interactWith(fridge);
//        son.interactWith(fridge);
//        daughter.interactWith(fridge);
//        grandma.interactWith(fridge);
//        grandpa.interactWith(fridge);

//        Oven oven = new Oven(1, documentation, consumption, 100, Oven.RangeSettingType.BAKE, 227);
//        oven.changeState(new IdleDeviceState(oven));
//        mom.interactWith(oven);
//        dad.interactWith(oven);
//        son.interactWith(oven);
//        daughter.interactWith(oven);
//        grandma.interactWith(oven);
//        grandpa.interactWith(oven);

//        RecordPlayer recordPlayer = new RecordPlayer(1, documentation, consumption, 100);
//        recordPlayer.changeState(new IdleDeviceState(recordPlayer));
//        mom.interactWith(recordPlayer);
//        dad.interactWith(recordPlayer);
//        son.interactWith(recordPlayer);
//        daughter.interactWith(recordPlayer);
//        grandma.interactWith(recordPlayer);
//        grandpa.interactWith(recordPlayer);

//        Television television = new Television(1, documentation, consumption, 100, 0);
//        television.changeState(new IdleDeviceState(television));
//        mom.interactWith(television);
//        dad.interactWith(television);
//        son.interactWith(television);
//        daughter.interactWith(television);
//        grandma.interactWith(television);
//        grandpa.interactWith(television);

//        Thermostat thermostat = new Thermostat(1, documentation, consumption, 100, 18, 24);
//        thermostat.changeState(new IdleDeviceState(thermostat));
//        mom.interactWith(thermostat);
//        dad.interactWith(thermostat);
//        son.interactWith(thermostat);
//        daughter.interactWith(thermostat);
//        grandma.interactWith(thermostat);
//        grandpa.interactWith(thermostat);

//        WashingMachine washingMachine = new WashingMachine(1, documentation, consumption, 100, 5);
//        washingMachine.changeState(new IdleDeviceState(washingMachine));
//        mom.interactWith(washingMachine);
//        dad.interactWith(washingMachine);
//        son.interactWith(washingMachine);
//        daughter.interactWith(washingMachine);
//        grandma.interactWith(washingMachine);
//        grandpa.interactWith(washingMachine);

//        Window window = new Window(1, documentation, consumption, 100, false, false);
//        mom.interactWith(window);
//        dad.interactWith(window);
//        son.interactWith(window);
//        daughter.interactWith(window);
//        grandma.interactWith(window);
//        grandpa.interactWith(window);

//        mom.interactWith(dad);
//        dad.interactWith(son);
//        son.interactWith(daughter);
//        daughter.interactWith(grandma);
//        grandma.interactWith(grandpa);
//        grandma.interactWith(dog);
//        dog.interactWith(cat);
//        cat.interactWith(hamster);
//        hamster.interactWith(mom);
//
//        dad.interactWith(skis);
//        dad.interactWith(weights);
//        dad.interactWith(bicycle);
//        dad.interactWith(car);

        EventManager eventManager = new EventManager();
        EventQueue eventQueue = new EventQueue(eventManager);

        HouseBuilderFacade HouseBuilder = new HouseBuilderFacade(eventQueue);

        House house = HouseBuilder.buildHouseFromJson("src/main/resources/house.json");

//        if(nonNull(house)) {
////           System.out.println(house);
////           System.out.println();
//           System.out.println(house.reportConfiguration());
////           System.out.println(ConsumptionReport.getConsumptionReport(house));
//       }

        Simulation simulation = new Simulation(house, family, pets, eventQueue);
        simulation.nextCycle();
        System.out.println();
//        simulation.nextCycle();
    }
}
