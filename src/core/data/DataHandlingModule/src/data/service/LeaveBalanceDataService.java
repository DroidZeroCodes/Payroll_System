package data.service;

import records.LeaveBalanceRecord;

/**
 * Represents a service for handling leave balance data.
 */
@SuppressWarnings("unused")
public interface LeaveBalanceDataService {

    /**
     * Retrieves the leave balance record for a specific employee.
     *
     * @param employeeID The ID of the employee.
     * @return The leave balance record associated with the specified employee.
     */
    LeaveBalanceRecord getLeaveBalance_ByEmployeeID(int employeeID);

    /**
     * Updates the leave balance record.
     *
     * @param updatedRecord The updated leave balance record.
     */
    void updateLeaveBalance(LeaveBalanceRecord updatedRecord);

    /**
     * Adds a new leave balance record.
     *
     * @param leaveBalanceRecord The leave balance record to be added.
     */
    void addLeaveBalance(LeaveBalanceRecord leaveBalanceRecord);
}
