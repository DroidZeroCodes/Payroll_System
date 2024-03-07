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
    private final ReportGenerator reportGenerator;

    public PayrollAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        this.reportGenerator = new ReportGenerator(dataService);
    }

    private List<String> getPayrollIDList() {
        List<String> payrollIDList = new ArrayList<>();
        for (PayrollRecords payrollRecord : getCurrentPeriodPayrollRecord()) {
            payrollIDList.add(payrollRecord.payrollID());
        }

        return payrollIDList;
    }

    public List<PayrollRecords> getCurrentPeriodPayrollRecord() {
        try {
            return payrollDataService.getAll_PayrollRecords_ForPeriod(DateTimeUtils.getMonthlyPeriod_StartDate(), null);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<PayrollRecords> getAllPayrollRecords() {
        try {
            return payrollDataService.getAll_PayrollRecords();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<PayrollRecords> getTempPayrollRecords() {
        return tempPayrollRecords;
    }

    public List<Integer> getEmployeeIDList() {
        try {
            return List.of(employeeDataService.getEmployeeID_List());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void runPayroll() throws EmployeeRecordsException, PayrollException {
        //logic to calculate payroll for each employee
        List<Integer> employeeIDList = getEmployeeIDList();
        List<String> payrollIDList = getPayrollIDList();

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

    public List<String[]> generatePayrollReport(String reportPeriod) throws PayrollException {
        LocalDate startDate = DateTimeUtils.getPeriodStartDate(reportPeriod);
        LocalDate endDate = DateTimeUtils.getPeriodEndDate(reportPeriod);

        return reportGenerator.generatePayrollReport(reportPeriod, startDate, endDate);
    }

    public void submitPayroll() throws PayrollException {
        //Check if tempPayrollRecords is empty
        if (tempPayrollRecords.isEmpty()) {
            PayrollException.throwError_NO_PAYROLL_PROCESSED();
            return;
        }

        for (PayrollRecords record : tempPayrollRecords) {
            payrollDataService.addPayrollRecord(record);
        }

        tempPayrollRecords.clear();
    }
}

