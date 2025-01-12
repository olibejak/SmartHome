package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Son extends Person {
    public Son(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitSon(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Son tells Mom about his latest adventure";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Son challenges Dad to a playful game";
    }

    @Override
    public String visitSon(Son son) {
        if (this.equals(son)) {
            return "Son cannot interact with himself";
        }
        return "Son tells hi to other Son";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Son teases Daughter with a mischievous grin";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Son shows Grandma his latest drawing";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Son asks Grandpa to share a fun story";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Son plays fetch with the Dog";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Son chases the Cat playfully around the room";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Son feeds the Hamster a tiny snack";
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
