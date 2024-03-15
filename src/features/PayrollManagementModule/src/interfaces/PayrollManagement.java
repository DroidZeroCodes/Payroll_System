package interfaces;

import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import records.PayrollRecord;

import java.util.List;

/**
 * Defines the interface for managing payroll records.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link PayrollManagement#runPayroll(List, String)}</li>
 *     <li>{@link PayrollManagement#submitPayroll(List)}</li>
 *     <li>{@link PayrollManagement#getAllPayrollRecords()}</li>
 *     <li>{@link PayrollManagement#getPayrollIDList(String)}</li>
 *     <li>{@link PayrollManagement#getPayrollRecord(int, int, String)}</li>
 *     <li>{@link PayrollManagement#getPayrollRecord(String)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public interface PayrollManagement {
    /**
     * Runs payroll for the specified temporary payroll records and payroll period.
     *
     * @param tempPayrollRecords the temporary payroll records to process
     * @param payrollPeriod      the period for which the payroll is being run
     * @throws EmployeeRecordsException if an error occurs while processing employee records
     * @throws PayrollException         if an error occurs while processing payroll
     */
    void runPayroll(List<PayrollRecord> tempPayrollRecords, String payrollPeriod) throws EmployeeRecordsException, PayrollException;

    /**
     * Submits payroll for the specified temporary payroll records.
     *
     * @param tempPayrollRecords the temporary payroll records to submit
     * @throws PayrollException if an error occurs while submitting payroll
     */
    void submitPayroll(List<PayrollRecord> tempPayrollRecords) throws PayrollException;

    /**
     * Retrieves a list of all payroll records.
     *
     * @return a list of all payroll records
     */
    List<PayrollRecord> getAllPayrollRecords();

    /**
     * Retrieves a list of payroll IDs for the specified payroll period.
     *
     * @param period the payroll period
     * @return a list of payroll IDs
     */
    List<String> getPayrollIDList(String period);

    /**
     * Retrieves the payroll record for the specified employee ID and year/month.
     *
     * @param employeeID the ID of the employee
     * @param month      the month of the year
     * @param period  the period of the payroll
     * @return the payroll record
     */
    PayrollRecord getPayrollRecord(int employeeID, int month, String period);

    /**
     * Retrieves the payroll record for the specified payroll ID.
     *
     * @param payrollID the ID of the payroll record
     * @return the payroll record
     */
    PayrollRecord getPayrollRecord(String payrollID);

    /**
     * Retrieves a list of payroll records for the specified payroll period.
     *
     * @param period the period of the payroll
     * @return a list of payroll records
     */
    List<PayrollRecord> getPayrollRecord_List(String period);
}
