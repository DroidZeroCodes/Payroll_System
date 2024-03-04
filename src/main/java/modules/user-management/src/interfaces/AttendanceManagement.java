package interfaces;

import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;

public interface AttendanceManagement {
    void clockIn() throws AttendanceException, EmployeeRecordsException;
    void clockOut() throws AttendanceException;
}
