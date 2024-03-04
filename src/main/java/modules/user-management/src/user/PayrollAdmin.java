package user;


import data.AttendanceRecord;
import data.EmployeeRecord;
import data.PayrollRecords;
import exceptions.AttendanceException;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import service.FileDataService;
import service.PayrollCalculator;
import util.TimeUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PayrollAdmin extends Employee {
    private final List<PayrollRecords> tempPayrollRecords = new ArrayList<>();
    private List<PayrollRecords> currentPeriodPayrollRecord;
    private List<PayrollRecords> allPayrollRecords;
    private List<Integer> employeeIDList;
    private List<String> payrollIDList = new ArrayList<>();

    public PayrollAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        try {
            this.currentPeriodPayrollRecord = payrollDataService.getPayrollRecords_ByPeriodDate(TimeUtils.getCurrentPeriod_StartDate());
        } catch (Exception e) {
            this.currentPeriodPayrollRecord = new ArrayList<>();
            System.err.println("Error: " + e.getMessage());
        }

        try {
            this.allPayrollRecords = payrollDataService.getAllPayrollRecords();
        } catch (Exception e) {
            this.allPayrollRecords = new ArrayList<>();
            System.err.println("Error: " + e.getMessage());
        }

        try {
            this.employeeIDList = List.of(employeeDataService.getEmployeeIDList());
        } catch (Exception e) {
            this.employeeIDList = new ArrayList<>();
            System.err.println("Error: " + e.getMessage());
        }

        try {
            this.payrollIDList = retrievePayrollIDList();
        } catch (PayrollException e) {
            this.payrollIDList = new ArrayList<>();
            System.err.println("Error: " + e.getMessage());
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
//        LocalDate startDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
//        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        //logic to calculate payroll for each employee
        if (employeeIDList.isEmpty()) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }
        int employeeCount = employeeIDList.size();
        int payrollCount = 0;

        //calculate payroll for each employee
        for (Integer employeeID : employeeIDList) {
            //Create payroll ID for the employee
            String payrollID = generate_PayrollID(employeeID);

            if (payrollIDList.contains(payrollID)) {
                payrollCount++;
                continue; //Skip if payroll already exists
            }

            //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
            AttendanceRecord attendanceRecord;
            try {
                attendanceRecord = getEmployeeAttendanceRecord(employeeID);
            } catch (AttendanceException e) {
                continue; //Skip if attendance record not found
            }

            LocalTime hoursWorked = attendanceRecord.hoursWorked();

            //Calculate Payroll
            if (hoursWorked.isAfter(LocalTime.MIN)) {

                EmployeeRecord employeeRecord = getEmployeeRecord(employeeID);

                PayrollCalculator payrollCalculator = new PayrollCalculator(employeeRecord, attendanceRecord);

                //Clear existing records
                tempPayrollRecords.clear();

                //Retrieve and display results
                tempPayrollRecords.add(new PayrollRecords(
                        payrollID,
                        employeeRecord.employeeID(),
                        employeeRecord.lastName() + ", " + employeeRecord.firstName(),
                        TimeUtils.getCurrentPeriod_StartDate(),
                        TimeUtils.getCurrentPeriod_EndDate(),
                        employeeRecord.position() + " / " + employeeRecord.department(),
                        employeeRecord.basicSalary(),
                        employeeRecord.hourlyRate(),
                        hoursWorked,
                        payrollCalculator.overtimePay(),
                        employeeRecord.riceSubsidy(),
                        employeeRecord.phoneAllowance(),
                        employeeRecord.clothingAllowance(),
                        payrollCalculator.calculateSSS(),
                        payrollCalculator.calculatePhilhealth(),
                        payrollCalculator.calculatePagIbig(),
                        payrollCalculator.calculateWithholdingTax(),
                        payrollCalculator.calculateTotalAllowances(),
                        payrollCalculator.calculateTotalDeduction(),
                        payrollCalculator.calculateGrossPay(),
                        payrollCalculator.calculateNetPay()
                ));
            }
        }

        //Check if there are newly added records
        if (payrollCount == employeeCount) {
            PayrollException.throwError_HAS_PAYROLL();
            tempPayrollRecords.clear();
        }
    }

    public void generatePayrollReport() {
        //TODO: generate payroll report
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
        }

        tempPayrollRecords.clear();
    }
}

