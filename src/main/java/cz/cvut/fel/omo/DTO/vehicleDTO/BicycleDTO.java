package cz.cvut.fel.omo.DTO.vehicleDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BicycleDTO extends VehicleDTO {

    private Integer gearCount;
}
