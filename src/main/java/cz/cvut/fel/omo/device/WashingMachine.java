package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

public class WashingMachine extends Device{

    private final ArrayList<Wash> washes = new ArrayList<>();

     public WashingMachine(int id, DeviceDocumentation documentation, Consumption consumption, int durability, ArrayList<Wash> washes) {
        super(id, documentation, consumption, durability);
    }

    @Override
    public String toString() {
        return "Washing machine " + id;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visitWashingMachine(this);
    }

    @AllArgsConstructor
    @Getter
    protected class Wash {
        private final String name;
    }
}
