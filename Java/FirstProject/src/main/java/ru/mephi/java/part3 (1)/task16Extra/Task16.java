package ru.mephi.java.part3.task16Extra;

import java.util.Arrays;
import java.util.function.Function;

public class Task16 {
    public static void main(String[] args) {
        String[] testArr = new String[] { "Abo", "Ken", "Boris", "Yaroslav", "Alex", "Aay", "Kirill" };

        MyStringComparator myComp1 = (s1, s2) -> s1.length() - s2.length();

        // Сортировка по длине слов + исп. метода toComparator
        Arrays.sort(testArr, myComp1.toComparator());
        System.out.println(Arrays.asList(testArr));

        // Сортировка в лексикографическом порядке + исп. метода compareTo
        MyStringComparator myComp2 = String::compareTo;
        Arrays.sort(testArr, myComp2.toComparator());
        System.out.println(Arrays.asList(testArr));

        // Применение функции thenComparing();
        Arrays.sort(testArr, myComp1.thenComparing(myComp2).toComparator());
        System.out.println(Arrays.asList(testArr));

        // Исп. метода nullsFirst
        String[] testArr2 = new String[] { "Evstahiy", null, "Janet"};
        Arrays.sort(testArr2, myComp2.nullsFirst().toComparator());
        System.out.println(Arrays.asList(testArr2));

        // Исп. метода comparing + метода reversed
        Arrays.sort(testArr, myComp2.reversed().toComparator());
        System.out.println(Arrays.asList(testArr));

        // Пусть передаваемая ф-я извлекает подстроку с 1 по последнюю, и именно по таким
        // подстрокам компаратор сравнивает лекцикографическом порядке
        Function<String, String> func = s -> s.substring(1, s.length() - 1);
        Arrays.sort(testArr, MyStringComparator.comparing(func, myComp2).nullsFirst().toComparator());
        System.out.println(Arrays.asList(testArr));
    }
}
