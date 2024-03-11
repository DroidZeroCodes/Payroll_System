package util;

import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class ID_Generator {
    public static String generatePayrollID(int employeeID) {
        String month = String.format("%02d", DateTimeUtils.now().getMonthValue());
        return DateTimeUtils.now().getYear() + month + "-" + employeeID;
    }

    public static String generatePayrollID(int employeeID, YearMonth yearMonth) {
        String month = String.format("%02d", yearMonth.getMonthValue());
        return yearMonth.getYear() + month + "-" + employeeID;
    }

    public static String generateAttendanceID(int employeeID) {
        String month = String.format("%02d", DateTimeUtils.now().getMonthValue());
        String day = String.format("%02d", DateTimeUtils.now().getDayOfMonth());
        return DateTimeUtils.now().getYear() + month + "-" + day + "-" + employeeID;
    }

    public static String generateLeaveID(int employeeID) {
        return DateTimeUtils.now() + "-" + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + "-" + employeeID;
    }
}
