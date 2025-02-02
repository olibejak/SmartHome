package cz.cvut.fel.omo.activity.vehicle;

/**
 * Defines the Visitor pattern for different types of vehicles.
 * This interface allows implementing classes to define interactions with specific vehicles.
 */
public interface VehicleVisitor {
    /**
     * Defines behavior for interacting with a {@link Bicycle}.
     *
     * @param bicycle The bicycle instance being visited.
     * @return A string describing the interaction.
     */
    String visitBicycle(Bicycle bicycle);

    /**
     * Defines behavior for interacting with a {@link Car}.
     *
     * @param car The car instance being visited.
     * @return A string describing the interaction.
     */
    String visitCar(Car car);
}
