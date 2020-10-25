package ru.mephi.java.part6.task10;

public class Main {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{5, 6, 7, 9, 11, 11, -1, 3, -5, 0};
        System.out.println(CustomArrays.min(ints));
        System.out.println(CustomArrays.max(ints));
    }
}
