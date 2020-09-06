package ru.mephi.java.part5.task06;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task06 {
    public String readSomething1(String filename) {
        BufferedReader in = null;
        String resultString = null;
        try {
            in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
            resultString = in.readLine();
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close(); // ВНИМАНИЕ: может быть сгенерировано исключение!
                } catch (IOException e) {
                    System.err.println("IOException caught during closing resources"
                            + e.getMessage());
                }
            }
        }
        return resultString;
    }

    public String readSomething2(String filename) {
        String resultString = null;
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
            resultString = in.readLine();
            if (in != null) {
                try {
                    in.close(); // ВНИМАНИЕ: может быть сгенерировано исключение!
                } catch (IOException e) {
                    System.err.println("IOException caught during closing resources"
                            + e.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
        return resultString;
    }

    public String readSomething3(String filename) {
        String resultString = null;
        try (BufferedReader in
                     = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            resultString = in.readLine();
        } catch (IOException ioEx) {
            System.err.println("Caught IOException: " + ioEx.getMessage());
        }
        return resultString;
    }
}
