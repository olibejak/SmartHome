package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.utils.RandomUtils;

import java.util.ArrayList;

public class House implements ConfigurationReport {
//    private String address;
//    private String ownerName;

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
