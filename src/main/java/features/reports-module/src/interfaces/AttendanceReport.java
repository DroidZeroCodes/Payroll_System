package interfaces;

import exceptions.AttendanceException;

import java.util.List;

public interface AttendanceReport {
    List<String[]> generateAttendanceReport(String reportPeriod) throws AttendanceException;
}
