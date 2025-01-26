package cz.cvut.fel.omo.BobTheBuilder.vehicleFactory;


import cz.cvut.fel.omo.DTO.vehicleDTO.CarDTO;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.activity.vehicle.EngineType;

public class CarFactory extends VehicleFactory<Car, CarDTO> {

    @Override
    public Car createVehicle(CarDTO dto) {
        replaceNullValues(dto);
        return new Car(dto.getModel(), dto.getYearOfManufacturing(), dto.getColor(), dto.getEngineType());
    }

    @Override
    protected void replaceNullValues(CarDTO dto){
        super.replaceNullValues(dto);
        if (dto.getEngineType() == null) {
            dto.setEngineType(EngineType.PETROL);
        }
    }
}
