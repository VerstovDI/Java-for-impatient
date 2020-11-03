package ru.mephi.java.part6.task07;

public class Main {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<>("LEFT JOIN", "RIGHT JOIN");
        System.out.println(pair.getElementLeft());
        System.out.println(pair.getElementRight());
    }
}
