package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.*;
import com.mmdc_group10_oop.dataHandlingModule.util.Convert;
import com.mmdc_group10_oop.dataHandlingModule.util.DateTimeCalculator;
import com.mmdc_group10_oop.service.actions.ErrorMessages;
import com.mmdc_group10_oop.service.actions.interfaces.AttendanceManagement;
import com.mmdc_group10_oop.service.actions.interfaces.LeaveManagement;
import com.mmdc_group10_oop.service.actions.interfaces.PayslipManagement;
import com.mmdc_group10_oop.service.actions.interfaces.ProfileManagement;
import com.mmdc_group10_oop.ui.employeeUI.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Employee implements ProfileManagement, AttendanceManagement, LeaveManagement, PayslipManagement {
    protected int employeeID;
    protected EmployeeRecord personalInfo;
    protected List<String[]> leaveRecords;
    protected List<String[]> attendanceRecords;
    protected PayrollRecords payslip;
    protected LeaveBalance leaveBalance;
    protected MyProfilePanel profilePage;
    protected AttendancePanel attendancePage;
    protected MyPayslipPanel payslipPage;
    protected LeavePanel leavePage;

    protected EmployeeUI ui;
    protected boolean isAttendanceColumnsRemoved = false;
    protected boolean isLeaveHistoryColumnsRemoved = false;
    protected LocalTime currentTime;
    protected LocalDate currentDate;
    public Employee(int employeeID, EmployeeUI ui) {
        this.employeeID = employeeID;

        //Initialize employeeUI, Details, and Records
        if (ui != null) {
            this.ui = ui;
            initDetails();
            initComponents();
        }
    }

    protected void initDetails() {
        //Initialize employeeUI's Details and Records
        this.personalInfo = new EmployeeRecord(employeeID);
        this.attendanceRecords = new AttendanceRecord(employeeID).retrieveAllPersonalRecord();
        this.payslip = new PayrollRecords(employeeID);
        this.leaveBalance = new LeaveBalance(employeeID);
        this.leaveRecords = new LeaveRecord(employeeID).retrieveAllPersonalRecord();
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
    public void clockIn() {

        currentTime = LocalTime.now();
        currentTime = LocalTime.of(currentTime.getHour(), currentTime.getMinute());
        currentDate = LocalDate.now();

        String timeIN = currentTime.toString();
        String attendanceID = currentDate + "-" + employeeID;

        System.out.println(attendanceID);
        System.out.println(currentDate);
        System.out.println(timeIN);

        AttendanceRecord newRecord = new AttendanceRecord(
                attendanceID,
                currentDate.toString(),
                employeeID,
                personalInfo.lastName(),
                personalInfo.firstName(),
                timeIN,
                "",
                "",
                "");

        if (newRecord.doesExist("ATTENDANCE_ID", attendanceID)){
            ErrorMessages.AttendanceModuleError_HAS_TIMED_IN();
            System.out.println("You have already clocked in for this employee today. Please clock out first.");
            return;
        }

        newRecord.addRecord();

        attendanceRecords = newRecord.retrieveAllPersonalRecord();

        // Reload attendance records after adding a new record

        displayAttendanceRecord();
    }
    @Override
    public void clockOut() {
        currentTime = LocalTime.now();
        currentTime = LocalTime.of(currentTime.getHour(), currentTime.getMinute());
        currentDate = LocalDate.now();

        String timeOut = currentTime.toString();

        //TODO: @Ibra

        //time Out must

    }
    @Override
    public void displayAttendanceRecord() {
        // Clear existing rows from the table model
        attendancePage.attendanceTableModel().setRowCount(0);

        if (!isAttendanceColumnsRemoved) {
            //Hide employee Number

            var attendanceTable = attendancePage.attendanceTable();
            var attendanceIdColumn = attendanceTable.getColumnModel().getColumn(0);
            var idColumn = attendanceTable.getColumnModel().getColumn(2);
            var lastNameColumn = attendanceTable.getColumnModel().getColumn(3);
            var firsNameColumn = attendanceTable.getColumnModel().getColumn(4);
            attendanceTable.removeColumn(attendanceIdColumn);
            attendanceTable.removeColumn(idColumn);

            attendanceTable.removeColumn(lastNameColumn);
            attendanceTable.removeColumn(firsNameColumn);

            isAttendanceColumnsRemoved = true; // Update the flag to indicate that columns have been removed
        }

        for (String[] record : attendanceRecords){
            attendancePage.attendanceTableModel().addRow(record);
        }
    }

    @Override
    public void displayLeaveBalance() {
        leavePage.sickLeaveTxtField().setText(String.valueOf(leaveBalance.sickBalance()));
        leavePage.vaccationLeaveTxtField().setText(String.valueOf(leaveBalance.vacationBalance()));
        leavePage.paternityLeaveTxtField().setText(String.valueOf(leaveBalance.paternalBalance()));
        leavePage.bereavementLeaveTxtField().setText(String.valueOf(leaveBalance.bereavementBalance()));
    }

    @Override
    public void submitLeaveRequest() {
        currentTime = LocalTime.now();
        currentTime = LocalTime.of(currentTime.getHour(), currentTime.getMinute());
        currentDate = LocalDate.now();
        String leaveID = currentDate + "-" + currentTime + "-" + employeeID;

        String leaveType = (String) leavePage.leaveTypeComboBox().getSelectedItem();
        LocalDate startDate = Convert.DateToLocalDate(leavePage.startDateChooser().getDate());
        LocalDate endDate = Convert.DateToLocalDate(leavePage.endDateChooser().getDate());
        String reasons = leavePage.leaveReasonsTxtArea().getText();

        System.out.println(leaveType);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(reasons);

        if (startDate == null || endDate == null){
            ErrorMessages.LeaveModuleError_INVALID_DATE();
            throw new RuntimeException("Empty date");
        }

        if (startDate.isAfter(endDate)){
            ErrorMessages.LeaveModuleError_INVALID_DATE_RANGE();
            throw new RuntimeException("Invalid date range");
        }

        int totalDays = DateTimeCalculator.totalDays(startDate, endDate);

        if (leaveType.equals("SICK")){
            if (leaveBalance.sickBalance() < totalDays){
                ErrorMessages.LeaveModuleError_INSUFFICIENT_BALANCE();
                throw new RuntimeException("No sick leave");
            } else {
                leaveBalance.updateRecord(
                        String.valueOf(employeeID), "SICK_LEAVE", String.valueOf(leaveBalance.sickBalance() - totalDays));
            }
        } if (leaveType.equals("VACATION")){
            if (leaveBalance.vacationBalance() < totalDays){
                ErrorMessages.LeaveModuleError_INSUFFICIENT_BALANCE();
                throw new RuntimeException("No vacation leave");
            } else {
                leaveBalance.updateRecord(
                        String.valueOf(employeeID), "VACATION_LEAVE", String.valueOf(leaveBalance.vacationBalance() - totalDays));
            }
        } if (leaveType.equals("PATERNITY")){
            if (leaveBalance.paternalBalance() < totalDays){
                ErrorMessages.LeaveModuleError_INSUFFICIENT_BALANCE();
                throw new RuntimeException("No paternity leave");
            } else {
                leaveBalance.updateRecord(
                        String.valueOf(employeeID), "PATERNAL_LEAVE", String.valueOf(leaveBalance.paternalBalance() - totalDays));
            }
        } if (leaveType.equals("BEREAVEMENT")){
            if (leaveBalance.bereavementBalance() < totalDays){
                ErrorMessages.LeaveModuleError_INSUFFICIENT_BALANCE();
                throw new RuntimeException("No bereavement leave");
            } else {
                leaveBalance.updateRecord(
                        String.valueOf(employeeID), "BEREAVEMENT_LEAVE", String.valueOf(leaveBalance.bereavementBalance() - totalDays));
            }
        }

        // Check for conflicts with existing records
        for (String[] record : leaveRecords) {
            LocalDate existingStartDate = Convert.MDYtoLocalDate(record[4]);
            LocalDate existingEndDate = Convert.MDYtoLocalDate(record[5]);

            // Check if the new record's start-end dates overlap with any existing record
            if (LeaveRecord.datesOverlap(startDate, endDate, existingStartDate, existingEndDate)) {
                ErrorMessages.LeaveModuleError_CONFLICTING_DATES();
                throw new RuntimeException("Conflicting leave request detected");
            }
        }

        LeaveRecord newRecord = new LeaveRecord(
                leaveID,
                employeeID,
                currentDate,
                leaveType,
                startDate,
                endDate,
                totalDays,
                reasons
        );

        newRecord.addRecord();

        leaveBalance = new LeaveBalance(employeeID);
        leaveRecords = newRecord.retrieveAllPersonalRecord();

        // Reload leave records after adding a new record
        displayLeaveBalance();
        displayLeaveHistory();
    }

    @Override
    public void displayLeaveHistory() {
        // Clear existing rows from the table model
        leavePage.leaveHistoryModel().setRowCount(0);

        if (!isLeaveHistoryColumnsRemoved) {
            //Hide employee Number
            var leaveHistoryTable = leavePage.leaveHistoryTable();
            var leaveIDColumn = leaveHistoryTable.getColumnModel().getColumn(0);
            var idColumn = leaveHistoryTable.getColumnModel().getColumn(1);
            var leaveReasonColumn = leaveHistoryTable.getColumnModel().getColumn(7);

            leaveHistoryTable.removeColumn(leaveIDColumn);
            leaveHistoryTable.removeColumn(idColumn);
            leaveHistoryTable.removeColumn(leaveReasonColumn);

            isLeaveHistoryColumnsRemoved = true; // Update the flag to indicate that columns have been removed
        }

        for (String[] record : leaveRecords){
            leavePage.leaveHistoryModel().addRow(record);
        }
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
        String hourlyRate = payslip.hourlyRate();
        String hoursWorked = String.valueOf(payslip.hoursWorked());
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


        String content = "Motor PH" + "\n".repeat(2) +

                "Payslip No: " + payslipNo + "\n".repeat(2) +

                "Employee ID: " + employeeID + "\n" +
                "Employee Name: " + employeeName + "\n" +
                "Period Start: " + periodStart + "\n" +
                "Period End: " + periodEnd + "\n" +
                "Position/Department: " + positionDepartment + "\n" +
                "Monthly Salary: " + monthlySalary + "\n" +
                "Hourly Rate: " + hourlyRate + "\n" +
                "Hours Worked: " + hoursWorked + "\n" +
                "Overtime Pay: " + overTimePay + "\n" +

                "-".repeat(30) + "\n" +
                "Allowances: " + "\n" +
                "Rice Allowance: " + riceAllowance + "\n" +
                "Phone Allowance: " + phoneAllowance + "\n" +
                "Clothing Allowance: " + clothingAllowance + "\n" +

                "-".repeat(30) + "\n" +
                "Deductions: " + "\n" +
                "SSS Deduction: " + sssDeduction + "\n" +
                "PhilHealth Deduction: " + philHealthDeduction + "\n" +
                "PagIbig Deduction: " + pagIbigDeduction + "\n" +
                "Tax Deduction: " + taxDeduction + "\n" +
                "-".repeat(30) + "\n" +

                "Summary: " + "\n" +
                "Total Benefits: " + totalBenefits + "\n" +
                "Total Deductions: " + totalDeductions + "\n" +
                "Gross Income: " + grossIncome + "\n" +
                "Net Income: " + netIncome;

        payslipArea.setMargin(new Insets(5, 10, 0, 0));
        payslipArea.setText(content);
    }
}
