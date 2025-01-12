package cz.cvut.fel.omo.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bicycle extends Vehicle {
    public Bicycle(String model, int yearOfManufacturing, String color, VehicleType type) {
        super(model, yearOfManufacturing, color, type);
    }

    @Override
    public String accept(VehicleVisitor visitor) {
        return visitor.visitBicycle(this);
    }
}
