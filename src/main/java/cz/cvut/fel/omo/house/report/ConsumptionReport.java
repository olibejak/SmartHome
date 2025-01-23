package cz.cvut.fel.omo.house.report;

import cz.cvut.fel.omo.device.visitor.DeviceConsumptionReportVisitor;
import cz.cvut.fel.omo.house.House;

import java.util.stream.Collectors;

/**
 * Class that generates a consumption report for a house.
 */
public class ConsumptionReport {

    private static final DeviceConsumptionReportVisitor visitor;

    static {
        visitor = new DeviceConsumptionReportVisitor();
    }

    /**
     * Returns a string representation of the consumption report of the house.
     * @param house the house for which the consumption report is generated
     * @return a string representation of the consumption report of the house
     */
    public static String getConsumptionReport(House house) {
        return house.getFloors().stream()
                .flatMap(floor -> floor.getRooms().stream())
                .flatMap(room -> room.getDevices().stream())
                .map(device -> device.accept(visitor))
                .collect(Collectors.joining("\n"));
    }

    public static String getFloorConsumptionReport(House house, int floorId) {
        return house.getFloors().stream()
                .filter(floor -> floor.getFloorNumber() == floorId)
                .flatMap(floor -> floor.getRooms().stream())
                .flatMap(room -> room.getDevices().stream())
                .map(device -> device.accept(visitor))
                .collect(Collectors.joining("\n"));
    }

    public static String getRoomConsumptionReport(House house, int roomId) {
        return house.getFloors().stream()
                .filter(floor -> floor.getFloorNumber() == roomId / 100)
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .flatMap(room -> room.getDevices().stream())
                .map(device -> device.accept(visitor))
                .collect(Collectors.joining("\n"));
    }
}
