package interfaces;


import data.LeaveBalanceRecord;

@SuppressWarnings("unused")
public interface LeaveBalanceDataService {
    LeaveBalanceRecord getLeaveBalance_ByEmployeeID(int employeeID);

    void updateLeaveBalance(LeaveBalanceRecord updatedRecord);

    void addLeaveBalance(LeaveBalanceRecord leaveBalanceRecord);
}
