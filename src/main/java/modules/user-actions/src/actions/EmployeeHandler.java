package actions;

import data.*;
import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import exceptions.PayrollException;
import interfaces.EmployeeActions;
import service.DateTimeCalculator;
import ui.GeneralComponents;
import ui.employee.*;
import user.Employee;
import util.Convert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Objects;

public class EmployeeHandler implements EmployeeActions {
    protected Employee employee;
    protected MyProfilePanel myProfilePage;
    protected AttendancePanel attendancePage;
    protected MyPayslipPanel payslipPage;
    protected LeavePanel leavePage;
    protected JButton myProfileBTN;
    protected JButton attendanceBTN;
    protected JButton payslipBTN;
    protected JButton leaveBTN;

    //Common Components
    protected boolean isAttendanceColumnsRemoved = false;
    protected boolean isLeaveHistoryColumnsRemoved = false;
    protected GeneralComponents generalComponents;

    public EmployeeHandler(Employee employee, EmployeeUI employeeUI) {
        this.employee = employee;

        if (employeeUI != null) {
            this.generalComponents = employeeUI;
            initComponents();
            initActions();
            showMyProfilePage();
        }
    }

    /**
     * Initializes the components for the Java class.
     */
    protected void initComponents(){
        myProfilePage = generalComponents.getMyProfilePage();
        attendancePage = generalComponents.getAttendancePage();
        payslipPage = generalComponents.getPayslipPage();
        leavePage = generalComponents.getLeavePage();
        myProfileBTN = generalComponents.getMyProfileBTN();
        attendanceBTN = generalComponents.getAttedanceBTN();
        payslipBTN = generalComponents.getPayslipBTN();
        leaveBTN = generalComponents.getLeaveBTN();
    }
    protected void initActions() {
        myProfileBTN.addActionListener(e -> showMyProfilePage());
        attendanceBTN.addActionListener(e -> showAttendancePage());
        leaveBTN.addActionListener(e -> showLeavePage());
        payslipBTN.addActionListener(e -> showPayslipPage(YearMonth.now().getMonthValue()));

        attendancePage.clockInBTN().addActionListener(e -> {
            try {
                employee.clockIn();
            } catch (AttendanceException ex) {
                System.err.println("Clock in error: " + ex.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Clocked In Successfully", "Clocked In", JOptionPane.INFORMATION_MESSAGE);
            showAttendancePage();
        });
        attendancePage.clockOutBTN().addActionListener(e -> {
            try {
                employee.clockOut();
            } catch (AttendanceException ex) {
                System.err.println("Clock out error: " + ex.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Clocked Out Successfully", "Clocked Out", JOptionPane.INFORMATION_MESSAGE);
            showAttendancePage();
        });
        leavePage.submitBTN().addActionListener(e -> {
            try {
                employee.submitLeaveRequest(retrieveLeaveRequest());
            } catch (LeaveException ex) {
                System.err.println("Leave error: " + ex.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Leave Request Submitted Successfully", "Leave Request Submitted", JOptionPane.INFORMATION_MESSAGE);
            showLeavePage();
        });

        payslipPage.payMonthChooser().addItemListener(this::showPayslipPage);
    }

    private LeaveRecord retrieveLeaveRequest() {
        int employeeID = employee.getEmployeeID();
        LocalDate startDate = Convert.DateToLocalDate(leavePage.startDateChooser().getDate());
        LocalDate endDate = Convert.DateToLocalDate(leavePage.endDateChooser().getDate());
        return new LeaveRecord(
                employee.generate_LeaveID(employeeID),
                employeeID,
                LocalDate.now(),
                Objects.requireNonNull(leavePage.leaveTypeComboBox().getSelectedItem()).toString(),
                startDate,
                endDate,
                DateTimeCalculator.totalDays(startDate,endDate),
                leavePage.leaveReasonsTxtArea().getText(),
            "PENDING"
        );
    }
    protected void showMyProfilePage() {
        resetPanelVisibility();

        myProfilePage.setVisible(true);

        try {
            displayProfile();
        } catch (EmployeeRecordsException e) {
            System.err.println("Profile error: " + e.getMessage());
        }
    }
    protected void showAttendancePage() {
        resetPanelVisibility();

        attendancePage.setVisible(true);

        try {
            displayAttendanceRecord();
        } catch (AttendanceException e) {
            System.err.println("Attendance error: " + e.getMessage());
        }
    }

    protected void showLeavePage() {
        resetPanelVisibility();

        leavePage.setVisible(true);
        try {
            displayLeaveBalance();
            displayLeaveHistory();
        } catch (LeaveException e) {
            System.err.println("Leave error: " + e.getMessage());
        }

    }

    protected void showPayslipPage(int selectedMonth) {
        resetPanelVisibility();
        YearMonth yearMonth = YearMonth.now().withMonth(selectedMonth).minusYears(2);

        payslipPage.setVisible(true);

        try {
            displayPayslip(yearMonth);
        } catch (PayrollException e) {
            System.err.println("Payslip error: " + e.getMessage());
        }
    }

    protected void showPayslipPage(ItemEvent e) {
        resetPanelVisibility();

        payslipPage.setVisible(true);
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int selectedMonth = payslipPage.payMonthChooser().getSelectedIndex() + 1; // Adding 1 to match YearMonth's 1-indexed months
            showPayslipPage(selectedMonth);
        }
    }
    protected void resetPanelVisibility() {
        myProfilePage.setVisible(false);
        attendancePage.setVisible(false);
        payslipPage.setVisible(false);
        leavePage.setVisible(false);
    }

    /**
     * Display Employee profile information on the UI components.
     */
    @Override
    public void displayProfile() throws EmployeeRecordsException {
        EmployeeRecord employeeRecord = employee.getPersonalRecord();

        if (employeeRecord == null) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        String lastName = employeeRecord.lastName();
        String firstName = employeeRecord.firstName();
        String birthday = employeeRecord.dob();
        String phoneNo = employeeRecord.phoneNum();
        String address = employeeRecord.address();
        String empID = String.valueOf(employeeRecord.employeeID());
        String department = employeeRecord.department();
        String position = employeeRecord.position();
        String supervisor = employeeRecord.supervisor();
        String status = employeeRecord.status();
        String basicSalary = String.valueOf(employeeRecord.basicSalary());
        String hourlyRate = String.valueOf(employeeRecord.hourlyRate());
        String semiMonthly = String.valueOf(employeeRecord.semiMonthlyRate());
        String riceSubsidy = String.valueOf(employeeRecord.riceSubsidy());
        String phoneAllowance = String.valueOf(employeeRecord.phoneAllowance());
        String clothingAllowance = String.valueOf(employeeRecord.clothingAllowance());
        String sss = employeeRecord.sssNo();
        String philHealth = employeeRecord.philHealthNo();
        String pagIbig = employeeRecord.pagIbigNo();
        String tin = employeeRecord.tinNo();

        //Employee Profile
        myProfilePage.nameTxtField().setText(lastName + " " + firstName);
        myProfilePage.birthdayTxtField().setText(birthday);
        myProfilePage.phoneNoTxtField().setText(phoneNo);
        myProfilePage.addressTxtArea().setText(address);

        //Employment
        myProfilePage.empIDTxtField().setText(empID);
        myProfilePage.departmentTxtField().setText(department);
        myProfilePage.positionTxtField().setText(position);
        myProfilePage.supervisoTxtField().setText(supervisor);
        myProfilePage.statusTxtField().setText(status);

        //Payroll
        myProfilePage.basicSalaryTxtField().setText(basicSalary);
        myProfilePage.hourlyRateTxtField().setText(hourlyRate);
        myProfilePage.semiMonthlyTxtField().setText(semiMonthly);

        //Allowances
        myProfilePage.riceSubsidyTxtField().setText(riceSubsidy);
        myProfilePage.phoneAllowanceTxtField().setText(phoneAllowance);
        myProfilePage.clothingAllowanceTxtField().setText(clothingAllowance);

        //Deductions
        myProfilePage.sssNoTextField().setText(sss);
        myProfilePage.philhealthNoTxtField().setText(philHealth);
        myProfilePage.pagibigNoTxtField().setText(pagIbig);
        myProfilePage.tinNoTxtField().setText(tin);
    }

    /**
     * This method refreshes the display of the attendance records in the attendance table.
     * It clears the existing rows from the table model, hides specific columns from the table,
     * and then adds new rows to the table based on the attendanceRecords data.
     */
    @Override
    public void displayAttendanceRecord() throws AttendanceException {
        List<AttendanceRecord> attendanceRecords = employee.getAttendanceRecords();

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

        if (attendanceRecords == null || attendanceRecords.isEmpty()) {
            AttendanceException.throwError_NO_RECORD_FOUND();
            return;
        }

        // Add new rows to the table based on the attendanceRecords data
        for (AttendanceRecord record : attendanceRecords){
            attendancePage.attendanceTableModel().addRow(record.toArray());
        }
    }

    /**
     * Display the leave balance on the leave page.
     */
    @Override
    public void displayLeaveBalance() throws LeaveException {
        LeaveBalanceRecord leaveBalance = employee.getLeaveBalance();

        if (leaveBalance == null) {
            LeaveException.throwError_NO_LEAVE_BALANCE();
            return;
        }

        leavePage.sickLeaveTxtField().setText(String.valueOf(leaveBalance.sickBalance()));
        leavePage.vacationLeaveTxtField().setText(String.valueOf(leaveBalance.vacationBalance()));
        leavePage.paternityLeaveTxtField().setText(String.valueOf(leaveBalance.paternalBalance()));
        leavePage.bereavementLeaveTxtField().setText(String.valueOf(leaveBalance.bereavementBalance()));
    }

    /**
     * Display the leave history by clearing existing rows from the table model,
     * hiding specific columns, and adding new records to the table model.
     */
    @Override
    public void displayLeaveHistory() throws LeaveException {
        List<LeaveRecord> leaveRecords = employee.getLeaveRecords();

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

        if (leaveRecords == null || leaveRecords.isEmpty()) {
            LeaveException.throwError_NO_RECORD_FOUND();
            return;
        }

        for (LeaveRecord record : leaveRecords){
            String[] recordArray = record.toArray();
            leavePage.leaveHistoryModel().addRow(recordArray);
        }
    }

    /**
     * Display the payslip information on the UI.
     *
     */
    @Override
    public void displayPayslip(YearMonth yearMonth) throws PayrollException {
        // Check if the employee has a payslip
        PayrollRecords payslip = employee.getPayslip(yearMonth);

        var payslipArea = payslipPage.payslipTxtArea();
        payslipArea.setText("");

        // Check if the employee has a payslip
        if (payslip == null){
            PayrollException.throwPayrollError_PAYSLIP_NOT_FOUND();
            return;
        }

        int employeeID = employee.getEmployeeID();


        // Check if the yearMonth is after the current yearMonth
        if (yearMonth.isAfter(YearMonth.now())){
            System.err.println("Payslip for this period: " + yearMonth + " not found. Displaying recent payslip instead.");
        }

        String payslipID = payslip.payslipID();
        String employeeName = payslip.employeeName();
        String periodStart = String.valueOf(payslip.periodStart());
        String periodEnd = String.valueOf(payslip.periodEnd());
        String positionDepartment = payslip.positionDepartment();
        String monthlySalary = String.valueOf(payslip.monthlySalary());
        String hourlyRate = String.valueOf(payslip.hourlyRate());
        String hoursWorked = String.valueOf(payslip.hoursWorked());
        String overTimePay = String.valueOf(payslip.overTimePay());
        String riceAllowance = String.valueOf(payslip.riceAllowance());
        String phoneAllowance = String.valueOf(payslip.phoneAllowance());
        String clothingAllowance = String.valueOf(payslip.clothingAllowance());
        String sssDeduction = String.valueOf(payslip.sssDeduction());
        String philHealthDeduction = String.valueOf(payslip.philHealthDeduction());
        String pagIbigDeduction = String.valueOf(payslip.pagIbigDeduction());
        String taxDeduction = String.valueOf(payslip.taxDeduction());
        String grossIncome = String.valueOf(payslip.grossIncome());
        String totalBenefits = String.valueOf(payslip.totalBenefits());
        String totalDeductions = String.valueOf(payslip.totalDeductions());
        String netIncome = String.valueOf(payslip.netIncome());


        String content = "Motor PH" + "\n".repeat(2) +

                "Payslip No: " + payslipID + "\n".repeat(2) +

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
