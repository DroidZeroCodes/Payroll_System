package interfaces;

import data.LeaveBalanceRecord;
import data.LeaveRecord;
import exceptions.LeaveException;

import java.util.List;

public interface LeaveManagement {
    void approveLeave(String leaveID);

    void rejectLeave(String leaveID, int employeeID, String leaveType, int duration);

    LeaveRecord getLeaveRecord(String leaveID);

    List<LeaveRecord> getLeaveRecord_List(int employeeID);

    List<LeaveRecord> getLeaveRecord_List();

    //Leave Balance
    LeaveBalanceRecord getLeaveBalanceRecord(int employeeID);

    int getLeaveBalance_OfType(int leaveBalance, String leaveTypeBalanceField);

    List<LeaveRecord> getAllLeaveRecords();

    void addLeaveRecord(LeaveRecord newRecord, LeaveBalanceRecord leaveBalance) throws LeaveException;

    int getLeaveBalance_OfType(LeaveBalanceRecord leaveBalance, String leaveType);

    void updateLeaveBalance(LeaveBalanceRecord leaveBalanceRecord, String leaveType, int newBalance);
}
