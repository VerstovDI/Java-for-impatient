package ru.mephi.java.part1.t14;

import java.util.Scanner;

public class task14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a magick square.\nEnter the lines of numbers separated by a space, one by one.");
        String line;
        int[][] sq = new int[0][0];
        int j = 0;
        boolean firstLine = true;
            while(true) {
                line = sc.nextLine();
                if (line.equals("")) {
                    break;
                }
                String[] strArr = line.split("\\s");
                if (firstLine) {
                    sq = new int[strArr.length][strArr.length];
                    firstLine = false;
                }
                for (int i = 0; i < strArr.length; i++) {
                        sq[j][i] = Integer.parseInt(strArr[i]);
                }
                j++;
            }

        //int[][] sq = {{4,9,2}, {3,5,7}, {8,1,6}};
         magickSquare(sq);
    }

    public static boolean magickSquare(int[][] square) {
        int diag1Sum = 0;
        int diag2Sum = 0;
        // Check diagonals
        for (int i = 0; i < square.length; i++) {
            diag1Sum += square[i][i];
            diag2Sum += square[i][square.length-1-i];
        }
        if (diag1Sum != diag2Sum) {
            System.out.println("It is not a magick square");
            return false;
        }
        // Check rows and columns
        for (int i = 0; i < square.length; i++) {
            int colSum = 0;
            int rowSum = 0;
            for (int j = 0; j < square.length; j++) {
                rowSum += square[i][j];
                colSum += square[j][i];
            }
            if ((rowSum != diag1Sum) || (colSum != diag1Sum)) {
                System.out.println("It is not a magick square");
                return false;
            }
        }
        System.out.println("It is a magic square");
        return true;
    }
}
