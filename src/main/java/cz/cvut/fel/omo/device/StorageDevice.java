package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.AllArgsConstructor;

import java.util.List;

public class StorageDevice extends Device {

    private final List<StorageItem> items;

    public StorageDevice(GlobalLogger logger, DeviceState state, UserManual manual, boolean isEssential,
                         boolean isBroken, String warrantyCertificate, Consumption consumption, int durability,
                         List<StorageItem> items) {
        super(logger, state, manual, isEssential, isBroken, warrantyCertificate, consumption, durability);
        this.items = items;
    }

    public void addItem(StorageItem item) {
        items.add(item);
    }

    public void removeItem(StorageItem item) {
        items.remove(item);
    }
}
