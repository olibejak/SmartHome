package cz.cvut.fel.omo.BobTheBuilder.vehicleFactory;

import cz.cvut.fel.omo.DTO.vehicleDTO.VehicleDTO;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;

public abstract class VehicleFactory<T extends Vehicle, D extends VehicleDTO> {

    public abstract T createVehicle(D dto);

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
