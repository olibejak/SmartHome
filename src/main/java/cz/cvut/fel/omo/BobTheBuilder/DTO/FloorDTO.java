package cz.cvut.fel.omo.BobTheBuilder.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FloorDTO {

    private RoomDTO[] rooms;
}
