package ru.mephi.java.part3.Theory3;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Tester {
    public static void main(String[] args) {
        /*char symbol = 'a';
        String str = "aBrAcAdAbRa!clz~;x'z'',,.c"; // 2
        IStringHandler strHandler = (char symb, String string) -> {
            int count = 0;
            for (int q = 0; q < string.length(); q++)
                if (symb == string.charAt(q)) {
                    count++;
                }
            return count;
        };
        System.out.println(strHandler.getNumberOfSymbols(symbol, str));
        StringSearcher searcher = new StringSearcher(symbol, str);*/
        // Constructor reference
        IPersonMaker p = Person::new;
        IPersonMaker q = (String str) -> {
            return new Person(str);
        };

        Person newPerson = p.make("HomoSapiens");
        System.out.println(newPerson.getSpecies());

        // Class::instance method
        SomeStringClass something = new SomeStringClass();
        Converter<String, String> converter = something::endsWith;
        String convertedString = converter.convert("Good morning, friend");
        System.out.println(convertedString);

        // Class::static method
        //IStringHandler stringHandler = s -> StringChecker.isPalindrome(s);
        IStringHandler stringHandler2 = StringChecker::isPalindrome;
        System.out.println(stringHandler2.checkString("level"));
        System.out.println(stringHandler2.checkString("levitate"));

        // object::instanceMethod
        // StringConsumer consumer = x -> System.out.println(x);
        StringConsumer consumer = System.out::println;
        consumer.acceptString("my wonderful example in da house");
    }
}
