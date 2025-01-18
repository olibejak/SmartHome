package cz.cvut.fel.omo.BobTheBuilder.houseBuilder;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.house.RoomType;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Builder for creating rooms.
 */
@NoArgsConstructor
public class RoomBuilder {

    private Room room;

    public RoomBuilder addDevices(ArrayList<Device> devices) {
        room.getDevices().addAll(devices);
        return this;
    }

    public RoomBuilder addVehicles(ArrayList<Vehicle> vehicles) {
        room.getVehicles().addAll(vehicles);
        return this;
    }

    public RoomBuilder addSportEquipment(ArrayList<SportEquipment> equipment) {
        room.getSportEquipment().addAll(equipment);
        return this;
    }

    public RoomBuilder setRoomType(RoomType type) {
        room.setType(type);
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
