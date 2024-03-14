package interfaces;

import java.util.List;

/**
 * Defines the interface for generating employee reports.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link EmployeeReport#generateEmployeeReport()}</li>
 * </ul>
 */
@SuppressWarnings("unused")
public interface EmployeeReport {
    List<String[]> generateEmployeeReport();
}
