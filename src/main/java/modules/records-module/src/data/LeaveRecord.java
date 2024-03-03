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
    public Object[] toArray() {
        return new String[]{
                leaveID,
                String.valueOf(employeeID),
                String.valueOf(requestDate),
                leaveType,
                String.valueOf(startDate),
                String.valueOf(endDate),
                String.valueOf(totalDays),
                leaveReason,
                status
        };
    }
}
