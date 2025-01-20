package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;
import cz.cvut.fel.omo.utils.RandomUtils;

public class Grandpa extends Person {
    public Grandpa(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitGrandpa(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Grandpa " + this.name + " praises Mom " + mom.getName() + " for her unwavering dedication to the family.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Grandpa " + this.name + " shares some timeless wisdom with Dad " + dad.getName() + " over a casual chat.";
    }

    @Override
    public String visitSon(Son son) {
        return "Grandpa " + this.name + " teaches Son " + son.getName() + " how to whistle a cheerful tune.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Grandpa " + this.name + " tells Daughter " + daughter.getName() + " an exciting tale from his adventurous past.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Grandpa " + this.name + " compliments Grandma " + grandma.getName() + "'s kindness and thoughtfulness.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        if (this.equals(grandpa)) {
            return "Grandpa " + this.name + " cannot interact with himself.";
        }
        return "Grandpa " + this.name + " exchanges greetings with Grandpa " + grandpa.getName() + " and shares a laugh.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Grandpa " + this.name + " calls Dog " + dog.getName() + " over for a playful pat and scratches behind its ears.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Grandpa " + this.name + " observes Cat " + cat.getName() + "'s curious behavior with amusement.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Grandpa " + this.name + " peers into Hamster " + hamster.getName() + "'s cage, marveling at its energy.";
    }

    @Override
    public String visitSkis(Skis skis) {
        if (this.age > 80) {
            return "Grandpa " + this.name + " smiles fondly, reminiscing about his younger days while holding the " + skis.getColor() + " skis.";
        }
        skis.setAvailable(false);
        return "Grandpa " + this.name + " carefully checks the bindings of the " + skis.getColor() + " skis before taking a safe ride.";
    }

    @Override
    public String visitWeights(Weights weights) {
        if (this.age > 80) {
            return "Grandpa " + this.name + " decides to skip using the weights, remembering his limits.";
        }
        weights.setAvailable(false);
        return "Grandpa " + this.name + " demonstrates his old-school lifting techniques with the weights, impressing everyone.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        if (this.age > 80) {
            return "Grandpa " + this.name + " decides not to ride the bicycle but tunes it up for someone else to enjoy.";
        }
        bicycle.setAvailable(false);
        return "Grandpa " + this.name + " repairs and tunes the " + bicycle.getColor() + " bicycle before taking it for a leisurely spin.";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Grandpa " + this.name + " checks the oil and tire pressure of the " + car.getColor() + " car before heading out for a comfortable drive.";
        }
        return "Grandpa " + this.name + " does not have a driver's license and cannot drive the car.";
    }


    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        if (dishwasher.getCurrentLoad() < dishwasher.getMaxLoad()) {
            int availableSpace = (int) (dishwasher.getMaxLoad() - dishwasher.getCurrentLoad());
            int maxDishes = Math.min(2, availableSpace);
            dishwasher.addItem("Cutlery", RandomUtils.getRandomNumber(1, maxDishes));
            return "Grandpa " + this.name + " added cutlery to " + dishwasher;
        }
        else {
            return "Grandpa " + this.name + " ignores full " + dishwasher;
        }
    }

    @Override
    public String visitFridge(Fridge fridge) {
        if (!fridge.isEmpty()) {
            String snack = fridge.removeFirstItem();
            return "Grandpa " + this.name + " got a " + snack + " from " + fridge;
        }
        return "Grandpa " + this.name + " could not get anything from empty " + fridge;
    }

    @Override
    public String visitOven(Oven oven) {
        oven.setSetting(Oven.RangeSettingType.WARM);
        oven.setTemperature(200);
        oven.turnOn();
        return "Grandpa " + this.name + " started making Baked Potatoes in " + oven;
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        recordPlayer.turnOff();
        return "Grandpa " + this.name + " turned off the " + recordPlayer;
    }

    @Override
    public String visitTelevision(Television television) {
        if (RandomUtils.isWithinPercentage(80)) {
            television.turnOn();
            television.setChannel(6);
            return "Grandpa " + this.name + " turned on the " + television + " and switched to channel 6";
        } else {
            television.turnOff();
            return "Grandpa " + this.name + " turned off the " + television;
        }
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        thermostat.turnOn();
        thermostat.setTemperature(thermostat.getCurrentTemperature() + 1);
        return "Grandpa " + this.name + " tries to turn up the temperature on " + thermostat;
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        if (washingMachine.getCurrentLoad() < washingMachine.getMaxLoad()) {
            int availableSpace = (int) (washingMachine.getMaxLoad() - washingMachine.getCurrentLoad());
            int maxClothes = Math.min(2, availableSpace);
            washingMachine.addItem("Sweatpants", RandomUtils.getRandomNumber(1, maxClothes));
            return "Grandpa " + this.name + " added sweatpants to " + washingMachine;
        }
        else {
            return "Grandpa " + this.name + " ignores full " + washingMachine;
        }
    }

    @Override
    public String visitWindow(Window window) {
        if (RandomUtils.isWithinPercentage(30)) {
            window.openCurtain();
            window.open();
            return "Grandpa " + this.name + " opened Window " + window.getId();
        }
        window.close();
        window.closeCurtain();
        return "Grandpa " + this.name + " closed the curtains of closed Window " + window.getId();
    }

    @Override
    public String toString() {
        return "Grandpa " + name + " (" + age + ")";
    }
}
