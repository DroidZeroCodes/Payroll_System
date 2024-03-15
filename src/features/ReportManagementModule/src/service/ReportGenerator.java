package service;

import calculator.DateTimeCalculator;
import exceptions.AttendanceException;
import exceptions.PayrollException;
import handlers.CSVHandler;
import interfaces.*;
import records.AttendanceRecord;
import records.EmployeeRecord;
import records.PayrollRecord;
import util.Convert;
import util.DateTimeUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates reports for employees, attendance, and payroll.
 * Currently, the employee report is not implemented.
 */
public class ReportGenerator implements AttendanceReport, EmployeeReport, PayrollReport {
/*
    private final String leaveReportPath = "reports/leave";

    private final String[][] MOTORPH = new String[][]{
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    MotorPH", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    7 Jupiter Avenue cor. F. Sandoval Jr., Bagong Nayon, Quezon City", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    Phone: (028) 911-5071 / (028) 911-5072 / (028) 911-5073", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    Email: corporate@motorph.com", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
    };
*/

    EmployeeDataService employeeDataService;
    AttendanceDataService attendanceDataService;
    LeaveDataService leaveDataService;
    PayrollDataService payrollDataService;

    /**
     * Creates a new ReportGenerator object for generating reports.
     *
     * @param fileDataService the file data service
     */
    public ReportGenerator(FileDataService fileDataService) {
        this.employeeDataService = fileDataService;
        this.attendanceDataService = fileDataService;
        this.leaveDataService = fileDataService;
        this.payrollDataService = fileDataService;
    }

    /**
     * Generates an attendance report for the specified report period.
     *
     * @param reportPeriod the period for which the report is generated
     * @return a list of arrays representing the attendance report
     */
    @Override
    public List<String[]> generateAttendanceReport(String reportPeriod) throws AttendanceException {
        // Get the start and end dates of the report period
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate_Current(reportPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate_Current(reportPeriod);

        // Generate the name and path of the report
        String reportName = ReportNameGenerator(reportPeriod, ReportType.ATTENDANCE);
        String attendanceReportPath = "reports/attendance";
        String reportPath = attendanceReportPath + "/" + reportName;

        try {
            // Check if there is an existing attendance report
            CSVHandler CSVHandler = new CSVHandler(reportPath);
            List<String[]> attendanceReports = CSVHandler.retrieveAllData();

            if (attendanceReports != null) {
                // Prompt the user to confirm overwriting the existing report
                int choice = JOptionPane.showConfirmDialog(null, "Existing attendance report found. Would you like to overwrite?", "Report", JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.NO_OPTION) {
                    // If user chooses not to overwrite, open the existing report and return it
                    openFileExplorer(reportPath);
                    return attendanceReports;
                }
            }
        } catch (Exception ignore) {
            // Ignore exception if existing report is not found
            System.out.println("Existing attendance report not found");
            System.out.println("Generating new attendance report...");
        }

        // If not found, generate the new attendance report
        payrollDataService = new FileDataService();
        employeeDataService = new FileDataService();
        List<String[]> attendanceListToGenerateReport = new ArrayList<>();
        String[] headers = {"Employee ID", "Full Name", "Position", "Department", "Days Worked", "Total Hours", "Overtime Hours"};

        List<AttendanceRecord> attendanceRecords;
        List<EmployeeRecord> employeeRecords;

        try {
            // Get all attendance records for the specified period
            attendanceRecords = attendanceDataService.getAll_AttendanceRecord_ForPeriod(periodStart, periodEnd);
        } catch (Exception ex) {
            // Throw an exception if no attendance records are found
            AttendanceException.throwError_NO_RECORD_FOUND();
            return null;
        }

        if (attendanceRecords.isEmpty()) {
            // Throw an exception if no attendance records are found
            AttendanceException.throwError_NO_RECORD_FOUND();
            return null;
        }

        try {
            // Get all active employee records
            employeeRecords = employeeDataService.getAll_Active_Employees();
        } catch (Exception ex) {
            // Throw a runtime exception if there's an error getting employee records
            throw new RuntimeException("Error: " + ex.getMessage());
        }

        // Iterate through the employee records to generate the attendance report
        for (EmployeeRecord employeeRecord : employeeRecords) {
            List<AttendanceRecord> recordCopy = new ArrayList<>(attendanceRecords);

            if (recordCopy.isEmpty()) {
                continue;
            }

            int employeeID = employeeRecord.employeeID();
            String name = employeeRecord.lastName() + ", " + employeeRecord.firstName();
            String position = employeeRecord.position();
            String department = employeeRecord.department();

            recordCopy.removeIf(record -> record.employeeID() != employeeID);
            int daysWorked = DateTimeCalculator.totalDays(recordCopy);
            String totalHours = Convert.doubleToString(DateTimeCalculator.totalHoursWorked(recordCopy));
            String overtimeHours = Convert.doubleToString(DateTimeCalculator.totalOvertimeHours(recordCopy));

            // Add the attendance details to the report
            attendanceListToGenerateReport.add(new String[]{String.valueOf(employeeID), name, position, department, String.valueOf(daysWorked), totalHours, overtimeHours});
        }

        try {
            // Create the CSV file for the attendance report
            CSVHandler CSVHandler = new CSVHandler(attendanceReportPath);
            CSVHandler.createCSVFile(attendanceListToGenerateReport, headers, reportPath);
        } catch (Exception e) {
            // Throw a runtime exception if there's an error creating the report file
            throw new RuntimeException("Error: " + e.getMessage());
        }

        // Open the file explorer to view the generated report
        openFileExplorer(reportPath);

        return attendanceListToGenerateReport;
    }

    @Override
    public List<String[]> generateEmployeeReport() {
        return null;
    }

    /**
     * Generates a payroll report for the specified report period.
     *
     * @param reportPeriod the period for which the payroll report is generated
     * @return a list of arrays containing payroll report data
     */
    @Override
    public List<String[]> generatePayrollReport(String reportPeriod) throws PayrollException {
        // Get the start and end dates of the report period
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate_Current(reportPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate_Current(reportPeriod);

        // Generate the name and path of the report file
        String reportName = ReportNameGenerator(reportPeriod, ReportType.PAYROLL);
        String payrollReportPath = "reports/payroll";
        String reportPath = payrollReportPath + "/" + reportName;

        try {
            // Try to retrieve existing payroll records
            CSVHandler CSVHandler = new CSVHandler(reportPath);
            List<String[]> payrollRecords = CSVHandler.retrieveAllData();

            // If existing payroll records are found, prompt the user to confirm overwrite
            if (payrollRecords != null) {
                int choice = JOptionPane.showConfirmDialog(null, "Existing payroll report found. Would you like to overwrite?", "Report", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION) {
                    openFileExplorer(reportPath);
                    return payrollRecords;
                }
            }
        } catch (Exception ignore) {
            System.out.println("Existing payroll report not found");
            System.out.println("Generating new payroll report...");
        }

        // If no existing payroll records are found, generate new payroll report
        payrollDataService = new FileDataService();
        employeeDataService = new FileDataService();
        List<String[]> payrollListToGenerateReport = new ArrayList<>();
        String[] headers = {"Employee ID", "Name", "Position", "Department", "Gross Pay", "SSS No", "SSS Contribution", "PhilHealth No", "PhilHealth Contribution", "PagIbig No", "PagIbig Contribution", "TIN No", "Withholding Tax", "Net Pay"};

        // Retrieve payroll records for the specified period
        List<PayrollRecord> payrollRecords;
        try {
            payrollRecords = payrollDataService.getAll_PayrollRecords_ForPeriod(periodStart, periodEnd);
        } catch (Exception ex) {
            PayrollException.throwError_NO_PAYROLL_PROCESSED();
            return null;
        }

        // If no payroll records are found, throw an error
        if (payrollRecords.isEmpty()) {
            PayrollException.throwError_NO_PAYROLL_PROCESSED();
            return null;
        }

        // Generate payroll report data for each record
        for (PayrollRecord record : payrollRecords) {
            String employeeID = String.valueOf(record.employeeID());
            String name = record.employeeName();
            String grossPay = Convert.doubleToString(record.grossIncome());
            String sssCont = Convert.doubleToString(record.sssDeduction());
            String philHealthCont = Convert.doubleToString(record.philHealthDeduction());
            String pagIbigCont = Convert.doubleToString(record.pagIbigDeduction());
            String withholdingTax = Convert.doubleToString(record.taxDeduction());
            String netPay = Convert.doubleToString(record.netIncome());

            // Retrieve employee details
            EmployeeRecord employeeRecord = employeeDataService.getEmployeeRecord_ByEmployeeID(Integer.parseInt(employeeID));
            String position = employeeRecord.position();
            String department = employeeRecord.department();
            String sssNo = employeeRecord.sssNo();
            String philHealthNo = employeeRecord.philHealthNo();
            String pagIbigNo = employeeRecord.pagIbigNo();
            String tinNo = employeeRecord.tinNo();

            // Add payroll report data to the list
            payrollListToGenerateReport.add(new String[]{employeeID, name, position, department, grossPay, sssNo, sssCont, philHealthNo, philHealthCont, pagIbigNo, pagIbigCont, tinNo, withholdingTax, netPay});
        }

        try {
            // Create the payroll report CSV file
            CSVHandler CSVHandler = new CSVHandler(payrollReportPath);
            CSVHandler.createCSVFile(payrollListToGenerateReport, headers, reportPath);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        // Open the file explorer to view the generated report
        openFileExplorer(reportPath);

        return payrollListToGenerateReport;
    }

    /**
     * Ask the user if they want to view the report
     *
     * @param filePath The file path of the report
     */
    public void openFileExplorer(String filePath) {
        // Ask the user if they want to view the report

        int choice = JOptionPane.showConfirmDialog(null, "Report generated. Do you want to view it?", "View Report", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            File file = new File(filePath);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Report file not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Open the file explorer and highlight the file
                Desktop.getDesktop().open(file.getParentFile());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error opening file explorer.", "Error", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error opening file explorer: " + e.getMessage());
            }
        }
    }

    /**
     * Generates a report name based on the report period and type.
     *
     * @param reportPeriod The period for which the report is generated (Weekly, Semi-Monthly, Monthly, Annual)
     * @param reportType   The type of report (ATTENDANCE or PAYROLL)
     * @return The generated report name including the relevant period and dates
     */
    public String ReportNameGenerator(String reportPeriod, ReportType reportType) {
        // Get the start and end dates of the report period
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate_Current(reportPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate_Current(reportPeriod);

        // Initialize the report name
        String reportName = null;

        // Determine the report name based on the report type
        switch (reportType) {
            case ATTENDANCE -> reportName = reportPeriod + "_AttendanceReport_";
            case PAYROLL -> reportName = reportPeriod + "_PayrollReport_";
        }

        // Generate the report name based on the report period
        return switch (reportPeriod) {
            case "Weekly", "Semi-Monthly" -> reportName + periodStart + "-" + periodEnd.getDayOfMonth() + ".csv";
            case "Monthly" -> reportName + periodStart.getYear() + "-" + periodStart.getMonthValue() + ".csv";
            case "Annual" -> reportName + periodStart.getYear() + ".csv";
            default -> throw new IllegalArgumentException("Invalid period: " + reportPeriod);
        };
    }

    /**
     * Enumerates the types of reports.
     */
    public enum ReportType {
        /**
         * Attendance report
         */
        ATTENDANCE,

        /**
         * Payroll report
         */
        PAYROLL,

        /**
         * Employee report
         */
        EMPLOYEE
        // Add more report types here
    }
}

