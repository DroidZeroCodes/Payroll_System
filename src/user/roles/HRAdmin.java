package user.roles;

import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import attendance.manager.AttendanceManagement;
import employee.manager.EmployeeManagement;
import leave.manager.LeaveManagement;
import attendance.manager.AttendanceManager;
import employee.manager.EmployeeManager;
import leave.manager.LeaveManager;
import records.AttendanceRecord;
import records.EmployeeRecord;
import records.LeaveRecord;
import data.service.FileDataService;
import reports.service.ReportGenerator;

import java.util.List;

/**
 * Represents an HR Admin in the system, responsible for managing employee-related tasks such as
 * attendance, leave, and employee records.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link HRAdmin#getNewEmployeeID()} Retrieves the ID for a new employee.</li>
 *     <li>{@link HRAdmin#getEmployeeList()} Retrieves a list of all employees.</li>
 *     <li>{@link HRAdmin#getEmployeeIDList()} Retrieves a list of all employee IDs.</li>
 *     <li>{@link HRAdmin#getAllAttendanceRecords()} Retrieves a list of all attendance records.</li>
 *     <li>{@link HRAdmin#getAllLeaveRecords()} Retrieves a list of all leave records.</li>
 *     <li>{@link HRAdmin#getEmployeeLeaveRecord(String)} Retrieves the leave record for a specific employee.</li>
 *     <li>{@link HRAdmin#getEmployeeRecord(int)} Retrieves the employee record for a specific employee.</li>
 *     <li>{@link HRAdmin#getEmployeeCSVPath()} Retrieves the file path for the employee CSV file.</li>
 *     <li>{@link HRAdmin#getAddedEmployeeCount()} Retrieves the count of added employees.</li>
 *     <li>{@link HRAdmin#addEmployee(EmployeeRecord)} Adds a new employee record.</li>
 *     <li>{@link HRAdmin#addEmployee()} Adds employees from a CSV file.</li>
 *     <li>{@link HRAdmin#updateEmployee(EmployeeRecord)} Updates an employee record.</li>
 *     <li>{@link HRAdmin#terminateEmployee(EmployeeRecord)} Terminates an employee.</li>
 *     <li>{@link HRAdmin#approveLeave(String)} Approves a leave request.</li>
 *     <li>{@link HRAdmin#rejectLeave(String, int, String, int)} Rejects a leave request.</li>
 *     <li>{@link HRAdmin#generateAttendanceReport(String)} Generates an attendance report for the specified period.</li>
 *     <li>{@link HRAdmin#setEmployeeCSV_File(String)} Sets the file path for the employee CSV file.</li>
 *     <li>{@link HRAdmin#getActiveEmployeeList()} Retrieves a list of active employees.</li>
 * </ul>
 */
public class HRAdmin extends Employee {
    private final AttendanceManagement attendanceManager;
    private final LeaveManagement leaveManager;
    private final EmployeeManagement employeeManager;
    private final ReportGenerator reportGenerator;
    private String employeeCSVPath;

    /**
     * Constructs an HRAdmin object.
     *
     * @param dataService The data service used for data manipulation.
     * @param employeeID  The unique identifier of the HR Admin employee.
     */
    public HRAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        attendanceManager = new AttendanceManager(dataService);
        leaveManager = new LeaveManager(dataService, dataService);
        employeeManager = new EmployeeManager(dataService);
        reportGenerator = new ReportGenerator(dataService);
    }

    /**
     * Retrieves the ID for a new employee.
     *
     * @return The ID for a new employee.
     */
    public String getNewEmployeeID() {
        return getEmployeeIDList().get(getEmployeeList().size() - 1) + 1 + "";
    }

    //Getters

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of all employees.
     */
    public List<EmployeeRecord> getEmployeeList() {
        return employeeManager.getEmployeeList();
    }

    /**
     * Retrieves a list of active employees.
     *
     * @return A list of active employees.
     */
    public List<EmployeeRecord> getActiveEmployeeList() {
        return employeeManager.getActiveEmployeeList();
    }

    /**
     * Retrieves a list of all employee IDs.
     *
     * @return A list of all employee IDs.
     */
    public List<Integer> getEmployeeIDList() {
        return employeeManager.getEmployeeIDList();
    }

    /**
     * Retrieves a list of all attendance records.
     *
     * @return A list of all attendance records.
     */
    public List<AttendanceRecord> getAllAttendanceRecords() {
        return attendanceManager.getAllAttendanceRecords();
    }

    /**
     * Retrieves a list of all leave records.
     *
     * @return A list of all leave records.
     */
    public List<LeaveRecord> getAllLeaveRecords() {
        return leaveManager.getAllLeaveRecords();
    }

    /**
     * Retrieves the leave record for a specific employee.
     *
     * @param leaveID The leave ID associated with the leave record.
     * @return The leave record for the specified employee.
     */
    public LeaveRecord getEmployeeLeaveRecord(String leaveID) {
        return leaveManager.getLeaveRecord(leaveID);
    }

    /**
     * Retrieves the employee record for a specific employee.
     *
     * @param employeeID The ID of the employee.
     * @return The employee record for the specified employee.
     */
    public EmployeeRecord getEmployeeRecord(int employeeID) {
        return employeeManager.getEmployeeRecord(employeeID);
    }

    /**
     * Retrieves the file path for the employee CSV file.
     *
     * @return The file path for the employee CSV file.
     */
    public String getEmployeeCSVPath() {
        return employeeCSVPath;
    }

    /**
     * Retrieves the count of added employees.
     *
     * @return The count of added employees.
     */
    public int getAddedEmployeeCount() {
        return employeeManager.getAddedEmployeeNumber(employeeCSVPath);
    }

    //Methods

    /**
     * Adds a new employee record.
     *
     * @param newRecord The new employee record to be added.
     * @throws EmployeeRecordsException If an error occurs while adding the employee record.
     */
    public void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException {
        employeeManager.addEmployee(newRecord);
    }

    /**
     * Adds employees from a CSV file.
     *
     * @throws EmployeeRecordsException If an error occurs while adding employees from the CSV file.
     */
    public void addEmployee() throws EmployeeRecordsException {
        employeeManager.addEmployee_CSV(employeeCSVPath);
        employeeCSVPath = null;
    }

    /**
     * Updates an employee record.
     *
     * @param updatedRecord The updated employee record.
     * @throws EmployeeRecordsException If an error occurs while updating the employee record.
     */
    public void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException {
        employeeManager.updateEmployee(updatedRecord);
    }

    /**
     * Terminates an employee.
     *
     * @param selectedEmployee The employee to be terminated.
     * @throws EmployeeRecordsException If an error occurs while terminating the employee.
     */
    public void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException {
        employeeManager.terminateEmployee(selectedEmployee);
    }

    /**
     * Approves a leave request.
     *
     * @param leaveID The ID of the leave request to be approved.
     */
    public void approveLeave(String leaveID) {
        leaveManager.approveLeave(leaveID);
    }

    /**
     * Rejects a leave request.
     *
     * @param leaveID    The ID of the leave request to be rejected.
     * @param employeeID The ID of the employee requesting leave.
     * @param leaveType  The type of leave requested.
     * @param duration   The duration of leave requested.
     */
    public void rejectLeave(String leaveID, int employeeID, String leaveType, int duration) {
        leaveManager.rejectLeave(leaveID, employeeID, leaveType, duration);
    }

    /**
     * Generates an attendance report for the specified period.
     *
     * @param reportPeriod The period for which the report is generated.
     * @return A list of string arrays representing the attendance report.
     * @throws AttendanceException If an error occurs while generating the attendance report.
     */
    public List<String[]> generateAttendanceReport(String reportPeriod) throws AttendanceException {
        return reportGenerator.generateAttendanceReport(reportPeriod);
    }

    /**
     * Sets the file path for the employee CSV file.
     *
     * @param filePath The file path for the employee CSV file.
     */
    public void setEmployeeCSV_File(String filePath) {
        this.employeeCSVPath = filePath;
    }
}
