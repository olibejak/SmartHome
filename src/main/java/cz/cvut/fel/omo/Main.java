package cz.cvut.fel.omo;

import cz.cvut.fel.omo.BobTheBuilder.HouseBuilderFacade;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.report.ConsumptionReport;

import static java.util.Objects.nonNull;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Main {
    public static void main(String[] args) {

       ConsumptionReport ConsumptionReport = new ConsumptionReport();
       HouseBuilderFacade HouseBuilder = new HouseBuilderFacade();

       House house = HouseBuilder.buildHouseFromJson("src/main/resources/house.json");

       if(nonNull(house)) {
           System.out.println(house);
           System.out.println();
//           System.out.println(house.reportConfiguration());
//           System.out.println(ConsumptionReport.getConsumptionReport(house));
       }

        System.out.println(house);
        System.out.println();
        System.out.println(house.reportConfiguration());
        System.out.println(ConsumptionReport.getConsumptionReport(house));
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
        System.out.println(ConsumptionReport.getConsumptionReport(house));
        System.out.println(house.getFloorNumbers());
        System.out.println(house.getRoomIds());


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
