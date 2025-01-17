package cz.cvut.fel.omo.BobTheBuilder.equipmentFactory;

import cz.cvut.fel.omo.BobTheBuilder.DTO.equipmentDTO.SportEquipmentDTO;
import cz.cvut.fel.omo.activity.equipment.SportEquipment;

public interface SportEquipmentFactory<T extends SportEquipment, D extends SportEquipmentDTO> {

    public abstract T createSportEquipment(D dto);

}
