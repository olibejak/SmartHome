package cz.cvut.fel.omo;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.factory.DeviceFactory;
import cz.cvut.fel.omo.device.factory.OvenFactory;
import cz.cvut.fel.omo.device.factory.TelevisionFactory;
import cz.cvut.fel.omo.device.state.OffDeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.house.RoomType;
import cz.cvut.fel.omo.house.report.ConsumptionReport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       ConsumptionReport ConsumptionReport = new ConsumptionReport();

        Room kitchen = new Room(1, RoomType.KITCHEN, new ArrayList<Device>(Arrays.asList(new Device[]{new TelevisionFactory().createDevice(), new OvenFactory().createDevice()})));
//        Room bathroom = new Room(2, RoomType.BATHROOM);
//        Room bedroom = new Room(3, RoomType.BEDROOM);
//        Room livingRoom = new Room(4, RoomType.LIVING_ROOM);
//        Room toilet = new Room(5, RoomType.TOILET);
//        Room garage = new Room(6, RoomType.GARAGE);
//        Room outside = new Room(7, RoomType.OUTSIDE);

        Floor groundFloor = new Floor(0, new ArrayList<>(Arrays.asList(kitchen)));
//        Floor groundFloor = new Floor(0, new ArrayList<>(Arrays.asList(outside, garage, kitchen, toilet)));
//        Floor firstFloor = new Floor(1, new ArrayList<>(Arrays.asList(bedroom, livingRoom, bathroom)));

//        House house = new House(new ArrayList<>(Arrays.asList(groundFloor, firstFloor)));
        House house = new House(new ArrayList<>(Arrays.asList(groundFloor)));
        System.out.println(house);
        System.out.println();
        System.out.println(house.reportConfiguration());
        System.out.println(ConsumptionReport.getConsumptionReport(house));
        for (Device device: kitchen.getDevices()) {
            device.changeState(new OffDeviceState(device));
            device.update();
        }System.out.println(ConsumptionReport.getConsumptionReport(house));
        for (Device device: kitchen.getDevices()) {
            device.turnOn();
            device.update();
        }System.out.println(ConsumptionReport.getConsumptionReport(house));
        for (Device device: kitchen.getDevices()) {
            device.update();
            device.turnOff();
        }for (Device device: kitchen.getDevices()) {
            device.update();
        }System.out.println(ConsumptionReport.getConsumptionReport(house));
        System.out.println(house.getFloorNumbers());
        System.out.println(house.getRoomIds());
//

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

    }
}
