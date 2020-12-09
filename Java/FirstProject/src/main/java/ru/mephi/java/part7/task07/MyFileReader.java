package ru.mephi.java.part7.task07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFileReader {
    private Map<String, Integer> wordFrequencyMap = new TreeMap<>();
    private Map<String, Set<Integer>> wordInLineMap = new TreeMap<>();

    private void calculateWordFrequency(Path filePath) {
        checkPath(filePath);
        try (Stream<String> stream = Files.lines(filePath)) {
            /*stream.collect(Collectors.groupingBy(k -> k, () -> wordFrequencyMap,
                    Collectors.counting()));*/
            stream.map(str -> str.split("\\s"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toMap(String::toLowerCase, w -> 1, Integer::sum, () -> wordFrequencyMap));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void calculateWordInLineOccurence(Path filePath) {
        try(Stream<String> stream = Files.lines(filePath)) {
            String[] lines = stream.toArray(String[]::new);
            for (int i = 0; i < lines.length; i++) {
                String[] words = lines[i].split("\\s");
                for (String word : words) {
                    wordInLineMap.putIfAbsent(word.toLowerCase(), new HashSet<>());
                    wordInLineMap.get(word.toLowerCase()).add(i);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void printWordOccurences(Path filePath) {
        calculateWordInLineOccurence(filePath);
        System.out.println(wordInLineMap);
    }

    private void checkPath(Path filePath) {
        if (!filePath.toFile().exists()) {
            throw new IllegalArgumentException(filePath + " has no file!");
        }
        if (!filePath.toFile().isFile()) {
            throw new IllegalArgumentException(filePath + " not a file!");
        }
    }

    public void printWordsFrequency(Path path) {
        calculateWordFrequency(path);
        System.out.println(wordFrequencyMap);
    }
}
