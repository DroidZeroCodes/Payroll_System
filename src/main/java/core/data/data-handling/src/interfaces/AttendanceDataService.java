package interfaces;

import data.AttendanceRecord;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceDataService {

    AttendanceRecord getAttendanceRecord_ByAttendanceID(String attendanceID);

    AttendanceRecord getAttendanceRecord_ByEmployeeID(int employeeID);

    List<AttendanceRecord> getAllAttendance_ByEmployeeID(int employeeID);

    List<AttendanceRecord> getAllAttendanceRecords();

    void updateAttendanceRecord(AttendanceRecord attendance);

    void addAttendanceRecord(AttendanceRecord attendance);


    List<AttendanceRecord> getAll_AttendanceRecord_ForPeriod(LocalDate periodStart, LocalDate periodEnd);
}
