package cz.cvut.fel.omo.BobTheBuilder.equipmentFactory;

import cz.cvut.fel.omo.DTO.equipmentDTO.WeightsDTO;
import cz.cvut.fel.omo.activity.equipment.Weights;

/**
 * Factory for creating weights.
 */
public class WeightsFactory implements SportEquipmentFactory<Weights, WeightsDTO> {

    @Override
    public Weights createSportEquipment(WeightsDTO dto) {
        if (dto.getIsAvailable() == null || dto.getUsageCount() == null) {
            return new Weights();
        }
        return new Weights(dto.getIsAvailable(), dto.getUsageCount());
    }
}
