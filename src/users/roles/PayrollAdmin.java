package users.roles;

import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import interfaces.*;
import manager.AttendanceManager;
import manager.EmployeeManager;
import manager.PayrollManager;
import records.EmployeeRecord;
import records.PayrollRecord;
import service.FileDataService;
import service.ReportGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Payroll Administrator in the system, responsible for managing payroll-related tasks.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link PayrollAdmin#getTempPayrollRecords_Batch()} Retrieves the temporary payroll records.</li>
 *     <li>{@link PayrollAdmin#getEmployeeIDList()} Retrieves a list of employee IDs.</li>
 *     <li>{@link PayrollAdmin#runBatchPayroll(String)} Runs payroll for the specified payroll period.</li>
 *     <li>{@link PayrollAdmin#generatePayrollReport(String)} Generates a payroll report for the specified period.</li>
 *     <li>{@link PayrollAdmin#submitBatchPayroll()} Submits the payroll records.</li>
 * </ul>
 */
public class PayrollAdmin extends Employee {
    private final List<PayrollRecord> tempPayrollRecords_Batch = new ArrayList<>();
    private PayrollRecord tempPayrollRecord_Manual = null;
    private final ReportGenerator reportGenerator;
    private final PayrollManagement payrollManager;
    private final EmployeeManagement employeeManager;

    /**
     * Constructs a PayrollAdmin object.
     *
     * @param dataService The data service used for data manipulation.
     * @param employeeID  The unique identifier of the Payroll Admin employee.
     */
    public PayrollAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        this.reportGenerator = new ReportGenerator(dataService);
        this.employeeManager = new EmployeeManager(dataService);
        AttendanceManagement attendanceManager = new AttendanceManager(dataService);
        this.payrollManager = new PayrollManager(dataService, employeeManager, attendanceManager);
    }

    //Getters

    /**
     * Retrieves the temporary payroll records from the batch process.
     *
     * @return The temporary payroll records.
     */
    public List<PayrollRecord> getTempPayrollRecords_Batch() {
        return tempPayrollRecords_Batch;
    }

    /**
     * Retrieves a list of employee IDs.
     *
     * @return A list of employee IDs.
     */
    public List<Integer> getEmployeeIDList() {
        return employeeManager.getEmployeeIDList();
    }

    /**
     * Retrieves an employee record.
     * @param employeeID The employee ID.
     * @return The employee record.
     */
    public EmployeeRecord getEmployeeRecord(int employeeID) {
        return employeeManager.getEmployeeRecord(employeeID);
    }

    /**
     * Retrieves the number of hours worked.
     * @param employeeID The employee ID.
     * @param period The period.
     * @return The number of hours worked.
     */
    public double getHoursWorked(int employeeID, String period) {
        return payrollManager.getHoursWorked(employeeID, period);
    }

    /**
     * Retrieves the number of overtime hours.
     * @param employeeID The employee ID.
     * @param period The period.
     * @return The number of overtime hours.
     */
    public double getOvertimeHours(int employeeID, String period) {
        return payrollManager.getOvertimeHours(employeeID, period);
    }

    //Methods

    /**
     * Runs batch payroll for the specified payroll period.
     *
     * @param payrollPeriod The period for which the payroll is to be run.
     * @throws EmployeeRecordsException If an error occurs while accessing employee records.
     * @throws PayrollException         If an error occurs during the payroll process.
     */
    public void runBatchPayroll(String payrollPeriod) throws EmployeeRecordsException, PayrollException {
        payrollManager.runBatchPayroll(tempPayrollRecords_Batch, payrollPeriod);
    }


    /**
     * Runs batch payroll for the specified payroll period.
     *
     * @param payrollPeriod The period for which the payroll is to be run.
     */
    public PayrollRecord runManualPayroll(PayrollRecord tempPayrollRecord_Manual, String payrollPeriod) throws EmployeeRecordsException {
        this.tempPayrollRecord_Manual = payrollManager.runManualPayroll(tempPayrollRecord_Manual, payrollPeriod);
        return this.tempPayrollRecord_Manual;
    }

    /**
     * Generates a payroll report for the specified period.
     *
     * @param reportPeriod The period for which the report is to be generated.
     * @return A list of string arrays representing the payroll report.
     * @throws PayrollException If an error occurs while generating the payroll report.
     */
    public List<String[]> generatePayrollReport(String reportPeriod) throws PayrollException {
        return reportGenerator.generatePayrollReport(reportPeriod);
    }

    /**
     * Submits the batch processed payroll records.
     *
     * @throws PayrollException If an error occurs while submitting the payroll records.
     */
    public void submitBatchPayroll() throws PayrollException {
        payrollManager.submitBatchPayroll(tempPayrollRecords_Batch);
    }

    /**
     * Submits the manual processed payroll records.
     *
     */
    public void submitManualPayroll() {
        payrollManager.submitManualPayroll(tempPayrollRecord_Manual);
    }
}
