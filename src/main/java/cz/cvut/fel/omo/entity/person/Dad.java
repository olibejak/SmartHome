package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Dad extends Person {
    public Dad(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitDad(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Dad jokes with Mom about something funny";
    }

    @Override
    public String visitDad(Dad dad) {
        if (this.equals(dad)) {
            return "Dad cannot interact with himself";
        }
        return "Dad tells hi to other Dad";
    }

    @Override
    public String visitSon(Son son) {
        return "Dad teaches Son a new trick";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Dad encourages Daughter's latest project";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Dad helps Grandma with something she needs";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Dad chats with Grandpa about old times";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Dad tosses a treat to the Dog";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Dad watches the Cat nap peacefully";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Dad gently taps the Hamster's cage to say hello";
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
