package cz.cvut.fel.omo.BobTheBuilder.DTO.vehicleDTO;

import cz.cvut.fel.omo.activity.vehicle.EngineType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDTO extends VehicleDTO {

    private EngineType engineType;
}
