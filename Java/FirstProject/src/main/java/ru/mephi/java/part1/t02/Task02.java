package ru.mephi.java.part1.t02;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter here the integer, please -->: ");
        int input;
        input = sc.nextInt();

        // Normalization without floor.Mod
        int normalized = input;
        normalized = normalized % 360;
        if ((input < 0) && (normalized != 0)) {
            normalized = normalized + 360;
        }
        System.out.println("[Without floor.Mod]: Normalized angle value: " + normalized + " deg.");

        // Normalization with floor.Mod
        int normalizedFloormod = input;
        normalizedFloormod = Math.floorMod(normalizedFloormod, 360);
        System.out.println("[With floor.Mod]: Normalized angle value: " + normalizedFloormod + " deg.");
    }
}