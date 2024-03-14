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
    /**
     * Generates an attendance report for the specified report period.
     *
     * @param reportPeriod the period for which the attendance report is generated
     * @return a list of string arrays representing the attendance report
     * @throws AttendanceException if an error occurs while generating the attendance report
     */
    List<String[]> generateAttendanceReport(String reportPeriod) throws AttendanceException;
}
