package cz.cvut.fel.omo.DTO.equipmentDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Abstract class representing sport equipment.
 * Inheritors are distinguished by "equipmentType" property.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "equipmentType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WeightsDTO.class, name = "WEIGHTS"),
        @JsonSubTypes.Type(value = SkisDTO.class, name = "SKIS")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class SportEquipmentDTO {

    protected Boolean isAvailable;
    protected Integer usageCount;
}
