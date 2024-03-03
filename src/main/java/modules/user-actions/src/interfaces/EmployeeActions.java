package interfaces;

import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import exceptions.PayrollException;

import java.time.YearMonth;

public interface EmployeeActions {
    void displayProfile() throws EmployeeRecordsException;
    void displayAttendanceRecord() throws AttendanceException;

    void displayLeaveBalance() throws LeaveException;

    void displayLeaveHistory() throws LeaveException;

    void displayPayslip(YearMonth yearMonth) throws PayrollException;
}
