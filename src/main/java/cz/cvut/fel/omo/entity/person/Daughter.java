package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Daughter extends Person {
    public Daughter(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
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
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "Daughter practices smooth, controlled skiing on the skis";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Daughter uses the weights for her daily strength workout";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Daughter cycles to her favorite scenic spot on the bicycle";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Daughter practices parking the car perfectly in the driveway";
        }
        return "Daughter does not have drivers license";
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
