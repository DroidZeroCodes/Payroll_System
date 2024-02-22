package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.AttendanceRecord;
import com.mmdc_group10_oop.ui.HRAdminUI.HRAdminUI;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class HRAdmin extends Employee {
    List <String[]> allEmployees;
    List <String[]> allLeaveRequests;
    List <String[]> allAttendanceRecords;
    HRAdminUI ui;
    public HRAdmin(int employeeID, HRAdminUI ui) throws IOException, CsvException {
        super(employeeID, null);
        this.ui = ui;
        initDetails();
        initComponents();
    }
    //Overloaded methods
    @Override
    protected void initDetails() throws IOException, CsvException {
        super.initDetails();
        allAttendanceRecords =  new AttendanceRecord(employeeID).retrieveAllRecords();
    }

    @Override
    protected void initComponents() {
        profilePage = ui.empProfilePanel();
        attendancePage = ui.empAttendancePanel();
        payslipPage = ui.empPayslipPanel();
        leavePage = ui.empLeavePanel();
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
}
