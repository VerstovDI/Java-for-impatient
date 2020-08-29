package ru.mephi.java.part4.task06;

public class Main {
    public static void main(String[] args) {
        DiscountedItem dI1 = new DiscountedItem("a", 2,3);
        Item dI2 = new Item("a", 2);
        DiscountedItem dI3 = new DiscountedItem("a", 2,5);
        System.out.println(dI1.equals(dI2));
        System.out.println(dI2.equals(dI3));
        System.out.println(dI1.equals(dI3));
        // Нарушение транзитивности. dI1 = dI2, dI2 = dI3, но dI1 != dI3.
    }
}
