package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.DataHandlingModule.*;
import com.mmdc_group10_oop.service.actions.interfaces.AttendanceManagement;
import com.mmdc_group10_oop.service.actions.interfaces.LeaveManagement;
import com.mmdc_group10_oop.service.actions.interfaces.PayslipManagement;
import com.mmdc_group10_oop.service.actions.interfaces.ProfileManagement;
import com.mmdc_group10_oop.ui.*;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Employee implements ProfileManagement, AttendanceManagement, LeaveManagement, PayslipManagement {
    int employeeID;
    String firstName;
    String lastName;
    protected PayrollInformation payrollInfo;
    protected EmployeeProfile personalInfo;
    protected EmploymentInformation employmentInfo;
    protected List<LeaveRecord> leaveRequests;
    protected List<AttendanceRecord> attendanceRecords;
    protected Payslip payslip;
    protected LeaveBalance leaveBalance;
    protected final EmployeeUI ui;

    protected final myProfilePanel profilePanel;
    protected final attendancePanel attendancePanel;

    protected final myPayslipPanel payslipPanel;
    protected final leavePanel leavePanel;
    public Employee(int employeeID, EmployeeUI ui) throws IOException, CsvException {
        this.employeeID = employeeID;
        this.ui = ui;

        personalInfo = new EmployeeProfile(employeeID);
        employmentInfo = new EmploymentInformation(employeeID);
        payrollInfo = new PayrollInformation(employeeID);


        profilePanel = ui.empProfilePanel;
        attendancePanel = ui.empAttendancePanel;
        payslipPanel = ui.empPayslipPanel;
        leavePanel = ui.empLeavePanel;


    }

    public PayrollInformation payrollInfo() {
        return payrollInfo;
    }

    public void setPayrollInfo(PayrollInformation payrollInfo) {
        this.payrollInfo = payrollInfo;
    }

    public EmployeeProfile personalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(EmployeeProfile personalInfo) {
        this.personalInfo = personalInfo;
    }

    public EmploymentInformation employmentInfo() {
        return employmentInfo;
    }

    public void setEmploymentInfo(EmploymentInformation employmentInfo) {
        this.employmentInfo = employmentInfo;
    }


    public void displayProfile() {
        //Employee Profile
        profilePanel.nameTxtField.setText(personalInfo().firstName() + " " + personalInfo().lastName());
        profilePanel.birthdayTxtField.setText(personalInfo().dob());
        profilePanel.phoneNoTxtField.setText(personalInfo().phoneNum());
        profilePanel.addressTxtArea.setText(personalInfo().address());

        //Employment
        profilePanel.empIDTxtField.setText(String.valueOf(employmentInfo().employeeID()));
        profilePanel.departmentTxtField.setText(employmentInfo().department());
        profilePanel.positionTxtField.setText(employmentInfo().position());
        profilePanel.supervisoTxtField.setText(String.valueOf(employmentInfo().supervisor()));
        profilePanel.statusTxtField.setText(employmentInfo().status());

        //Payroll
        profilePanel.basicSalaryTxtField.setText(String.valueOf(payrollInfo().basicSalary()));
        profilePanel.hourlyRateTxtField.setText(String.valueOf(payrollInfo().hourlyRate()));
        profilePanel.semiMonthlyTxtField.setText(String.valueOf(payrollInfo().semiMonthlyRate()));

        //Allowances
        profilePanel.riceSubsidyTxtField.setText(String.valueOf(payrollInfo().riceSubsidy()));
        profilePanel.phoneAllowanceTxtField.setText(String.valueOf(payrollInfo().phoneAllowance()));
        profilePanel.clothingAllowanceTxtField.setText(String.valueOf(payrollInfo().clothingAllowance()));

        //Deductions
        profilePanel.sssNoTextField.setText(String.valueOf(payrollInfo().sssNo()));
        profilePanel.philhealthNoTxtField.setText(String.valueOf(payrollInfo().philHealthNo()));
        profilePanel.pagibigNoTxtField.setText(String.valueOf(payrollInfo().pagIbigNo()));
        profilePanel.tinNoTxtField.setText(String.valueOf(payrollInfo().tinNo()));
        // Set other UI components using model data
    }

    @Override
    public void clockIn() {

    }

    @Override
    public void clockOut() {

    }

    @Override
    public void displayAttendanceRecord(JTable table) {

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
