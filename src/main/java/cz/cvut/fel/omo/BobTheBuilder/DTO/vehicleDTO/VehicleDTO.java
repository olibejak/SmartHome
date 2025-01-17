package cz.cvut.fel.omo.BobTheBuilder.DTO.vehicleDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.BobTheBuilder.vehicleFactory.CarFactory;
import cz.cvut.fel.omo.BobTheBuilder.vehicleFactory.VehicleFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Function;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "vehicleType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BicycleDTO.class, name = "BICYCLE"),
        @JsonSubTypes.Type(value = CarDTO.class, name = "CAR")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class VehicleDTO {

    protected String model;
    protected Integer yearOfManufacturing;
    protected String color;

}
