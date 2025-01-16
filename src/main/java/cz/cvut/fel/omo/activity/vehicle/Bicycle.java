package cz.cvut.fel.omo.activity.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bicycle extends Vehicle {
    private int gearCount;

    public Bicycle(String model, int yearOfManufacturing, String color, int gearCount) {
        super(model, yearOfManufacturing, color);
        this.gearCount = gearCount;
    }

    @Override
    public String accept(VehicleVisitor visitor) {
        return visitor.visitBicycle(this);
    }
}
