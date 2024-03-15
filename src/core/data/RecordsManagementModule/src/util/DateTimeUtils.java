package util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;

/**
 * Utility class for handling date and time operations.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link DateTimeUtils#getWeekNumber(LocalDate)}</li>
 *     <li>{@link DateTimeUtils#getWeeklyPeriod_StartDate(LocalDate, int)}</li>
 *     <li>{@link DateTimeUtils#getWeeklyPeriod_EndDate(LocalDate, int)}</li>
 *     <li>{@link DateTimeUtils#getSemiMonthlyPeriod_StartDate(LocalDate, int)}</li>
 *     <li>{@link DateTimeUtils#getSemiMonthlyPeriod_EndDate(LocalDate, int)}</li>
 *     <li>{@link DateTimeUtils#getMonthlyPeriod_StartDate(LocalDate)}</li>
 *     <li>{@link DateTimeUtils#getMonthlyPeriod_EndDate(LocalDate)}</li>
 *     <li>{@link DateTimeUtils#getAnnualPeriod_StartDate(LocalDate)}</li>
 *     <li>{@link DateTimeUtils#getAnnualPeriod_EndDate(LocalDate)}</li>
 *     <li>{@link DateTimeUtils#now()}</li>
 *     <li>{@link DateTimeUtils#currentTime()}</li>
 *     <li>{@link DateTimeUtils#getPeriodStartDate_Current(String)}</li>
 *     <li>{@link DateTimeUtils#getPeriodStartDate_WithMonth(String, int)}</li>
 *     <li>{@link DateTimeUtils#getPeriodEndDate_Current(String)}</li>
 *     <li>{@link DateTimeUtils#getPeriodEndDate_WithMonth(String, int)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public class DateTimeUtils {

    /**
     * Retrieves the week number of the specified date.
     *
     * @param date the date
     * @return the week number of the specified date
     */
    public static int getWeekNumber(LocalDate date) {
        WeekFields weekFields = WeekFields.ISO;
        return date.get(weekFields.weekOfMonth());
    }

    /**
     * Retrieves the semi-month number of the specified date.
     *
     * @param date the date
     * @return the
     */
    public static int getSemiMonthNo(LocalDate date) {
        WeekFields weekFields = WeekFields.ISO;

        int week = getWeekNumber(date);

        return switch (week) {
            case 1, 2 -> 1;
            case 3, 4 -> 2;
            default -> throw new IllegalArgumentException("Invalid week number: " + week);
        };
    }

    /**
     * Retrieves the start date (Monday) of the specified week number.
     *
     * @param date   the date
     * @param weekNo the week number
     * @return the start date (Monday) of the specified week number
     */
    public static LocalDate getWeeklyPeriod_StartDate(LocalDate date, int weekNo) {
        // Set the date to the first day of the month and then move to Monday
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate firstDayOfWeek = firstDayOfMonth.with(DayOfWeek.MONDAY);

        // Move to the first Monday of the month
        if (!firstDayOfWeek.getMonth().equals(date.getMonth())) {
            firstDayOfWeek = firstDayOfWeek.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }

        // Move to the desired week number
        return firstDayOfWeek.plusWeeks(weekNo - 1);
    }

    /**
     * Retrieves the end date of the current week.
     *
     * @param date the date
     * @param weekNo the week number
     *
     * @return the end date of the current week
     */
    public static LocalDate getWeeklyPeriod_EndDate(LocalDate date, int weekNo) {
        return getWeeklyPeriod_StartDate(date, weekNo).plusDays(6);
    }

    /**
     * Retrieves the start date of the current semi-monthly pay period.
     * @param date the date
     * @return the start date of the current semi-monthly pay period
     */
    public static LocalDate getSemiMonthlyPeriod_StartDate(LocalDate date, int semiMonthNo) {
        if (semiMonthNo == 1) {
            return getWeeklyPeriod_StartDate(date,1);
        } else if (semiMonthNo == 2) {
            return getWeeklyPeriod_StartDate(date,3);
        }
        throw new IllegalArgumentException("Invalid semi-month number: " + semiMonthNo);
    }

    /**
     * Retrieves the end date of the current semi-monthly pay period.
     * @param date the date
     * @return the end date of the current semi-monthly pay period
     */
    public static LocalDate getSemiMonthlyPeriod_EndDate(LocalDate date, int semiMonthNo) {
        int dayOfMonth = date.getDayOfMonth();
        LocalDate startDate = getSemiMonthlyPeriod_StartDate(date, semiMonthNo);
        return (dayOfMonth <= 15) ? startDate.plusDays(14) : startDate.withDayOfMonth(startDate.lengthOfMonth());
    }

    /**
     * Retrieves the start date of the current month.
     * @param date the date
     * @return the start date of the current month
     */
    public static LocalDate getMonthlyPeriod_StartDate(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     * Retrieves the end date of the current month.
     * @param date the date
     * @return the end date of the current month
     */
    public static LocalDate getMonthlyPeriod_EndDate(LocalDate date) {
        return getMonthlyPeriod_StartDate(date).withDayOfMonth(getMonthlyPeriod_StartDate(date).lengthOfMonth());
    }

    /**
     * Retrieves the start date of the current year.
     * @param date the date
     * @return the start date of the current year
     */
    public static LocalDate getAnnualPeriod_StartDate(LocalDate date) {
        return date.withDayOfYear(1);
    }

    /**
     * Retrieves the end date of the current year.
     * @param date the date
     * @return the end date of the current year
     */
    public static LocalDate getAnnualPeriod_EndDate(LocalDate date) {
        return getAnnualPeriod_StartDate(date).withDayOfYear(getAnnualPeriod_StartDate(date).lengthOfYear());
    }

    /**
     * Retrieves the current date.
     *
     * @return the current date
     */
    public static LocalDate now() {
        return LocalDate.now();
    }

    /**
     * Retrieves the current time truncated to minutes.
     *
     * @return the current time truncated to minutes
     */
    public static LocalTime currentTime() {
        return LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    /**
     * Retrieves the start date of the specified period.
     *
     * @param period the period for which to retrieve the start date
     * @return the start date of the specified period
     * @throws IllegalArgumentException if the period is invalid
     */
    public static LocalDate getPeriodStartDate_Current(String period) {
        LocalDate date = DateTimeUtils.now();
        return switch (period) {
            case "Weekly" -> getWeeklyPeriod_StartDate(date, getWeekNumber(date));
            case "Semi-Monthly" -> getSemiMonthlyPeriod_StartDate(date, getSemiMonthNo(date));
            case "Monthly" -> getMonthlyPeriod_StartDate(date);
            case "Annual" -> getAnnualPeriod_StartDate(date);
            default -> throw new IllegalArgumentException("Invalid period: " + period);
        };
    }

    /**
     * Retrieves the start date of the specified period.
     *
     * @param period the period for which to retrieve the start date
     * @param month the month for which to retrieve the start date
     * @return the start date of the specified period
     * @throws IllegalArgumentException if the period is invalid
     */
    public static LocalDate getPeriodStartDate_WithMonth(String period, int month) {
        LocalDate date = LocalDate.of(DateTimeUtils.now().getYear(), month, 1);
        return switch (period) {
            case "Week 1" -> getWeeklyPeriod_StartDate(date,1);
            case "Week 2" -> getWeeklyPeriod_StartDate(date,2);
            case "Week 3" -> getWeeklyPeriod_StartDate( date,3);
            case "Week 4" -> getWeeklyPeriod_StartDate(date,4);
            case "Semi-Monthly 1" -> getSemiMonthlyPeriod_StartDate(date, 1);
            case "Semi-Monthly 2" -> getSemiMonthlyPeriod_StartDate(date,  2);
            case "Monthly" -> getMonthlyPeriod_StartDate(date);
            default -> throw new IllegalArgumentException("Invalid period: " + period);
        };
    }

    /**
     * Retrieves the end date of the specified period.
     *
     * @param period the period for which to retrieve the end date
     * @return the end date of the specified period
     * @throws IllegalArgumentException if the period is invalid
     */
    public static LocalDate getPeriodEndDate_Current(String period) {
        LocalDate date = DateTimeUtils.now();
        return switch (period) {
            case "Weekly" -> getWeeklyPeriod_EndDate(date, getWeekNumber(date));
            case "Semi-Monthly" -> getSemiMonthlyPeriod_EndDate(date, getSemiMonthNo(date));
            case "Monthly" -> getMonthlyPeriod_EndDate(date);
            case "Annual" -> getAnnualPeriod_EndDate(date);
            default -> throw new IllegalArgumentException("Invalid period: " + period);
        };
    }

    /**
     * Retrieves the end date of the specified period.
     *
     * @param period the period for which to retrieve the end date
     * @param month the month for which to retrieve the end date
     * @return the end date of the specified period
     * @throws IllegalArgumentException if the period is invalid
     */
    public static LocalDate getPeriodEndDate_WithMonth(String period, int month) {
        LocalDate date = LocalDate.of(DateTimeUtils.now().getYear(), month, 1);
        return switch (period) {
            case "Week 1" -> getWeeklyPeriod_EndDate(date, 1);
            case "Week 2" -> getWeeklyPeriod_EndDate(date, 2);
            case "Week 3" -> getWeeklyPeriod_EndDate(date, 3);
            case "Week 4" -> getWeeklyPeriod_EndDate(date, 4);
            case "Semi-Monthly 1" -> getSemiMonthlyPeriod_EndDate(date, 1);
            case "Semi-Monthly 2" -> getSemiMonthlyPeriod_EndDate(date, 2);
            case "Monthly" -> getMonthlyPeriod_EndDate(date);
            default -> throw new IllegalArgumentException("Invalid period: " + period);
        };
    }
}