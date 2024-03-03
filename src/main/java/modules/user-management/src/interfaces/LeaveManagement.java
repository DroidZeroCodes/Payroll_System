package interfaces;

import data.LeaveRecord;
import exceptions.LeaveException;

public interface LeaveManagement {
    void submitLeaveRequest(LeaveRecord newLeave) throws LeaveException;
}
