package ru.mephi.java.part6.task12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> sourceList = new ArrayList<>(List.of(-5,0,-5,4,3,2,10,0));
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        minmax(sourceList, comparator, resultList);
        System.out.println((resultList));
    }

    public static <T> void minmax(List<T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        if (elements.isEmpty()) {
            return;
        }
        T min = elements.get(0);
        T max = min;
        for (T el : elements) {
            if (comp.compare(el, min) < 0) {
                min = el;
            }
        }
        for (T el : elements) {
            if (comp.compare(el, max) > 0) {
                max = el;
            }
        }
        result.add(min);
        result.add(max);
    }
}
