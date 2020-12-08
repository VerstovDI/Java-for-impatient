package ru.mephi.java.part7.task01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SieveOfErathostenes sieveOfErathostenes = new SieveOfErathostenes();
        System.out.println(sieveOfErathostenes.getPrimesHashSet());
        System.out.println(Arrays
                .toString(
                        sieveOfErathostenes.getPrimesBitSet().stream().toArray()
                ));
    }
}
