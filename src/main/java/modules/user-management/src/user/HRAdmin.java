package user;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveRecord;
import interfaces.EmployeeManagement;
import service.FileDataService;

import java.util.ArrayList;
import java.util.List;

public class HRAdmin extends Employee implements EmployeeManagement {
    private List<EmployeeRecord> allEmployees;
    private List<LeaveRecord> allLeaveHistory;
    private List<AttendanceRecord> allAttendanceRecords;
    private Integer[] employeeIDList;
    public HRAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        try {
            this.allEmployees = employeeDataService.getAllEmployees();
        } catch (Exception e) {
            this.allEmployees = new ArrayList<>();
            System.out.println("Employee record not found");
        }

        try {
            this.allLeaveHistory = leaveDataService.getAllLeaveRecords();
        } catch (Exception e) {
            this.allLeaveHistory = new ArrayList<>();
            System.out.println("Leave record not found");
        }

        try {
            this.allAttendanceRecords = attendanceDataService.getAllAttendanceRecords();
        } catch (Exception e) {
            this.allAttendanceRecords = new ArrayList<>();
            System.out.println("Attendance record not found");
        }

        try {
            this.employeeIDList = employeeDataService.getEmployeeIDList();
        } catch (Exception e) {
            this.employeeIDList = new Integer[0];
            System.out.println("Employee ID list not found");
        }
    }

    public String getNewEmployeeID(){
        return employeeIDList[employeeIDList.length - 1] + 1 + "";
    }

    //Getters
    public List<EmployeeRecord> getAllEmployees() {
        return allEmployees;
    }
    public List<LeaveRecord> getAllLeaveHistory() {
        return allLeaveHistory;
    }
    public List<AttendanceRecord> getAllAttendanceRecords() {
        return allAttendanceRecords;
    }


    @Override
    public void addEmployee(EmployeeRecord newRecord) {
        System.out.println("Adding employee: " + newRecord);

        //Add on database
        employeeDataService.addEmployeeRecord(newRecord);

        //Add on display
        allEmployees.add(newRecord);
    }

    @Override
    public void updateEmployee(EmployeeRecord newRecord) {
        System.out.println("Updating employee: " + newRecord);

        //Update on database
        employeeDataService.updateEmployeeRecord(newRecord);

        //Update on display
        allEmployees.set(allEmployees.indexOf(newRecord), newRecord);
    }
}

