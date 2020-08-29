package ru.mephi.java.part3.task04;

public interface IntSequence {
    boolean hasNext();
    int next();
    static IntSequence of(int... objects) {
        class ReturnedIntSequence implements IntSequence {
            private int currInt = 0;

            @Override
            public boolean hasNext() {
                return this.currInt != objects.length;
            }

            @Override
            public int next() {
                return this.hasNext() ? objects[currInt++] : 0;
            }
        }
        return new ReturnedIntSequence();
    }
}
