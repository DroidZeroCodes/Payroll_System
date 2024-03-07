package user;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveBalanceRecord;
import data.LeaveRecord;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import interfaces.EmployeeManagement;
import service.FileDataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HRAdmin extends Employee implements EmployeeManagement {
    private List<EmployeeRecord> employeeList;
    private List<LeaveRecord> allLeaveHistory;
    private List<AttendanceRecord> allAttendanceRecords;
    private List<Integer> employeeIDList;

    public HRAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        try {
            this.employeeList = employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            this.employeeList = new ArrayList<>();
            System.err.println("Employee record not found");
        }

        try {
            this.allLeaveHistory = leaveDataService.getAllLeaveRecords();
        } catch (Exception e) {
            this.allLeaveHistory = new ArrayList<>();
            System.err.println("Leave record not found");
        }

        try {
            this.allAttendanceRecords = attendanceDataService.getAllAttendanceRecords();
        } catch (Exception e) {
            this.allAttendanceRecords = new ArrayList<>();
            System.err.println("Attendance record not found");
        }

        try {
            this.employeeIDList = List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            this.employeeIDList = List.of(new Integer[0]);
            System.err.println("Employee ID list not found");
        }
    }

    public String getNewEmployeeID() {
        return employeeIDList.get(employeeIDList.size() - 1) + 1 + "";
    }


//    public LeaveRecord retrieveleaveRecord(String leaveID){
//    }

    //Getters
    public List<EmployeeRecord> getEmployeeList() {
        return employeeList;
    }

    public List<LeaveRecord> getAllLeaveHistory() {
        return allLeaveHistory;
    }

    public List<AttendanceRecord> getAllAttendanceRecords() {
        return allAttendanceRecords;
    }

    public List<Integer> getEmployeeIDList() {
        return employeeIDList;
    }

    @Override
    public void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException {
        System.out.println("Adding employee: " + newRecord);

        if (employeeList.contains(newRecord)) {
            EmployeeRecordsException.throwError_DUPLICATE_RECORD();
            return;
        }

        //Add on database
        employeeDataService.addEmployeeRecord(newRecord);
        //Add on display
        employeeList.add(newRecord);

        System.out.println("Employee added successfully");
    }

    @Override
    public void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException {
        System.out.println("Updating employee: " + updatedRecord);

        if (employeeList.contains(updatedRecord)) {
            EmployeeRecordsException.throwError_NO_CHANGE();
            return;
        }

        try {
            //update display
            for (int i = 0; i < employeeList.size(); i++) {
                EmployeeRecord record = employeeList.get(i);
                if (record.employeeID() == updatedRecord.employeeID()) {
                    employeeList.set(i, updatedRecord);
                }
            }

            //update database
            employeeDataService.updateEmployeeRecord(updatedRecord);
        } catch (Exception e) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
        }

        System.out.println("Employee details updated successfully");
    }

    public void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException {
        System.out.println("Terminating employee: " + selectedEmployee);

        if (!employeeList.contains(selectedEmployee)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        //Terminate on database
        employeeDataService.deleteEmployeeRecord(selectedEmployee);

        //Terminate on display
        employeeList.remove(selectedEmployee);

        System.out.println("Employee terminated successfully");
    }

    public LeaveRecord getEmployeeLeaveRecord(String leaveID) throws LeaveException {
        for (LeaveRecord record : allLeaveHistory) {
            if (record.leaveID().equals(leaveID)) {
                return record;
            }
        }
        LeaveException.throwError_NO_RECORD_FOUND();
        return null;
    }

    public void approveLeave(String leaveID) throws LeaveException {
        LeaveRecord leaveRecord = getEmployeeLeaveRecord(leaveID).withStatus(LeaveRecord.LEAVE_STATUS.APPROVED);

        updateLeaveRecord(leaveRecord);
    }

    public void rejectLeave(String leaveID, String leaveType, int employeeID, int duration) throws LeaveException {
        LeaveRecord leaveRecord = getEmployeeLeaveRecord(leaveID).withStatus(LeaveRecord.LEAVE_STATUS.REJECTED);
        LeaveBalanceRecord leaveBalanceRecord = getEmployeeLeaveBalance(employeeID);

        updateLeaveRecord(leaveRecord);
        updateLeaveBalance(
                switch (leaveType) {
                    case "SICK" -> leaveBalanceRecord.withSickBalance(leaveBalanceRecord.sickBalance() + duration);
                    case "VACATION" ->
                            leaveBalanceRecord.withVacationBalance(leaveBalanceRecord.vacationBalance() + duration);
                    case "PATERNAL" ->
                            leaveBalanceRecord.withPaternalBalance(leaveBalanceRecord.paternalBalance() + duration);
                    case "BEREAVEMENT" ->
                            leaveBalanceRecord.withBereavementBalance(leaveBalanceRecord.bereavementBalance() + duration);
                    default -> throw new IllegalStateException("Unexpected value: " + leaveType);
                }
        );
    }

    private LeaveBalanceRecord getEmployeeLeaveBalance(int employeeID) {
        return leaveBalanceDataService.getLeaveBalance_ByEmployeeID(employeeID);
    }

    private void updateLeaveRecord(LeaveRecord leaveRecord) {
        leaveDataService.updateLeaveRecord(leaveRecord);

        //update display
        for (int i = 0; i < allLeaveHistory.size(); i++) {
            LeaveRecord record = allLeaveHistory.get(i);
            if (Objects.equals(record.leaveID(), leaveRecord.leaveID())) {
                allLeaveHistory.set(i, leaveRecord);
            }
        }
    }
}

