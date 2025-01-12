package cz.cvut.fel.omo.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Skis extends SportEquipment {
    private String color;

    public Skis(boolean isAvailable, int usageCount, String color) {
        super(isAvailable, usageCount);
        this.color = color;
    }

    public Skis(String color) {
        super(true, 0);
        this.color = color;
    }

    @Override
    public String accept(SportEquipmentVisitor visitor) {
        return visitor.visitSkis(this);
    }
}
