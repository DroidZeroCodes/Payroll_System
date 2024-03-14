package calculator;

import records.AttendanceRecord;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Utility class for date and time calculations.
 * Provides methods for calculating total hours worked, total overtime hours, regular hours worked,
 * adjusted time in, total number of days, months, and years between two dates, and calculating overtime hours.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link DateTimeCalculator#totalHoursWorked(List)}</li>
 *     <li>{@link DateTimeCalculator#totalOvertimeHours(List)}</li>
 *     <li>{@link DateTimeCalculator#regularHoursWorked(LocalTime, LocalTime)}</li>
 *     <li>{@link DateTimeCalculator#adjustedTimeIn(LocalTime)}</li>
 *     <li>{@link DateTimeCalculator#totalDays(List)}</li>
 *     <li>{@link DateTimeCalculator#totalDays(LocalDate, LocalDate)}</li>
 *     <li>{@link DateTimeCalculator#totalMonths(LocalDate, LocalDate)}</li>
 *     <li>{@link DateTimeCalculator#totalYears(LocalDate, LocalDate)}</li>
 *     <li>{@link DateTimeCalculator#overtimeHours(LocalTime, LocalTime)}</li>
 * </ul>
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})

public class DateTimeCalculator {
    // Constants
    private static final LocalTime REGULAR_HOURS_START = LocalTime.of(8, 0);
    private static final LocalTime END_OF_REGULAR_HOURS = LocalTime.of(17, 0);
    private static final LocalTime GRACE_PERIOD = LocalTime.of(8, 10);

    /**
     * Calculates the total hours worked based on a list of attendance records.
     *
     * @param attendanceRecordList the list of attendance records
     * @return the total hours worked
     */
    public static double totalHoursWorked(List<AttendanceRecord> attendanceRecordList) {
        double totalHours = 0;
        for (AttendanceRecord record : attendanceRecordList) {
            LocalTime hoursWorked = record.hoursWorked();

            System.out.println("Date :" + record.date());
            int hours = adjustedTimeIn(hoursWorked).getHour();
            int minutes = hoursWorked.getMinute();

            totalHours = totalHours + (double) hours + (double) minutes / 60;
        }

        return totalHours;
    }

    /**
     * Calculates the total overtime hours based on a list of attendance records.
     *
     * @param attendanceRecordList the list of attendance records
     * @return the total overtime hours
     */
    public static double totalOvertimeHours(List<AttendanceRecord> attendanceRecordList) {
        double totalOvertimeHours = 0;
        for (AttendanceRecord record : attendanceRecordList) {
            LocalTime overtimeHours = record.overTimeHours();

            int hours = overtimeHours.getHour();
            int minutes = overtimeHours.getMinute();
            totalOvertimeHours = totalOvertimeHours + (double) hours + (double) minutes / 60;
        }

        return totalOvertimeHours;
    }

    /**
     * Calculates the regular hours worked between two times.
     *
     * @param timeIn  the time in
     * @param timeOut the time out
     * @return the regular hours worked
     */
    public static LocalTime regularHoursWorked(LocalTime timeIn, LocalTime timeOut) {
        Duration duration = Duration.between(timeIn, timeOut);
        if (duration.isNegative()) {
            duration = duration.plus(Duration.ofDays(1));
        }
        return LocalTime.of(duration.toHoursPart(), duration.toMinutesPart());
    }

    /**
     * Adjusts the time in if it's before or equal to the grace period.
     *
     * @param timeIn the time in
     * @return the adjusted time in
     */
    public static LocalTime adjustedTimeIn(LocalTime timeIn) {
        if (timeIn.isBefore(GRACE_PERIOD) || timeIn == GRACE_PERIOD) {
            timeIn = REGULAR_HOURS_START;
        }

        return timeIn;
    }

    /**
     * Calculates the total number of days from a list of attendance records.
     *
     * @param attendanceRecordList the list of attendance records
     * @return the total number of days
     */
    public static int totalDays(List<AttendanceRecord> attendanceRecordList) {
        return attendanceRecordList.size();
    }

    /**
     * Calculates the total number of days between two dates.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the total number of days
     */
    public static int totalDays(LocalDate startDate, LocalDate endDate) {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    /**
     * Calculates the total number of months between two dates.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the total number of months
     */
    public static int totalMonths(LocalDate startDate, LocalDate endDate) {
        return endDate.getMonthValue() - startDate.getMonthValue();
    }

    /**
     * Calculates the total number of years between two dates.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the total number of years
     */
    public static int totalYears(LocalDate startDate, LocalDate endDate) {
        return endDate.getYear() - startDate.getYear();
    }

    /**
     * Calculate overtime hours based on the time in and time out.
     *
     * @param timeIn  the starting time
     * @param timeOut the ending time
     * @return the total overtime hours
     */
    public static LocalTime overtimeHours(LocalTime timeIn, LocalTime timeOut) {
        LocalTime totalHours = regularHoursWorked(timeIn, timeOut);
        return totalHours.isAfter(END_OF_REGULAR_HOURS) ? totalHours.minusHours(END_OF_REGULAR_HOURS.getHour()) : LocalTime.of(0, 0);
    }
}
