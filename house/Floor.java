package house;

import java.util.ArrayList;

public class Floor {
    private final ArrayList<Room> rooms;

    public Floor(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "rooms=" + rooms +
                '}';
    }
}
