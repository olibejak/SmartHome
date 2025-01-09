package cz.cvut.fel.omo.BobTheBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.BobTheBuilder.DTO.DeviceType;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.DeviceFactoryRegistry;
import cz.cvut.fel.omo.BobTheBuilder.deviceCreator.factoryMethod.*;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;

/**
 * Class for loading house and utility from different sources
 */
public class HouseLoader {

    /**
     * Load house from JSON file
     * @param filePath path to JSON file
     * @return HouseDTO object
     * @throws IOException if file is not found
     */
    public static HouseDTO loadHouseDTOFromJson(@NonNull String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), HouseDTO.class);
    }

    /**
     * Populate device factory registry with supported device factories
     * @param deviceFactoryRegistry device factory registry for deciding which factory to use based on device type
     * @return device factory registry with supported device factories
     */
    public static DeviceFactoryRegistry populateDeviceFactoryRegistry(DeviceFactoryRegistry deviceFactoryRegistry) {
        deviceFactoryRegistry.registerFactory(DeviceType.DISHWASHER, new DishwasherFactory());
        deviceFactoryRegistry.registerFactory(DeviceType.FRIDGE, new FridgeFactory());
        deviceFactoryRegistry.registerFactory(DeviceType.OVEN, new OvenFactory());
        deviceFactoryRegistry.registerFactory(DeviceType.RECORD_PLAYER, new RecordPlayerFactory());
        deviceFactoryRegistry.registerFactory(DeviceType.TELEVISION, new TelevisionFactory());
        deviceFactoryRegistry.registerFactory(DeviceType.THERMOSTAT, new ThermostatFactory());
        deviceFactoryRegistry.registerFactory(DeviceType.WASHING_MACHINE, new WashingMachineFactory());
        deviceFactoryRegistry.registerFactory(DeviceType.WINDOW, new WindowFactory());
        return deviceFactoryRegistry;
    }
}
