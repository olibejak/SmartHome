package cz.cvut.fel.omo.activity.vehicle;

import cz.cvut.fel.omo.house.ConfigurationReport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle implements ConfigurationReport {
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
