package service;

import data.AttendanceRecord;
import data.EmployeeRecord;
import data.PayrollRecords;
import exceptions.PayrollException;
import interfaces.*;
import logic.DataHandler;
import util.Convert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator implements AttendanceReport, EmployeeReport, PayrollReport {
    private String payrollReportPath = "reports/payroll";
    private String attendanceReportPath = "reports/attendance";
    private String leaveReportPath = "reports/leave";

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
    public List<String[]> generateAttendanceReport(LocalDate periodStart, LocalDate periodEnd) {
        attendanceDataService = new FileDataService();

        try {
            List<AttendanceRecord> attendanceRecords = attendanceDataService.getAll_AttendanceRecord_ForPeriod(periodStart, periodEnd);

            if (attendanceRecords.isEmpty()) {
                throw new RuntimeException("No attendance records found for the specified period.");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<String[]> generateEmployeeReport() {
        return null;
    }

    @Override
    public List<String[]> generatePayrollReport(String reportPeriod, LocalDate periodStart, LocalDate periodEnd) {
        //Look for existing reports
        String reportName = reportPeriod + "_PayrollReport_" + periodStart.getYear() + "_" + periodStart.getMonthValue() + ".csv";

        try {
            DataHandler dataHandler = new DataHandler(payrollReportPath + "/" + reportName);

            List<String[]> payrollRecords = dataHandler.retrieveAllData();

            if (payrollRecords != null) {
                return payrollRecords;
            }

        } catch (Exception ignore) {
            System.out.println("Existing payroll report not found");
            System.out.println("Generating new payroll report...");
        }

        //If not found, generate
        String[][] MOTORPH = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"    MotorPH", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"    7 Jupiter Avenue cor. F. Sandoval Jr., Bagong Nayon, Quezon City", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"    Phone: (028) 911-5071 / (028) 911-5072 / (028) 911-5073", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"    Email: corporate@motorph.com", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
        };

        payrollDataService = new FileDataService();
        employeeDataService = new FileDataService();

        List<String[]> payrollListToGenerateReport = new ArrayList<>();

        String[] headers = {"Employee ID", "Name", "Position", "Department", "Gross Pay", "SSS Contribution", "PhilHealth Contribution", "PagIbig Contribution", "TIN Contribution", "Withholding Tax", "Net Pay"};

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

        try {
            List<PayrollRecords> payrollRecords = payrollDataService.getAll_PayrollRecords_ForPeriod(periodStart);

            if (payrollRecords.isEmpty()) {
                PayrollException.throwError_FAILED_REPORT_GENERATION();
                return null;
            }

            for (PayrollRecords record : payrollRecords) {
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

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }


        //Create the report
        try {
            DataHandler dataHandler = new DataHandler(payrollReportPath);

            dataHandler.createCSVFile(payrollListToGenerateReport, headers, reportName);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return payrollListToGenerateReport;
    }
}
