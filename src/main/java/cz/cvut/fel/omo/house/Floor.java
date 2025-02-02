package cz.cvut.fel.omo.house;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Represents a floor in the house, containing multiple rooms.
 */
@Getter
@Setter
public class Floor implements ConfigurationReport {
    private final int floorNumber;
    private final ArrayList<Room> rooms;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.rooms = new ArrayList<>();
    }

    /**
     * Generates a configuration report for the floor, listing all rooms.
     * @return A formatted string containing the floor's configuration.
     */
    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder("\tFloor #" + floorNumber);
        for (Room room : rooms) {
            configurationReport.append(room.reportConfiguration());
        }
        return configurationReport.toString();
    }

    @Override
    public String toString() {
        return "Floor{" + "floorNumber=" + floorNumber + ", rooms=" + rooms + '}';
    }
}
