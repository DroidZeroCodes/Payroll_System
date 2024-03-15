package users.roles;

import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import interfaces.AttendanceManagement;
import interfaces.EmployeeManagement;
import interfaces.LeaveManagement;
import interfaces.PayrollManagement;
import manager.AttendanceManager;
import manager.EmployeeManager;
import manager.LeaveManager;
import manager.PayrollManager;
import records.*;
import service.FileDataService;
import util.ID_Generator;

import java.time.YearMonth;
import java.util.List;

/**
 * Represents an employee in the system, providing access to various features such as attendance management,
 * leave management, and payroll management.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link Employee#getEmployeeID()} Returns the employee's ID.</li>
 *     <li>{@link Employee#getAttendanceID()} Returns the attendance ID associated with the employee.</li>
 *     <li>{@link Employee#getLeaveID()} Returns the leave ID associated with the employee.</li>
 *     <li>{@link Employee#getPersonalRecord()} Returns the personal record of the employee.</li>
 *     <li>{@link Employee#getPersonalAttendanceRecordList()} Returns a list of personal attendance records of the employee.</li>
 *     <li>{@link Employee#getPersonalLeaveRecordList()} Returns a list of personal leave records of the employee.</li>
 *     <li>{@link Employee#getLeaveBalance_OfType(String)} Returns the leave balance of the specified type for the employee.</li>
 *     <li>{@link Employee#getLeaveBalance()} Returns the leave balance record of the employee.</li>
 *     <li>{@link Employee#getPayslip(String, int, int)} Returns the payslip of the employee for the specified period and month.</li>
 *     <li>{@link Employee#clockIn()} Logs the employee's time in.</li>
 *     <li>{@link Employee#clockOut()} Logs the employee's time out.</li>
 *     <li>{@link Employee#submitLeaveRequest(LeaveRecord)} Submits a leave request for the employee.</li>
 * </ul>
 */
@SuppressWarnings("unused")
public class Employee {
    private final int employeeID;
    private final String attendanceID;
    private final String leaveID;

    // Features Managers
    private final AttendanceManagement attendanceManager;
    private final LeaveManagement leaveManager;
    private final PayrollManagement payrollManager;
    private final EmployeeManagement employeeManager;


    /**
     * Constructs an Employee object.
     *
     * @param dataService The data service used for data manipulation.
     * @param employeeID  The unique identifier of the employee.
     */
    public Employee(FileDataService dataService, int employeeID) {
        // Initialize management modules
        this.attendanceManager = new AttendanceManager(dataService);
        this.leaveManager = new LeaveManager(dataService, dataService);
        this.employeeManager = new EmployeeManager(dataService);
        this.payrollManager = new PayrollManager(dataService, employeeManager, attendanceManager);

        // Generate IDs
        this.employeeID = employeeID;
        this.attendanceID = ID_Generator.generateAttendanceID(employeeID);
        this.leaveID = ID_Generator.generateLeaveID(employeeID);
    }

    //Getters

    /**
     * Retrieves the employee's ID.
     *
     * @return The employee's ID.
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Retrieves the attendance ID associated with the employee.
     *
     * @return The attendance ID associated with the employee.
     */
    public String getAttendanceID() {
        return attendanceID;
    }

    /**
     * Retrieves the leave ID associated with the employee.
     *
     * @return The leave ID associated with the employee.
     */
    public String getLeaveID() {
        return leaveID;
    }

    /**
     * Retrieves the personal record of the employee.
     *
     * @return The personal record of the employee.
     */
    public EmployeeRecord getPersonalRecord() {
        return employeeManager.getEmployeeRecord(employeeID);
    }

    /**
     * Retrieves a list of personal attendance records of the employee.
     *
     * @return A list of personal attendance records of the employee.
     */
    public List<AttendanceRecord> getPersonalAttendanceRecordList() {
        return attendanceManager.getAttendanceRecord_List(employeeID);
    }

    /**
     * Retrieves a list of personal leave records of the employee.
     *
     * @return A list of personal leave records of the employee.
     */
    public List<LeaveRecord> getPersonalLeaveRecordList() {
        return leaveManager.getLeaveRecord_List(employeeID);
    }

    /**
     * Retrieves the leave balance of the specified type for the employee.
     *
     * @param leaveType The type of leave.
     * @return The leave balance of the specified type for the employee.
     */
    public int getLeaveBalance_OfType(String leaveType) {
        return leaveManager.getLeaveBalance_OfType(employeeID, leaveType);
    }

    /**
     * Retrieves the leave balance record of the employee.
     *
     * @return The leave balance record of the employee.
     */
    public LeaveBalanceRecord getLeaveBalance() {
        return leaveManager.getLeaveBalanceRecord(employeeID);
    }

    /**
     * Retrieves the payslip of the employee for the specified year and month.
     *
     * @param period  The period for which the payslip is requested.
     * @param month   The month for which the payslip is requested.
     * @param employeeID The unique identifier of the employee.
     * @return The payslip of the employee for the specified year and month.
     */
    public PayrollRecord getPayslip(String period, int month, int employeeID) {
        return payrollManager.getPayrollRecord(employeeID, month, period);
    }

    //Methods

    /**
     * Logs the employee's time in.
     *
     * @throws AttendanceException      If an error occurs during attendance logging.
     * @throws EmployeeRecordsException If an error occurs while accessing employee records.
     */
    public void clockIn() throws AttendanceException, EmployeeRecordsException {
        attendanceManager.logTimeIn(employeeID, getPersonalRecord());
    }

    /**
     * Logs the employee's time out.
     *
     * @throws AttendanceException If an error occurs during attendance logging.
     */
    public void clockOut() throws AttendanceException {
        attendanceManager.logTimeOut(attendanceID);
    }

    /**
     * Submits a leave request for the employee.
     *
     * @param leaveRecord The leave record to be submitted.
     * @throws LeaveException If an error occurs while processing the leave request.
     */
    public void submitLeaveRequest(LeaveRecord leaveRecord) throws LeaveException {
        leaveManager.addLeaveRecord(leaveRecord, getLeaveBalance());
    }
}