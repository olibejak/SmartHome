package cz.cvut.fel.omo.house.report;

import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.device.Device;

import java.util.stream.Collectors;

public class ConsumptionReport {

    public static String getConsumptionReport(House house) {
        return house.getFloors().stream()
                .flatMap(floor -> floor.getRooms().stream())
                .flatMap(room -> room.getDevices().stream())
                .map(Device::reportConsumption)
                .collect(Collectors.joining("\n"));
    }
}
