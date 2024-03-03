package user;


import data.AttendanceRecord;
import data.EmployeeRecord;
import data.PayrollRecords;
import interfaces.PayrollActions;
import service.FileDataService;
import service.PayrollCalculator;
import util.TimeUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PayrollAdmin extends Employee implements PayrollActions {
    private final List<PayrollRecords> payrollRecords_CurrentPeriod;
    private final List<PayrollRecords> payrollRecords_All;
    private final List<PayrollRecords> tempPayrollRecords = new ArrayList<>();
    public PayrollAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);
        this.payrollRecords_CurrentPeriod = payrollDataService.getPayrollRecords_ByPeriodDate(TimeUtils.getCurrentPeriod_StartDate());
        this.payrollRecords_All = payrollDataService.getAllPayrollRecords();
    }
    public List<PayrollRecords> getPayrollRecords_CurrentPeriod() {
        return payrollRecords_CurrentPeriod;
    }

    public List<PayrollRecords> getPayrollRecords_All() {
        return payrollRecords_All;
    }

    public List<PayrollRecords> getTempPayrollRecords() {
        return tempPayrollRecords;
    }

    @Override
    public void runPayroll(){
//        LocalDate startDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
//        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        //logic to calculate payroll for each employee

        //retrieve employee information specifically employee ID's
        Integer[] employeeIDList = employeeDataService.getEmployeeIDList();

        //calculate payroll for each employee

        for (Integer employeeID : employeeIDList){
            //Create payroll ID for the employee
            String payrollID = generate_PayrollID(employeeID);
            //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
            AttendanceRecord attendanceRecord = attendanceDataService.getAttendanceRecord_ByAttendanceID(payrollID);
            LocalTime hoursWorked = attendanceRecord.hoursWorked();
            if (hoursWorked.isAfter(LocalTime.MIN)) {
                EmployeeRecord employeeRecord = employeeDataService.getEmployeeRecord_ByEmployeeID(employeeID);
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
    @Override
    public void generatePayrollReport() {

    }

    @Override
    public void exportPayrollReport() {

    }

    @Override
    public void searchPayslip() {
    }

    @Override
    public void searchPayroll() {
    }

    @Override
    public void submitPayroll() {
        for (PayrollRecords record : tempPayrollRecords) {
            payrollDataService.addPayrollRecord(record);
        }
    }
}

