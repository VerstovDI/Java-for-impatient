package ru.mephi.java.part3.Theory3;

public class Animal implements IChangeSpecies{
    String species;

    public Animal() {
        this.species="animal";
    }


    @Override
    public IChangeSpecies getOtherSpeciesBeing(IChangeSpecies livingBeing) {
        return getAnimalFromPerson((Person) livingBeing);
    }

    private static Animal getAnimalFromPerson(Person p) {
        return new Animal();
    }
}
