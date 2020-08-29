package ru.mephi.java.part2.Again3rdSeptember;

import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.lang.System.out;
import static java.lang.Math.abs;

public class CalendarBuilder {
    private final static int DAYS_IN_WEEK = 7;
    private final static int END_OF_THE_WORLD = 2029;
    private final static int START_OF_THE_WORLD = 1971;
    private final static String[] daysOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

    public void printCalendar(int year, int month, int mode) {
        boolean checkRes = checkInput(year, month, mode);
        if (!checkRes) {
            return;
        }
        LocalDate date = LocalDate.of(year, month, 1);
        out.println("  |Calendar for " + date + "|");
        printDaysMode(mode);
        DayOfWeek weekday = date.getDayOfWeek();
        int weekdayVal = weekday.getValue();
        int shift = shiftCalendar(weekdayVal, mode);
        int currDayPos = 0;
        for (int j = 0; j < shift - 1; j++, currDayPos++) {
            out.print("    ");
        }
        while (date.getMonthValue() == month) {
            out.printf("%4d", date.getDayOfMonth());
            if (currDayPos < DAYS_IN_WEEK - 1) {
                currDayPos++;
            } else {
                out.println();
                currDayPos = 0;
            }
            date = date.plusDays(1);
        }
        if (currDayPos != 0) {
            out.println();
        }
    }

    private boolean checkInput(int yearInput, int monthInput, int modeInput) {
        boolean checkFl = true;
        if ((yearInput < START_OF_THE_WORLD) || (yearInput > END_OF_THE_WORLD)) {
            out.println("[LOG]: Unsupported year!");
            checkFl = false;
        } else if ((monthInput < 1) || (monthInput > 12)) {
            out.println("[LOG]: Invalid month!");
            checkFl = false;
        } else if (modeInput < 0) {
            out.println("[LOG]: Invalid mode!");
            checkFl = false;
        }
        return checkFl;
    }

    private int shiftCalendar(int weekdayVal, int mode) {
        int shift = weekdayVal - mode;
        return shift > 0 ? shift : DAYS_IN_WEEK - abs(shift % DAYS_IN_WEEK);
    }

    private void printDaysMode(int shift) {
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            out.format(" %s", daysOfWeek[abs(i + shift) % DAYS_IN_WEEK]);
        }
        out.println();
    }
}
