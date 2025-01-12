package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Grandpa extends Person {
    public Grandpa(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitGrandpa(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Grandpa praises Mom for her dedication";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Grandpa shares wisdom with Dad over a casual chat";
    }

    @Override
    public String visitSon(Son son) {
        return "Grandpa teaches Son how to whistle";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Grandpa tells Daughter an exciting tale";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Grandpa compliments Grandma's kindness";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        if (this.equals(grandpa)) {
            return "Grandpa cannot interact with himself";
        }
        return "Grandpa tells hi to other Grandpa";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Grandpa calls the Dog for a playful pat";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Grandpa observes the Cat's curious behavior";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Grandpa peers into the Hamster's cage with interest";
    }

    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        return "";
    }

    @Override
    public String visitFridge(Fridge fridge) {
        return "";
    }

    @Override
    public String visitOven(Oven oven) {
        return "";
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        return "";
    }

    @Override
    public String visitTelevision(Television television) {
        return "";
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        return "";
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        return "";
    }

    @Override
    public String visitWindow(Window window) {
        return "";
    }
}
