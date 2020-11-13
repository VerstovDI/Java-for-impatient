package ru.mephi.java.part3.Theory3;

public class Animal implements IChangeSpecies{
    public String species;

    public Animal() {
        this.species="animal";
    }

    public Animal(String species) {
        this.species = species;
    }


    @Override
    public IChangeSpecies getOtherSpeciesBeing(IChangeSpecies livingBeing) {
        return getAnimalFromPerson((Person) livingBeing);
    }

    private static Animal getAnimalFromPerson(Person p) {
        return new Animal();
    }
}
