package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.utils.RandomUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class House implements ConfigurationReport {
//    private String address;
//    private String ownerName;

    @Getter
    private final ArrayList<Floor> floors;
//    private final int floorCount;
    private int cycleCount = 0;

    public House(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public void nextCycle() {
        cycleCount++;
        System.out.println(cycleCount);
    }

    public void nextCycles(int count) {
        for (int i = 0; i < count; i++) {
            nextCycle();
        }
    }

    public ArrayList<Integer> getFloorNumbers() {
        ArrayList<Integer> floorNumbers = new ArrayList<Integer>();
        for (Floor floor : floors) {
            floorNumbers.add(floor.getFloorNumber());
        }
        floorNumbers.sort(Comparator.comparingInt(n -> n));
        return floorNumbers;
    }

    // todo functional programming - filters
    public ArrayList<Integer> getRoomIds() {
        ArrayList<Integer> roomIds = new ArrayList<Integer>();
        for (Floor floor : floors) {
            for (Room room : floor.getRooms()) {
                roomIds.add(room.getId());
            }
        }
        roomIds.sort(Comparator.comparingInt(id -> id));
        return roomIds;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                '}';
    }

    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder("House Configuration Report:\n");
        configurationReport.append("\nFloor Configuration:\n");
        for (Floor floor : floors) {
            configurationReport.append(floor.reportConfiguration()).append("\n");
        }
        configurationReport.append("Entity Configuration:\n");
//        todo entities configuration
        configurationReport.append("todo");
        return configurationReport.toString();
    }
}
