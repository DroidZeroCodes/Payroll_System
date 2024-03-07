package actions;

import data.*;
import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.LeaveException;
import service.DateTimeCalculator;
import ui.GeneralComponents;
import ui.employee.*;
import user.Employee;
import util.Convert;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EmployeeHandler {
    // Cell renderer for Date formatter
    protected final DefaultTableCellRenderer dateRenderer = new DefaultTableCellRenderer() {
        private final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        private final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        @Override
        protected void setValue(Object value) {
            if (value instanceof LocalDate date) {
                setText(date.format(outputFormatter));
            } else if (value instanceof String) {
                // Parse the string to LocalDate
                LocalDate date = LocalDate.parse((String) value, inputFormatter);
                setText(date.format(outputFormatter));
            } else {
                super.setValue(value);
            }
        }
    };
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
    protected void initComponents() {
        myProfilePage = generalComponents.getMyProfilePage_Comp();
        attendancePage = generalComponents.getAttendancePage_Comp();
        payslipPage = generalComponents.getPayslipPage_Comp();
        leavePage = generalComponents.getLeavePage_Comp();
        myProfileBTN = generalComponents.getMyProfileBTN_Comp();
        attendanceBTN = generalComponents.getAttedanceBTN_Comp();
        payslipBTN = generalComponents.getPayslipBTN_Comp();
        leaveBTN = generalComponents.getLeaveBTN_Comp();
    }

    protected void initActions() {
        myProfileBTN.addActionListener(e -> showMyProfilePage());
        attendanceBTN.addActionListener(e -> showAttendancePage());
        leaveBTN.addActionListener(e -> showLeavePage());
        payslipBTN.addActionListener(e -> {
            try {
                showPayslipPage(YearMonth.now().getMonthValue(), employee.getEmployeeID());
            } catch (EmployeeRecordsException ex) {
                System.err.println("Payslip error: " + ex.getMessage());
            }
        });

        attendancePage.getClockInBTN().addActionListener(e -> {
            try {
                employee.clockIn();

                JOptionPane.showMessageDialog(null, "Clocked In Successfully", "Clocked In", JOptionPane.INFORMATION_MESSAGE);

            } catch (AttendanceException ex) {
                System.err.println("Clock in error: " + ex.getMessage());
            }

            showAttendancePage();
        });
        attendancePage.getClockOutBTN().addActionListener(e -> {
            try {
                employee.clockOut();

                JOptionPane.showMessageDialog(null, "Clocked Out Successfully", "Clocked Out", JOptionPane.INFORMATION_MESSAGE);
            } catch (AttendanceException ex) {
                System.err.println("Clock out error: " + ex.getMessage());
            }

            showAttendancePage();
        });
        attendancePage.getAttendanceDateChooser().addPropertyChangeListener(e -> showFilteredAttendanceTable());

        leavePage.getSubmitBTN().addActionListener(e -> {
            try {
                employee.submitLeaveRequest(Objects.requireNonNull(retrieveLeaveRequest()));

                JOptionPane.showMessageDialog(null, "Leave Request Submitted Successfully", "Leave Request Submitted", JOptionPane.INFORMATION_MESSAGE);
            } catch (LeaveException ex) {
                System.err.println("Leave error: " + ex.getMessage());
            }

            showLeavePage();
        });

        payslipPage.getPayMonthChooser().addItemListener(e -> {
            int employeeID = 0;

            try {
                employeeID = Integer.parseInt(payslipPage.getSearchField().getText());
            } catch (NumberFormatException ignore) {
            }

            if (employeeID == 0) {
                employeeID = employee.getEmployeeID();
            }

            try {
                showPayslipPage(e, employeeID);
            } catch (EmployeeRecordsException ex) {
                System.err.println("Payslip error: " + ex.getMessage());
            }
        });
    }

    private void showFilteredAttendanceTable() {
        Date date = attendancePage.getAttendanceDateChooser().getDate();
        if (date == null) {
            attendancePage.getAttendanceSorter().setRowFilter(null);
        } else {
            try {
                LocalDate convertedDate = Convert.DateToLocalDate(date);
                attendancePage.getAttendanceSorter().setRowFilter(RowFilter.regexFilter(convertedDate.toString(), 0, 1));
                // Check if any records match the filter
                if (attendancePage.getAttendanceTable().getRowCount() == 0) {
                    // Show message indicating no records found
                    AttendanceException.throwError_NO_RECORD_FOUND();
                    attendancePage.getAttendanceSorter().setRowFilter(null);
                }
            } catch (IllegalArgumentException | AttendanceException ex) {
                // If the entered date is invalid or the regex filter fails, just ignore and clear the filter
                attendancePage.getAttendanceSorter().setRowFilter(null);
            }
        }
    }

    private LeaveRecord retrieveLeaveRequest() throws LeaveException {
        int employeeID = employee.getEmployeeID();


        LocalDate startDate = Convert.DateToLocalDate(leavePage.getStartDateChooser().getDate());
        LocalDate endDate = Convert.DateToLocalDate(leavePage.getEndDateChooser().getDate());

        if (startDate == null || endDate == null) {
            LeaveException.throwError_INVALID_DATE();
            return null;
        }

        if (endDate.isBefore(startDate)) {
            LeaveException.throwError_INVALID_DATE_RANGE();
            return null;
        }

        if (employee.getLeaveBalance(Objects.requireNonNull(leavePage.getLeaveTypeComboBox().getSelectedItem()).toString()) < DateTimeCalculator.totalDays(startDate, endDate)) {
            LeaveException.throwError_INSUFFICIENT_BALANCE();
            return null;
        }

        return new LeaveRecord(
                employee.generate_LeaveID(employeeID),
                employeeID,
                LocalDate.now(),
                Objects.requireNonNull(leavePage.getLeaveTypeComboBox().getSelectedItem()).toString(),
                startDate,
                endDate,
                DateTimeCalculator.totalDays(startDate, endDate),
                leavePage.getLeaveReasonsTxtArea().getText(),
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

    private void showAttendancePage() {
        resetPanelVisibility();

        attendancePage.setVisible(true);

        try {
            displayAttendanceRecord();
        } catch (AttendanceException e) {
            System.err.println("Attendance error: " + e.getMessage());
        }
    }

    private void showLeavePage() {
        resetPanelVisibility();

        leavePage.setVisible(true);
        try {
            displayLeaveBalance();
            displayLeaveHistory();
        } catch (LeaveException e) {
            System.err.println("Leave error: " + e.getMessage());
        }

    }

    private void showPayslipPage(int selectedMonth, int employeeID) throws EmployeeRecordsException {
        resetPanelVisibility();
        YearMonth yearMonth = YearMonth.now().withMonth(selectedMonth);

        payslipPage.setVisible(true);

        displayPayslip(yearMonth, employeeID);
    }

    private void showPayslipPage(ItemEvent e, int employeeID) throws EmployeeRecordsException {
        resetPanelVisibility();

        payslipPage.setVisible(true);
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int selectedMonth = payslipPage.getPayMonthChooser().getSelectedIndex() + 1; // Adding 1 to match YearMonth's 1-indexed months
            showPayslipPage(selectedMonth, employeeID);
        }
    }

    /**
     * Display Employee profile information on the UI components.
     */
    private void displayProfile() throws EmployeeRecordsException {
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
        String basicSalary = Convert.doubleToString(employeeRecord.basicSalary());
        String hourlyRate = Convert.doubleToString(employeeRecord.hourlyRate());
        String semiMonthly = Convert.doubleToString(employeeRecord.semiMonthlyRate());
        String riceSubsidy = Convert.doubleToString(employeeRecord.riceSubsidy());
        String phoneAllowance = Convert.doubleToString(employeeRecord.phoneAllowance());
        String clothingAllowance = Convert.doubleToString(employeeRecord.clothingAllowance());
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
        myProfilePage.philHealthNoTxtField().setText(philHealth);
        myProfilePage.pagIbigNoTxtField().setText(pagIbig);
        myProfilePage.tinNoTxtField().setText(tin);
    }

    /**
     * This method refreshes the display of the attendance records in the attendance table.
     * It clears the existing rows from the table model, hides specific columns from the table,
     * and then adds new rows to the table based on the attendanceRecords data.
     */
    protected void displayAttendanceRecord() throws AttendanceException {
        List<AttendanceRecord> attendanceRecords = employee.getAttendanceRecordList();

        // Clear existing rows from the table model
        attendancePage.getAttendanceTableModel().setRowCount(0);

        // Check if the attendance columns have been removed
        if (!isAttendanceColumnsRemoved) {
            // Hide certain columns from the table
            var attendanceTable = attendancePage.getAttendanceTable();
            var attendanceID = attendanceTable.getColumnModel().getColumn(0);
            var idColumn = attendanceTable.getColumnModel().getColumn(2);
            var lastNameColumn = attendanceTable.getColumnModel().getColumn(3);
            var firstNameColumn = attendanceTable.getColumnModel().getColumn(4);

            attendanceTable.getColumnModel().removeColumn(attendanceID);
            attendanceTable.getColumnModel().removeColumn(idColumn);
            attendanceTable.getColumnModel().removeColumn(lastNameColumn);
            attendanceTable.getColumnModel().removeColumn(firstNameColumn);

            isAttendanceColumnsRemoved = true; // Update the flag to indicate that columns have been removed
        }

        if (attendanceRecords == null || attendanceRecords.isEmpty()) {
            AttendanceException.throwError_NO_RECORD_FOUND();
            return;
        }


        // Add new rows to the table based on the attendanceRecords data
        for (AttendanceRecord record : attendanceRecords) {
            attendancePage.getAttendanceTableModel().addRow(record.toArray());
        }

        // Set the custom renderer for the date column after adding the rows
        attendancePage.getAttendanceTable().getColumnModel().getColumn(0).setCellRenderer(dateRenderer);
    }

    /**
     * Display the leave balance on the leave page.
     */
    private void displayLeaveBalance() throws LeaveException {
        LeaveBalanceRecord leaveBalance = employee.getLeaveBalance();

        if (leaveBalance == null) {
            LeaveException.throwError_NO_LEAVE_BALANCE();
            return;
        }

        leavePage.getSickLeaveTxtField().setText(String.valueOf(leaveBalance.sickBalance()));
        leavePage.getVacationLeaveTxtField().setText(String.valueOf(leaveBalance.vacationBalance()));
        leavePage.getPaternalLeaveTxtField().setText(String.valueOf(leaveBalance.paternalBalance()));
        leavePage.getBereavementLeaveTxtField().setText(String.valueOf(leaveBalance.bereavementBalance()));
    }

    /**
     * Display the leave history by clearing existing rows from the table model,
     * hiding specific columns, and adding new records to the table model.
     */
    protected void displayLeaveHistory() throws LeaveException {
        List<LeaveRecord> leaveRecords = employee.getLeaveRecordList();

        // Clear existing rows from the table model
        leavePage.getLeaveHistoryModel().setRowCount(0);

        if (!isLeaveHistoryColumnsRemoved) {
            //Hide employee Number
            var leaveHistoryTable = leavePage.getLeaveHistoryTable();
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

        for (LeaveRecord record : leaveRecords) {
            String[] recordArray = record.toArray();
            leavePage.getLeaveHistoryModel().addRow(recordArray);
        }

        // Set the custom renderer for the date column after adding the rows
        leavePage.getLeaveHistoryTable().getColumnModel().getColumn(0).setCellRenderer(dateRenderer);
        leavePage.getLeaveHistoryTable().getColumnModel().getColumn(2).setCellRenderer(dateRenderer);
        leavePage.getLeaveHistoryTable().getColumnModel().getColumn(3).setCellRenderer(dateRenderer);
    }

    /**
     * Display the payslip information on the UI.
     */
    protected void displayPayslip(YearMonth yearMonth, int employeeID) {
        // Check if the employee has a payslip
        PayrollRecords payslip = employee.getPayslip(yearMonth, employeeID);


        // Check if the employee has a payslip
        if (payslip == null) {
            return;
        }

        // Check if the yearMonth is after the current yearMonth
        if (yearMonth.isAfter(YearMonth.now())) {
            System.err.println("Payslip for this period: " + yearMonth + " not found. Displaying recent payslip instead.");
        }

        String payslipID = payslip.payrollID();
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

        // Define payslip data
        Object[][] data = {
                {},
                {"MotorPH"},
                {},
                {"Address:", "7 Jupiter Avenue cor. F. Sandoval Jr.,", "Bagong Nayon, Quezon City"},
                {"Phone:", "(028) 911-5071 /", "(028) 911-5072 /", "(028) 911-5073 "},
                {"Email:", "corporate@motorph.com"},
                {"Payslip No", payslipID, "Period Start", periodStart},
                {"Employee ID", "Period End", periodEnd},
                {"Employee Name", employeeName, "Position/Department", positionDepartment},
                {""},
                {"Earnings"},
                {"Monthly Salary", "", "", "₱ " + monthlySalary},
                {"Hourly Rate", "", "", "₱ " + hourlyRate},
                {"Hours Worked", "", "", hoursWorked},
                {"Overtime Pay", "", "", "₱ " + overTimePay},
                {"Allowances", ""},
                {"Rice Allowance", "", "", "₱ " + riceAllowance},
                {"Phone Allowance", "", "", "₱ " + phoneAllowance},
                {"Clothing Allowance", "", "", "₱ " + clothingAllowance},
                {},
                {"Deductions", ""},
                {"SSS Deduction", "", "", "₱ " + sssDeduction},
                {"PhilHealth Deduction", "", "", "₱ " + philHealthDeduction},
                {"PagIbig Deduction", "", "", "₱ " + pagIbigDeduction},
                {"Tax Deduction", "", "", "₱ " + taxDeduction},
                {},
                {"Summary", ""},
                {"Total Benefits", "", "", "₱ " + totalBenefits},
                {"Total Deductions", "", "", "₱ " + totalDeductions},
                {"Gross Income", "", "", "₱ " + grossIncome},
                {"Net Income", "", "", "₱ " + netIncome}
        };

        // update table
        payslipPage.updatePayslipTable(data);

    }


    protected void resetPanelVisibility() {
        myProfilePage.setVisible(false);
        attendancePage.setVisible(false);
        payslipPage.setVisible(false);
        leavePage.setVisible(false);
    }
}

enum Action {
    ADD,
    UPDATE,
    DELETE
}