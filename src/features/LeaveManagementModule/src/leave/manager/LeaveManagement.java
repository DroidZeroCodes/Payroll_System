package leave.manager;

import exceptions.LeaveException;
import records.LeaveBalanceRecord;
import records.LeaveRecord;

import java.util.List;

/**
 * Defines the interface for managing leave records and balances.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link LeaveManagement#approveLeave(String)}</li>
 *     <li>{@link LeaveManagement#rejectLeave(String, int, String, int)}</li>
 *     <li>{@link LeaveManagement#getLeaveRecord(String)}</li>
 *     <li>{@link LeaveManagement#getLeaveRecord_List(int)}</li>
 *     <li>{@link LeaveManagement#getLeaveRecord_List()}</li>
 *     <li>{@link LeaveManagement#getLeaveBalanceRecord(int)}</li>
 *     <li>{@link LeaveManagement#getLeaveBalance_OfType(int, String)}</li>
 *     <li>{@link LeaveManagement#getAllLeaveRecords()}</li>
 *     <li>{@link LeaveManagement#addLeaveRecord(LeaveRecord, LeaveBalanceRecord)}</li>
 *     <li>{@link LeaveManagement#getLeaveBalance_OfType(LeaveBalanceRecord, String)}</li>
 *     <li>{@link LeaveManagement#updateLeaveBalance(LeaveBalanceRecord, String, int)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public interface LeaveManagement {
    /**
     * Approves a leave request.
     *
     * @param leaveID the ID of the leave request to approve
     */
    void approveLeave(String leaveID);

    /**
     * Rejects a leave request.
     *
     * @param leaveID    the ID of the leave request to reject
     * @param employeeID the ID of the employee requesting the leave
     * @param leaveType  the type of leave requested
     * @param duration   the duration of the leave requested
     */
    void rejectLeave(String leaveID, int employeeID, String leaveType, int duration);

    /**
     * Retrieves a leave record by its ID.
     *
     * @param leaveID the ID of the leave record to retrieve
     * @return the leave record
     */
    LeaveRecord getLeaveRecord(String leaveID);

    /**
     * Retrieves a list of leave records for a specific employee.
     *
     * @param employeeID the ID of the employee
     * @return a list of leave records
     */
    List<LeaveRecord> getLeaveRecord_List(int employeeID);

    /**
     * Retrieves a list of all leave records.
     *
     * @return a list of all leave records
     */
    List<LeaveRecord> getLeaveRecord_List();

    // Leave Balance

    /**
     * Retrieves the leave balance record for a specific employee.
     *
     * @param employeeID the ID of the employee
     * @return the leave balance record
     */
    LeaveBalanceRecord getLeaveBalanceRecord(int employeeID);

    /**
     * Retrieves the leave balance for a specific type of leave.
     *
     * @param leaveBalance the leave balance record
     * @param leaveType    the type of leave for which the balance is retrieved
     * @return the leave balance for the specified type
     */
    int getLeaveBalance_OfType(int leaveBalance, String leaveType);

    /**
     * Retrieves a list of all leave records.
     *
     * @return a list of all leave records
     */
    List<LeaveRecord> getAllLeaveRecords();

    /**
     * Adds a new leave record and updates the leave balance.
     *
     * @param newRecord    the new leave record to add
     * @param leaveBalance the leave balance record to update
     * @throws LeaveException if an error occurs while adding the leave record
     */
    void addLeaveRecord(LeaveRecord newRecord, LeaveBalanceRecord leaveBalance) throws LeaveException;

    /**
     * Retrieves the leave balance for a specific type of leave from a leave balance record.
     *
     * @param leaveBalance the leave balance
     * @param leaveType    the type of leave
     * @return the leave balance for the specified type
     */
    int getLeaveBalance_OfType(LeaveBalanceRecord leaveBalance, String leaveType);

    /**
     * Updates the leave balance for a specific type of leave.
     *
     * @param leaveBalanceRecord the leave balance record to update
     * @param leaveType          the type of leave
     * @param newBalance         the new leave balance
     */
    void updateLeaveBalance(LeaveBalanceRecord leaveBalanceRecord, String leaveType, int newBalance);
}
