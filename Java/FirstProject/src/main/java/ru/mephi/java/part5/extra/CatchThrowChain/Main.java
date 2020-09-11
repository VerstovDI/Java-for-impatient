package ru.mephi.java.part5.extra.CatchThrowChain;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //float res = simpleThrowExample(5, 0);

        //tryCatchExample();

        /*try {
            setBirthday("22.13.20005");
        } catch (InvalidBirthdayException ex) {
            // throw .... слой за слоем можно пробрасывать дальше
            System.err.println("Кривая дата, уходи");
            ex.printStackTrace();
        }*/

        try {
            suppressedExample("magickPath");
        } catch (IOException ex) {
            ex.getSuppressed();
        }
    }

    public static float simpleThrowExample(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider must be non-zero");
        } else {
            return a/b;
        }
        /*float c;
        try {
            c = a/b;
        } catch (ArithmeticException arithmeticEx) {
            System.err.println("Illegal division! (.../0)");
            System.err.println("Returned -1");
            c = -1;
            return c;
        }*/
    }

    public static void tryCatchExample() {
        List<String> list= Arrays.asList("String#1", "String#2", "String#3");

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(list.get(i));
            }
            catch (ArrayIndexOutOfBoundsException e) {
                //System.out.println(e.getMessage());
                System.err.println("Out of bounds");
            }
            finally {
                System.out.println("Continue...");
            }
        }
    }

    public static void setBirthday(String birthDate) throws InvalidBirthdayException {
        DateFormat formatter = new SimpleDateFormat();
        try {
            Date birthday = formatter.parse(birthDate);
        } catch (ParseException ex) {
            throw new InvalidBirthdayException("Date of birth is invalid", ex);
        }
    }

    public static void suppressedExample(String filePath) throws IOException {
        Throwable firstException = null;
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(filePath);
        } catch (IOException e) {
            firstException = e;
        } finally {
            try {
                fileIn.close();
            } catch (NullPointerException npe) {
                if (firstException != null) {
                    npe.addSuppressed(firstException);
                }
                throw npe;
            }
        }
    }
}
