package interfaces;


import data.LeaveBalanceRecord;

public interface LeaveBalanceDataService {
    LeaveBalanceRecord getLeaveBalance_ByEmployeeID(int employeeID);

    void updateLeaveBalance(LeaveBalanceRecord updatedRecord);

    void addLeaveBalance(LeaveBalanceRecord leaveBalanceRecord);
}
