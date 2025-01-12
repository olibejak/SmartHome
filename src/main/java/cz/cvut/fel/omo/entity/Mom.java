package cz.cvut.fel.omo.entity;

import cz.cvut.fel.omo.device.*;

public class Mom extends Person {
    public Mom(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitMom(this);}


    @Override
    public String visitMom(Mom mom) {
        // check if the entity is interacting with itself
        if (this.equals(mom)) {
            return "Mom cannot interact with herself";
        }
        return "Mom tells hi to other mom";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Mom pets the dog";
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
