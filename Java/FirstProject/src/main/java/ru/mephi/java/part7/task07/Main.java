package ru.mephi.java.part7.task07;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

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
        myFileReader.printWordOccurences(filePath);

        MyFileReader2 myFileReader2 = new MyFileReader2();
        myFileReader2.printWordsFrequency(filePath);
        myFileReader2.printWordOccurences(filePath);






        /*LineIterator it = FileUtils.lineIterator(filePath.toFile(), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                // и то же самое...
            }
        } finally {
            it.close();
        }*/
    }
}
