package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordPlayer extends Device{

    private Record currentRecord;

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

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.RECORD_PLAYER);
    }

    protected record Record(String name, String artist) {
        @Override
        public String toString() {
            return name + " - " + artist;
        }
    }
}
