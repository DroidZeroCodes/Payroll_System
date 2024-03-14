package interfaces;

import exceptions.PayrollException;

import java.util.List;

/**
 * Defines the interface for generating payroll reports.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link PayrollReport#generatePayrollReport(String)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public interface PayrollReport {
    List<String[]> generatePayrollReport(String reportType) throws PayrollException;
}
