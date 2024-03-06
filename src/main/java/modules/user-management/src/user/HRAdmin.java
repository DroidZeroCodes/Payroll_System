package user;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.LeaveRecord;
import exceptions.EmployeeRecordsException;
import interfaces.EmployeeManagement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import service.FileDataService;

import java.util.ArrayList;
import java.util.List;
import ui.employee.LeavePanel;
import ui.hr.LeaveInfoFrame;

public class HRAdmin extends Employee implements EmployeeManagement {
    private List<EmployeeRecord> employeeList;
    private List<LeaveRecord> allLeaveHistory;
    private List<AttendanceRecord> allAttendanceRecords;
    private List<Integer> employeeIDList;
    private LeavePanel leavePanel;
    private LeaveInfoFrame leaveInfoFrame;

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
    
    public void displayLeaveInfoFrame(){
        leavePanel.getLeaveHistoryTable().addMouseListener(new MouseAdapter(){
        
            @Override
            public void mouseClicked(MouseEvent e){
                if (e.getClickCount() == 2){
                    int selectedRow = leavePanel.getLeaveHistoryTable().getSelectedRow();
                    if (selectedRow != -1){
                        // retrieve leave info from table
                        String leaveID = leavePanel.getLeaveHistoryTable().getValueAt(selectedRow, 0).toString();
                        String requestDate = leavePanel.getLeaveHistoryTable().getValueAt(selectedRow, 1).toString();
                        String startDate = leavePanel.getLeaveHistoryTable().getValueAt(selectedRow, 2).toString();
                        String endDate = leavePanel.getLeaveHistoryTable().getValueAt(selectedRow, 3).toString();
                        String status = leavePanel.getLeaveHistoryTable().getValueAt(selectedRow, 4).toString();
                        String type = leavePanel.getLeaveHistoryTable().getValueAt(selectedRow, 5).toString();
                        
                        leaveInfoFrame.getLeaveIDTxtField().setText(leaveID);
                        leaveInfoFrame.getRequestDateTxtField().setText(requestDate);
                        leaveInfoFrame.getStartDateTxtField().setText(startDate);
                        leaveInfoFrame.getEndDateTxtField().setText(endDate);
                        leaveInfoFrame.getStatusTxtField().setText(status);
                        leaveInfoFrame.getTypeTxtField().setText(type);
                        leaveInfoFrame.setVisible(true);
                    }
                }
            }
        });
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
}

