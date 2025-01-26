package cz.cvut.fel.omo.BobTheBuilder.equipmentFactory;

import cz.cvut.fel.omo.DTO.equipmentDTO.SkisDTO;
import cz.cvut.fel.omo.activity.equipment.Skis;

/**
 * Factory for creating skis
 */
public class SkisFactory implements SportEquipmentFactory<Skis, SkisDTO> {

    @Override
    public Skis createSportEquipment(SkisDTO dto) {
        if (dto.getColor() == null) {
            dto.setColor("#000000");
        }
        if (dto.getIsAvailable() == null || dto.getUsageCount() == null) {
            return new Skis(dto.getColor());
        }
        return new Skis(dto.getIsAvailable(), dto.getUsageCount(), dto.getColor());
    }
}
