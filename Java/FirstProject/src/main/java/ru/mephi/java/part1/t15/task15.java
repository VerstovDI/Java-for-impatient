package ru.mephi.java.part1.t15;

import java.util.ArrayList;
import java.util.Scanner;

public class task15 {
    public static void main(String[] args) {
        // Input
        System.out.println("Please, enter the degree (integer n):");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Creation of 2-d ArrayList structure
        ArrayList<ArrayList<Integer>> pascal_triangle = new ArrayList<>();
        for(int i=0; i < n; i++) {
            pascal_triangle.add(new ArrayList<>());
        }
        // Initialization as a Pascal triangle
        for (int i = 0; i < n; i++) {
            pascal_triangle.get(i).add(0,1);
            for (int j = 1; j < i; j++) {
                pascal_triangle.get(i).add(j, pascal_triangle.get(i-1).get(j-1) + pascal_triangle.get(i-1).get(j));
            }
            if (i != 0) {
                pascal_triangle.get(i).add(1);
            }
        }
        for (ArrayList<Integer> arr_lst : pascal_triangle) {
            for (Integer el : arr_lst) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
