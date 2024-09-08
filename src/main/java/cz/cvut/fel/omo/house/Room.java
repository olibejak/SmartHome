package cz.cvut.fel.omo.house;

public class Room {
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
}
