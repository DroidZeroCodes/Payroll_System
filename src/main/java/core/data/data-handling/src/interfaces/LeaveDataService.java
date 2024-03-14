package interfaces;


import data.LeaveRecord;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
public interface LeaveDataService {
    LeaveRecord getLeaveByLeaveID(String leaveID);

    List<LeaveRecord> getLeaveRecords_ByEmployeeID(int employeeID);

    List<LeaveRecord> getLeaveRecordsByDate(LocalDate requestDate);

    List<LeaveRecord> allLeaveRecords();

    void addLeaveRecord(LeaveRecord leaveRecord);

    List<LeaveRecord> getAllLeaveRecords();

    void updateLeaveRecord(LeaveRecord leaveRecord);
}
