package ru.mephi.java.part2.task04;

public final class IntHolder {
    private int intVal;

    public IntHolder() {
        this.intVal = 0;
    }

    public IntHolder(int initialIntVal) {
        this.intVal = initialIntVal;
    }

    public int getIntValue() {
        return this.intVal;
    }

    public void setIntValue(int newIntVal) {
        this.intVal = newIntVal;
    }
}
