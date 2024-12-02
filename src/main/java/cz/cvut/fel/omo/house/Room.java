package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.device.Device;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Room implements ConfigurationReport {

    private final int id;
    private RoomType type;
    private final ArrayList<Device> devices = new ArrayList<>();

    public Room(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }

    @Override
    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append(id).append(" ").append(type);
//        todo device configuration
        return configurationReport.toString();
    }
}
