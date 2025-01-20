package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.Device;
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

    public RoomType getRoomTypeByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getType)
                .orElse(null);
    }


    public ArrayList<Device> getDevicesByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getDevices)
                .orElse(new ArrayList<>());
    }

    public ArrayList<SportEquipment> getSportEquipmentByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getSportEquipment)
                .orElse(new ArrayList<>());
    }

    public ArrayList<Vehicle> getVehiclesByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getVehicles)
                .orElse(new ArrayList<>());
    }

    @Override
    public String toString() {
        return "House{" + "floors=" + floors + '}';
    }

    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder("House Configuration Report:\n");
        configurationReport.append("\nFloor Configuration:");
        for (Floor floor : floors) {
            configurationReport.append("\n").append(floor.reportConfiguration());
        }
        return configurationReport.toString();
    }
}

