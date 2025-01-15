package cz.cvut.fel.omo.house;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

//@NoArgsConstructor(force = true)
@Getter
@Setter
public class Floor implements ConfigurationReport {
    private final int floorNumber;
    private final ArrayList<Room> rooms;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.rooms = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Floor{" + "floorNumber=" + floorNumber + ", rooms=" + rooms + '}';
    }

    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder("Floor #" + floorNumber + "\n");
        for (Room room : rooms) {
            configurationReport.append(room.reportConfiguration()).append("\n");
        }
        return configurationReport.toString();
    }
}
