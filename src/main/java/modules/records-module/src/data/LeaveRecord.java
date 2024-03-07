package data;

import java.time.LocalDate;

public record LeaveRecord(
        String leaveID,
        int employeeID,
        LocalDate requestDate,
        String leaveType,
        LocalDate startDate,
        LocalDate endDate,
        int totalDays,
        String leaveReason,
        String status
) {
    public String[] toArray() {
        return new String[]{
                leaveID,
                String.valueOf(employeeID),
                String.valueOf(requestDate),
                leaveType,
                String.valueOf(startDate),
                String.valueOf(endDate),
                String.valueOf(totalDays),
                leaveReason,
                String.valueOf(status)
        };
    }

    public LeaveRecord withStatus(LEAVE_STATUS leaveStatus) {
        return new LeaveRecord(
                leaveID,
                employeeID,
                requestDate,
                leaveType,
                startDate,
                endDate,
                totalDays,
                leaveReason,
                String.valueOf(leaveStatus) //leaveStatus
        );
    }


    public enum LEAVE_STATUS {
        PENDING,
        APPROVED,
        REJECTED
    }
}
