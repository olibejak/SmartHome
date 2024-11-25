package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class RecordPlayer extends Device{

    private Record currentRecord;
    public RecordPlayer(int id, DeviceDocumentation documentation, Consumption consumption, int durability) {
        super(id, documentation, consumption, durability);
    }

    public void insertRecord(String name, String artist) {
        currentRecord = new Record(name, artist);
    }

    @AllArgsConstructor
    @Getter
    protected class Record {
        private final String name;
        private final String artist;
    }
}
