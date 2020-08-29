package ru.mephi.java.part3.task04;

public interface IntSequenceExtra {
    boolean hasNext();
    int next();
    static IntSequenceExtra of(int... objects) {
        return new IntSequenceExtra() {
            private int currLen = 0;
            @Override
            public boolean hasNext() {
                return currLen < objects.length;
            }

            @Override
            public int next() {
                return this.hasNext() ? objects[currLen++] : 0;
            }
        };
    }
}
