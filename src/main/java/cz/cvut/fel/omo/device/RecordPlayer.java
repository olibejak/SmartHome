package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import cz.cvut.fel.omo.device.visitor.EmptyDeviceVisitor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RecordPlayer extends Device{

    private Record currentRecord;

    public RecordPlayer(UUID id) {
        super(id);
    }

    @Override
    public String acceptDeviceVisitor(DeviceVisitor visitor) {
        return visitor.visitRecordPlayer(this);
    }

    public void insertRecord(String name, String artist) {
        currentRecord = new Record(name, artist);
    }

    @Override
    public String toString() {
        return "Record Player " + id + " with Record " + currentRecord.toString();
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.RECORD_PLAYER);
    }

    @Override
    public String reportConfiguration() {
        return "Record Player: " + id;
    }

    protected record Record(String name, String artist) {
        @Override
        public String toString() {
            return name + " - " + artist;
        }
    }
}
