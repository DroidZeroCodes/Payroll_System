package attendance.manager;

import records.util.DateTimeCalculator;
import exceptions.AttendanceException;
import data.service.AttendanceDataService;
import records.AttendanceRecord;
import records.EmployeeRecord;
import records.util.DateTimeUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static records.util.ID_Generator.generateAttendanceID;

/**
 * Manages attendance-related operations.
 * This class provides methods for logging time in and time out, adding and updating attendance records,
 * retrieving attendance records, and retrieving attendance records for specific employees or periods.
 * Utilizes interfaces {@link AttendanceDataService}, and {@link AttendanceManagement} for data access and management.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link AttendanceManager#logTimeIn(int, EmployeeRecord)}</li>
 *     <li>{@link AttendanceManager#logTimeOut(String)}</li>
 *     <li>{@link AttendanceManager#addAttendanceRecord(AttendanceRecord)}</li>
 *     <li>{@link AttendanceManager#updateAttendanceRecord(AttendanceRecord)}</li>
 *     <li>{@link AttendanceManager#getAttendanceRecord(String)}</li>
 *     <li>{@link AttendanceManager#getAllAttendanceRecords()}</li>
 *     <li>{@link AttendanceManager#getAttendanceRecord_List(int, LocalDate, LocalDate)}</li>
 *     <li>{@link AttendanceManager#getAttendanceRecord_List(int)}</li>
 * </ul>
 */

public class AttendanceManager implements AttendanceManagement {
    private final AttendanceDataService attendanceDataService;

    /**
     * Constructor for AttendanceManager.
     *
     * @param attendanceDataService the data service for attendance
     */
    public AttendanceManager(AttendanceDataService attendanceDataService) {
        this.attendanceDataService = attendanceDataService;
    }

    @Override
    public void logTimeIn(int employeeID, EmployeeRecord personalRecord) throws AttendanceException {
        // Retrieve the current time and date
        LocalTime timeIn = DateTimeUtils.currentTime();
        LocalDate currentDate = LocalDate.now();
        String attendanceID = generateAttendanceID(employeeID);

        AttendanceRecord currentAttendanceRecord = getAttendanceRecord(attendanceID);

        if (currentAttendanceRecord != null) {
            // Display an error message
            AttendanceException.throwError_ALREADY_CLOCKED_IN();
        }

        // Add the new attendance record
        addAttendanceRecord(new AttendanceRecord(
                attendanceID,
                currentDate,
                employeeID,
                personalRecord.lastName(),
                personalRecord.firstName(),
                timeIn,
                LocalTime.MIN,
                LocalTime.MIN,
                LocalTime.MIN
        ));
    }

    @Override
    public void logTimeOut(String attendanceID) throws AttendanceException {
        LocalTime timeOut = DateTimeUtils.currentTime();

        AttendanceRecord currentAttendanceRecord = getAttendanceRecord(attendanceID);

        if (currentAttendanceRecord == null) {
            AttendanceException.throwError_NOT_CLOCKEDIN();
            return;
        }

        if (!currentAttendanceRecord.timeOut().equals(LocalTime.MIN)) {
            AttendanceException.throwError_ALREADY_CLOCKED_OUT();
            return;
        }

        LocalTime hoursWorked = DateTimeCalculator.regularHoursWorked(currentAttendanceRecord.timeIn(), timeOut);
        LocalTime overtimeHours = DateTimeCalculator.overtimeHours(currentAttendanceRecord.timeIn(), timeOut);

        updateAttendanceRecord(currentAttendanceRecord.withTimeOut(timeOut).withHoursWorked(hoursWorked).withOverTimeHours(overtimeHours));
    }

    /**
     * Adds a new attendance record.
     *
     * @param newRecord the new attendance record to add
     */
    public void addAttendanceRecord(AttendanceRecord newRecord) {
        System.out.println("Adding attendance record: " + newRecord);

        // Add to the database
        try {
            attendanceDataService.addAttendanceRecord(newRecord);
        } catch (Exception e) {
            System.err.println("Error while adding attendance record: " + e);
        }
    }

    @Override
    public void updateAttendanceRecord(AttendanceRecord updatedRecord) {
        System.out.println("Updating attendance record: " + updatedRecord);

        // Update in the database
        try {
            attendanceDataService.updateAttendanceRecord(updatedRecord);
        } catch (Exception e) {
            System.err.println("Error while updating attendance record: " + e);
        }
    }

    @Override
    public AttendanceRecord getAttendanceRecord(String attendanceID) {
        try {
            return attendanceDataService.getAttendanceRecord_ByAttendanceID(attendanceID);
        } catch (Exception e) {
            System.err.println("Attendance record not found for this day");
            return null;
        }
    }

    @Override
    public List<AttendanceRecord> getAllAttendanceRecords() {
        try {
            return attendanceDataService.getAllAttendanceRecords();
        } catch (Exception e) {
            System.err.println("Attendance record not found");
            return null;
        }
    }

    @Override
    public List<AttendanceRecord> getAttendanceRecord_List(int employeeID, LocalDate periodStart, LocalDate periodEnd) {
        List<AttendanceRecord> attendanceRecords;
        try {
            attendanceRecords = attendanceDataService.getAll_AttendanceRecord_ForPeriod(periodStart, periodEnd);
        } catch (Exception e) {
            System.err.println("No attendance records found" + e);
            return Collections.emptyList();
        }

        if (attendanceRecords.isEmpty()) {
            return Collections.emptyList();
        }

        attendanceRecords.removeIf(record -> record.employeeID() != employeeID);
        return attendanceRecords;
    }

    @Override
    public List<AttendanceRecord> getAttendanceRecord_List(int employeeID) {
        try {
            return attendanceDataService.getAllAttendance_ByEmployeeID(employeeID);
        } catch (IllegalArgumentException e) {
            System.err.println("No attendance records found" + e);
            return null;
        }
    }
}
