package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {

    public static LocalDate getWeeklyPeriod_StartDate() {
        for (int i = 0; i < 7; i++) {
            LocalDate date = LocalDate.now().minusDays(i);
            if (date.getDayOfWeek().getValue() == 1) {
                return date;
            }
        }

        return LocalDate.now();
    }

    public static LocalDate getWeeklyPeriod_EndDate() {
        return getWeeklyPeriod_StartDate().plusDays(6);
    }

    public static LocalDate getSemiMonthlyPeriod_StartDate() {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        return (dayOfMonth <= 15) ? LocalDate.now().withDayOfMonth(1) : LocalDate.now().withDayOfMonth(16);
    }

    public static LocalDate getSemiMonthlyPeriod_EndDate() {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        LocalDate startDate = getSemiMonthlyPeriod_StartDate();
        return (dayOfMonth <= 15) ? startDate.plusDays(14) : startDate.withDayOfMonth(startDate.lengthOfMonth());
    }

    public static LocalDate getMonthlyPeriod_StartDate() {
        return LocalDate.now().withDayOfMonth(1);
    }

    public static LocalDate getMonthlyPeriod_EndDate() {
        return getMonthlyPeriod_StartDate().withDayOfMonth(getMonthlyPeriod_StartDate().lengthOfMonth());
    }

    public static LocalDate getAnnualPeriod_StartDate() {
        return LocalDate.now().withDayOfYear(1);
    }

    public static LocalDate getAnnualPeriod_EndDate() {
        return getAnnualPeriod_StartDate().withDayOfYear(getAnnualPeriod_StartDate().lengthOfYear());
    }

    public static LocalDate now() {
        return LocalDate.now();
    }

    public static LocalTime currentTime() {
        return LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public static boolean datesOverlap(LocalDate startDate1, LocalDate endDate1, LocalDate startDate2, LocalDate endDate2) {
        return !endDate1.isBefore(startDate2) && !startDate1.isAfter(endDate2);
    }

    public static LocalDate getPeriodStartDate(String period) {
        return switch (period) {
            case "Weekly" -> getWeeklyPeriod_StartDate();
            case "Semi-Monthly" -> getSemiMonthlyPeriod_StartDate();
            case "Monthly" -> getMonthlyPeriod_StartDate();
            case "Annual" -> getAnnualPeriod_StartDate();
            default -> throw new IllegalArgumentException("Invalid period: " + period);
        };
    }

    public static LocalDate getPeriodEndDate(String period) {
        return switch (period) {
            case "Weekly" -> getWeeklyPeriod_EndDate();
            case "Semi-Monthly" -> getSemiMonthlyPeriod_EndDate();
            case "Monthly" -> getMonthlyPeriod_EndDate();
            case "Annual" -> getAnnualPeriod_EndDate();
            default -> throw new IllegalArgumentException("Invalid period: " + period);
        };
    }
}
