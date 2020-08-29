package ru.mephi.java.part4.task07;

public class Main {
    public static void main(String[] args) {
        for (Colors c : Colors.values()) {
            System.out.println(c);
        }
        System.out.println();
        Colors color1 = Colors.valueOf("BLACK");
        Colors color2 = Colors.BLUE;
        Object color3 = Colors.class;
        System.out.println(color1);
        System.out.println(color2);
        System.out.println(color3);
        System.out.println(color2.ordinal());
        System.out.println(color1.getBlue() + " " + color1.getGreen() + " " + color1.getRed());
    }
}
