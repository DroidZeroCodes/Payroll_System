package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.*;
import com.mmdc_group10_oop.service.actions.interfaces.AttendanceManagement;
import com.mmdc_group10_oop.service.actions.interfaces.LeaveManagement;
import com.mmdc_group10_oop.service.actions.interfaces.PayslipManagement;
import com.mmdc_group10_oop.service.actions.interfaces.ProfileManagement;
import com.mmdc_group10_oop.ui.employeeUI.*;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Employee implements ProfileManagement, AttendanceManagement, LeaveManagement, PayslipManagement {
    int employeeID;
    String firstName;
    String lastName;
    protected EmployeeRecord personalInfo;
    protected List<String[]> leaveRequests;
    protected List<String[]> attendanceRecords;
    protected PayrollRecords payslip;
    protected LeaveBalance leaveBalance;
    protected MyProfilePanel profilePage;
    protected AttendancePanel attendancePage;
    protected MyPayslipPanel payslipPage;
    protected LeavePanel leavePage;

    protected EmployeeUI ui;

    public Employee(int employeeID, EmployeeUI ui) throws IOException, CsvException {
        this.employeeID = employeeID;

        //Initialize employeeUI, Details, and Records
        if (ui != null) {
            this.ui = ui;
            initDetails();
            initComponents();
        }
    }

    protected void initDetails() throws IOException, CsvException {
        //Initialize employeeUI's Details and Records
        this.personalInfo = new EmployeeRecord(employeeID);
        this.attendanceRecords = new AttendanceRecord(employeeID).retrieveAllPersonalRecord();
    }
    protected void initComponents(){
        profilePage = this.ui.empProfilePanel();
        attendancePage = this.ui.empAttendancePanel();
        payslipPage = this.ui.empPayslipPanel();
        leavePage = this.ui.empLeavePanel();
    }

    /**
     * Display Employee profile information on the UI components.
     *
     */
    public void displayProfile() {
        //Employee Profile
        profilePage.nameTxtField().setText(personalInfo.firstName() + " " + personalInfo.lastName());
        profilePage.birthdayTxtField().setText(personalInfo.dob());
        profilePage.phoneNoTxtField().setText(personalInfo.phoneNum());
        profilePage.addressTxtArea().setText(personalInfo.address());

        //Employment
        profilePage.empIDTxtField().setText(String.valueOf(personalInfo.employeeID()));
        profilePage.departmentTxtField().setText(personalInfo.department());
        profilePage.positionTxtField().setText(personalInfo.position());
        profilePage.supervisoTxtField().setText(String.valueOf(personalInfo.supervisor()));
        profilePage.statusTxtField().setText(personalInfo.status());

        //Payroll
        profilePage.basicSalaryTxtField().setText(String.valueOf(personalInfo.basicSalary()));
        profilePage.hourlyRateTxtField().setText(String.valueOf(personalInfo.hourlyRate()));
        profilePage.semiMonthlyTxtField().setText(String.valueOf(personalInfo.semiMonthlyRate()));

        //Allowances
        profilePage.riceSubsidyTxtField().setText(String.valueOf(personalInfo.riceSubsidy()));
        profilePage.phoneAllowanceTxtField().setText(String.valueOf(personalInfo.phoneAllowance()));
        profilePage.clothingAllowanceTxtField().setText(String.valueOf(personalInfo.clothingAllowance()));

        //Deductions
        profilePage.sssNoTextField().setText(String.valueOf(personalInfo.sssNo()));
        profilePage.philhealthNoTxtField().setText(String.valueOf(personalInfo.philHealthNo()));
        profilePage.pagibigNoTxtField().setText(String.valueOf(personalInfo.pagIbigNo()));
        profilePage.tinNoTxtField().setText(String.valueOf(personalInfo.tinNo()));
    }

    @Override
    public void clockIn() throws CsvValidationException, IOException {
        LocalDate today = LocalDate.now();
        LocalTime timeIN = LocalTime.now();

        AttendanceRecord newRecord = new AttendanceRecord(employeeID);

//        if (attendanceR)

        newRecord.setDate(null);
        newRecord.setEmployeeID(employeeID);

        displayAttendanceRecord();
    }

    @Override
    public void clockOut() {
        //TODO: @Ibra

    }

    @Override
    public void displayAttendanceRecord() {
        //Hide employee Number
        var attendanceTable = attendancePage.attendanceTable();
        var idColumn = attendanceTable.getColumnModel().getColumn(1);
        var firstNameColumn = attendanceTable.getColumnModel().getColumn(2);
        var lastNameColumn = attendanceTable.getColumnModel().getColumn(3);

        attendanceTable.removeColumn(idColumn);
        attendanceTable.removeColumn(firstNameColumn);
        attendanceTable.removeColumn(lastNameColumn);

        for (String[] record : attendanceRecords){
            attendancePage.attendanceTableModel().addRow(record);
        }
    }

    @Override
    public void displayLeaveBalance() {

    }

    @Override
    public void submitLeaveRequest() {

    }

    @Override
    public void displayLeaveStatus() {

    }

    @Override
    public void displayPayslip() {

    }
}
