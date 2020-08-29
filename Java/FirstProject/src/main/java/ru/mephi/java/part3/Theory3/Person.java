package ru.mephi.java.part3.Theory3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Person implements IChangeSpecies { //, IPrintInfo {
    String species;
    public final static PrintStream out = null;

    @Override
    public IChangeSpecies getOtherSpeciesBeing(IChangeSpecies livingBeing) {
        return getAnimalFromPerson((Person) livingBeing);
    }

    private static Animal getAnimalFromPerson(Person p) {
        return new Animal();
    }

    public Person(String species) {
        this.species = species;
    }

    public Person() {
        this.species = "human";
    }

    public String getSpecies() {
        return this.species;
    }

/*    @Override
    public void printInfo(IPrintInfo p) throws FileNotFoundException {
        PrintStream filePrintStream = new PrintStream(new File("C:\\personInfo.txt"));
        filePrintStream.println(p.getSpecies());
    }*/
}
