package ru.mephi.java.part2.task01;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Task01 {
    private final static int DAY_TO_START_VALUE = 3;
    private static int shift(int weekdayVal) {
        return weekdayVal - DAY_TO_START_VALUE;
    }

    public static void main(String[] args) {
        //LocalDate date = LocalDate.now().withDayOfMonth(1);
        LocalDate date = LocalDate.of(2020, 3, 1).withDayOfMonth(1);
        int month;
        if (args.length >= 2) {
            month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            date = LocalDate.of(year, month, 1);
        } else {
            month = date.getMonthValue();
        }

        // System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
        System.out.println(" Wed Thu Fri Sat Sun Mon Tue");
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, ... 7 = Sunday
        int shiftVal = shift(value);
        for (int i = 1; i < value - shiftVal; i++)
            System.out.print("    ");
        shiftVal = 7 - DAY_TO_START_VALUE;
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
            shiftVal--;
            if (shiftVal < 0) {
                System.out.println();
                shiftVal = 6;
            }
        }
        if (shiftVal != 6) {
            System.out.println();
        }
    }
}
