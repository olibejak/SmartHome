package cz.cvut.fel.omo.entity;

public class Dog extends Pet {
    public Dog(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PetVisitor visitor) {return visitor.visitDog(this);}


}
