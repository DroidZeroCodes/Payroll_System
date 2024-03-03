package interfaces;


import data.LeaveBalanceRecord;

public interface LeaveBalanceDataService {
    LeaveBalanceRecord getLeaveBalance_ByEmployeeID(int employeeID);

    void updateLeaveBalance(int employeeID, String leaveType, int newBalance);

    void addLeaveBalance(LeaveBalanceRecord leaveBalanceRecord);
}
