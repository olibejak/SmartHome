package cz.cvut.fel.omo.device.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.logger.GlobalLogger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for loading device documentation from a JSON file.
 * If the documentation for a device type is not found, default values are used.
 */
public class DeviceDocumentationLoader {
    private static final Map<DeviceType, DeviceDocumentation> documentationMap;
    private static final GlobalLogger logger = GlobalLogger.getInstance();

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<DeviceType, DeviceDocumentation> tempMap;

        try {
            tempMap = objectMapper.readValue(
                    Path.of("config/deviceDocumentation.json").toFile(),
                    objectMapper.getTypeFactory().constructMapType(Map.class, String.class, DeviceDocumentation.class)
            );
            logger.info("Successfully loaded device documentation config.");
        } catch (IOException e) {
            logger.error("Failed to load device documentation config from file: config/deviceDocumentation.json\n" + e.getMessage());
            tempMap = new HashMap<>();
        }

        documentationMap = tempMap;
    }


    /**
     * Returns documentation for a device type.
     * @param deviceType Device type
     * @return Documentation
     */
    public static DeviceDocumentation getDocumentation(DeviceType deviceType) {
        return documentationMap.getOrDefault(deviceType, getDefaultDocumentation(deviceType));
    }

    /**
     * Returns default documentation for a device type.
     * @param deviceType Device type
     * @return Default documentation
     */
    private static DeviceDocumentation getDefaultDocumentation(DeviceType deviceType) {
        logger.error("No documentation found for " + deviceType + ", using default values.");
        return new DeviceDocumentation(
                "Model",
                "Manufacturer",
                "Manual content",
                false,
                "Warranty certificate"
        );
    }
}
