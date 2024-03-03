package interfaces;

import java.time.YearMonth;

public interface EmployeeActions {
    void displayProfile();
    void displayAttendanceRecord();

    void displayLeaveBalance();

    void displayLeaveHistory();

    void displayPayslip(YearMonth yearMonth);
}
