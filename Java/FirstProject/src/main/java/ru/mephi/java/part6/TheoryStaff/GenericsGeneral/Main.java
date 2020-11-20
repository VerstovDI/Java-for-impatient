package ru.mephi.java.part6.TheoryStaff.GenericsGeneral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List ints = new LinkedList();
        ints.add(1);
        // Integer i = ints.iterator().next(); так делать было бы нельзя - нужно кастовать к Integer
        // Компилятор на этапе компиляции не знает, какой тип будет возвращен и просит его указать.

        // Но.
        List listUntilJava5 = new ArrayList();
        listUntilJava5.add(2020);
        listUntilJava5.add("Some string"); // !!!
        for (Object str : listUntilJava5) {
            System.out.println((String)str); // !!
        }
        // Компилятор до Java 5 не увидит ничего плохо -> получим ошибку во время выполнения (runtime)
        // ClassCastException -> не могу прикастовать Integer к String

        // Начиная с Java 1.5:
        List<String> listAfterJava5 = new ArrayList<>();
        listAfterJava5.add("Hello!");
        // listAfterJava5.add(123); Компилятор предостерегает программиста от ошибки в runtime
        // и говорит, что не получится добавить Integer в лист, т.к. он типизирован String
        // - Безопасно, т.к. теперь явно понятно, что класс, типизированный дженериком,
        // хранит элементы одного конкретного типа (Type safety)
        // - Теперь есть проверка типов до runtime. (Compile-time checking)
        // - Избавляет от runtime-ошибки ClassCastException.
        // - Избавляет от множества ненужны кастов при использовани (например, выводе)
        // (Type casting - теперь не нужен)
        // - Делает понятнее код.
        for (Object str : listAfterJava5) {
            System.out.println(str);
        }
        for (String str : listAfterJava5) {
            System.out.println(str);
        }
        // TODO: Зачем нужнаконтр-вариантность. Примеры кода, рассказать, почему без них не получилось быы
        // TODO: второй безопасный способ создать массив T[]
        // TODO: слайд Class, 5 строчек. Привести примеры. 1 раз с использованием рефлексии,
        // 1 раз с использованием лямбда-выражений.
    }
}
