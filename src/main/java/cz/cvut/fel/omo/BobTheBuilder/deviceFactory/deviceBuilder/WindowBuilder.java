package cz.cvut.fel.omo.BobTheBuilder.deviceFactory.deviceBuilder;

import cz.cvut.fel.omo.device.Window;

import java.util.UUID;

/**
 * Builder for Window.
 * Part of the Builder design pattern.
 */
public class WindowBuilder extends DeviceBuilder<WindowBuilder, Window> {

    public WindowBuilder() {
        reset();
    }

    public WindowBuilder hasOpenedCurtain(boolean hasOpenedCurtain) {
        device.setHasOpenedCurtain(hasOpenedCurtain);
        return self();
    }

    public WindowBuilder isOpen(boolean isOpen) {
        device.setOpen(isOpen);
        return self();
    }

    @Override
    public WindowBuilder self() {
        return this;
    }

    @Override
    public WindowBuilder reset() {
        device = new Window(UUID.randomUUID());
        return self();
    }

    @Override
    public Window build() {
        Window result = device;
        reset();
        return result;
    }
}
