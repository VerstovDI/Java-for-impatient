package ru.mephi.java.part3.Theory3;

@FunctionalInterface
public interface Converter<F, T> {
        T convert(F from);
}
