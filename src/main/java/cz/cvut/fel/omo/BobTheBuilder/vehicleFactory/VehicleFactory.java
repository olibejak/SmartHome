package cz.cvut.fel.omo.BobTheBuilder.vehicleFactory;

import cz.cvut.fel.omo.DTO.vehicleDTO.VehicleDTO;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;

/**
 * Abstract method factory for creating Vehicle objects.
 * @param <T> Vehicle object
 * @param <D> VehicleDTO object
 */
public abstract class VehicleFactory<T extends Vehicle, D extends VehicleDTO> {

    /**
     * Creates a Vehicle object from a DTO.
     * @param dto DTO of the Vehicle
     * @return Vehicle object
     */
    public abstract T createVehicle(D dto);

    /**
     * Replaces null values in the DTO with default values.
     * @param dto DTO of the Vehicle
     */
    protected void replaceNullValues(D dto) {
        if (dto.getModel() == null) {
            dto.setModel("Default Model");
        }
        if (dto.getYearOfManufacturing() == null) {
            dto.setYearOfManufacturing(0);
        }
        if (dto.getColor() == null) {
            dto.setColor("#000000");
        }
    }
}
