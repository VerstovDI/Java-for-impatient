package ru.mephi.java.part5.task12;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;


public class Task12 {
    public int minAssert(int[] values) {
        int arrayMin = IntStream.of(values).min().getAsInt();
        assert Arrays.stream(values).allMatch(x -> x >= arrayMin) : "Something went wrong...";
        return arrayMin;
    }

    public int minWithoutAssert(int[] values) {
        int arrayMin = IntStream.of(values).min().getAsInt();
        return arrayMin;
    }
}
