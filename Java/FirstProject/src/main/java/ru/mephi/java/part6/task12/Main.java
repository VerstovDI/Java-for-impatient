package ru.mephi.java.part6.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(3,4,3,-5,6,10,23);
        List<Integer> result1 = new ArrayList<>();

        minmax(ints, Comparator.comparingInt(o -> o), result1);
        System.out.println(result1);

        List<Integer> result2 = new ArrayList<>();
        minmax2(ints, Comparator.comparingInt(o -> o), result2);
        System.out.println(result2);

        List<Integer> result3= new ArrayList<>();
        minmax3(ints, result3);
        System.out.println(result3);
    }

    public static <T> void minmax(List<T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
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

    public static <T> void minmax2(List<? extends T> elements,
                               Comparator<T> comp, List<T> result) {
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
    public static <T extends Comparable<T>> void minmax3(List<? extends T> elements,
                                                         List<T> result) {
        if (elements.size() > 0) {
            T min = elements.get(0);
            T max = elements.get(0);
            T el = elements.get(0);
            int comparisonResult;
            for (T element : elements) {
                comparisonResult = element.compareTo(el);
                el = element;
                if (comparisonResult < 0) {
                    min = element;
                }
                if (comparisonResult > 0) {
                    max = element;
                }
            }
            result.add(min);
            result.add(max);
        }
    }
}
