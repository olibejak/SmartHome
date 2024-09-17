package cz.cvut.fel.omo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pet extends Entity {

    private PetType type;
}
