package cz.cvut.fel.omo.BobTheBuilder.vehicleFactory;

import cz.cvut.fel.omo.BobTheBuilder.DTO.vehicleDTO.VehicleDTO;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.logger.GlobalLogger;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactoryRegistry {

    private final Map<Class<? extends VehicleDTO>, VehicleFactory<? extends Vehicle, ? extends VehicleDTO>> vehicleFactories;
    private final GlobalLogger logger = GlobalLogger.getInstance();

    public VehicleFactoryRegistry() {
        vehicleFactories = new HashMap<>();
    }

    public void registerFactory(Class<? extends VehicleDTO> dtoClass, VehicleFactory<?,?> vehicleFactory) {
        vehicleFactories.put(dtoClass, vehicleFactory);
    }

    public <D extends VehicleDTO> Vehicle createVehicle(D dto) {
        VehicleFactory factory = vehicleFactories.get(dto.getClass());
        if (factory == null) {
            logger.info("No factory found for vehicle type " + dto.getClass());
            return null;
        }
        return factory.createVehicle(dto);
    }
}
