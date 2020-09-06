package ru.mephi.java.part5.task05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task05 {
    public String method1(String filenameFrom, String filenameTo) throws IOException {
        StringBuilder resultString = new StringBuilder();
        try (Scanner in = new Scanner(new File(filenameFrom));
             PrintWriter out = new PrintWriter(filenameTo)) {
            while (in.hasNext()) {
                resultString.append(in.next().toLowerCase()).append(" ");
            }
            out.print(resultString.toString().trim());
        }
        return resultString.toString().trim();
    }

    public String method2(String filenameFrom, String filenameTo) {
        StringBuilder resultString = new StringBuilder();
        Scanner in = null;
        File file;
        PrintWriter printWriterOut = null;
        try {
            file = new File(filenameFrom);
            in = new Scanner(file);
            printWriterOut = new PrintWriter(filenameTo);
            while (in.hasNext()) {
                resultString.append(in.next().toLowerCase()).append(" ");
            }
            printWriterOut.print(resultString.toString().trim());
        } catch (NullPointerException npEx) {
            System.err.println(filenameFrom + " caused because of null pathname");
        } catch (FileNotFoundException fileNotFoundEx) {
            System.err.println("File " + filenameFrom + " wasn't found");
        } catch (SecurityException securityEx) {
            System.err.println("Do not have necessary access to file" + filenameTo);
        } catch (IllegalStateException illegalStateEx) {
            System.err.println("Scanner is closed, data can't be written");
        } finally {
            // First close last
            if (in != null) {
                in.close();
            }
            if (printWriterOut != null) {
                printWriterOut.close();
            }
        }
        return resultString.toString().trim();
    }
}
