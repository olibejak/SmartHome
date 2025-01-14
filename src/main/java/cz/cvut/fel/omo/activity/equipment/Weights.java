package cz.cvut.fel.omo.activity.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weights extends SportEquipment {
    public Weights(boolean isAvailable, int usageCount) {
        super(isAvailable, usageCount);
    }

    public Weights() {
        super(true, 0);
    }

    @Override
    public String accept(SportEquipmentVisitor visitor) {
        return visitor.visitWeights(this);
    }
}
