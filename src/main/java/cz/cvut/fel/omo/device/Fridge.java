package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

public class Fridge extends Device{

    private final ArrayList<Food> foods;

    public Fridge(int id, DeviceDocumentation documentation, Consumption consumption, int durability, ArrayList<Food> foods) {
        super(id, documentation, consumption, durability);
        this.foods = foods;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visitFridge(this);
    }

    @AllArgsConstructor
    @Getter
    protected class Food {
        private final String name;
    }

    @Override
    public String toString() {
        return "Fridge " + id;
    }
}
