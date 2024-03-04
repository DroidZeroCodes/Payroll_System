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
    private List<PayrollRecords> currentPeriodPayrollRecord;
    private List<PayrollRecords> allPayrollRecords;
    private final List<PayrollRecords> tempPayrollRecords = new ArrayList<>();
    private List<Integer> employeeIDList;
    private List<String> payrollIDList;
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
            this.employeeIDList = null;
            System.err.println("Error: " + e.getMessage());
        }

        try {
            this.payrollIDList = retrievePayrollIDList();
        } catch (PayrollException e) {
            this.payrollIDList = null;
            System.err.println("Error: " + e.getMessage());
        }
    }
    private List<String> retrievePayrollIDList() throws PayrollException {
        for (PayrollRecords payrollRecord : currentPeriodPayrollRecord) {
            payrollIDList.add(payrollRecord.payrollID());
        }

        if (payrollIDList == null){
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

    public void runPayroll() throws EmployeeRecordsException {
//        LocalDate startDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
//        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        //logic to calculate payroll for each employee

        if (employeeIDList == null){
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        //calculate payroll for each employee
        for (Integer employeeID : employeeIDList){
            //Create payroll ID for the employee
            String payrollID = generate_PayrollID(employeeID);

            if (payrollIDList.contains(payrollID)){
                continue;
            }

            //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
            AttendanceRecord attendanceRecord;
            try {
                attendanceRecord = getEmployeeAttendanceRecord(employeeID);
            } catch (AttendanceException e) {
                continue;
            }

            LocalTime hoursWorked = attendanceRecord.hoursWorked();
            if (hoursWorked.isAfter(LocalTime.MIN)) {

                EmployeeRecord employeeRecord = getEmployeeRecord(employeeID);

                PayrollCalculator payrollCalculator = new PayrollCalculator(employeeRecord, attendanceRecord);

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
    }
    public void generatePayrollReport() {
        //TODO: generate payroll report
    }
    public void exportPayrollReport() {
        //TODO: export payroll report
    }
    public void submitPayroll() {
        for (PayrollRecords record : tempPayrollRecords) {
            payrollDataService.addPayrollRecord(record);
        }
    }
}

