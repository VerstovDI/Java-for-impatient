package ru.mephi.java.part6.task08;

public class Pair<E extends Comparable<? super E>> {
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

    public E min() {
        return (elementLeft.compareTo(elementRight)) <= 0 ? elementLeft : elementRight;
    }

    public E max() {
        return (elementLeft.compareTo(elementRight)) >= 0 ? elementLeft : elementRight;
    }


    @Override
    public String toString() {
        return "Pair{" +
                "elementLeft=" + elementLeft +
                ", elementRight=" + elementRight +
                '}';
    }
}
