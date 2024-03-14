package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Utility class for handling date and time operations.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link DateTimeUtils#getWeeklyPeriod_StartDate()}</li>
 *     <li>{@link DateTimeUtils#getWeeklyPeriod_EndDate()}</li>
 *     <li>{@link DateTimeUtils#getSemiMonthlyPeriod_StartDate()}</li>
 *     <li>{@link DateTimeUtils#getSemiMonthlyPeriod_EndDate()}</li>
 *     <li>{@link DateTimeUtils#getMonthlyPeriod_StartDate()}</li>
 *     <li>{@link DateTimeUtils#getMonthlyPeriod_EndDate()}</li>
 *     <li>{@link DateTimeUtils#getAnnualPeriod_StartDate()}</li>
 *     <li>{@link DateTimeUtils#getAnnualPeriod_EndDate()}</li>
 *     <li>{@link DateTimeUtils#now()}</li>
 *     <li>{@link DateTimeUtils#currentTime()}</li>
 *     <li>{@link DateTimeUtils#getPeriodStartDate(String)}</li>
 *     <li>{@link DateTimeUtils#getPeriodEndDate(String)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public class DateTimeUtils {

    /**
     * Retrieves the start date of the current week.
     *
     * @return the start date of the current week
     */
    public static LocalDate getWeeklyPeriod_StartDate() {
        for (int i = 0; i < 7; i++) {
            LocalDate date = LocalDate.now().minusDays(i);
            if (date.getDayOfWeek().getValue() == 1) {
                return date;
            }
        }
        return LocalDate.now();
    }

    /**
     * Retrieves the end date of the current week.
     *
     * @return the end date of the current week
     */
    public static LocalDate getWeeklyPeriod_EndDate() {
        return getWeeklyPeriod_StartDate().plusDays(6);
    }

    /**
     * Retrieves the start date of the current semi-monthly pay period.
     *
     * @return the start date of the current semi-monthly pay period
     */
    public static LocalDate getSemiMonthlyPeriod_StartDate() {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        return (dayOfMonth <= 15) ? LocalDate.now().withDayOfMonth(1) : LocalDate.now().withDayOfMonth(16);
    }

    /**
     * Retrieves the end date of the current semi-monthly pay period.
     *
     * @return the end date of the current semi-monthly pay period
     */
    public static LocalDate getSemiMonthlyPeriod_EndDate() {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        LocalDate startDate = getSemiMonthlyPeriod_StartDate();
        return (dayOfMonth <= 15) ? startDate.plusDays(14) : startDate.withDayOfMonth(startDate.lengthOfMonth());
    }

    /**
     * Retrieves the start date of the current month.
     *
     * @return the start date of the current month
     */
    public static LocalDate getMonthlyPeriod_StartDate() {
        return LocalDate.now().withDayOfMonth(1);
    }

    /**
     * Retrieves the end date of the current month.
     *
     * @return the end date of the current month
     */
    public static LocalDate getMonthlyPeriod_EndDate() {
        return getMonthlyPeriod_StartDate().withDayOfMonth(getMonthlyPeriod_StartDate().lengthOfMonth());
    }

    /**
     * Retrieves the start date of the current year.
     *
     * @return the start date of the current year
     */
    public static LocalDate getAnnualPeriod_StartDate() {
        return LocalDate.now().withDayOfYear(1);
    }

    /**
     * Retrieves the end date of the current year.
     *
     * @return the end date of the current year
     */
    public static LocalDate getAnnualPeriod_EndDate() {
        return getAnnualPeriod_StartDate().withDayOfYear(getAnnualPeriod_StartDate().lengthOfYear());
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
    public static LocalDate getPeriodStartDate(String period) {
        return switch (period) {
            case "Weekly" -> getWeeklyPeriod_StartDate();
            case "Semi-Monthly" -> getSemiMonthlyPeriod_StartDate();
            case "Monthly" -> getMonthlyPeriod_StartDate();
            case "Annual" -> getAnnualPeriod_StartDate();
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