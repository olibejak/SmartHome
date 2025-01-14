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
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "Dad tests the skis' durability with sharp turns";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Dad pushes himself to lift heavier weights each set";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Dad uses the bicycle for a high-speed workout around the neighborhood";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Dad takes the car for a long, smooth drive on the highway";
        }
        return "Dad does not have drivers license";
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
