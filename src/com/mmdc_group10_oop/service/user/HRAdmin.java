package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.AttendanceRecord;
import com.mmdc_group10_oop.dataHandlingModule.EmployeeRecord;
import com.mmdc_group10_oop.ui.hrAdminUI.HRAdminUI;
import com.mmdc_group10_oop.ui.hrAdminUI.ManageEmpPanel;
import com.mmdc_group10_oop.ui.hrAdminUI.ProfileManagementPanel;

import java.util.List;

public class HRAdmin extends Employee {
    List <String[]> allEmployees;
    List <String[]> allLeaveRequests;
    List <String[]> allAttendanceRecords;
    ManageEmpPanel mngEmpPage;
    ProfileManagementPanel profileMngPage;
    HRAdminUI ui;
    public HRAdmin(int employeeID, HRAdminUI ui) {
        super(employeeID, null);
        this.ui = ui;
        initDetails();
        initComponents();
    }
    //Overloaded methods
    @Override
    protected void initDetails() {
        super.initDetails();
        allAttendanceRecords =  new AttendanceRecord(employeeID).retrieveAllRecords();
        allEmployees = new EmployeeRecord().retrieveAllRecords();
    }

    @Override
    protected void initComponents() {
        myProfilePage = ui.empProfilePanel();
        attendancePage = ui.empAttendancePanel();
        payslipPage = ui.empPayslipPanel();
        leavePage = ui.empLeavePanel();
        mngEmpPage = ui.manageEmpPanel();
        profileMngPage = ui.profileManagementPanel();
    }

    /**
     *
     */
    @Override
    public void displayAttendanceRecord() {
        for (String[] record : allAttendanceRecords){
            attendancePage.attendanceTableModel().addRow(record);
        }
    }

    public void displayEmployeeList(){
        for (String[] record : allEmployees){
            mngEmpPage.empRecordTableModel().addRow(record);
        }
    }
}
