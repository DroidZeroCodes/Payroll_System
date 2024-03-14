package interfaces;

import records.LeaveRecord;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a service for handling leave data.
 */
@SuppressWarnings("unused")
public interface LeaveDataService {

    /**
     * Retrieves a leave record by its leave ID.
     *
     * @param leaveID The ID of the leave record.
     * @return The leave record with the specified ID.
     */
    LeaveRecord getLeaveByLeaveID(String leaveID);

    /**
     * Retrieves all leave records for a specific employee.
     *
     * @param employeeID The ID of the employee.
     * @return A list of all leave records for the specified employee.
     */
    List<LeaveRecord> getLeaveRecords_ByEmployeeID(int employeeID);

    /**
     * Retrieves all leave records for a specific date.
     *
     * @param requestDate The date for which leave records are requested.
     * @return A list of all leave records for the specified date.
     */
    List<LeaveRecord> getLeaveRecordsByDate(LocalDate requestDate);

    /**
     * Retrieves all leave records.
     *
     * @return A list of all leave records.
     */
    List<LeaveRecord> allLeaveRecords();

    /**
     * Adds a new leave record.
     *
     * @param leaveRecord The leave record to be added.
     */
    void addLeaveRecord(LeaveRecord leaveRecord);

    /**
     * Retrieves all leave records.
     *
     * @return A list of all leave records.
     */
    List<LeaveRecord> getAllLeaveRecords();

    /**
     * Updates a leave record.
     *
     * @param leaveRecord The leave record to be updated.
     */
    void updateLeaveRecord(LeaveRecord leaveRecord);
}
