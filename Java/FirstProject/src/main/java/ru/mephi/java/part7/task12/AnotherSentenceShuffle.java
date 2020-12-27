package ru.mephi.java.part7.task12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AnotherSentenceShuffle {
    public static void main(String[] args) {
        //System.out.println(anotherSentenceShuffle("My friend Sam likes football very much"));
        anotherSentenceShuffle("My friend Sam likes football very much");
    }

    public static void anotherSentenceShuffle(String sentence) {
        List<String> words = Arrays.asList(sentence.trim().split("\\s"));
        words.set(0, words.get(0).toLowerCase());
        Collections.shuffle(words);
        words.set(words.size()-1, words.get(words.size()-1).concat("."));
        System.out.println(String.join(" ", words));
        //return String.join(" ", words);
    }
}
