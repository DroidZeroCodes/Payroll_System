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
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Employee implements ProfileManagement, AttendanceManagement, LeaveManagement, PayslipManagement {
    protected int employeeID;
    protected EmployeeRecord personalInfo;
    protected List<String[]> leaveRecords;
    protected List<String[]> attendanceRecords;
    protected PayrollRecords payslip;
    protected LeaveBalance leaveBalance;
    protected MyProfilePanel myProfilePage;
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

    /**
     * Initialize employeeUI's Details and Records
     */
    protected void initDetails() {
        //Initialize employeeUI's Details and Records
        this.personalInfo = new EmployeeRecord(employeeID);
        this.attendanceRecords = new AttendanceRecord(employeeID).retrieveAllPersonalRecord();
        this.payslip = new PayrollRecords(employeeID);
        this.leaveBalance = new LeaveBalance(employeeID);
        this.leaveRecords = new LeaveRecord(employeeID).retrieveAllPersonalRecord();
    }

    /**
     * Initializes the components for the Java class.
     */
    protected void initComponents(){
        myProfilePage = this.ui.empProfilePanel();
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
        myProfilePage.nameTxtField().setText(personalInfo.firstName() + " " + personalInfo.lastName());
        myProfilePage.birthdayTxtField().setText(personalInfo.dob());
        myProfilePage.phoneNoTxtField().setText(personalInfo.phoneNum());
        myProfilePage.addressTxtArea().setText(personalInfo.address());

        //Employment
        myProfilePage.empIDTxtField().setText(String.valueOf(personalInfo.employeeID()));
        myProfilePage.departmentTxtField().setText(personalInfo.department());
        myProfilePage.positionTxtField().setText(personalInfo.position());
        myProfilePage.supervisoTxtField().setText(String.valueOf(personalInfo.supervisor()));
        myProfilePage.statusTxtField().setText(personalInfo.status());

        //Payroll
        myProfilePage.basicSalaryTxtField().setText(String.valueOf(personalInfo.basicSalary()));
        myProfilePage.hourlyRateTxtField().setText(String.valueOf(personalInfo.hourlyRate()));
        myProfilePage.semiMonthlyTxtField().setText(String.valueOf(personalInfo.semiMonthlyRate()));

        //Allowances
        myProfilePage.riceSubsidyTxtField().setText(String.valueOf(personalInfo.riceSubsidy()));
        myProfilePage.phoneAllowanceTxtField().setText(String.valueOf(personalInfo.phoneAllowance()));
        myProfilePage.clothingAllowanceTxtField().setText(String.valueOf(personalInfo.clothingAllowance()));

        //Deductions
        myProfilePage.sssNoTextField().setText(String.valueOf(personalInfo.sssNo()));
        myProfilePage.philhealthNoTxtField().setText(String.valueOf(personalInfo.philHealthNo()));
        myProfilePage.pagibigNoTxtField().setText(String.valueOf(personalInfo.pagIbigNo()));
        myProfilePage.tinNoTxtField().setText(String.valueOf(personalInfo.tinNo()));
    }

    /**
     * Method to clock in the employee.
     * It retrieves the current time and date, generates a unique attendance ID,
     * creates a new attendance record, and checks if the employee has already clocked in for the day.
     * If the employee has not clocked in, it adds a new attendance record and updates the display of attendance records.
     * If the employee has already clocked in, it displays an error message and prompts the employee to clock out first.
     */
    @Override
    public void clockIn() {
        // Retrieve the current time and date
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        LocalDate currentDate = LocalDate.now();

        // Convert the time to string and generate attendance ID
        String timeIn = currentTime.toString();
        String attendanceId = currentDate + "-" + employeeID;

        // Create a new attendance record
        AttendanceRecord newRecord = new AttendanceRecord(employeeID);

        // Check if the attendance record already exists
        if (newRecord.doesExist("ATTENDANCE_ID", attendanceId)){
            ErrorMessages.AttendanceModuleError_HAS_TIMED_IN();
            System.out.println("You have already clocked in for this employee today. Please clock out first.");
            return;
        }

        // Add the new attendance record and update the display
        newRecord.addRecord(new String[]{
                attendanceId,
                currentDate.toString(),
                String.valueOf(employeeID),
                personalInfo.lastName(),
                personalInfo.firstName(),
                timeIn,
                "",
                "",
                ""
        }, false);
        attendanceRecords = newRecord.retrieveAllPersonalRecord();

        displayAttendanceRecord();
    }
    @Override
    public void clockOut() {
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        LocalDate currentDate = LocalDate.now();

        String timeOut = currentTime.toString();

        //TODO: @Ibra

        //time Out must

    }

    /**
     * This method refreshes the display of the attendance records in the attendance table.
     * It clears the existing rows from the table model, hides specific columns from the table,
     * and then adds new rows to the table based on the attendanceRecords data.
     */
    @Override
    public void displayAttendanceRecord() {
        // Clear existing rows from the table model
        attendancePage.attendanceTableModel().setRowCount(0);

        // Check if the attendance columns have been removed
        if (!isAttendanceColumnsRemoved) {
            // Hide certain columns from the table
            var attendanceTable = attendancePage.attendanceTable();
            var columnsToHide = new int[]{0, 2, 3, 4}; // Indexes of the columns to be hidden
            for (int columnIndex : columnsToHide) {
                attendanceTable.removeColumn(attendanceTable.getColumnModel().getColumn(columnIndex));
            }
            isAttendanceColumnsRemoved = true; // Update the flag to indicate that columns have been removed
        }

        // Add new rows to the table based on the attendanceRecords data
        for (String[] record : attendanceRecords){
            attendancePage.attendanceTableModel().addRow(record);
        }
    }


    /**
     * Display the leave balance on the leave page.
     */
    @Override
    public void displayLeaveBalance() {
        leavePage.sickLeaveTxtField().setText(String.valueOf(leaveBalance.sickBalance()));
        leavePage.vaccationLeaveTxtField().setText(String.valueOf(leaveBalance.vacationBalance()));
        leavePage.paternityLeaveTxtField().setText(String.valueOf(leaveBalance.paternalBalance()));
        leavePage.bereavementLeaveTxtField().setText(String.valueOf(leaveBalance.bereavementBalance()));
    }

    /**
     * Submit a leave request based on the selected leave type, start date, end date, and reasons.
     */
    @Override
    public void submitLeaveRequest() {
        LocalDate currentDate = LocalDate.now();

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

        assert leaveType != null;
        String leaveTypeBalanceField = leaveType.toUpperCase() + "_BALANCE";
        int leaveBalanceValue = leaveBalance.getLeaveBalance(leaveTypeBalanceField);

        if (leaveBalanceValue < totalDays){
            ErrorMessages.LeaveModuleError_INSUFFICIENT_BALANCE();
            throw new RuntimeException("Insufficient " + leaveType.toLowerCase() + " leave balance");
        } else {
            leaveBalance.updateRecord(
                    String.valueOf(employeeID), leaveType.toUpperCase() + "_LEAVE", String.valueOf(leaveBalanceValue - totalDays));
        }

        if (leaveRecords.stream().anyMatch(record ->
                LeaveRecord.datesOverlap(startDate, endDate, Convert.MDYtoLocalDate(record[4]), Convert.MDYtoLocalDate(record[5])))) {
            ErrorMessages.LeaveModuleError_CONFLICTING_DATES();
            throw new RuntimeException("Conflicting leave request detected");
        }

        LeaveRecord newRecord = new LeaveRecord(employeeID);

        newRecord.addRecord(new String[]{
                currentDate + "-" + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + "-" + employeeID,
                String.valueOf(employeeID),
                Convert.LocalDateToMDY(currentDate),
                leaveType,
                Convert.LocalDateToMDY(startDate),
                Convert.LocalDateToMDY(endDate),
                String.valueOf(totalDays),
                reasons
        }, false);

        leaveBalance = new LeaveBalance(employeeID);
        leaveRecords = newRecord.retrieveAllPersonalRecord();

        displayLeaveBalance();
        displayLeaveHistory();
    }

    /**
     * Display the leave history by clearing existing rows from the table model,
     * hiding specific columns, and adding new records to the table model.
     */
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

    /**
     * Display the payslip information on the UI.
     *
     */
    @Override
    public void displayPayslip() {
        var payslipArea = payslipPage.payslipTxtArea();
        payslipArea.setText("");
        payslip = new PayrollRecords(employeeID);

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
