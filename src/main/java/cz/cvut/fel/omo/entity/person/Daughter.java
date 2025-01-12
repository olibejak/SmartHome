package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Daughter extends Person {
    public Daughter(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitDaughter(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Daughter shares her plans with Mom excitedly";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Daughter asks Dad for help with a puzzle";
    }

    @Override
    public String visitSon(Son son) {
        return "Daughter laughs at Son's silly joke";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        if (this.equals(daughter)) {
            return "Daughter cannot interact with herself";
        }
        return "Daughter tells hi to other Daughter";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Daughter listens to Grandma's fascinating story";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Daughter asks Grandpa to teach her something new";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Daughter gives the Dog a big hug";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Daughter tries to make the Cat chase a string";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Daughter watches the Hamster climb its cage";
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
