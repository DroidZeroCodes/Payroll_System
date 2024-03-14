package interfaces;

import exceptions.AttendanceException;
import records.AttendanceRecord;
import records.EmployeeRecord;

import java.time.LocalDate;
import java.util.List;

/**
 * Defines the interface for managing attendance records.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link AttendanceManagement#logTimeIn(int, EmployeeRecord)}</li>
 *     <li>{@link AttendanceManagement#logTimeOut(String)}</li>
 *     <li>{@link AttendanceManagement#addAttendanceRecord(AttendanceRecord)}</li>
 *     <li>{@link AttendanceManagement#updateAttendanceRecord(AttendanceRecord)}</li>
 *     <li>{@link AttendanceManagement#getAttendanceRecord(String)}</li>
 *     <li>{@link AttendanceManagement#getAttendanceRecord_List(int)}</li>
 *     <li>{@link AttendanceManagement#getAllAttendanceRecords()}</li>
 *     <li>{@link AttendanceManagement#getAttendanceRecord_List(int, LocalDate, LocalDate)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public interface AttendanceManagement {
    /**
     * Logs the time in for an employee.
     *
     * @param employeeID     the ID of the employee
     * @param personalRecord the personal record of the employee
     * @throws AttendanceException if an error occurs during logging time in
     */
    void logTimeIn(int employeeID, EmployeeRecord personalRecord) throws AttendanceException;

    /**
     * Logs the time out for an attendance record.
     *
     * @param attendanceID the ID of the attendance record
     * @throws AttendanceException if an error occurs during logging time out
     */
    void logTimeOut(String attendanceID) throws AttendanceException;

    /**
     * Adds a new attendance record.
     *
     * @param newRecord the new attendance record to add
     */
    void addAttendanceRecord(AttendanceRecord newRecord);

    /**
     * Updates an existing attendance record.
     *
     * @param updatedRecord the updated attendance record
     */
    void updateAttendanceRecord(AttendanceRecord updatedRecord);

    /**
     * Retrieves an attendance record by its ID.
     *
     * @param attendanceID the ID of the attendance record to retrieve
     * @return the attendance record
     * @throws AttendanceException if the attendance record is not found
     */
    AttendanceRecord getAttendanceRecord(String attendanceID) throws AttendanceException;

    /**
     * Retrieves all attendance records for a specific employee.
     *
     * @param employeeID the ID of the employee
     * @return a list of attendance records for the employee
     */
    List<AttendanceRecord> getAttendanceRecord_List(int employeeID);

    /**
     * Retrieves all attendance records.
     *
     * @return a list of all attendance records
     */
    List<AttendanceRecord> getAllAttendanceRecords();

    /**
     * Retrieves attendance records for a specific employee within a specified period.
     *
     * @param employeeID  the ID of the employee
     * @param periodStart the start date of the period
     * @param periodEnd   the end date of the period
     * @return a list of attendance records for the employee within the specified period
     */
    List<AttendanceRecord> getAttendanceRecord_List(int employeeID, LocalDate periodStart, LocalDate periodEnd);
}
