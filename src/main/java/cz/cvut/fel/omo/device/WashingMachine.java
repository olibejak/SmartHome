package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

public class WashingMachine extends Device{

    private final ArrayList<Wash> washes = new ArrayList<>();

     public WashingMachine(int id, DeviceDocumentation documentation, Consumption consumption, int durability, ArrayList<Wash> washes) {
        super(id, documentation, consumption, durability);
    }

    @AllArgsConstructor
    @Getter
    protected class Wash {
        private final String name;
    }
}
