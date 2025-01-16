package cz.cvut.fel.omo.activity.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car extends Vehicle {
    private EngineType engineType;

    public Car(String model, int yearOfManufacturing, String color, EngineType engineType) {
        super(model, yearOfManufacturing, color);
        this.engineType = engineType;
    }

    @Override
    public String accept(VehicleVisitor visitor) {
        return visitor.visitCar(this);
    }
}
