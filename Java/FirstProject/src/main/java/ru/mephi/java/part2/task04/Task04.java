package ru.mephi.java.part2.task04;

public class Task04 {
    public static void main(String[] args) {
        // Потому что передается по значению, и потому что Integer - immutable
        // IntHolder check
        IntHolder myZeroInt = new IntHolder();
        IntHolder myInt = new IntHolder(6);
        printResult1(myZeroInt, myInt);
        swap(myZeroInt, myInt);
        printResult1(myZeroInt, myInt);
        // Integers check
        Integer integerA = 2;
        Integer integerB = 3;
        printResult2(integerA, integerB);
        swap(myZeroInt, myInt);
        printResult2(integerA, integerB);
    }

    private static void swap(IntHolder int1, IntHolder int2) {
        // Although a and b are copies, they are copies *of a reference*.
        // That means they point at the same object as in the caller,
        // and changes made to the object will be visible in both places.
        IntHolder tmpInt = new IntHolder(int1.getIntValue());
        int1.setIntValue(int2.getIntValue());
        int2.setIntValue(tmpInt.getIntValue());
    }

    private static void swap(Integer integer1, Integer integer2) {
        Integer tempInteger;
        tempInteger = integer1;
        integer1 = integer2;
        integer2 = tempInteger;
    }

    public static void printResult1(IntHolder first, IntHolder second) {
        System.out.format("First int: %d;%n Second int: %d%n", first.getIntValue(), second.getIntValue());
    }

    public static void printResult2(Integer first, Integer second) {
        System.out.format("First int: %d;%n Second int: %d%n", first, second);
    }
}
