package util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

public class TimeUtils {
    private static final LocalDate startDate = LocalDate.of(2022, 3, 1).minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
    private static final LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

    // Method to check if dates overlap
    public static LocalDate getCurrentPeriod_StartDate() {
        return startDate;
    }

    public static LocalDate getCurrentPeriod_EndDate() {
        return endDate;
    }

    public static Year getCurrentPeriod_Year() {
        return Year.from(startDate);
    }

    public static int getCurrentPeriod_Month() {
        return Month.from(startDate).getValue();
    }

    public static boolean datesOverlap(LocalDate startDate1, LocalDate endDate1, LocalDate startDate2, LocalDate endDate2) {
        return !endDate1.isBefore(startDate2) && !startDate1.isAfter(endDate2);
    }
}
