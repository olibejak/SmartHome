package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.Television;

/**
 * Builder for Television.
 * Part of the Builder design pattern.
 */
public class TelevisionBuilder extends DeviceBuilder<TelevisionBuilder, Television> {

    public TelevisionBuilder() {
        reset();
    }

    public TelevisionBuilder channel(int channel) {
        device.changeChannel(channel);
        return self();
    }

    @Override
    public TelevisionBuilder self() {
        return this;
    }

    @Override
    public TelevisionBuilder reset() {
        device = new Television();
        return self();
    }

    @Override
    public Television build() {
        Television result = device;
        reset();
        return result;
    }
}
