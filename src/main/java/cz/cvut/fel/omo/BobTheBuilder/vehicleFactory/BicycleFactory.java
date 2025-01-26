package cz.cvut.fel.omo.BobTheBuilder.vehicleFactory;

import cz.cvut.fel.omo.DTO.vehicleDTO.BicycleDTO;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;

public class BicycleFactory extends VehicleFactory<Bicycle, BicycleDTO> {

    @Override
    public Bicycle createVehicle(BicycleDTO dto) {
        replaceNullValues(dto);
        return new Bicycle(dto.getModel(), dto.getYearOfManufacturing(), dto.getColor(), dto.getGearCount());
    }

    @Override
    protected void replaceNullValues(BicycleDTO dto){
        super.replaceNullValues(dto);
        if (dto.getGearCount() == null) {
            dto.setGearCount(1);
        }
    }
}
