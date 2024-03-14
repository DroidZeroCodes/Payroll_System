package interfaces;

import exceptions.AttendanceException;

import java.util.List;

/**
 * Defines the interface for generating attendance reports.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link AttendanceReport#generateAttendanceReport(String)}</li>
 * </ul>
 */
@SuppressWarnings("unused")
public interface AttendanceReport {
    List<String[]> generateAttendanceReport(String reportPeriod) throws AttendanceException;
}
