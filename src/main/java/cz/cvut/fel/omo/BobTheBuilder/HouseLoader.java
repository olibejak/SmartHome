package cz.cvut.fel.omo.BobTheBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;

/**
 * Class for loading house from different sources
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
}
