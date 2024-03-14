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
    /**
     * Generates the payroll report.
     *
     * @param reportPeriod the report period to be generated
     * @return a list of string arrays representing the report
     * @throws PayrollException if an error occurs
     */
    List<String[]> generatePayrollReport(String reportPeriod) throws PayrollException;
}
