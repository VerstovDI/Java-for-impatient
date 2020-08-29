package ru.mephi.java.part3.task15;

import java.util.Random;


public class Task15 {
    public static void main(String[] args) {
        IntSequence seq =  Task15.randomInts(3,10);
        for (int i = 0; i < 5; i++) {
            if (seq.hasNext()) {
                System.out.println(seq.next());
            }
        }
    }

    private static Random generator = new Random();

    private static class RandomSequence implements IntSequence {
        private final int low;
        private final int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return this.low + generator.nextInt(this.high - this.low + 1);
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }
}
