package cz.cvut.fel.omo.DTO;

import cz.cvut.fel.omo.DTO.type.DeviceType;
import cz.cvut.fel.omo.DTO.type.StateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceDTO {

    private DeviceType type;
    private StateType state;
    private Integer durability;
}
