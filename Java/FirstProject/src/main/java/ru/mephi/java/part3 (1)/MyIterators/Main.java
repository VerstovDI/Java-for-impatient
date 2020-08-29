package ru.mephi.java.part3.MyIterators;

import java.util.*;
import java.util.function.Function;

//import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
       /* ArrayList<String> stringsArray =
                new ArrayList<>(Arrays.asList("Москва", "Пермь", "Ош", "Ашхабад", "Томь"));
        Iterator<String> iterator1 = stringsArray.iterator();*/

        /*// Тест метода fromIterator
        MyIterator2<String, Integer> myIterator2 = MyIterator2.fromIterator(iterator1);
        out.println("myIterator2 is " + myIterator2.getClass() + "\n");

        // Тесты методов hasNext и next
        while (myIterator2.hasNext()) {
            out.println(myIterator2.next());
        }
        out.println();

        Function<String, Integer> function1 = String -> String.length();
        Function<Integer, String> function2 = i -> i.toString();
        //function2.andThen(function1.apply("hello"));

        Function<String, String> f1 = s -> s + "1";
        Function<String, String> f2 = s -> s + "2";
        Function<String, String> f3 = s -> s + "3";
        Function<String, String> f4 = s -> s + "4";
        System.out.println(f1.andThen(f2).compose(f3).compose(f4).apply("Compose"));
        System.out.println(f1.andThen(f2).andThen(f3).apply("AndThen"));

        Function<String, Integer> f5 = str -> str.length();
        Function<Integer, String> f6 = inputInt -> Integer.toString(inputInt);
        out.println(f5.compose(f6).compose(f5).apply("Hello"));*/

        /*// Тест метода map
        MyIterator2<String, Integer> myIterator3 = MyIterator2.fromIterator(stringsArray.iterator())
                .map(s -> s.length())
                .map(i -> i.toString())
                .map(s -> s.length());
        //myIterator3 = myIterator3.map(function1);
        int i = 5;
        while (myIterator3.hasNext()) {
            out.println(myIterator3.next());
        }

        // Тест метода forEach
        //Consumer myConsumer = s -> out.println("Transformed element: " + s);
        //myIterator3.forEach(myConsumer);*/
        /*Iterator<String> sIterator = Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "bbbb", "cccc", "ddddd").iterator();
            MyIterator2.fromIterator(sIterator).map(s -> s.length()).map(i -> i.toString())
                    .map(str -> str.length()).forEach(System.out::println);*/
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("Antananarivu");
        arrList.add("hi");
        Iterator it = arrList.iterator();
        Function<String, Integer> f = String::length;

        Function<Integer, String> g = Object::toString;
        //MyIterator.fromIterator(it).map(f).forEach(System.out::println);
        MyIterator.fromIterator(it).map(f).map(g).map(f).forEach(System.out::println);
    }
}
