package cz.cvut.fel.omo;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.activity.vehicle.EngineType;
import cz.cvut.fel.omo.entity.person.*;
import cz.cvut.fel.omo.entity.pet.Cat;
import cz.cvut.fel.omo.entity.pet.Dog;
import cz.cvut.fel.omo.entity.pet.Hamster;

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

        // Entity interaction showcase
        Mom alice = new Mom("Alice", 35, 1, true);
        Mom sarah = new Mom("Sarah", 30, 1, true);
        Dog buddy = new Dog("Buddy", 3, 1);
        Dog max = new Dog("Max", 5, 1);

        alice.interactWith(alice);
        alice.interactWith(sarah);
        alice.interactWith(buddy);

        buddy.interactWith(buddy);
        buddy.interactWith(max);
        buddy.interactWith(alice);

        // Family
        Mom mom = new Mom("Jane", 39, 1, true);
        Dad dad = new Dad("John", 41, 1, true);
        Son son = new Son("Jake", 9, 1, false);
        Daughter daughter = new Daughter("Jessica", 7, 1, false);
        Grandma grandma = new Grandma("Janet", 68, 1, false);
        Grandpa grandpa = new Grandpa("Joe", 71, 1, true);

        Dog dog = new Dog("Max", 4, 1);
        Cat cat = new Cat("Coots", 3, 1);
        Hamster hamster = new Hamster("Jerry", 2, 1);

        Skis skis = new Skis(true, 0, "Blue");
        Weights weights = new Weights(true, 0);

        Bicycle bicycle = new Bicycle("Wheels", 2012, "Red", 6);
        Car car = new Car("Skoda", 2008, "White", EngineType.PETROL);

        mom.interactWith(dad);
        dad.interactWith(son);
        son.interactWith(daughter);
        daughter.interactWith(grandma);
        grandma.interactWith(grandpa);
        grandma.interactWith(dog);
        dog.interactWith(cat);
        cat.interactWith(hamster);
        hamster.interactWith(mom);

        dad.interactWith(skis);
        dad.interactWith(weights);
        dad.interactWith(bicycle);
        dad.interactWith(car);

    }
}
