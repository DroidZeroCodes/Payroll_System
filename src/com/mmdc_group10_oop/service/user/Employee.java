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
    protected PayrollInformation payrollInfo;
    protected EmployeeProfile personalInfo;
    protected EmploymentInformation employmentInfo;
    protected List<String[]> leaveRequests;
    protected List<String[]> attendanceRecords;
    protected Payslip payslip;
    protected LeaveBalance leaveBalance;
    protected MyProfilePanel profilePage;
    protected AttendancePanel attendancePage;
    protected MyPayslipPanel payslipPage;
    protected LeavePanel leavePage;

    public Employee(int employeeID, EmployeeUI ui) throws IOException, CsvException {
        this.employeeID = employeeID;

        //Initialize employeeUI's Details and Records
        initDetails();

        if (ui != null){
            profilePage = ui.empProfilePanel;
            attendancePage = ui.empAttendancePanel;
            payslipPage = ui.empPayslipPanel;
            leavePage = ui.empLeavePanel;
        }
    }

    private void initDetails() throws IOException, CsvException {
        //Initialize employeeUI's Details and Records
        this.personalInfo = new EmployeeProfile(employeeID);
        this.employmentInfo = new EmploymentInformation(employeeID);
        this.payrollInfo = new PayrollInformation(employeeID);
        this.attendanceRecords = new AttendanceRecord(employeeID).retrieveAllPersonalRecord();

    }

    /**
     * Display employeeUI profile information on the UI components.
     *
     */
    public void displayProfile() {

        //employeeUI Profile
        profilePage.nameTxtField.setText(personalInfo.firstName() + " " + personalInfo.lastName());
        profilePage.birthdayTxtField.setText(personalInfo.dob());
        profilePage.phoneNoTxtField.setText(personalInfo.phoneNum());
        profilePage.addressTxtArea.setText(personalInfo.address());

        //Employment
        profilePage.empIDTxtField.setText(String.valueOf(employmentInfo.employeeID()));
        profilePage.departmentTxtField.setText(employmentInfo.department());
        profilePage.positionTxtField.setText(employmentInfo.position());
        profilePage.supervisoTxtField.setText(String.valueOf(employmentInfo.supervisor()));
        profilePage.statusTxtField.setText(employmentInfo.status());

        //Payroll
        profilePage.basicSalaryTxtField.setText(String.valueOf(payrollInfo.basicSalary()));
        profilePage.hourlyRateTxtField.setText(String.valueOf(payrollInfo.hourlyRate()));
        profilePage.semiMonthlyTxtField.setText(String.valueOf(payrollInfo.semiMonthlyRate()));

        //Allowances
        profilePage.riceSubsidyTxtField.setText(String.valueOf(payrollInfo.riceSubsidy()));
        profilePage.phoneAllowanceTxtField.setText(String.valueOf(payrollInfo.phoneAllowance()));
        profilePage.clothingAllowanceTxtField.setText(String.valueOf(payrollInfo.clothingAllowance()));

        //Deductions
        profilePage.sssNoTextField.setText(String.valueOf(payrollInfo.sssNo()));
        profilePage.philhealthNoTxtField.setText(String.valueOf(payrollInfo.philHealthNo()));
        profilePage.pagibigNoTxtField.setText(String.valueOf(payrollInfo.pagIbigNo()));
        profilePage.tinNoTxtField.setText(String.valueOf(payrollInfo.tinNo()));
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

    }

    @Override
    public void displayAttendanceRecord() {

        for (String[] record : attendanceRecords){
            attendancePage.attendanceTable.addRow(record);
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
