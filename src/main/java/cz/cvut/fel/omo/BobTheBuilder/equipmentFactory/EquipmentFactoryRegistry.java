package cz.cvut.fel.omo.BobTheBuilder.equipmentFactory;

import cz.cvut.fel.omo.BobTheBuilder.DTO.equipmentDTO.SportEquipmentDTO;
import cz.cvut.fel.omo.BobTheBuilder.FactoryRegistry;
import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.logger.GlobalLogger;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry for equipment factories
 */
public class EquipmentFactoryRegistry implements FactoryRegistry<SportEquipment, SportEquipmentDTO> {

    /**
     * Map of equipment factories.
     * Key: class of the equipment DTO
     * Value: factory for the equipment
     */
    private final Map<
            Class<? extends SportEquipmentDTO>,
            SportEquipmentFactory<? extends SportEquipment, ? extends SportEquipmentDTO>> equipmentFactories;
    private final GlobalLogger logger = GlobalLogger.getInstance();

    public EquipmentFactoryRegistry() {
        equipmentFactories = new HashMap<>();
    }

    /**
     * Registers a factory for a specific equipment type
     * @param dtoClass class of the equipment DTO
     * @param vehicleFactory factory for the equipment
     */
    public void registerFactory(Class<? extends SportEquipmentDTO> dtoClass, SportEquipmentFactory<?,?> vehicleFactory) {
        equipmentFactories.put(dtoClass, vehicleFactory);
    }

    @Override
    public SportEquipment createObject(SportEquipmentDTO dto, int roomId) {
        SportEquipmentFactory factory = equipmentFactories.get(dto.getClass());
        if (factory == null) {
            logger.info("No factory found for vehicle type " + dto.getClass());
            return null;
        }
        return factory.createSportEquipment(dto);
    }
}
