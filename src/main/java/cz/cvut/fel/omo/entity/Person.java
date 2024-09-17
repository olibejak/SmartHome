package cz.cvut.fel.omo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends Entity {

    private PersonType type;
}
