package ru.mephi.java.part5.extra.why_try_with_resources;


import java.io.*;
import java.util.ArrayList;

public class Main {
    private static final String basePath = "src" + File.separator
            + "main" + File.separator + "resources" + File.separator
            + "extras" + File.separator;
    public static void main(String[] args) {
        writeStrings2(new File(basePath + "from.txt"),
                new File(basePath + "compareTo.txt"),
                new File(basePath + "to.txt"));
    }

    public static void writeStrings1(File fileFrom, File fileCompareTo, File fileTo) {
        ArrayList<String> matchStrings = new ArrayList<>();
        ArrayList<String> allStrings = new ArrayList<>();

        try (BufferedReader readerFrom =
                     new BufferedReader(
                     new InputStreamReader(new FileInputStream(fileFrom)));
             BufferedReader readerCompare =
                     new BufferedReader(
                     new InputStreamReader(new FileInputStream(fileCompareTo)));
             BufferedWriter writer =
                     new BufferedWriter(
                     new OutputStreamWriter((new FileOutputStream((fileTo)))))
        ) {
            doSomething(readerFrom, readerCompare, writer, matchStrings, allStrings);
        } catch (FileNotFoundException fileNotFoundEx) {
            System.err.println("File wasn't found;" + fileNotFoundEx.getLocalizedMessage());
        } catch (IOException ioException) {
            System.err.println("Something went wrong during writing/reading from files");
        }
    }

    public static void writeStrings2(File fileFrom, File fileCompareTo, File fileTo) {
        BufferedReader readerFrom = null;
        BufferedReader readerCompareTo = null;
        BufferedWriter writer = null;
        ArrayList<String> matchStrings = new ArrayList<>();
        ArrayList<String> allStrings = new ArrayList<>();
        try {
            readerFrom = new BufferedReader(new InputStreamReader(new FileInputStream(fileFrom)));
            readerCompareTo = new BufferedReader(new InputStreamReader
                    (new FileInputStream(fileCompareTo)));
            writer = new BufferedWriter(new OutputStreamWriter(
                    (new FileOutputStream((fileTo)))));
            doSomething(readerFrom, readerCompareTo, writer, matchStrings, allStrings);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("file wasn't found");
        } finally {
            if (readerFrom != null) {
                try {
                    readerFrom.close();
                } catch (IOException ioEx) {
                    System.err.println("Exception during closing readerFrom resource");
                }
            }
            if (readerCompareTo != null) {
                try {
                    readerCompareTo.close();
                } catch (IOException ioEx) {
                    System.err.println("Exception during closing compareTo resource");
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ioEx) {
                    System.err.println("Exception during closing to resource");
                }
            }
        }
    }

    private static void doSomething(BufferedReader readerFrom,
                                    BufferedReader readerCompareTo,
                                    BufferedWriter writer,
                                    ArrayList<String> matchStrings,
                                    ArrayList<String> allStrings) {
        String line;
        try {
            while ((line = readerFrom.readLine()) != null) {
                allStrings.add(line);
            }
            while ((line = readerCompareTo.readLine()) != null) {
                matchStrings.add(line);
            }
            for (String resString : allStrings) {
                if (matchStrings.contains(resString)) {
                    writer.write(resString + "\n");
                }
            }
        } catch (IOException ioException) {
            System.err.println("IOException during operations with readerFrom," +
                    "readerCompareTo, resString");
        }
    }
}
