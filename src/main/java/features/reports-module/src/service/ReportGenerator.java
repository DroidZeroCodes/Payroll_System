package service;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.PayrollRecord;
import exceptions.AttendanceException;
import exceptions.PayrollException;
import function.DateTimeCalculator;
import handlers.DataHandler;
import interfaces.*;
import util.Convert;
import util.DateTimeUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator implements AttendanceReport, EmployeeReport, PayrollReport {
    private final String payrollReportPath = "reports/payroll";
    private final String attendanceReportPath = "reports/attendance";
    private final String leaveReportPath = "reports/leave";

    private final String[][] MOTORPH = new String[][]{
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    MotorPH", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    7 Jupiter Avenue cor. F. Sandoval Jr., Bagong Nayon, Quezon City", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    Phone: (028) 911-5071 / (028) 911-5072 / (028) 911-5073", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"    Email: corporate@motorph.com", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
    };

    EmployeeDataService employeeDataService;
    AttendanceDataService attendanceDataService;
    LeaveDataService leaveDataService;
    PayrollDataService payrollDataService;

    public ReportGenerator(FileDataService fileDataService) {
        this.employeeDataService = fileDataService;
        this.attendanceDataService = fileDataService;
        this.leaveDataService = fileDataService;
        this.payrollDataService = fileDataService;
    }

    @Override
    public List<String[]> generateAttendanceReport(String reportPeriod) throws AttendanceException {
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate(reportPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate(reportPeriod);

        //Look for existing reports
        String reportName = nameGenerator(reportPeriod, ReportType.ATTENDANCE);

        try {
            DataHandler dataHandler = new DataHandler(attendanceReportPath + "/" + reportName);

            List<String[]> payrollRecords = dataHandler.retrieveAllData();

            if (payrollRecords != null) {

                openFileExplorer(attendanceReportPath + "/" + reportName);

                return payrollRecords;
            }

        } catch (Exception ignore) {
            System.out.println("Existing attendance report not found");
            System.out.println("Generating new attendance report...");
        }


        //If not found, generate

        payrollDataService = new FileDataService();
        employeeDataService = new FileDataService();

        List<String[]> attendanceListToGenerateReport = new ArrayList<>();

        String[] headers = {"Employee ID", "Full Name", "Position", "Department", "Days Worked", "Total Hours", "Overtime Hours"};

        int employeeID;
        String name;
        String position;
        String department;
        int daysWorked;
        String totalHours;
        String overtimeHours;

        List<AttendanceRecord> attendanceRecords;
        List<EmployeeRecord> employeeRecords;

        try {
            attendanceRecords = attendanceDataService.getAll_AttendanceRecord_ForPeriod(periodStart, periodEnd);
        } catch (Exception ex) {
            AttendanceException.throwError_NO_RECORD_FOUND();
            return null;
        }

        if (attendanceRecords.isEmpty()) {
            AttendanceException.throwError_NO_RECORD_FOUND();
            return null;
        }

        try {
            employeeRecords = employeeDataService.getAll_Active_Employees();
        } catch (Exception ex) {
            throw new RuntimeException("Error: " + ex.getMessage());
        }


        for (EmployeeRecord employeeRecord : employeeRecords) {
            List<AttendanceRecord> recordCopy = new ArrayList<>(attendanceRecords);

            if (recordCopy.isEmpty()) {
                continue;
            }

            employeeID = employeeRecord.employeeID();
            name = employeeRecord.lastName() + ", " + employeeRecord.firstName();
            position = employeeRecord.position();
            department = employeeRecord.department();

            System.out.println("Employee ID: " + employeeID);

            int finalEmployeeID = employeeID;
            recordCopy.removeIf(record -> record.employeeID() != finalEmployeeID);
            daysWorked = DateTimeCalculator.totalDays(recordCopy);
            totalHours = Convert.doubleToString(DateTimeCalculator.totalHoursWorked(recordCopy));
            overtimeHours = Convert.doubleToString(DateTimeCalculator.totalOvertimeHours(recordCopy));

            attendanceListToGenerateReport.add(new String[]{String.valueOf(employeeID), name, position, department, String.valueOf(daysWorked), totalHours, overtimeHours});
        }


        //Create the report
        try {
            DataHandler dataHandler = new DataHandler(attendanceReportPath);
            dataHandler.createCSVFile(attendanceListToGenerateReport, headers, reportName);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        openFileExplorer(attendanceReportPath + "/" + reportName);

        return attendanceListToGenerateReport;
    }

    @Override
    public List<String[]> generateEmployeeReport() {
        return null;
    }

    @Override
    public List<String[]> generatePayrollReport(String reportPeriod) throws PayrollException {
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate(reportPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate(reportPeriod);

        //Look for existing reports
        String reportName = nameGenerator(reportPeriod, ReportType.PAYROLL);

        try {
            DataHandler dataHandler = new DataHandler(payrollReportPath + "/" + reportName);

            List<String[]> payrollRecords = dataHandler.retrieveAllData();

            if (payrollRecords != null) {

                openFileExplorer(payrollReportPath + "/" + reportName);

                return payrollRecords;
            }

        } catch (Exception ignore) {
            System.out.println("Existing payroll report not found");
            System.out.println("Generating new payroll report...");
        }

        //If not found, generate

        payrollDataService = new FileDataService();
        employeeDataService = new FileDataService();

        List<String[]> payrollListToGenerateReport = new ArrayList<>();

        String[] headers = {"Employee ID", "Name", "Position", "Department", "Gross Pay", "SSS No", "SSS Contribution", "PhilHealth No", "PhilHealth Contribution", "PagIbig No", "PagIbig Contribution", "TIN No", "Withholding Tax", "Net Pay"};

        String employeeID;
        String name;
        String position;
        String department;
        String grossPay;
        String sssNo;
        String sssCont;
        String philHealthNo;
        String philHealthCont;
        String pagIbigNo;
        String pagIbigCont;
        String tinNo;
        String withholdingTax;
        String netPay;


        List<PayrollRecord> payrollRecords;
        try {
            payrollRecords = payrollDataService.getAll_PayrollRecords_ForPeriod(periodStart, periodEnd);
        } catch (Exception ex) {
            PayrollException.throwError_NO_PAYROLL_PROCESSED();
            return null;
        }

        if (payrollRecords.isEmpty()) {
            PayrollException.throwError_NO_PAYROLL_PROCESSED();
            return null;
        }

        for (PayrollRecord record : payrollRecords) {
            employeeID = String.valueOf(record.employeeID());
            name = record.employeeName();
            grossPay = Convert.doubleToCurrency(record.grossIncome());
            sssCont = Convert.doubleToCurrency(record.sssDeduction());
            philHealthCont = Convert.doubleToCurrency(record.philHealthDeduction());
            pagIbigCont = Convert.doubleToCurrency(record.pagIbigDeduction());
            withholdingTax = Convert.doubleToCurrency(record.taxDeduction());
            netPay = Convert.doubleToCurrency(record.netIncome());

            EmployeeRecord employeeRecord = employeeDataService.getEmployeeRecord_ByEmployeeID(Integer.parseInt(employeeID));

            position = employeeRecord.position();
            department = employeeRecord.department();
            sssNo = employeeRecord.sssNo();
            philHealthNo = employeeRecord.philHealthNo();
            pagIbigNo = employeeRecord.pagIbigNo();
            tinNo = employeeRecord.tinNo();

            payrollListToGenerateReport.add(new String[]{employeeID, name, position, department, grossPay, sssNo, sssCont, philHealthNo, philHealthCont, pagIbigNo, pagIbigCont, tinNo, withholdingTax, netPay});
        }


        //Create the report
        try {
            DataHandler dataHandler = new DataHandler(payrollReportPath);
            dataHandler.createCSVFile(payrollListToGenerateReport, headers, reportName);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        openFileExplorer(payrollReportPath + "/" + reportName);

        return payrollListToGenerateReport;
    }

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

    public String nameGenerator(String reportPeriod, ReportType reportType) {
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate(reportPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate(reportPeriod);

        String reportName = null;

        switch (reportType) {
            case ATTENDANCE -> reportName = reportPeriod + "_AttendanceReport_";
            case PAYROLL -> reportName = reportPeriod + "_PayrollReport_";
        }

        return switch (reportPeriod) {
            case "Weekly", "Semi-Monthly" -> reportName + periodStart + "-" + periodEnd.getDayOfMonth() + ".csv";
            case "Monthly" -> reportName + periodStart.getYear() + "-" + periodStart.getMonthValue() + ".csv";
            case "Annual" -> reportName + periodStart.getYear() + ".csv";
            default -> throw new IllegalArgumentException("Invalid period: " + reportPeriod);
        };

    }

    enum ReportType {
        ATTENDANCE,
        PAYROLL
    }
}

