package ru.mephi.java.part7.task07;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MyFileReader2 {
    private Map<String, Integer> wordFrequencyMap = new TreeMap<>();
    private Map<String, Set<Integer>> wordInLineMap = new TreeMap<>();

    public void calculateWordFrequency(Path filePath) {
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader
                        (new FileInputStream(filePath.toFile())))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    putWordFrequencyInMap(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calculateWordInLineOccurence(Path filePath) {
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader
                        (new FileInputStream(filePath.toFile())))) {
            int lineNumber = 0;
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] lineWords = line.split("\\s+");
                putWordInLine(lineWords, lineNumber);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void putWordInLine(String[] words, int lineNumber) {
        for (String word : words) {
            wordInLineMap.putIfAbsent(word.toLowerCase(), new HashSet<>());
            wordInLineMap.get(word.toLowerCase()).add(lineNumber);
        }
    }

    private void putWordFrequencyInMap(String word) {
        wordFrequencyMap.compute(word.toLowerCase(), (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void printWordOccurences(Path filePath) {
        calculateWordInLineOccurence(filePath);
        System.out.println(wordInLineMap);
    }

    public void printWordsFrequency(Path path) {
        calculateWordFrequency(path);
        System.out.println(wordFrequencyMap);
    }

    private void checkPath(Path filePath) {
        if (!filePath.toFile().exists()) {
            throw new IllegalArgumentException(filePath + " has no file!");
        }
        if (!filePath.toFile().isFile()) {
            throw new IllegalArgumentException(filePath + " not a file!");
        }
    }
}
