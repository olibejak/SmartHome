package cz.cvut.fel.omo.house;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;

@NoArgsConstructor
@Getter
@Setter
public class House implements ConfigurationReport {
    private final ArrayList<Floor> floors = new ArrayList<>();

    public ArrayList<Integer> getFloorNumbers() {
        ArrayList<Integer> floorNumbers = new ArrayList<Integer>();
        for (Floor floor : floors) {
            floorNumbers.add(floor.getFloorNumber());
        }
        floorNumbers.sort(Comparator.comparingInt(n -> n));
        return floorNumbers;
    }

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
        return configurationReport.toString();
    }
}

