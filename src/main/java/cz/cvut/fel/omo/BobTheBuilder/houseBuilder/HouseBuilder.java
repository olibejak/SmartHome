package cz.cvut.fel.omo.BobTheBuilder.houseBuilder;

import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;

import java.util.ArrayList;

/**
 * Builder for creating houses.
 */
public class HouseBuilder {

    private House house;

    public HouseBuilder() {
        reset();
    }

    public HouseBuilder addFloors(ArrayList<Floor> floors) {
       house.getFloors().addAll(floors);
       return this;
    }

    public HouseBuilder addFloor(Floor floor) {
        house.getFloors().add(floor);
        return this;
    }

    public House build() {
        House houseMD = this.house;
        reset();
        return houseMD;
    }

    public HouseBuilder reset() {
        this.house = new House();
        return this;
    }
}
