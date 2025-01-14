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
        return "Grandma " + this.name + " warmly thanks Mom " + mom.getName() + " for keeping the house lively and cheerful.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Grandma " + this.name + " shares a heartwarming story with Dad " + dad.getName() + " from her younger days.";
    }

    @Override
    public String visitSon(Son son) {
        return "Grandma " + this.name + " lovingly knits a special sweater for Son " + son.getName() + ".";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Grandma " + this.name + " admires Daughter " + daughter.getName() + "'s boundless enthusiasm and energy.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        if (this.equals(grandma)) {
            return "Grandma " + this.name + " cannot interact with herself.";
        }
        return "Grandma " + this.name + " exchanges warm greetings with Grandma " + grandma.getName() + ".";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Grandma " + this.name + " reminisces with Grandpa " + grandpa.getName() + " about their cherished memories together.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Grandma " + this.name + " gently scratches Dog " + dog.getName() + " behind its ears while it wags its tail.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Grandma " + this.name + " smiles as Cat " + cat.getName() + " curls up on her lap, purring contentedly.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Grandma " + this.name + " chuckles at Hamster " + hamster.getName() + "'s amusing antics in its cage.";
    }

    @Override
    public String visitSkis(Skis skis) {
        if (this.age > 80) {
            return "Grandma " + this.name + " reminisces about her adventurous youth while holding the " + skis.getColor() + " skis.";
        }
        skis.setAvailable(false);
        return "Grandma " + this.name + " carefully glides down the slope on the " + skis.getColor() + " skis, enjoying the fresh air.";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Grandma " + this.name + " selects the lightest weights for a gentle and mindful exercise session.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Grandma " + this.name + " enjoys a slow, peaceful ride on the " + bicycle.getColor() + " bicycle through the garden path.";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Grandma " + this.name + " adjusts the seat and mirrors before taking the " + car.getColor() + " car for a short, comfortable drive.";
        }
        return "Grandma " + this.name + " does not have a driver's license and cannot drive the car.";
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
