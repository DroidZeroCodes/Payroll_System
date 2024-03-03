package data;

import java.time.LocalDate;
import java.time.LocalTime;
public record AttendanceRecord(
        String attendanceID,
        LocalDate date,
        int employeeID,
        String lastName,
        String firstName,
        LocalTime timeIn,
        LocalTime timeOut,
        double hoursWorked,
        double overTimeHours
) {
    public String[] toArray() {
        return new String[]{
                attendanceID,
                String.valueOf(date),
                String.valueOf(employeeID),
                lastName,
                firstName,
                String.valueOf(timeIn),
                String.valueOf(timeOut),
                String.valueOf(hoursWorked),
                String.valueOf(overTimeHours)
        };
    }
}
