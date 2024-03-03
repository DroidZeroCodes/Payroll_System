package interfaces;

import data.AttendanceRecord;

import java.util.List;

public interface AttendanceDataService {

    AttendanceRecord getAttendanceRecord_ByAttendanceID(String attendanceID);
    List<AttendanceRecord> getAttendanceRecords_ByEmployeeID(int employeeID);
    List<AttendanceRecord> getAllAttendanceRecords();
    void updateAttendanceRecord(AttendanceRecord attendance);
    void addAttendanceRecord(AttendanceRecord attendance);
}
