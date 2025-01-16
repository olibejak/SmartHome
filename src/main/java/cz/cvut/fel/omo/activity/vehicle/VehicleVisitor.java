package cz.cvut.fel.omo.activity.vehicle;

public interface VehicleVisitor {
    String visitBicycle(Bicycle bicycle);

    String visitCar(Car car);
}
