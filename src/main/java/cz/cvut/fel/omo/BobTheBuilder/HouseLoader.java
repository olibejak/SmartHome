package cz.cvut.fel.omo.BobTheBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.BobTheBuilder.DTO.HouseDTO;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;

public class HouseLoader {

    public HouseDTO loadHouseDTOFromJson(@NonNull String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), HouseDTO.class);
    }
}
