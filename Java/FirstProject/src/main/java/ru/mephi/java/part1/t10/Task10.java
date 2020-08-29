package ru.mephi.java.part1.t10;


import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        String randomStr = genRandStr(15);
        System.out.println( "The random string is: " + randomStr);
    }

    public static String genRandStr (int strLength){  // принимал длину строки, которую нужно вернуть. метод принимает длину строки. метод тот же
        Random generator = new Random();
        long a = Math.abs(generator.nextLong());
        StringBuilder strA = new StringBuilder(Long.toString(a, 36));
        while (strA.length() < strLength) {
            strA.append(Long.toString(Math.abs(generator.nextLong()), 36));
        }
        //
        //strA.setLength(0);
        return strA.toString().substring(0, strLength);  // alt + enter
    }
}
