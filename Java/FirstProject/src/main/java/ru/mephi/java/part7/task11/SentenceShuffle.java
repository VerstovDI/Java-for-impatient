package ru.mephi.java.part7.task11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceShuffle {
    public static void main(String[] args) {
        System.out.println(sentenceShuffle("My friend Sam likes football very much"));
    }

    public static String sentenceShuffle(String sentence) {
        List<String> words = Arrays.asList(sentence.trim().split("\\s"));
        Collections.shuffle(words
                = words.stream().skip(1).limit(words.size() - 2).collect(Collectors.toList()));
        return String.join(" ", words);
    }
}
