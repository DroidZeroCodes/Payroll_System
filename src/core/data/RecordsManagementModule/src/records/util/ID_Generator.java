package records.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Utility class for generating unique IDs.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link ID_Generator#generatePayrollID(int, String)}</li>
 *     <li>{@link ID_Generator#generatePayrollID_WithMonth(int, int, String)}</li>
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
    public static String generatePayrollID(int employeeID, String payrollPeriod) {
        LocalDate start = DateTimeUtils.getPeriodStartDate_Current(payrollPeriod);
        LocalDate end = DateTimeUtils.getPeriodEndDate_Current(payrollPeriod);
        return start + "-" + end.getDayOfMonth() + "-" + employeeID;
    }

    /**
     * Generates a unique payroll ID for the specified employee and period.
     *
     * @param employeeID the ID of the employee
     * @param month      the month for which the ID is generated
     * @param payrollPeriod  the period for which the ID is generated
     * @return a unique payroll ID
     */
    public static String generatePayrollID_WithMonth(int employeeID, int month, String payrollPeriod) {
        LocalDate start = DateTimeUtils.getPeriodStartDate_WithMonth(payrollPeriod, month);
        LocalDate end = DateTimeUtils.getPeriodEndDate_WithMonth(payrollPeriod, month);
        return start + "-" + end.getDayOfMonth() + "-" + employeeID;
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
