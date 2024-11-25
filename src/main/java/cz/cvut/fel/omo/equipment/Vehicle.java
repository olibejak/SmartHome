package cz.cvut.fel.omo.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    private String model;
    private int yearOfManufacturing;
    private String color;
    private VehicleType type;
}
