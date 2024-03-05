package util;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTimeUtils {
    private static final LocalDate startDate = LocalDate.of(2024, 4, 1).minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
    private static final LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

    // Method to check if dates overlap
    public static LocalDate getCurrentPeriod_StartDate() {
        return startDate;
    }

    public static LocalDate getCurrentPeriod_EndDate() {
        return endDate;
    }

    public static int getCurrentPeriod_Year() {
        return startDate.getYear();
    }

    public static int getCurrentPeriod_Month() {
        return startDate.getMonthValue();
    }

    public static boolean datesOverlap(LocalDate startDate1, LocalDate endDate1, LocalDate startDate2, LocalDate endDate2) {
        return !endDate1.isBefore(startDate2) && !startDate1.isAfter(endDate2);
    }

    public static LocalDate now() {
        return startDate;
    }
}
