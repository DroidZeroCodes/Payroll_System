package users;

import data.*;
import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import interfaces.AttendanceManagement;
import interfaces.EmployeeManagement;
import interfaces.LeaveManagement;
import interfaces.PayrollManagement;
import service.*;
import util.ID_Generator;

import java.time.YearMonth;
import java.util.List;

public class Employee {
    private int employeeID;
    private String attendanceID;
    private String leaveID;
    private String payrollID;

    // Features Managers
    private AttendanceManagement attendanceManager;
    private LeaveManagement leaveManager;
    private PayrollManagement payrollManager;
    private EmployeeManagement employeeManager;

    public Employee(FileDataService dataService, int employeeID) {
        // Initialize modules
        this.attendanceManager = new AttendanceManager(dataService);
        this.leaveManager = new LeaveManager(dataService, dataService);
        this.employeeManager = new EmployeeManager(dataService);
        this.payrollManager = new PayrollManager(dataService, employeeManager, attendanceManager);

        // Generate IDs
        this.employeeID = employeeID;
        this.attendanceID = ID_Generator.generateAttendanceID(employeeID);
        this.leaveID = ID_Generator.generateLeaveID(employeeID);
        this.payrollID = ID_Generator.generatePayrollID(employeeID);
    }


    //Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getAttendanceID() {
        return attendanceID;
    }

    public String getLeaveID() {
        return leaveID;
    }

    public String getPayrollID() {
        return payrollID;
    }

    public EmployeeRecord getPersonalRecord() throws EmployeeRecordsException {
        return employeeManager.getEmployeeRecord(employeeID);
    }

    public List<AttendanceRecord> getPersonalAttendanceRecordList() {
        return attendanceManager.getAttendanceRecord_List(employeeID);
    }

    public List<LeaveRecord> getPersonalLeaveRecordList() {
        return leaveManager.getLeaveRecord_List(employeeID);
    }

    public int getLeaveBalance_OfType(String leaveType) {
        return leaveManager.getLeaveBalance_OfType(employeeID, leaveType);
    }

    public LeaveBalanceRecord getLeaveBalance() {
        return leaveManager.getLeaveBalanceRecord(employeeID);
    }

    public PayrollRecords getPayslip(YearMonth yearMonth, int employeeID) {
        return payrollManager.getPayrollRecord(employeeID, yearMonth);
    }

    //Methods
    public void clockIn() throws AttendanceException, EmployeeRecordsException {
        attendanceManager.logTimeIn(employeeID, getPersonalRecord());
    }

    public void clockOut() throws AttendanceException {
        attendanceManager.logTimeOut(attendanceID);
    }

    public void submitLeaveRequest(LeaveRecord leaveRecord) throws LeaveException {
        leaveManager.addLeaveRecord(leaveRecord, getLeaveBalance());
    }
}

