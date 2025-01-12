package cz.cvut.fel.omo.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    private String model;
    private int yearOfManufacturing;
    private String color;
    private VehicleType type;
    private boolean isAvailable;

    public Vehicle(String model, int yearOfManufacturing, String color, VehicleType type) {
        this.model = model;
        this.yearOfManufacturing = yearOfManufacturing;
        this.color = color;
        this.type = type;
        this.isAvailable = true;
    }
}
