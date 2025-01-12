package cz.cvut.fel.omo.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Skis extends SportEquipment {
    private String color;

    public Skis(String color) {
        this.color = color;
    }

    @Override
    public String accept(SportEquipmentVisitor visitor) {
        return visitor.visitSkis(this);
    }
}
