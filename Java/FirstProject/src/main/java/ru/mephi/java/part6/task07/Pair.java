package ru.mephi.java.part6.task07;

public class Pair<E> {
    private E elementLeft;
    private E elementRight;

    public Pair() { }

    public Pair(E elementLeft, E elementRight) {
        this.elementLeft = elementLeft;
        this.elementRight = elementRight;
    }

    public E getElementLeft() {
        return elementLeft;
    }

    public E getElementRight() {
        return elementRight;
    }

    public void setElementLeft(E elementLeft) {
        this.elementLeft = elementLeft;
    }

    public void setElementRight(E elementRight) {
        this.elementRight = elementRight;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "elementLeft=" + elementLeft +
                ", elementRight=" + elementRight +
                '}';
    }
}
