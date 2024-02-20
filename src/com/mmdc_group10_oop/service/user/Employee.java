package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.DataHandlingModule.*;
import com.mmdc_group10_oop.ui.EmployeeUI;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Employee implements ProfileManagement, AttendanceManagement, LeaveManagement, PayslipManagement {
    int employeeID;
    String firstName;
    String lastName;
    private PayrollInformation payrollInfo;
    private EmployeeProfile personalInfo;
    private EmploymentInformation employmentInfo;
    private List<LeaveRecord> leaveRequests;
    private List<AttendanceRecord> attendanceRecords;
    private Payslip payslip;
    private LeaveBalance leaveBalance;
    public Employee(int employeeID) throws IOException, CsvException {
        this.employeeID = employeeID;

        personalInfo = new EmployeeProfile(employeeID);
        employmentInfo = new EmploymentInformation(employeeID);
        payrollInfo = new PayrollInformation(employeeID);
    }

    @Override
    public void viewProfile(EmployeeUI employeeUI) {
        employeeUI.empIDTxtField.setText(String.valueOf(employeeID));

    }

    @Override
    public void changePersonalInfo() {

    }

    @Override
    public void clockIn() {

    }

    @Override
    public void clockOut() {

    }
    @Override
    public void viewAttendanceRecord(JTable table) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.setRowCount(0); // Clear existing rows
//
//        // Populate table with profile records
//        for (AttendanceRecord record : employee.getAttendanceRecords()) {
//            Object[] rowData = {
//                    record.date().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
//                    record.timeIn().format(DateTimeFormatter.ofPattern("HH:mm")),
//                    record.timeOut().format(DateTimeFormatter.ofPattern("HH:mm")),
//                    record.overTime(),
//                    record.totalHours()
//            };
//            model.addRow(rowData);
//        }
    }
    @Override
    public void viewLeaveBalance() {

    }
    @Override
    public void submitLeaveRequest() {

    }

    @Override
    public void viewLeaveStatus() {

    }

    @Override
    public void viewPayslip() {

    }
}
