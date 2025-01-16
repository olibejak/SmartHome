package cz.cvut.fel.omo.BobTheBuilder.DTO;

import cz.cvut.fel.omo.BobTheBuilder.DTO.equipmentDTO.SportEquipmentDTO;
import cz.cvut.fel.omo.BobTheBuilder.DTO.vehicleDTO.VehicleDTO;
import cz.cvut.fel.omo.house.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {

    private RoomType type;
    private DeviceDTO[] devices;
    private SportEquipmentDTO[] equipment;
    private VehicleDTO[] vehicles;
}
