package ru.mephi.java.part6.task18;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //CustomArrays.repeat(10, 42, int[]::new);
        System.out.println(Arrays.toString(CustomArrays.repeat(10, 42, Integer[]::new)));
    }
}
