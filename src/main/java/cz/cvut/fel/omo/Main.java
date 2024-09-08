package cz.cvut.fel.omo;

import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.house.RoomType;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Room kitchen = new Room(RoomType.KITCHEN);
        Room bathroom = new Room(RoomType.BATHROOM);
        Room bedroom = new Room(RoomType.BEDROOM);
        Room livingRoom = new Room(RoomType.LIVING_ROOM);
        Room toilet = new Room(RoomType.TOILET);
        Room garage = new Room(RoomType.GARAGE);
        Room outside = new Room(RoomType.OUTSIDE);

        Floor groundFloor = new Floor(new ArrayList<>(Arrays.asList(outside, garage, kitchen)));
        Floor firstFloor = new Floor(new ArrayList<>(Arrays.asList(bedroom, livingRoom, bathroom, toilet)));

        House house = new House(new ArrayList<>(Arrays.asList(groundFloor, firstFloor)));

        System.out.println(house);
    }
}
