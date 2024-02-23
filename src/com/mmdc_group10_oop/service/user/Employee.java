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
    protected boolean attendanceColumnsRemoved = false;

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
        this.payslip = new PayrollRecords(employeeID);
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
        if (!attendanceColumnsRemoved) {
            //Hide employee Number
            var attendanceTable = attendancePage.attendanceTable();
            var idColumn = attendanceTable.getColumnModel().getColumn(1);
            var firstNameColumn = attendanceTable.getColumnModel().getColumn(2);
            var lastNameColumn = attendanceTable.getColumnModel().getColumn(3);

            attendanceTable.removeColumn(idColumn);
            attendanceTable.removeColumn(firstNameColumn);
            attendanceTable.removeColumn(lastNameColumn);

            attendanceColumnsRemoved = true; // Update the flag to indicate that columns have been removed
        }

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
        var payslipArea = payslipPage.payslipTxtArea();

        String payslipNo = payslip.payslipNo();
        String employeeName = payslip.employeeName();
        String periodStart = payslip.periodStart();
        String periodEnd = payslip.periodEnd();
        String positionDepartment = payslip.positionDepartment();
        String monthlySalary = payslip.monthlySalary();
        String dailyRate = payslip.dailyRate();
        String daysWorked = String.valueOf(payslip.daysWorked());
        String overTimePay = payslip.overTimePay();
        String riceAllowance = payslip.riceAllowance();
        String phoneAllowance = payslip.phoneAllowance();
        String clothingAllowance = payslip.clothingAllowance();
        String sssDeduction = payslip.sssDeduction();
        String philHealthDeduction = payslip.philHealthDeduction();
        String pagIbigDeduction = payslip.pagIbigDeduction();
        String taxDeduction = payslip.taxDeduction();
        String grossIncome = payslip.grossIncome();
        String totalBenefits = payslip.totalBenefits();
        String totalDeductions = payslip.totalDeductions();
        String netIncome = payslip.netIncome();


        String content = "Motor PH" + "\n".repeat(3) +
                "Payslip No: " + payslipNo + "\n" +
                "Employee ID: " + employeeID + "\n" +
                "Employee Name: " + employeeName + "\n" +
                "Period Start: " + periodStart + "\n" +
                "Period End: " + periodEnd + "\n" +
                "Position/Department: " + positionDepartment + "\n" +
                "Monthly Salary: " + monthlySalary + "\n" +
                "Daily Rate: " + dailyRate + "\n" +
                "Days Worked: " + daysWorked + "\n" +
                "Overtime Pay: " + overTimePay + "\n" +
                "Rice Allowance: " + riceAllowance + "\n" +
                "Phone Allowance: " + phoneAllowance + "\n" +
                "Clothing Allowance: " + clothingAllowance + "\n" +
                "SSS Deduction: " + sssDeduction + "\n" +
                "PhilHealth Deduction: " + philHealthDeduction + "\n" +
                "PagIbig Deduction: " + pagIbigDeduction + "\n" +
                "Tax Deduction: " + taxDeduction + "\n" +
                "Gross Income: " + grossIncome + "\n" +
                "Total Benefits: " + totalBenefits + "\n" +
                "Total Deductions: " + totalDeductions + "\n" +
                "Net Income: " + netIncome;

        payslipArea.setText(content);
    }
}
