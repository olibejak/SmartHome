package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class RecordPlayer extends Device{

    private Record currentRecord;

    public RecordPlayer(int id, DeviceDocumentation documentation, Consumption consumption, int durability) {
        super(id, documentation, consumption, durability);
        this.currentRecord = new Record("Whale Sounds", "Whales"); // default
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitRecordPlayer(this);
    }

    public void insertRecord(String name, String artist) {
        currentRecord = new Record(name, artist);
    }

    @Override
    public String toString() {
        return "Record player " + id + " with Record " + currentRecord.toString();
    }

    @AllArgsConstructor
    @Getter
    protected class Record {
        private final String name;
        private final String artist;

        @Override
        public String toString() {
            return name + " - " + artist;
        }
    }
}
