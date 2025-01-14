package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Grandma extends Person {
    public Grandma(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitGrandma(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Grandma thanks Mom for keeping the house lively";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Grandma shares a nostalgic story with Dad";
    }

    @Override
    public String visitSon(Son son) {
        return "Grandma knits something special for Son";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Grandma admires Daughter's enthusiasm";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        if (this.equals(grandma)) {
            return "Grandma cannot interact with herself";
        }
        return "Grandma tells hi to other Grandma";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Grandma reminisces with Grandpa about the past";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Grandma gently scratches the Dog behind its ears";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Grandma watches the Cat curl up on her lap";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Grandma chuckles at the Hamster's antics";
    }

    @Override
    public String visitSkis(Skis skis) {
        if (this.age > 80) {
            return "Grandma reminisces about her younger days while holding the skis";
        }
        skis.setAvailable(false);
        return "Grandma carefully glides down the slope on the skis";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Grandma uses the lightest weights for a gentle exercise";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Grandma enjoys a slow, peaceful ride on the bicycle";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Grandma adjusts the car seat for comfort before her short drive";
        }
        return "Grandma does not have drivers license";
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
