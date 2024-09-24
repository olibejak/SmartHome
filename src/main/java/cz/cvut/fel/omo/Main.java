package cz.cvut.fel.omo;

import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.house.RoomType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room kitchen = new Room(RoomType.KITCHEN);
        Room bathroom = new Room(RoomType.BATHROOM);
        Room bedroom = new Room(RoomType.BEDROOM);
        Room livingRoom = new Room(RoomType.LIVING_ROOM);
        Room toilet = new Room(RoomType.TOILET);
        Room garage = new Room(RoomType.GARAGE);
        Room outside = new Room(RoomType.OUTSIDE);

        Floor groundFloor = new Floor(0, new ArrayList<>(Arrays.asList(outside, garage, kitchen, toilet)));
        Floor firstFloor = new Floor(1, new ArrayList<>(Arrays.asList(bedroom, livingRoom, bathroom)));

        House house = new House(new ArrayList<>(Arrays.asList(groundFloor, firstFloor)));

//        System.out.println(house);
        System.out.println();
//        System.out.println(house.reportConfiguration());


        // version 1 - user input
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        while (true) {
            System.out.print("Enter an integer greater than 0 and less or equal to 5: ");

            if (scanner.hasNextInt()) {  // Check if input is an integer
                userInput = scanner.nextInt();

                if (userInput > 0 && userInput <= 5) {  // Validate the range
                    house.nextCycles(userInput);
                } else {
                    System.out.println("Invalid input");
                    break;
                }
            } else {
                System.out.println("Invalid input");
                break;
            }
        }
        scanner.close();  // Close the scanner

        // version 2 - timed output
        for (int i = 0; i < 5; i++) {
            try {
                house.nextCycle();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An interruption occurred.");
                break;
            }
        }

    }
}
