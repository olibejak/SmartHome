package cz.cvut.fel.omo.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    protected String model;
    protected int yearOfManufacturing;
    protected String color;
    protected VehicleType type;
    protected boolean isAvailable;

    public Vehicle(String model, int yearOfManufacturing, String color, VehicleType type) {
        this.model = model;
        this.yearOfManufacturing = yearOfManufacturing;
        this.color = color;
        this.type = type;
        this.isAvailable = true;
    }

    public abstract String accept(VehicleVisitor visitor);
}
