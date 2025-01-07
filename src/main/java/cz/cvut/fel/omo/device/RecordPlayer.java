package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class RecordPlayer extends Device{

    private Record currentRecord;
    @Setter
    private int speed;

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitRecordPlayer(this);
    }

    public void insertRecord(String name, String artist) {
        currentRecord = new Record(name, artist);
    }

    @Override
    public String toString() {
        return "Record player " + id;
    }

    @AllArgsConstructor
    @Getter
    protected class Record {
        private final String name;
        private final String artist;
    }
}
