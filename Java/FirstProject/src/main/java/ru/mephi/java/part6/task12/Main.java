package ru.mephi.java.part6.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(3,4,3,-5,6,10,23);
        List<Integer> result = new ArrayList<>();
        //minmax(ints, Comparator.comparingInt(o -> o), result);
        System.out.println(result);
    }

    public static <T> void minmax(List<T> elements,
                                  Comparator<Object> comp, List<Object> result) {
        if (elements.size() > 0) {
            T min = elements.get(0);
            T max = elements.get(0);
            for (T element : elements) {
                if (comp.compare(element, min) < 0) {
                    min = element;
                }
                if ((comp.compare(element, max) > 0)) {
                    max = element;
                }
            }
            result.add(min);
            result.add(max);
        }
    }
}
