package cz.cvut.fel.omo.main;

import cz.cvut.fel.omo.entity.person.*;
import cz.cvut.fel.omo.entity.pet.Cat;
import cz.cvut.fel.omo.entity.pet.Dog;
import cz.cvut.fel.omo.entity.pet.Hamster;
import cz.cvut.fel.omo.entity.pet.Pet;

import java.util.ArrayList;

public class EntityInitialization {

    // Family
    Mom mom = new Mom("Jane", 39, 1, true);
    Dad dad = new Dad("John", 41, 1, true);
    Son son = new Son("Jake", 9, 1, false);
    Daughter daughter = new Daughter("Jessica", 7, 1, false);
    Grandma grandma = new Grandma("Janet", 68, 1, false);
    Grandpa grandpa = new Grandpa("Joe", 71, 1, true);

    // Pets
    Dog dog = new Dog("Max", 4, 1);
    Cat cat = new Cat("Coots", 3, 1);
    Hamster hamster = new Hamster("Jerry", 2, 1);

    public ArrayList<Person> getFamily() {
        ArrayList<Person> family = new ArrayList<>();
        family.add(mom);
        family.add(dad);
        family.add(daughter);
        family.add(son);
        family.add(grandma);
        family.add(grandpa);
        return family;
    }

    public ArrayList<Pet> getPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(dog);
        pets.add(cat);
        pets.add(hamster);
        return pets;
    }
}
