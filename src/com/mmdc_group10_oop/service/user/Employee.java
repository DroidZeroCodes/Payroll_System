package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.*;
import com.mmdc_group10_oop.service.actions.interfaces.AttendanceManagement;
import com.mmdc_group10_oop.service.actions.interfaces.LeaveManagement;
import com.mmdc_group10_oop.service.actions.interfaces.PayslipManagement;
import com.mmdc_group10_oop.service.actions.interfaces.ProfileManagement;
import com.mmdc_group10_oop.ui.employee.*;
import com.opencsv.exceptions.CsvException;

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

    public Employee(int employeeID) throws IOException, CsvException {
        this.employeeID = employeeID;

        //Initialize employee's Details and Records
        personalInfo = new EmployeeProfile(employeeID);
        employmentInfo = new EmploymentInformation(employeeID);
        payrollInfo = new PayrollInformation(employeeID);
    }


    /**
     * Display employee profile information on the UI components.
     *
     */
    public void displayProfile(MyProfilePanel panel) {
        if (panel == null){
            System.out.println("No panels found");
            return;
        }

        //employee Profile
        panel.nameTxtField.setText(personalInfo.firstName() + " " + personalInfo.lastName());
        panel.birthdayTxtField.setText(personalInfo.dob());
        panel.phoneNoTxtField.setText(personalInfo.phoneNum());
        panel.addressTxtArea.setText(personalInfo.address());

        //Employment
        panel.empIDTxtField.setText(String.valueOf(employmentInfo.employeeID()));
        panel.departmentTxtField.setText(employmentInfo.department());
        panel.positionTxtField.setText(employmentInfo.position());
        panel.supervisoTxtField.setText(String.valueOf(employmentInfo.supervisor()));
        panel.statusTxtField.setText(employmentInfo.status());

        //Payroll
        panel.basicSalaryTxtField.setText(String.valueOf(payrollInfo.basicSalary()));
        panel.hourlyRateTxtField.setText(String.valueOf(payrollInfo.hourlyRate()));
        panel.semiMonthlyTxtField.setText(String.valueOf(payrollInfo.semiMonthlyRate()));

        //Allowances
        panel.riceSubsidyTxtField.setText(String.valueOf(payrollInfo.riceSubsidy()));
        panel.phoneAllowanceTxtField.setText(String.valueOf(payrollInfo.phoneAllowance()));
        panel.clothingAllowanceTxtField.setText(String.valueOf(payrollInfo.clothingAllowance()));

        //Deductions
        panel.sssNoTextField.setText(String.valueOf(payrollInfo.sssNo()));
        panel.philhealthNoTxtField.setText(String.valueOf(payrollInfo.philHealthNo()));
        panel.pagibigNoTxtField.setText(String.valueOf(payrollInfo.pagIbigNo()));
        panel.tinNoTxtField.setText(String.valueOf(payrollInfo.tinNo()));
    }

    @Override
    public void clockIn() {

    }

    @Override
    public void clockOut() {

    }

    @Override
    public void displayAttendanceRecord() {

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
