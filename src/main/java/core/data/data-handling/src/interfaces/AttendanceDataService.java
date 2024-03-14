package interfaces;

import data.AttendanceRecord;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a service for handling attendance data.
 */
@SuppressWarnings("unused")
public interface AttendanceDataService {

    /**
     * Retrieves an attendance record by its attendance ID.
     *
     * @param attendanceID The ID of the attendance record.
     * @return The attendance record with the specified ID.
     */
    AttendanceRecord getAttendanceRecord_ByAttendanceID(String attendanceID);

    /**
     * Retrieves an attendance record by employee ID.
     *
     * @param employeeID The ID of the employee.
     * @return The attendance record associated with the specified employee.
     */
    AttendanceRecord getAttendanceRecord_ByEmployeeID(int employeeID);

    /**
     * Retrieves all attendance records for a specific employee.
     *
     * @param employeeID The ID of the employee.
     * @return A list of all attendance records for the specified employee.
     */
    List<AttendanceRecord> getAllAttendance_ByEmployeeID(int employeeID);

    /**
     * Retrieves all attendance records.
     *
     * @return A list of all attendance records.
     */
    List<AttendanceRecord> getAllAttendanceRecords();

    /**
     * Updates an attendance record.
     *
     * @param attendance The attendance record to be updated.
     */
    void updateAttendanceRecord(AttendanceRecord attendance);

    /**
     * Adds a new attendance record.
     *
     * @param attendance The attendance record to be added.
     */
    void addAttendanceRecord(AttendanceRecord attendance);

    /**
     * Retrieves all attendance records for a specified period.
     *
     * @param periodStart The start date of the period.
     * @param periodEnd   The end date of the period.
     * @return A list of all attendance records within the specified period.
     */
    List<AttendanceRecord> getAll_AttendanceRecord_ForPeriod(LocalDate periodStart, LocalDate periodEnd);
}
