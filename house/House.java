package house;

import java.util.ArrayList;

public class House {
    private final ArrayList<Floor> floors;

    public House(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                '}';
    }
}
