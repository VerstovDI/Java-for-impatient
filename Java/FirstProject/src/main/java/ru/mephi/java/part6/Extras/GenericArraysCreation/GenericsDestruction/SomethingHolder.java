package ru.mephi.java.part6.Extras.GenericArraysCreation.GenericsDestruction;

public class SomethingHolder<E> {
    private E something;

    public SomethingHolder() {}

    public SomethingHolder(E something) {
        this.something = something;
    }

    public E getSomething() {
        return something;
    }

    public void setSomething(E something) {
        this.something = something;
    }

    @Override
    public String toString() {
        return "SomethingHolder{" +
                "something=" + something +
                '}';
    }
}
