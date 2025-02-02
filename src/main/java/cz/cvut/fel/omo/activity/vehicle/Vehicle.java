package cz.cvut.fel.omo.activity.vehicle;

import cz.cvut.fel.omo.house.report.ConfigurationReport;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a vehicle in the smart home simulation.
 * Implements the Visitor pattern to allow interaction with different types of vehicles.
 * Implements {@link ConfigurationReport} to support configuration reporting.
 */
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

    /**
     * Accepts a visitor to interact with this vehicle.
     * Part of the Visitor pattern.
     *
     * @param visitor The visitor interacting with the vehicle.
     * @return A string describing the interaction result.
     */
    public abstract String accept(VehicleVisitor visitor);
}
