package ru.mephi.java.part7.task08;

import ru.mephi.java.part7.task07.MyFileReader;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        // Саму реализацию см. в task07
        String fileName = "part7" + File.separator + "SomeFile.txt";
        Path filePath = Paths.get(Objects.requireNonNull(ru.mephi.java.part7.task07.Main.class
                .getClassLoader()
                .getResource(fileName))
                .toURI());
        MyFileReader myFileReader = new MyFileReader();
        myFileReader.printWordOccurences(filePath);
    }
}
