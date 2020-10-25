package ru.mephi.java.part6.task10;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CustomArrays {
    private CustomArrays() {
    }

    public static <E extends Comparable<? super E>> E min(@NotNull E[] array) {
        Objects.requireNonNull(array);
        E min = array[0];
        for (E el : array) {
            if (el.compareTo(min) < 0) {
                min = el;
            }
        }
        return min;
    }

    public static <E extends Comparable<? super E>> E max(@NotNull E[] array) {
        Objects.requireNonNull(array);
        E max = array[0];
        for (E el : array) {
            if (el.compareTo(max) > 0) {
                max = el;
            }
        }
        return max;
    }
}
