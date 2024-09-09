package house;

public class Room implements ConfigurationReport {
    private final RoomType type;

    public Room(RoomType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type=" + type +
                '}';
    }

    @Override
    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append(type);
//        todo device configuration
        return configurationReport.toString();
    }
}
