package interfaces;

import exceptions.PayrollException;

import java.time.YearMonth;

public interface EmployeeActions {
    void displayProfile();
    void displayAttendanceRecord();

    void displayLeaveBalance();

    void displayLeaveHistory();

    void displayPayslip(YearMonth yearMonth) throws PayrollException;
}
