package interfaces;

import data.PayrollRecord;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a service for handling payroll data.
 */
@SuppressWarnings("unused")
public interface PayrollDataService {

    /**
     * Retrieves a payroll record by its payroll ID.
     *
     * @param payrollID The ID of the payroll record.
     * @return The payroll record with the specified ID.
     */
    PayrollRecord getPayroll_ByPayrollID(String payrollID);

    /**
     * Retrieves the payroll record for a specific employee.
     *
     * @param employeeID The ID of the employee.
     * @return The payroll record associated with the specified employee.
     */
    PayrollRecord getPayroll_ByEmployeeID(int employeeID);

    /**
     * Retrieves all payroll records for a specific employee.
     *
     * @param employeeID The ID of the employee.
     * @return A list of all payroll records for the specified employee.
     */
    List<PayrollRecord> getAll_Payroll_ByEmployeeID(String employeeID);

    /**
     * Retrieves all payroll records for a specified period.
     *
     * @param startDate The start date of the period.
     * @param endDate   The end date of the period.
     * @return A list of all payroll records within the specified period.
     */
    List<PayrollRecord> getAll_PayrollRecords_ForPeriod(LocalDate startDate, LocalDate endDate);

    /**
     * Retrieves all payroll records.
     *
     * @return A list of all payroll records.
     */
    List<PayrollRecord> getAll_PayrollRecords();

    /**
     * Adds a new payroll record.
     *
     * @param newRecord The payroll record to be added.
     */
    void addPayrollRecord(PayrollRecord newRecord);
}
