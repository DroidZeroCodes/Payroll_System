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
        LocalTime hoursWorked,
        LocalTime overTimeHours
) {
    
    public AttendanceRecord withTimeIn(LocalTime timeIn) {
        return new AttendanceRecord(
                this.attendanceID,
                this.date,
                this.employeeID,
                this.lastName,
                this.firstName,
                timeIn,
                timeOut,
                this.hoursWorked,
                this.overTimeHours
        ) ;
    }
    public AttendanceRecord withTimeOut(LocalTime timeOut) {
        return new AttendanceRecord(
                this.attendanceID,
                this.date,
                this.employeeID,
                this.lastName,
                this.firstName,
                timeIn,
                timeOut,
                this.hoursWorked,
                this.overTimeHours
        );
    }

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
