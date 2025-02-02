package cz.cvut.fel.omo.BobTheBuilder.equipmentFactory;

import cz.cvut.fel.omo.DTO.equipmentDTO.SportEquipmentDTO;
import cz.cvut.fel.omo.activity.equipment.SportEquipment;

/**
 * Factory for creating sport equipment.
 */
public interface SportEquipmentFactory<T extends SportEquipment, D extends SportEquipmentDTO> {

    /**
     * Creates a sport equipment object from a DTO
     * @param dto DTO of the sport equipment
     * @return sport equipment object
     */
    T createSportEquipment(D dto);

}
