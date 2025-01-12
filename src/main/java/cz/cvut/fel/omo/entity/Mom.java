package cz.cvut.fel.omo.entity;

public class Mom extends Person {
    public Mom(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitMom(this);}


}
