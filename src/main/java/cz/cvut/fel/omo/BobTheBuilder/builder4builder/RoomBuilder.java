package cz.cvut.fel.omo.BobTheBuilder.builder4builder;

import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceDTO;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.house.Room;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class RoomBuilder {

    private Room room;

    public RoomBuilder addDevices(ArrayList<Device> devices) {
        room.getDevices().addAll(devices);
        return this;
    }

    public RoomBuilder addDevice(Device device) {
        room.getDevices().add(device);
        return this;
    }

    public Room build() {
        return room;
    }

    public RoomBuilder reset(int id) {
        room = new Room(id);
        return this;
    }
}
