package ru.mephi.java.part7.task07;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        String fileName = "part7" + File.separator + "SomeFile.txt";
        Path filePath = Paths.get(Objects.requireNonNull(Main.class
                        .getClassLoader()
                        .getResource(fileName))
                        .toURI());
        MyFileReader myFileReader = new MyFileReader();
        myFileReader.printWordsFrequency(filePath);
    }
}
