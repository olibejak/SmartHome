package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.entity.person.Mom;

public interface PersonVisitor {
    String visitMom(Mom mom);

    String visitDad(Dad dad);

    String visitSon(Son son);

    String visitDaughter(Daughter daughter);

    String visitGrandma(Grandma grandma);

    String visitGrandpa(Grandpa grandpa);
}
