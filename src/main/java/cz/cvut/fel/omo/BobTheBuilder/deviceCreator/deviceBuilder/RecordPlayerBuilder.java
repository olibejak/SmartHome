package cz.cvut.fel.omo.BobTheBuilder.deviceCreator.deviceBuilder;

import cz.cvut.fel.omo.device.RecordPlayer;

public class RecordPlayerBuilder extends DeviceBuilder<RecordPlayerBuilder, RecordPlayer> {

    public RecordPlayerBuilder() {
        reset();
    }

    public RecordPlayerBuilder currentRecord(String name, String artist) {
        device.insertRecord(name, artist);
        return self();
    }

    public RecordPlayerBuilder speed(int speed) {
        device.setSpeed(speed);
        return this;
    }

    @Override
    public RecordPlayerBuilder self() {
        return this;
    }

    @Override
    public RecordPlayerBuilder reset() {
        device = new RecordPlayer();
        return this;
    }

    @Override
    public RecordPlayer build() {
        RecordPlayer result = device;
        reset();
        return result;
    }
}
