package cz.cvut.fel.omo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionDTO {

    private double electricityIdleRate;
    private double electricityActiveRate;
    private double gasRate;
    private double waterRate;
}
