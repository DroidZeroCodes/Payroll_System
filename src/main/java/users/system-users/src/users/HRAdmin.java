package users;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveRecord;
import exceptions.EmployeeRecordsException;
import interfaces.AttendanceManagement;
import interfaces.EmployeeManagement;
import interfaces.LeaveManagement;
import service.AttendanceManager;
import service.EmployeeManager;
import service.FileDataService;
import service.LeaveManager;

import java.util.List;

public class HRAdmin extends Employee {
    private AttendanceManagement attendanceManager;
    private LeaveManagement leaveManager;
    private EmployeeManagement employeeManager;

    public HRAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        attendanceManager = new AttendanceManager(dataService);
        leaveManager = new LeaveManager(dataService, dataService);
        employeeManager = new EmployeeManager(dataService);
    }

    public String getNewEmployeeID() {
        return getEmployeeIDList().get(getEmployeeList().size() - 1) + 1 + "";
    }

    //Getters
    public List<EmployeeRecord> getEmployeeList() {
        return employeeManager.getEmployeeList();
    }

    public List<Integer> getEmployeeIDList() {
        return employeeManager.getEmployeeIDList();
    }

    public List<AttendanceRecord> getAllAttendanceRecords() {
        return attendanceManager.getAllAttendanceRecords();
    }

    public List<LeaveRecord> getAllLeaveRecords() {
        return leaveManager.getAllLeaveRecords();
    }

    public LeaveRecord getEmployeeLeaveRecord(String leaveID) {
        return leaveManager.getLeaveRecord(leaveID);
    }

    public EmployeeRecord getEmployeeRecord(int employeeID) {
        return employeeManager.getEmployeeRecord(employeeID);
    }


    //Methods
    public void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException {
        employeeManager.addEmployee(newRecord);
    }

    public void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException {
        employeeManager.updateEmployee(updatedRecord);
    }

    public void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException {
        employeeManager.terminateEmployee(selectedEmployee);
    }

    public void approveLeave(String leaveID) {
        leaveManager.approveLeave(leaveID);
    }

    public void rejectLeave(String leaveID, int employeeID, String leaveType, int duration) {
        leaveManager.rejectLeave(leaveID, employeeID, leaveType, duration);
    }
}

