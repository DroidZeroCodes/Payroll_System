package user;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveRecord;
import interfaces.EmployeeManagement;
import service.FileDataService;

import java.util.List;

public class HRAdmin extends Employee implements EmployeeManagement {
    private final List<EmployeeRecord> allEmployees;
    private final List<LeaveRecord> allLeaveHistory;
    private final List<AttendanceRecord> allAttendanceRecords;
    private final Integer[] employeeIDList;
    public HRAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);
        this.allEmployees = employeeDataService.getAllEmployees();
        this.allLeaveHistory = leaveDataService.getAllLeaveRecords();
        this.allAttendanceRecords = attendanceDataService.getAllAttendanceRecords();
        this.employeeIDList = employeeDataService.getEmployeeIDList();
    }
    public List<EmployeeRecord> getAllEmployees() {
        return allEmployees;
    }
    public List<LeaveRecord> getAllLeaveHistory() {
        return allLeaveHistory;
    }
    public List<AttendanceRecord> getAllAttendanceRecords() {
        return allAttendanceRecords;
    }
    public Integer[] getEmployeeIDList() {
        return employeeIDList;
    }

    @Override
    public void addEmployee(EmployeeRecord newRecord) {
        employeeDataService.addEmployeeRecord(newRecord);
    }

    @Override
    public void updateEmployee(EmployeeRecord newRecord) {
        employeeDataService.updateEmployeeRecord(newRecord);
    }
}

