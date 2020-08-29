package ru.mephi.java.part2.task09;

import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Car devyatka = new Car(60,6);
        devyatka.move(6, 1);
        System.out.format("Car moved on %s km.%n", devyatka.distance());
        System.out.format("Fuel left: %s litres%n", devyatka.fuelResidue());
        devyatka.addFuel(10);
        System.out.println("+ 10 litres");
        System.out.format("Current fuel balance: %s%n", devyatka.fuelResidue());
        System.out.format("Car moved on 10 kilometres more%n");
        devyatka.move(10, -1);
        System.out.format("Since start car moved on %s km.%n", devyatka.distance());
        System.out.format("Fuel left: %s litres%n", devyatka.fuelResidue());
    }
}
