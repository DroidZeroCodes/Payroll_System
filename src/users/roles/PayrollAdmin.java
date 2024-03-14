package users.roles;

import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import interfaces.AttendanceManagement;
import interfaces.EmployeeManagement;
import interfaces.PayrollManagement;
import manager.AttendanceManager;
import manager.EmployeeManager;
import manager.PayrollManager;
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
 *     <li>{@link PayrollAdmin#getTempPayrollRecords()} Retrieves the temporary payroll records.</li>
 *     <li>{@link PayrollAdmin#getEmployeeIDList()} Retrieves a list of employee IDs.</li>
 *     <li>{@link PayrollAdmin#runPayroll(String)} Runs payroll for the specified payroll period.</li>
 *     <li>{@link PayrollAdmin#generatePayrollReport(String)} Generates a payroll report for the specified period.</li>
 *     <li>{@link PayrollAdmin#submitPayroll()} Submits the payroll records.</li>
 * </ul>
 */
public class PayrollAdmin extends Employee {
    private final List<PayrollRecord> tempPayrollRecords = new ArrayList<>();
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
     * Retrieves the temporary payroll records.
     *
     * @return The temporary payroll records.
     */
    public List<PayrollRecord> getTempPayrollRecords() {
        return tempPayrollRecords;
    }

    /**
     * Retrieves a list of employee IDs.
     *
     * @return A list of employee IDs.
     */
    public List<Integer> getEmployeeIDList() {
        return employeeManager.getEmployeeIDList();
    }

    //Methods

    /**
     * Runs payroll for the specified payroll period.
     *
     * @param payrollPeriod The period for which the payroll is to be run.
     * @throws EmployeeRecordsException If an error occurs while accessing employee records.
     * @throws PayrollException         If an error occurs during the payroll process.
     */
    public void runPayroll(String payrollPeriod) throws EmployeeRecordsException, PayrollException {
        payrollManager.runPayroll(tempPayrollRecords, payrollPeriod);
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
     * Submits the payroll records.
     *
     * @throws PayrollException If an error occurs while submitting the payroll records.
     */
    public void submitPayroll() throws PayrollException {
        payrollManager.submitPayroll(tempPayrollRecords);
    }
}
