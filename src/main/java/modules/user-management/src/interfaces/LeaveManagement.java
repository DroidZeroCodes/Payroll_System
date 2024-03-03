package interfaces;

import exceptions.LeaveException;

import java.time.LocalDate;

public interface LeaveManagement {
    void submitLeaveRequest(String leaveType, LocalDate startDate, LocalDate endDate, String reasons) throws LeaveException;
}
