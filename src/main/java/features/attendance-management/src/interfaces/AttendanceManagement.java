package interfaces;


import data.AttendanceRecord;
import data.EmployeeRecord;
import exceptions.AttendanceException;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceManagement {
    void logTimeIn(int employeeID, EmployeeRecord personalRecord) throws AttendanceException;

    void logTimeOut(String attendanceID) throws AttendanceException;

    void addAttendanceRecord(AttendanceRecord newRecord);

    void updateAttendanceRecord(AttendanceRecord updatedRecord);

    AttendanceRecord getAttendanceRecord(String attendanceID) throws AttendanceException;

    List<AttendanceRecord> getAttendanceRecord_List(int employeeID);

    List<AttendanceRecord> getAllAttendanceRecords();

    List<AttendanceRecord> getAttendanceRecord_List(int employeeID, LocalDate periodStart, LocalDate periodEnd);

}
