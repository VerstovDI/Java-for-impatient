package ru.mephi.java.part5.task10;

import java.math.BigInteger;

public class Main {
    private static long depth=0L;

    public static void main(String[] args){
        factorialStackFrameJava8();
        // TODO: допилить
    }

    public static void factorialStackFrameJava8(){
        System.err.println(++depth);
        factorialStackFrameJava8();
    }

    /*public static BigInteger factorialStackFrameJava9(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Can't calculate factorial of negative number");
        }
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        StackWalker walker = StackWalker.getInstance();
        walker.forEach(stackFrame -> {
            if (stackFrame.getClassName().equals("Ch5_11")) {
                System.out.println(stackFrame);
            }
        });
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }*/
}
