package cz.cvut.fel.omo.BobTheBuilder.builder4builder;

import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.Room;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class FloorBuilder {

    private Floor floor;

    public FloorBuilder addRoom(Room room) {
        floor.getRooms().add(room);
        return this;
    }

    public FloorBuilder addRooms(ArrayList<Room> rooms) {
        floor.getRooms().addAll(rooms);
        return this;
    }

    public Floor build() {
        return floor;
    }

    public FloorBuilder reset(int id) {
       floor = new Floor(id);
       return this;
    }
}
