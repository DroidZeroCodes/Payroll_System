package payroll.manager;

import attendance.manager.AttendanceManagement;
import calculator.PayrollCalculator;

import employee.manager.EmployeeManagement;
import records.util.DateTimeCalculator;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import data.service.PayrollDataService;
import records.AttendanceRecord;
import records.EmployeeRecord;
import records.PayrollRecord;
import records.util.Convert;
import records.util.DateTimeUtils;
import records.util.ID_Generator;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages payroll-related operations.
 *
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link PayrollManager#runBatchPayroll(List, String)}</li>
 *     <li>{@link PayrollManager#submitBatchPayroll(List)}</li>
 *     <li>{@link PayrollManager#getAllPayrollRecords()}</li>
 *     <li>{@link PayrollManager#getPayrollIDList(String)}</li>
 *     <li>{@link PayrollManager#getPayrollRecord(int, int, String)}</li>
 *     <li>{@link PayrollManager#getPayrollRecord(String)}</li>
 *     <li>{@link PayrollManager#getPayrollRecord_List(String)}</li>
 * </ul>
 *
 * @author [Author Name]
 */

public class PayrollManager implements PayrollManagement {
    private final PayrollDataService payrollDataService;
    private final EmployeeManagement employeeManager;
    private final AttendanceManagement attendanceManager;

    /**
     * Constructor for the PayrollManager class.
     * Initializes the PayrollDataService, EmployeeManagement, and AttendanceManagement objects.
     *
     * @param payrollDataService The PayrollDataService object to use for data access.
     * @param employeeManager    The EmployeeManagement object to use for employee management.
     * @param attendanceManager  The AttendanceManagement object to use for attendance management.
     */
    public PayrollManager(PayrollDataService payrollDataService, EmployeeManagement employeeManager, AttendanceManagement attendanceManager) {
        this.payrollDataService = payrollDataService;
        this.employeeManager = employeeManager;
        this.attendanceManager = attendanceManager;
    }


    /**
     * Runs the payroll for the specified period.
     *
     * @param tempPayrollRecords the temporary payroll records to process
     * @param payrollPeriod      the period for which the payroll is being run
     * @throws EmployeeRecordsException if no records are found
     * @throws PayrollException         if an error occurs
     */
    @Override
    public void runBatchPayroll(List<PayrollRecord> tempPayrollRecords, String payrollPeriod) throws EmployeeRecordsException, PayrollException {
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate_Current(payrollPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate_Current(payrollPeriod);

        //logic to calculate payroll for each employee
        List<Integer> employeeIDList = employeeManager.getEmployeeIDList();
        List<String> payrollIDList = getPayrollIDList(payrollPeriod);

        if (employeeIDList.isEmpty()) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        int oldPayrollCount = payrollIDList.size();
        int newPayrollCount = 0;

        //calculate payroll for each employee
        for (Integer employeeID : employeeIDList) {
            //Create payroll ID for the employee
            String payrollID = ID_Generator.generatePayrollID(employeeID, payrollPeriod);

            if (payrollIDList.contains(payrollID)) {
                newPayrollCount++;
                continue; //Skip if payroll already exists
            }

            //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
            List<AttendanceRecord> attendanceRecords = attendanceManager.getAttendanceRecord_List(employeeID, periodStart, periodEnd);

            if (attendanceRecords == null || attendanceRecords.isEmpty()) {
                continue; //Skip if no attendance records found
            }

            double totalHoursWorked = DateTimeCalculator.totalHoursWorked(attendanceRecords);
            double overtimeHoursWorked = DateTimeCalculator.totalOvertimeHours(attendanceRecords);

            //Calculate Payroll
            EmployeeRecord employeeRecord = employeeManager.getEmployeeRecord(employeeID);
            double hourlyRate = employeeRecord.hourlyRate();
            double riceSubsidy = employeeRecord.riceSubsidy();
            double phoneAllowance = employeeRecord.phoneAllowance();
            double clothingAllowance = employeeRecord.clothingAllowance();

            PayrollCalculator payrollCalculator = new PayrollCalculator(totalHoursWorked, overtimeHoursWorked, hourlyRate, riceSubsidy, phoneAllowance, clothingAllowance);

            //Retrieve and display results
            tempPayrollRecords.add(new PayrollRecord(
                    payrollID,
                    employeeRecord.employeeID(),
                    employeeRecord.lastName() + ", " + employeeRecord.firstName(),
                    periodStart,
                    periodEnd,
                    employeeRecord.position() + " / " + employeeRecord.department(),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.salary()),
                    hourlyRate,
                    Convert.roundToTwoDecimalPlaces(totalHoursWorked),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.overtimePay()),
                    employeeRecord.riceSubsidy(),
                    phoneAllowance,
                    clothingAllowance,
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateSSS()),
                    Convert.roundToTwoDecimalPlaces(payrollCalculator.calculatePhilHealth()),
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
        if (newPayrollCount == oldPayrollCount && newPayrollCount > 0) {
            PayrollException.throwError_PAYROLL_ALREADY_PROCESSED();
            tempPayrollRecords.clear();
        }

        //Check if there are no new records
        if (newPayrollCount == 0) {
            PayrollException.throwError_FAILED_PAYROLL();
            tempPayrollRecords.clear();
        }
    }

    /**
     * Submits the temporary payroll records to the database.
     *
     * @param tempPayrollRecords the temporary payroll records to submit
     * @throws PayrollException if an error occurs
     */
    @Override
    public void submitBatchPayroll(List<PayrollRecord> tempPayrollRecords) throws PayrollException {
        //Check if tempPayrollRecords is empty
        if (tempPayrollRecords.isEmpty()) {
            PayrollException.throwError_NO_PAYROLL_PROCESSED();
            return;
        }

        for (PayrollRecord record : tempPayrollRecords) {
            payrollDataService.addPayrollRecord(record);
        }

        tempPayrollRecords.clear();
    }

    @Override
    public PayrollRecord runManualPayroll(PayrollRecord tempPayrollRecord, String payrollPeriod) throws EmployeeRecordsException {
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate_Current(payrollPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate_Current(payrollPeriod);

        List<Integer> employeeIDList = employeeManager.getEmployeeIDList();
        List<String> payrollIDList = getPayrollIDList(payrollPeriod);

        if (employeeIDList.isEmpty()) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return null;
        }

        String payrollID = ID_Generator.generatePayrollID(tempPayrollRecord.employeeID(), payrollPeriod);

        if (payrollIDList.contains(payrollID)) {
            int option = JOptionPane.showConfirmDialog(null, "Payroll already processed. Do you want to overwrite?", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION){
                return null;
            }
        }

        EmployeeRecord employeeRecord = employeeManager.getEmployeeRecord(tempPayrollRecord.employeeID());
        PayrollCalculator payrollCalculator = new PayrollCalculator(
                tempPayrollRecord.hoursWorked(), tempPayrollRecord.overTimePay(),tempPayrollRecord.hourlyRate(),
                tempPayrollRecord.riceSubsidy(), tempPayrollRecord.phoneAllowance(), tempPayrollRecord.clothingAllowance());

        return new PayrollRecord(
                payrollID,
                tempPayrollRecord.employeeID(),
                employeeRecord.lastName() + ", " + employeeRecord.firstName(),
                periodStart,
                periodEnd,
                employeeRecord.position() + " / " + employeeRecord.department(),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.salary()),
                tempPayrollRecord.hourlyRate(),
                Convert.roundToTwoDecimalPlaces( tempPayrollRecord.hoursWorked()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.overtimePay()),
                tempPayrollRecord.riceSubsidy(),
                tempPayrollRecord.phoneAllowance(),
                tempPayrollRecord.clothingAllowance(),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateSSS()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculatePhilHealth()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculatePagIbig()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateWithholdingTax()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateTotalAllowances()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateTotalDeduction()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateGrossPay()),
                Convert.roundToTwoDecimalPlaces(payrollCalculator.calculateNetPay()));
    }

    /**
     * Submits the temporary payroll record to the database.
     * @param tempPayrollRecord the payroll record to submit
     */
    @Override
    public void submitManualPayroll(PayrollRecord tempPayrollRecord) {
        payrollDataService.addPayrollRecord(tempPayrollRecord);
    }


    /**
     * Retrieves all payroll records.
     *
     * @return a list of all payroll records
     */
    @Override
    public List<PayrollRecord> getAllPayrollRecords() {
        try {
            return payrollDataService.getAll_PayrollRecords();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    /**
     * Retrieves the list of payroll IDs for the specified period
     *
     * @param period the payroll period
     * @return the list of payroll IDs
     */
    @Override
    public List<String> getPayrollIDList(String period) {
        List<String> payrollIDList = new ArrayList<>();

        List<PayrollRecord> payrollRecords = getPayrollRecord_List(period); // Retrieve the list of payroll records for the specified period();

        try {
            for (PayrollRecord payrollRecord : payrollRecords) {
                payrollIDList.add(payrollRecord.payrollID());
            }
            return payrollIDList;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Retrieves the payroll record for the specified employee and year and month
     *
     * @param employeeID the ID of the employee
     * @param month the month of the payroll
     * @param period the period of the payroll
     * @return the payroll record
     */
    @Override
    public PayrollRecord getPayrollRecord(int employeeID, int month, String period) {
        String payrollID = ID_Generator.generatePayrollID_WithMonth(employeeID, month, period); // Generate the payrollID based on the employeeID and the Month parameter

        try {
            return payrollDataService.getPayroll_ByPayrollID(payrollID);
        } catch (Exception e) {
            System.err.println("Cannot get Payslip, Payroll record not found for " + payrollID);

            int option = JOptionPane.showConfirmDialog(null, "No Payroll record found for " + period + " " + Month.of(month) + "\nDo you want to check the latest payroll?", "Payroll Record Not Found", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.NO_OPTION) {
                return null;
            }

            try {
                List<PayrollRecord> allPayrolls = payrollDataService.getAll_Payroll_ByEmployeeID(String.valueOf(employeeID));
                if (!allPayrolls.isEmpty()) {
                    return allPayrolls.get(0);
                } else {
                    System.err.println("No Payroll record found for employee: " + employeeID);
                    return null;
                }
            } catch (Exception ex) {
                System.err.println("Cannot get Payslip, Error retrieving payroll records for employee: " + employeeID);
                return null;
            }
        }
    }

    /**
     * Retrieves the payroll record for the specified ID
     *
     * @param payrollID the ID of the payroll record
     * @return the payroll record
     */
    @Override
    public PayrollRecord getPayrollRecord(String payrollID) {
        try {
            return payrollDataService.getPayroll_ByPayrollID(payrollID);
        } catch (Exception e) {
            System.err.println("Error: Cannot get Payroll Record: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves the list of payroll records for the specified period
     *
     * @param period the period for which the records are retrieved
     * @return the list of payroll records
     */
    @Override
    public List<PayrollRecord> getPayrollRecord_List(String period) {
        LocalDate startDate = DateTimeUtils.getPeriodStartDate_Current(period);
        LocalDate endDate = DateTimeUtils.getPeriodEndDate_Current(period);
        try {
            return payrollDataService.getAll_PayrollRecords_ForPeriod(startDate, endDate);
        } catch (Exception e) {
            System.err.println("Error: Cannot get Payroll Record: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public double getHoursWorked(int employeeID, String payrollPeriod){
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate_Current(payrollPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate_Current(payrollPeriod);

        //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
        List<AttendanceRecord> attendanceRecords = attendanceManager.getAttendanceRecord_List(employeeID, periodStart, periodEnd);

        if (attendanceRecords == null || attendanceRecords.isEmpty()) {
            return 0.0;
        }

        return DateTimeCalculator.totalHoursWorked(attendanceRecords);
    }

    @Override
    public double getOvertimeHours(int employeeID, String payrollPeriod) {
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate_Current(payrollPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate_Current(payrollPeriod);

        //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
        List<AttendanceRecord> attendanceRecords = attendanceManager.getAttendanceRecord_List(employeeID, periodStart, periodEnd);

        if (attendanceRecords == null || attendanceRecords.isEmpty()) {
            return 0.0;
        }

        return DateTimeCalculator.totalOvertimeHours(attendanceRecords);
    }
}
