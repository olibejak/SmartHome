package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.RecordPlayer;

import java.util.UUID;

/**
 * Builder for RecordPlayer.
 * Part of the Builder design pattern.
 */
public class RecordPlayerBuilder extends DeviceBuilder<RecordPlayerBuilder, RecordPlayer> {

    public RecordPlayerBuilder() {
        reset();
    }

    public RecordPlayerBuilder currentRecord(String name, String artist) {
        device.insertRecord(name, artist);
        return self();
    }

    @Override
    public RecordPlayerBuilder self() {
        return this;
    }

    @Override
    public RecordPlayerBuilder reset() {
        device = new RecordPlayer(UUID.randomUUID());
        return this;
    }

    @Override
    public RecordPlayer build() {
        RecordPlayer result = device;
        reset();
        return result;
    }
}
