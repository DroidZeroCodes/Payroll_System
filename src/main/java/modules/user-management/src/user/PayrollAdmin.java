package user;


import data.AttendanceRecord;
import data.EmployeeRecord;
import data.PayrollRecords;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import service.DateTimeCalculator;
import service.FileDataService;
import service.PayrollCalculator;
import service.ReportGenerator;
import util.Convert;
import util.DateTimeUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollAdmin extends Employee {
    private final List<PayrollRecords> tempPayrollRecords = new ArrayList<>();
    private List<PayrollRecords> currentPeriodPayrollRecord;
    private List<PayrollRecords> allPayrollRecords;
    private List<Integer> employeeIDList;
    private List<String> payrollIDList = new ArrayList<>();
    private ReportGenerator reportGenerator;

    public PayrollAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        this.reportGenerator = new ReportGenerator(dataService);

        try {
            this.currentPeriodPayrollRecord = payrollDataService.getAll_PayrollRecords_ForPeriod(DateTimeUtils.getMonthlyPeriod_StartDate(), null);
        } catch (Exception e) {
            this.currentPeriodPayrollRecord = new ArrayList<>();
            System.err.println("Current period payroll record not found: " + e.getMessage());
        }

        try {
            this.allPayrollRecords = payrollDataService.getAll_PayrollRecords();
        } catch (Exception e) {
            this.allPayrollRecords = new ArrayList<>();
            System.err.println("All payroll record not found: " + e.getMessage());
        }

        try {
            this.employeeIDList = List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            this.employeeIDList = new ArrayList<>();
            System.err.println("Employee ID list not found: " + e.getMessage());
        }

        try {
            this.payrollIDList = retrievePayrollIDList();
        } catch (PayrollException e) {
            this.payrollIDList = new ArrayList<>();
            System.err.println("Payroll ID list not found: " + e.getMessage());
        }
    }

    private List<String> retrievePayrollIDList() throws PayrollException {
        for (PayrollRecords payrollRecord : currentPeriodPayrollRecord) {
            payrollIDList.add(payrollRecord.payrollID());
        }

        if (payrollIDList == null) {
            throw new PayrollException("Error: No payroll record found.");
        }

        return payrollIDList;
    }

    public List<PayrollRecords> getCurrentPeriodPayrollRecord() {
        return currentPeriodPayrollRecord;
    }

    public List<PayrollRecords> getAllPayrollRecords() {
        return allPayrollRecords;
    }

    public List<PayrollRecords> getTempPayrollRecords() {
        return tempPayrollRecords;
    }

    public List<Integer> getEmployeeIDList() {
        return employeeIDList;
    }

    public List<String> getPayrollIDList() {
        return payrollIDList;
    }

    public void runPayroll() throws EmployeeRecordsException, PayrollException {
        //logic to calculate payroll for each employee
        if (employeeIDList.isEmpty()) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        if (payrollIDList.size() == employeeIDList.size()) {
            PayrollException.throwError_PAYROLL_ALREADY_PROCESSED();
            return;
        }

        int oldPayrollCount = payrollIDList.size();
        int newPayrollCount = 0;

        //calculate payroll for each employee
        for (Integer employeeID : employeeIDList) {
            //Create payroll ID for the employee
            String payrollID = generate_PayrollID(employeeID);

            if (payrollIDList.contains(payrollID)) {
                newPayrollCount++;
                continue; //Skip if payroll already exists
            }

            //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
            List<AttendanceRecord> attendanceRecords = getAttendanceRecordsForThisPeriod(employeeID);

            if (attendanceRecords == null || attendanceRecords.isEmpty()) {
                continue; //Skip if no attendance records found
            }

            double totalHoursWorked = DateTimeCalculator.totalHoursWorked(attendanceRecords);
            double overtimeHoursWorked = DateTimeCalculator.totalOvertimeHours(attendanceRecords);

//            System.out.println("Payroll ID: " + payrollID);
//            System.out.println("Employee ID: " + employeeID);
//            System.out.println("Total Hours Worked: " + totalHoursWorked);
//            System.out.println("Overtime Hours Worked: " + overtimeHoursWorked);

            //Calculate Payroll
            EmployeeRecord employeeRecord = getEmployeeRecord(employeeID);
            PayrollCalculator payrollCalculator = new PayrollCalculator(employeeRecord, totalHoursWorked, overtimeHoursWorked);

            //Retrieve and display results
            tempPayrollRecords.add(new PayrollRecords(
                    payrollID,
                    employeeRecord.employeeID(),
                    employeeRecord.lastName() + ", " + employeeRecord.firstName(),
                    DateTimeUtils.getMonthlyPeriod_StartDate(),
                    DateTimeUtils.getMonthlyPeriod_EndDate(),
                    employeeRecord.position() + " / " + employeeRecord.department(),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.salary()),
                    employeeRecord.hourlyRate(),
                    Convert.roundToTwoDecimalPlaces(totalHoursWorked),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.overtimePay()),
                    employeeRecord.riceSubsidy(),
                    employeeRecord.phoneAllowance(),
                    employeeRecord.clothingAllowance(),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateSSS()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculatePhilhealth()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculatePagIbig()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateWithholdingTax()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateTotalAllowances()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateTotalDeduction()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateGrossPay()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateNetPay())
            ));

            System.out.println("Payroll for " + employeeRecord.lastName() + ", " + employeeRecord.firstName() + " has been generated.");
            System.out.println("Payroll ID: " + payrollID);
            newPayrollCount++;
        }

        //Check if there are newly added records
        if (newPayrollCount == oldPayrollCount) {
            PayrollException.throwError_PAYROLL_ALREADY_PROCESSED();
            tempPayrollRecords.clear();
        }

        //Check if there are no new records
        if (newPayrollCount == 0) {
            PayrollException.throwError_FAILED_PAYROLL();
            tempPayrollRecords.clear();
        }
    }

    public List<String[]> generatePayrollReport(String reportPeriod) {
        LocalDate startDate = DateTimeUtils.getPeriodStartDate(reportPeriod);
        LocalDate endDate = DateTimeUtils.getPeriodEndDate(reportPeriod);

        return reportGenerator.generatePayrollReport(reportPeriod, startDate, endDate);
    }

    public void exportPayrollReport() {
        //TODO: export payroll report
    }

    public void submitPayroll() throws PayrollException {
        //Check if tempPayrollRecords is empty
        if (tempPayrollRecords.isEmpty()) {
            PayrollException.throwError_NO_PAYROLL_PROCESSED();
            return;
        }

        for (PayrollRecords record : tempPayrollRecords) {
            payrollDataService.addPayrollRecord(record);
            currentPeriodPayrollRecord.add(record);
        }

        this.payrollIDList = retrievePayrollIDList();

        tempPayrollRecords.clear();
    }
}

