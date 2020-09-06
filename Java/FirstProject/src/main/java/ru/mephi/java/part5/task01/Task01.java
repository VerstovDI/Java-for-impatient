package ru.mephi.java.part5.task01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task01 {
    static Logger LOGGER = Logger.getLogger(Task01.class.getName());
    static String resourcesFilePath = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator;

    public static void main(String[] args) throws IOException {
        String filePath = resourcesFilePath + "task01.txt";
        System.out.println(readValues(filePath));
    }

    public static ArrayList<Double> readValues(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Invalid file's name");
        }
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        BufferedReader bReader = new BufferedReader(new FileReader(filename));  // new FileReader(..) -> FileNotFoundException
        /*} catch (FileNotFoundException e) {
            System.out.println("File could not be opened for reading; closing program");
            System.exit(1);
        }*/
        String line;
        LOGGER.info("Start reading from file " + filename);
        while ((line = bReader.readLine()) != null) {  // .readLine() -> IOException
            doubleArrayList.add(Double.parseDouble(line));
        }
        LOGGER.info("End of reading from file" + filename);
        return doubleArrayList;
    }


    public static ArrayList<Double> readValues1(String filename) {
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        LOGGER.info("Start reading from file " + filename);
        try {
            for (String line : Files.readAllLines(Paths.get(filename))) {
                try {
                    doubleArrayList.add(Double.parseDouble(line));
                } catch (NullPointerException | NumberFormatException ex) {
                    LOGGER.log(Level.SEVERE,
                            "Line " + line + " isn't a float-pointing number", ex);
                    System.exit(1);
                }
            }
        } catch (IOException e) {
            e.getCause();
            LOGGER.log(Level.SEVERE, "I/O exception while reading doubles from " + e.getMessage(),  e.getCause());
            LOGGER.info("nothing was read");
        }
        LOGGER.info("End of reading from file" + filename);
        return doubleArrayList;
    }

    public boolean isDouble(String string) {
        try {
            Double.valueOf(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String getResourcesFilePath() {
        return resourcesFilePath;
    }

    public static void setResourcesFilePath(String resourcesFilePath) {
        Task01.resourcesFilePath = resourcesFilePath;
    }

    public ArrayList<Double> readValues3(String filename) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("invalid filename");
        }
        ArrayList<Double> resultArray = new ArrayList<Double>();
        Scanner in = new Scanner(new File(filename));
        while (in.hasNextDouble()) {
            resultArray.add(in.nextDouble());
        }
        return resultArray;
    }
}

