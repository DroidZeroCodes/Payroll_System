package util;

import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

/**
 * Provides utility methods for generating unique IDs.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link ID_Generator#generatePayrollID(int)}</li>
 *     <li>{@link ID_Generator#generatePayrollID(int, YearMonth)}</li>
 *     <li>{@link ID_Generator#generateAttendanceID(int)}</li>
 *     <li>{@link ID_Generator#generateLeaveID(int)}</li>
 * </ul>
 */
@SuppressWarnings("unused")
public class ID_Generator {

    /**
     * Generates a unique payroll ID for the specified employee and current month.
     *
     * @param employeeID the ID of the employee
     * @return a unique payroll ID
     */
    public static String generatePayrollID(int employeeID) {
        String month = String.format("%02d", DateTimeUtils.now().getMonthValue());
        return DateTimeUtils.now().getYear() + month + "-" + employeeID;
    }

    /**
     * Generates a unique payroll ID for the specified employee and year month.
     *
     * @param employeeID the ID of the employee
     * @param yearMonth  the year and month
     * @return a unique payroll ID
     */
    public static String generatePayrollID(int employeeID, YearMonth yearMonth) {
        String month = String.format("%02d", yearMonth.getMonthValue());
        return yearMonth.getYear() + month + "-" + employeeID;
    }

    /**
     * Generates a unique attendance ID for the specified employee and current date.
     *
     * @param employeeID the ID of the employee
     * @return a unique attendance ID
     */
    public static String generateAttendanceID(int employeeID) {
        String month = String.format("%02d", DateTimeUtils.now().getMonthValue());
        String day = String.format("%02d", DateTimeUtils.now().getDayOfMonth());
        return DateTimeUtils.now().getYear() + month + "-" + day + "-" + employeeID;
    }

    /**
     * Generates a unique leave ID for the specified employee and current date and time.
     *
     * @param employeeID the ID of the employee
     * @return a unique leave ID
     */
    public static String generateLeaveID(int employeeID) {
        return DateTimeUtils.now() + "-" + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + "-" + employeeID;
    }
}
