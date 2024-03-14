package manager;

import calculator.PayrollCalculator;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import interfaces.AttendanceManagement;
import interfaces.EmployeeManagement;
import interfaces.PayrollDataService;
import interfaces.PayrollManagement;
import records.AttendanceRecord;
import records.EmployeeRecord;
import records.PayrollRecord;
import records.util.Convert;
import records.util.DateTimeUtils;
import records.util.ID_Generator;
import records.util.calculator.DateTimeCalculator;

import javax.swing.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static records.util.ID_Generator.generatePayrollID;

/**
 * Manages payroll-related operations including running payroll for a specific period, submitting payroll records,
 * retrieving payroll records, and obtaining payroll IDs.
 * Utilizes interfaces {@link interfaces.PayrollDataService}, {@link interfaces.EmployeeManagement},
 * and {@link interfaces.AttendanceManagement} for data access and management.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link PayrollManager#runPayroll(List, String)}</li>
 *     <li>{@link PayrollManager#submitPayroll(List)}</li>
 *     <li>{@link PayrollManager#getAllPayrollRecords()}</li>
 *     <li>{@link PayrollManager#getPayrollIDList(String)}</li>
 *     <li>{@link PayrollManager#getPayrollRecord(int, YearMonth)}</li>
 *     <li>{@link PayrollManager#getPayrollRecord(String)}</li>
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
    public void runPayroll(List<PayrollRecord> tempPayrollRecords, String payrollPeriod) throws EmployeeRecordsException, PayrollException {
        LocalDate periodStart = DateTimeUtils.getPeriodStartDate(payrollPeriod);
        LocalDate periodEnd = DateTimeUtils.getPeriodEndDate(payrollPeriod);

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
            String payrollID = generatePayrollID(employeeID);

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

    /**
     * Submits the temporary payroll records to the database.
     *
     * @param tempPayrollRecords the temporary payroll records to submit
     * @throws PayrollException if an error occurs
     */
    @Override
    public void submitPayroll(List<PayrollRecord> tempPayrollRecords) throws PayrollException {
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
     * @param yearMonth  the year and month of the payroll record
     * @return the payroll record
     */
    @Override
    public PayrollRecord getPayrollRecord(int employeeID, YearMonth yearMonth) {
        String payrollID = ID_Generator.generatePayrollID(employeeID, yearMonth); // Generate the payrollID based on the employeeID and the yearMonth parameter

        try {
            return payrollDataService.getPayroll_ByPayrollID(payrollID);
        } catch (Exception e) {
            System.err.println("Cannot get Payslip, Payroll record not found for " + payrollID);

            //prompt the service if they want to check the latest payroll
            int option = JOptionPane.showConfirmDialog(null, "No Payroll record found for " + yearMonth + "\nDo you want to check the latest payroll?", "Payroll Record Not Found", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.NO_OPTION) {
                return null;
            }

            try {
                return payrollDataService.getAll_Payroll_ByEmployeeID(String.valueOf(employeeID)).get(0); //retrieve the first record
            } catch (Exception ex) {
                System.err.println("Cannot get Payslip, Payroll record not found for " + employeeID);
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
        LocalDate startDate = DateTimeUtils.getPeriodStartDate(period);
        LocalDate endDate = DateTimeUtils.getPeriodEndDate(period);
        try {
            return payrollDataService.getAll_PayrollRecords_ForPeriod(startDate, endDate);
        } catch (Exception e) {
            System.err.println("Error: Cannot get Payroll Record: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
