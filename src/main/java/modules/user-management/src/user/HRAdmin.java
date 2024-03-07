package user;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveBalanceRecord;
import data.LeaveRecord;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import interfaces.EmployeeManagement;
import service.FileDataService;

import java.util.List;
import java.util.Objects;

public class HRAdmin extends Employee implements EmployeeManagement {
    public HRAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);
    }

    public String getNewEmployeeID() {
        return getEmployeeIDList().get(getEmployeeList().size() - 1) + 1 + "";
    }


//    public LeaveRecord retrieveleaveRecord(String leaveID){
//    }

    //Getters
    public List<EmployeeRecord> getEmployeeList() {
        try {
            return employeeDataService.getAll_Active_Employees();
        } catch (Exception e) {
            System.err.println("Employee record not found" + e);
            return null;
        }
    }

    public List<LeaveRecord> getAllLeaveHistory() {
        try {
            return leaveDataService.getAllLeaveRecords();
        } catch (Exception e) {
            System.err.println("Leave record not found" + e);
            return null;
        }
    }

    public List<AttendanceRecord> getAllAttendanceRecords() {
        try {
            return attendanceDataService.getAllAttendanceRecords();
        } catch (Exception e) {
            System.err.println("Attendance record not found");
            return null;
        }
    }

    public List<Integer> getEmployeeIDList() {
        try {
            return List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            System.err.println("Employee ID list not found");
            return null;
        }
    }

    @Override
    public void addEmployee(EmployeeRecord newRecord) throws EmployeeRecordsException {
        System.out.println("Adding employee: " + newRecord);

        if (getEmployeeList().contains(newRecord)) {
            EmployeeRecordsException.throwError_DUPLICATE_RECORD();
            return;
        }

        //Add on database
        employeeDataService.addEmployeeRecord(newRecord);

        System.out.println("Employee added successfully");
    }

    @Override
    public void updateEmployee(EmployeeRecord updatedRecord) throws EmployeeRecordsException {
        System.out.println("Updating employee: " + updatedRecord);

        if (getEmployeeList().contains(updatedRecord)) {
            EmployeeRecordsException.throwError_NO_CHANGE();
            return;
        }

        try {

            //update database
            employeeDataService.updateEmployeeRecord(updatedRecord);
        } catch (Exception e) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
        }

        System.out.println("Employee details updated successfully");
    }

    public void terminateEmployee(EmployeeRecord selectedEmployee) throws EmployeeRecordsException {
        System.out.println("Terminating employee: " + selectedEmployee);

        if (!getEmployeeList().contains(selectedEmployee)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        //Terminate on database
        employeeDataService.deleteEmployeeRecord(selectedEmployee);

        System.out.println("Employee terminated successfully");
    }

    public LeaveRecord getEmployeeLeaveRecord(String leaveID) throws LeaveException {
        for (LeaveRecord record : getAllLeaveHistory()) {
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
        leaveBalanceDataService.updateLeaveBalance(
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

        List<LeaveRecord> leaveRecords = getAllLeaveHistory(); //get all leave records>

        //update display
        for (int i = 0; i < leaveRecords.size(); i++) {
            LeaveRecord record = leaveRecords.get(i);
            if (Objects.equals(record.leaveID(), leaveRecord.leaveID())) {
                leaveRecords.set(i, leaveRecord);
            }
        }
    }
}

