package ru.mephi.java.part2.task03;

import java.math.BigInteger;

public class Task03 {
    public static void main(String[] args) {
        BigInteger bigInt = BigInteger.valueOf(2019);
        bigInt = bigInt.add(BigInteger.valueOf(1));
        // javadoc: Returns a BigInteger whose value is (this + val). <- mutator method that returns BigInteger
        myAccessor(); // ?
    }

    public static void myAccessor() {
        System.out.println("");
    }
}
