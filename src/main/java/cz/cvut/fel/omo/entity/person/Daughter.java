package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;
import cz.cvut.fel.omo.utils.RandomUtils;

public class Daughter extends Person {
    public Daughter(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitDaughter(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Daughter " + this.name + " shares her exciting plans with Mom " + mom.getName() + " while seeking advice.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Daughter " + this.name + " asks Dad " + dad.getName() + " for help solving a tricky puzzle.";
    }

    @Override
    public String visitSon(Son son) {
        return "Daughter " + this.name + " bursts into laughter at Son " + son.getName() + "'s hilarious joke.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        if (this.equals(daughter)) {
            return "Daughter " + this.name + " cannot interact with herself.";
        }
        return "Daughter " + this.name + " greets her friend Daughter " + daughter.getName() + " with a cheerful wave.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Daughter " + this.name + " listens intently as Grandma " + grandma.getName() + " tells a fascinating story from her youth.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Daughter " + this.name + " asks Grandpa " + grandpa.getName() + " to teach her something new about history.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Daughter " + this.name + " kneels down to give Dog " + dog.getName() + " a warm and loving hug.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Daughter " + this.name + " dangles a string to entice Cat " + cat.getName() + " into a playful chase.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Daughter " + this.name + " watches Hamster " + hamster.getName() + " climb around its cage with delight.";
    }

    @Override
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "Daughter " + this.name + " practices graceful and controlled skiing on the " + skis.getColor() + " skis.";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Daughter " + this.name + " incorporates the weights into her daily fitness routine with focus.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Daughter " + this.name + " rides the " + bicycle.getColor() + " bicycle to her favorite scenic spot to relax.";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Daughter " + this.name + " carefully practices parking the " + car.getColor() + " car perfectly in the driveway.";
        }
        return "Daughter " + this.name + " does not have a driver's license yet and cannot drive the car.";
    }


    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        if (dishwasher.getCurrentLoad() < dishwasher.getMaxLoad()) {
            int availableSpace = (int) (dishwasher.getMaxLoad() - dishwasher.getCurrentLoad());
            int maxDishes = Math.min(3, availableSpace);
            dishwasher.addItem("Mug", RandomUtils.getRandomNumber(1, maxDishes));
            return "Daughter " + this.name + " added mugs to Dishwasher " + dishwasher.getId();
        }
        else {
            return "Daughter " + this.name + " notices full Dishwasher " + dishwasher.getId();
        }
    }

    @Override
    public String visitFridge(Fridge fridge) {
        if (!fridge.isEmpty()) {
            String snack = fridge.getFirstItem();
            return "Daughter " + this.name + " got a " + snack + " from Fridge " + fridge.getId();
        }
        return "Daughter " + this.name + " could not get anything from empty Fridge " + fridge.getId();
    }

    @Override
    public String visitOven(Oven oven) {
        return "";
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        recordPlayer.insertRecord("Dark Horse", "Katy Perry");
        recordPlayer.turnOn();
        return "Daughter " + this.name + " turned on the Record Player " + recordPlayer.getId();
    }

    @Override
    public String visitTelevision(Television television) {
        if (RandomUtils.isWithinPercentage(60)) {
            television.setChannel(4);
            television.turnOn();
            return "Daughter " + this.name + " turned on the TV " + television.getId();
        } else {
            television.turnOff();
            return "Daughter " + this.name + " turned off the TV " + television.getId();
        }
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        thermostat.setTemperature(thermostat.getCurrentTemperature() + 1);
        thermostat.turnOn();
        return "Daughter " + this.name + " tries to turn up the temperature on Thermostat " + thermostat.getId();
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        if (washingMachine.getCurrentLoad() < washingMachine.getMaxLoad()) {
            int availableSpace = (int) (washingMachine.getMaxLoad() - washingMachine.getCurrentLoad());
            int maxClothes = Math.min(2, availableSpace);
            washingMachine.addItem("T-Shirt", RandomUtils.getRandomNumber(1, maxClothes));
            return "Daughter " + this.name + " added t-shirts to Washing Machine " + washingMachine.getId();
        }
        else {
            return "Daughter " + this.name + " notices full Washing Machine " + washingMachine.getId();
        }
    }

    @Override
    public String visitWindow(Window window) {
        if (RandomUtils.isWithinPercentage(40)) {
            window.openCurtain();
            window.open();
            return "Daughter " + this.name + " opened Window " + window.getId();
        }
        window.close();
        window.openCurtain();
        return "Daughter " + this.name + " opened the curtains of closed Window " + window.getId();
    }
}
