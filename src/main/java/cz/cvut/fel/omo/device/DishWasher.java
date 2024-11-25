package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

public class DishWasher extends Device {

    private final ArrayList<Dish> dishes;

    public DishWasher(int id, DeviceDocumentation documentation, Consumption consumption, int durability, ArrayList<Dish> dishes) {
        super(id, documentation, consumption, durability);
        this.dishes = dishes;
    }

    public void addDish(String name) {
        dishes.add(new Dish(name));
    }

    public void wash() {
        logger.info(this.toString() + " :Washing dishes...");
        dishes.clear();
    }



    @AllArgsConstructor
    private class Dish {
        private final String name;
    }
}
