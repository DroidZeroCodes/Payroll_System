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
 *     <li>{@link PayrollManagement#runBatchPayroll(List, String)}</li>
 *     <li>{@link PayrollManagement#submitBatchPayroll(List)}</li>
 *     <li>{@link PayrollManagement#runManualPayroll(PayrollRecord, String)}</li>
 *     <li>{@link PayrollManagement#submitManualPayroll(PayrollRecord)}</li>
 *     <li>{@link PayrollManagement#getAllPayrollRecords()}</li>
 *     <li>{@link PayrollManagement#getPayrollIDList(String)}</li>
 *     <li>{@link PayrollManagement#getPayrollRecord(int, int, String)}</li>
 *     <li>{@link PayrollManagement#getPayrollRecord(String)}</li>
 *     <li>{@link PayrollManagement#getPayrollRecord_List(String)}</li>
 *     <li>{@link PayrollManagement#getHoursWorked(int, String)}</li>
 *     <li>{@link PayrollManagement#getOvertimeHours(int, String)}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public interface PayrollManagement {
    /**
     * Runs batch payroll for the specified temporary payroll records and payroll period.
     *
     * @param tempPayrollRecords the temporary payroll records to process
     * @param payrollPeriod      the period for which the payroll is being run
     * @throws EmployeeRecordsException if an error occurs while processing employee records
     * @throws PayrollException         if an error occurs while processing payroll
     */
    void runBatchPayroll(List<PayrollRecord> tempPayrollRecords, String payrollPeriod) throws EmployeeRecordsException, PayrollException;

    /**
     * Submits batch processed payroll for the specified temporary payroll records.
     *
     * @param tempPayrollRecords the temporary payroll records to submit
     * @throws PayrollException if an error occurs while submitting payroll
     */
    void submitBatchPayroll(List<PayrollRecord> tempPayrollRecords) throws PayrollException;

    /**
     * Retrieves a list of all payroll records.
     *
     * @return a list of all payroll records
     */
    List<PayrollRecord> getAllPayrollRecords();

    /**
     * Runs manual payroll for the specified temporary payroll record and period.
     * @param tempPayrollRecord the temporary payroll record to process, has empty fields which needs calculations to be filled
     * @param payrollPeriod the period for which the payroll is being run
     *
     */
    PayrollRecord runManualPayroll(PayrollRecord tempPayrollRecord, String payrollPeriod) throws EmployeeRecordsException;

    /**
     * Submits manual processed payroll for the specified temporary payroll record.
     *
     * @param payrollRecord the payroll record to submit
     */
    void submitManualPayroll(PayrollRecord payrollRecord);

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
     * Retrieves a list of payroll records for the specified period.
     *
     * @param period the period
     * @return a list of payroll records
     */
    List<PayrollRecord> getPayrollRecord_List(String period);

    /**
     * Retrieves the number of hours worked for the specified employee ID and period.
     *
     * @param employeeID the ID of the employee
     * @param period  the period
     * @return the number of hours worked
     */
    double getHoursWorked(int employeeID, String period);

    /**
     * Retrieves the number of overtime hours for the specified employee ID and period.
     *
     * @param employeeID the ID of the employee
     * @param period  the period
     * @return the number of overtime hours
     */
    double getOvertimeHours(int employeeID, String period);

}
