package cz.cvut.fel.omo.device.Scoop;

import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.device.Window;

public class DeviceFactory {

    private DeviceBuilder commonDeviceBuilder, storageDeviceBuilder, windowBuilder;

    public DeviceFactory() {
        this.commonDeviceBuilder = new CommonDeviceBuilder();
        this.storageDeviceBuilder = new StorageDeviceBuilder();
        this.windowBuilder = new WindowBuilder();
    }

    public Device createDevice(DeviceBuilder deviceBuilder) {
        return deviceBuilder.build();
    }
}
