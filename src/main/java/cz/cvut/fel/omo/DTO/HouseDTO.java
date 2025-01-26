package cz.cvut.fel.omo.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HouseDTO {

    private FloorDTO[] floors;
}
