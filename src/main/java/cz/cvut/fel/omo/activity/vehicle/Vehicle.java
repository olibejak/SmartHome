package cz.cvut.fel.omo.activity.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    protected String model;
    protected int yearOfManufacturing;
    protected String color;
    protected boolean isAvailable;

    public Vehicle(String model, int yearOfManufacturing, String color) {
        this.model = model;
        this.yearOfManufacturing = yearOfManufacturing;
        this.color = color;
        this.isAvailable = true;
    }

    public abstract String accept(VehicleVisitor visitor);
}
