package interfaces;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceReport {
    List<String[]> generateAttendanceReport(LocalDate periodStart, LocalDate periodEnd);
}
