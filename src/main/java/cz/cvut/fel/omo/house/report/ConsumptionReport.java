package cz.cvut.fel.omo.house.report;

import cz.cvut.fel.omo.device.visitor.DeviceConsumptionReportVisitor;
import cz.cvut.fel.omo.house.House;

import java.util.stream.Collectors;

public class ConsumptionReport {

   private final DeviceConsumptionReportVisitor visitor = new DeviceConsumptionReportVisitor();

    public  String getConsumptionReport(House house) {
        return house.getFloors().stream()
                .flatMap(floor -> floor.getRooms().stream())
                .flatMap(room -> room.getDevices().stream())
                .map(device -> device.accept(visitor))
                .collect(Collectors.joining("\n"));
    }
}
