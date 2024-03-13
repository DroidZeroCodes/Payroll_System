package data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents an attendance record.
 */
public record AttendanceRecord(
        String attendanceID,
        LocalDate date,
        int employeeID,
        String lastName,
        String firstName,
        LocalTime timeIn,
        LocalTime timeOut,
        LocalTime hoursWorked,
        LocalTime overTimeHours
) {
    /**
     * Returns a new AttendanceRecord with the specified time in.
     *
     * @param timeIn the time in
     * @return a new AttendanceRecord with the specified time in
     */
    public AttendanceRecord withTimeIn(LocalTime timeIn) {
        return new AttendanceRecord(
                this.attendanceID,
                this.date,
                this.employeeID,
                this.lastName,
                this.firstName,
                timeIn,
                this.timeOut,
                this.hoursWorked,
                this.overTimeHours
        );
    }

    /**
     * Returns a new AttendanceRecord with the specified time out.
     *
     * @param timeOut the time out
     * @return a new AttendanceRecord with the specified time out
     */
    public AttendanceRecord withTimeOut(LocalTime timeOut) {
        return new AttendanceRecord(
                this.attendanceID,
                this.date,
                this.employeeID,
                this.lastName,
                this.firstName,
                this.timeIn,
                timeOut,
                this.hoursWorked,
                this.overTimeHours
        );
    }

    /**
     * Returns a new AttendanceRecord with the specified hours worked.
     *
     * @param hoursWorked the hours worked
     * @return a new AttendanceRecord with the specified hours worked
     */
    public AttendanceRecord withHoursWorked(LocalTime hoursWorked) {
        return new AttendanceRecord(
                this.attendanceID,
                this.date,
                this.employeeID,
                this.lastName,
                this.firstName,
                this.timeIn,
                this.timeOut,
                hoursWorked,
                this.overTimeHours
        );
    }

    /**
     * Returns a new AttendanceRecord with the specified overtime hours.
     *
     * @param overTimeHours the overtime hours
     * @return a new AttendanceRecord with the specified overtime hours
     */
    public AttendanceRecord withOverTimeHours(LocalTime overTimeHours) {
        return new AttendanceRecord(
                this.attendanceID,
                this.date,
                this.employeeID,
                this.lastName,
                this.firstName,
                this.timeIn,
                this.timeOut,
                this.hoursWorked,
                overTimeHours
        );
    }

    /**
     * Converts the AttendanceRecord to an array of strings.
     *
     * @return an array of strings representing the AttendanceRecord
     */
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
