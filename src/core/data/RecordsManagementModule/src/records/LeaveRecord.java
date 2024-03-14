package records;

import java.time.LocalDate;

/**
 * Represents a leave record.
 * This record contains information about an employee's leave request, including the leave ID,
 * employee ID, request date, leave type, start date, end date, total days, leave reason, and status.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link LeaveRecord#toArray()}</li>
 *     <li>{@link LeaveRecord#withStatus(LEAVE_STATUS)}</li>
 * </ul>
 */

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

    /**
     * Converts the object's attributes to a String array.
     *
     * @return String array containing leaveID, employeeID, requestDate, leaveType, startDate, endDate, totalDays, leaveReason, and status
     */
    @SuppressWarnings("unused")
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

    /**
     * Updates the leave status of the LeaveRecord.
     *
     * @param leaveStatus the new leave status to be set
     * @return the updated LeaveRecord with the new leave status
     */
    @SuppressWarnings("unused")
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

    /**
     * Enumerates the possible leave statuses.
     */
    @SuppressWarnings("unused")
    public enum LEAVE_STATUS {
        /**
         * Pending - when the leave request is waiting approval
         */
        PENDING,

        /**
         * Approved - when the leave request has been approved
         */
        APPROVED,

        /**
         * Rejected - when the leave request has been rejected
         */
        REJECTED
    }
}
