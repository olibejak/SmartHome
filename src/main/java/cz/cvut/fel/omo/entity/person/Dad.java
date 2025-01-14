package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Dad extends Person {
    public Dad(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitDad(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Dad laughs with Mom " + mom.getName() + " about a funny memory they share.";
    }

    @Override
    public String visitDad(Dad dad) {
        if (this.equals(dad)) {
            return "Dad " + this.name + " cannot interact with himself.";
        }
        return "Dad " + this.name + " greets Dad " + dad.getName() + " with a firm handshake.";
    }

    @Override
    public String visitSon(Son son) {
        return "Dad " + this.name + " teaches Son " + son.getName() + " how to throw a perfect curveball.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Dad " + this.name + " praises Daughter " + daughter.getName() + " for her amazing school project.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Dad " + this.name + " helps Grandma " + grandma.getName() + " set up her new favorite TV show.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Dad " + this.name + " and Grandpa " + grandpa.getName() + " chat about their favorite old-time stories.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Dad " + this.name + " throws a ball for Dog " + dog.getName() + " to fetch.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Dad " + this.name + " gently scratches behind Cat " + cat.getName() + "'s ears while it purrs.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Dad " + this.name + " watches Hamster " + hamster.getName() + " sprint on its wheel with amusement.";
    }

    @Override
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "Dad " + this.name + " carves sharp turns down the slope on the " + skis.getColor() + " skis.";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Dad " + this.name + " challenges himself to lift the heavy weights, pushing his limits.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Dad " + this.name + " rides the " + bicycle.getColor() + " bicycle at full speed, feeling the wind rush past.";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Dad " + this.name + " takes the " + car.getColor() + " car for a scenic drive through the countryside.";
        }
        return "Dad " + this.name + " cannot drive the car because he doesn't have a driver's license.";
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
