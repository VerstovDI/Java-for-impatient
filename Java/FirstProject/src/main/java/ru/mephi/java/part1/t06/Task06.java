package ru.mephi.java.part1.t06;


import java.math.*;

public class Task06 {
    static BigInteger[] cache = new BigInteger[1005];
    static {
        cache[0] = BigInteger.ONE;
    };

    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        System.out.println("[Without caching]: Factorial of 1000 equals:\n" + factorial(1000));
        long timespent = System.currentTimeMillis() - starttime;
        System.out.println("Time spent " + timespent + " ms");

        System.out.println("[With caching]: Factorial of 1000 equals:\n" + factorial(1000));
        long timespent_cache = System.currentTimeMillis() - starttime - timespent;
        System.out.println("Time spent " + timespent_cache + " ms");
    }

    public static BigInteger factorial(int num) {
        if ((cache.length > num) && (cache[num] != null)) {
            if (!cache[num].equals(BigInteger.valueOf(0))) {
                return cache[num];
            }
        }
        cache[num] = BigInteger.valueOf(num).multiply(factorial(num - 1));
        return cache[num];
    }
}
