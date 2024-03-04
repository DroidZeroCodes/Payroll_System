package interfaces;

import data.AttendanceRecord;

import java.util.List;

public interface AttendanceDataService {

    AttendanceRecord getAttendanceRecord_ByAttendanceID(String attendanceID);
    AttendanceRecord getAttendanceRecord_ByEmployeeID(int employeeID);
    List<AttendanceRecord> getAllAttendance_ByEmployeeID(int employeeID);
    List<AttendanceRecord> getAllAttendanceRecords();
    void updateAttendanceRecord(AttendanceRecord attendance);
    void addAttendanceRecord(AttendanceRecord attendance);

}
