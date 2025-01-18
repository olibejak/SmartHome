package cz.cvut.fel.omo.BobTheBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.BobTheBuilder.DTO.ConsumptionDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.equipmentDTO.SkisDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.equipmentDTO.WeightsDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.vehicleDTO.BicycleDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.vehicleDTO.CarDTO;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.DeviceFactoryRegistry;
import cz.cvut.fel.omo.BobTheBuilder.deviceFactory.factoryMethod.*;
import cz.cvut.fel.omo.BobTheBuilder.equipmentFactory.EquipmentFactoryRegistry;
import cz.cvut.fel.omo.BobTheBuilder.equipmentFactory.SkisFactory;
import cz.cvut.fel.omo.BobTheBuilder.equipmentFactory.WeightsFactory;
import cz.cvut.fel.omo.BobTheBuilder.vehicleFactory.BicycleFactory;
import cz.cvut.fel.omo.BobTheBuilder.vehicleFactory.CarFactory;
import cz.cvut.fel.omo.BobTheBuilder.vehicleFactory.VehicleFactoryRegistry;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Class for loading house and utility from different sources
 */
public class HouseLoader {

    public static ObjectMapper mapper = new ObjectMapper();

    /**
     * Load house from JSON file
     * @param filePath path to JSON file
     * @return HouseDTO object
     * @throws IOException if file is not found
     */
    public static HouseDTO loadHouseDTOFromJson(@NonNull String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Ignore unknown properties
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(new File(filePath), HouseDTO.class);
    }

    /**
     * Load utility from JSON file
     * @param filePath path to JSON file
     * @return HouseDTO object
     * @throws IOException if file is not found
     */
    public static Map<DeviceType, ConsumptionDTO> loadDeviceConsumptionConfig(@NonNull String filePath) throws IOException {
        return mapper.readValue(
                new File(filePath),
                new TypeReference<>() {}
        );
    }

    /**
     * Populate device factory registry with supported device factories
     * @param deviceFactoryRegistry device factory registry for deciding which factory to use based on device type
     * @return device factory registry with supported device factories
     */
    public static DeviceFactoryRegistry populateDeviceFactoryRegistry(@NonNull DeviceFactoryRegistry deviceFactoryRegistry) {
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

    /**
     * Populate vehicle factory registry with supported vehicle factories
     * @param vehicleFactoryRegistry vehicle factory registry for deciding which factory to use based on vehicle type
     * @return vehicle factory registry with supported vehicle factories
     */
    public static VehicleFactoryRegistry populateVehicleFactoryRegistry(@NonNull VehicleFactoryRegistry vehicleFactoryRegistry) {
        vehicleFactoryRegistry.registerFactory(CarDTO.class, new CarFactory());
        vehicleFactoryRegistry.registerFactory(BicycleDTO.class, new BicycleFactory());
        return vehicleFactoryRegistry;
    }

    /**
     * Populate sport equipment factory registry with supported sport equipment factories
     * @param equipmentFactoryRegistry equipment factory registry for deciding which factory to use based on sport equipment type
     * @return equipment factory registry with supported sport equipment factories
     */
    public static EquipmentFactoryRegistry populateSportEquipmentFactoryRegistry(@NonNull EquipmentFactoryRegistry equipmentFactoryRegistry) {
        equipmentFactoryRegistry.registerFactory(WeightsDTO.class, new WeightsFactory());
        equipmentFactoryRegistry.registerFactory(SkisDTO.class, new SkisFactory());
        return equipmentFactoryRegistry;

    }

    /**
     * Get default house DTO.
     * @return default house DTO
     */
    public static HouseDTO getDefaultHouseDTO() {
        return new HouseDTO();
    }
}
