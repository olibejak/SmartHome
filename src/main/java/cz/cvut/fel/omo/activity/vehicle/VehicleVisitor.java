package cz.cvut.fel.omo.activity.vehicle;

/**
 * Visitor pattern interface for vehicles.
 */
public interface VehicleVisitor {
    String visitBicycle(Bicycle bicycle);

    String visitCar(Car car);
}
