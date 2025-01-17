package cz.cvut.fel.omo.BobTheBuilder.equipmentFactory;

import cz.cvut.fel.omo.BobTheBuilder.DTO.equipmentDTO.SportEquipmentDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.vehicleDTO.VehicleDTO;
import cz.cvut.fel.omo.BobTheBuilder.vehicleFactory.VehicleFactory;
import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.logger.GlobalLogger;

import java.util.HashMap;
import java.util.Map;

public class EquipmentFactoryRegistry {

    private final Map<Class<? extends SportEquipmentDTO>, SportEquipmentFactory<? extends SportEquipment, ? extends SportEquipmentDTO>> equipmentFactories;
    private final GlobalLogger logger = GlobalLogger.getInstance();

    public EquipmentFactoryRegistry() {
        equipmentFactories = new HashMap<>();
    }

    public void registerFactory(Class<? extends SportEquipmentDTO> dtoClass, SportEquipmentFactory<?,?> vehicleFactory) {
        equipmentFactories.put(dtoClass, vehicleFactory);
    }

    public <D extends SportEquipmentDTO> SportEquipment createSportEquipment(D dto) {
        SportEquipmentFactory factory = equipmentFactories.get(dto.getClass());
        if (factory == null) {
            logger.info("No factory found for vehicle type " + dto.getClass());
            return null;
        }
        return factory.createSportEquipment(dto);
    }
}
