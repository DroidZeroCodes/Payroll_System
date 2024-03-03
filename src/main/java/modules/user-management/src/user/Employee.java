package user;

import data.*;
import interfaces.*;
import service.*;
import util.Convert;
import util.ErrorMessages;
import util.TimeUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Employee implements AttendanceManagement, LeaveManagement {
    private final int employeeID;
    protected final String payrollID;
    protected final String attendanceID;
    protected EmployeeRecord personalRecord;
    protected List<LeaveRecord> leaveRecords;
    protected List<AttendanceRecord> attendanceRecords;
    protected PayrollRecords payslip;
    protected LeaveBalanceRecord leaveBalance;

    //data services
    protected EmployeeDataService employeeDataService;
    protected AttendanceDataService attendanceDataService;
    protected LeaveDataService leaveDataService;
    protected LeaveBalanceDataService leaveBalanceDataService;
    protected PayrollDataService payrollDataService;
    public Employee(FileDataService dataService, int employeeID) {
        this.employeeID = employeeID;
        this.employeeDataService = dataService;
        this.attendanceDataService = dataService;
        this.leaveDataService = dataService;
        this.leaveBalanceDataService = dataService;
        this.payrollDataService = dataService;
        this.payrollID = getCurrentPeriod_PayrollID(employeeID);
        this.attendanceID = getCurrentPeriod_AttendanceID(employeeID);
        this.personalRecord = employeeDataService.getEmployeeRecord_ByEmployeeID(employeeID);
        this.leaveRecords = leaveDataService.getLeaveRecords_ByEmployeeID(employeeID);
        this.leaveBalance = leaveBalanceDataService.getLeaveBalance_ByEmployeeID(employeeID);
        this.attendanceRecords = attendanceDataService.getAttendanceRecords_ByEmployeeID(employeeID);
        this.payslip = payrollDataService.getPayroll_ByPayrollID(payrollID);
    }
    protected String getCurrentPeriod_PayrollID(int employeeID){
        return TimeUtils.getCurrentPeriod_Year() +
                Convert.MonthValueToString(TimeUtils.getCurrentPeriod_Month()) +
                "-" +
                employeeID;
    }
    protected String getCurrentPeriod_AttendanceID(int employeeID){
        return LocalDate.now() + "-" + employeeID;
    }
    protected LocalTime currentTime(){
        return LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    protected int getLeaveBalance(String leaveTypeBalanceField) {
        return switch (leaveTypeBalanceField) {
            case "SICK" -> leaveBalance.sickBalance();
            case "VACATION" -> leaveBalance.vacationBalance();
            case "PATERNAL" -> leaveBalance.paternalBalance();
            case "BEREAVEMENT" -> leaveBalance.bereavementBalance();
            default -> 0;
        };
    }

    //Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getPayrollID() {
        return payrollID;
    }

    public EmployeeRecord getPersonalRecord() {
        return personalRecord;
    }

    public void setPersonalRecord(EmployeeRecord personalRecord) {
        this.personalRecord = personalRecord;
    }

    public List<LeaveRecord> getLeaveRecords() {
        return leaveRecords;
    }

    public void setLeaveRecords(List<LeaveRecord> leaveRecords) {
        this.leaveRecords = leaveRecords;
    }

    public List<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public PayrollRecords getPayslip(YearMonth yearMonth) {
        return payslip;
    }

    public void setPayslip(PayrollRecords payslip) {
        this.payslip = payslip;
    }

    public LeaveBalanceRecord getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(LeaveBalanceRecord leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    /**
     * Method to clock in the employee.
     * It retrieves the current time and date, generates a unique attendance ID,
     * creates a new attendance record, and checks if the employee has already clocked in for the day.
     * If the employee has not clocked in, it adds a new attendance record and updates the display of attendance records.
     * If the employee has already clocked in, it displays an error message and prompts the employee to clock out first.
     */
    @Override
    public void clockIn() {
        // Retrieve the current time and date
        LocalTime timeIn = currentTime();
        LocalDate currentDate = LocalDate.now();

        // Check if the attendance record already exists
        AttendanceRecord newRecord = attendanceDataService.getAttendanceRecord_ByAttendanceID(attendanceID);

        if (newRecord != null) {
            ErrorMessages.AttendanceModuleError_HAS_TIMED_IN();
            System.out.println("You have already clocked in for this employee today. Please clock out first.");
            return;
        }

        // Add the new attendance record
        attendanceDataService.addAttendanceRecord(new AttendanceRecord(
                attendanceID,
                currentDate,
                employeeID,
                personalRecord.lastName(),
                personalRecord.firstName(),
                timeIn,
                null,
                0,
                0
        ));
    };

    @Override
    public void clockOut() {
        LocalTime timeOut = currentTime();
        LocalDate currentDate = LocalDate.now();

        //TODO: @Ibra

        //time Out must

    }

    /**
     * Submit a leave request based on the selected leave type, start date, end date, and reasons.
     */
    @Override
    public void submitLeaveRequest(String leaveType, LocalDate startDate, LocalDate endDate, String reasons) {
        LocalDate currentDate = LocalDate.now();

        if (startDate == null || endDate == null){
            ErrorMessages.LeaveModuleError_INVALID_DATE();
            throw new RuntimeException("Empty date");
        }

        if (startDate.isAfter(endDate)){
            ErrorMessages.LeaveModuleError_INVALID_DATE_RANGE();
            throw new RuntimeException("Invalid date range");
        }

        assert leaveType != null;

        String[] currentRecord = (String[]) leaveRecords.toArray();

        // Check if there are any conflicting leave requests
        if (leaveRecords.stream().anyMatch(record ->
                TimeUtils.datesOverlap(startDate, endDate, Convert.MDYtoLocalDate(currentRecord[4]), Convert.MDYtoLocalDate(currentRecord[5])))) {
            ErrorMessages.LeaveModuleError_CONFLICTING_DATES();
            throw new RuntimeException("Conflicting leave request detected");
        }

        // Retrieve the leave balance for the selected leave type
        String leaveTypeBalanceField = leaveType.toUpperCase();
        int leaveBalanceValue = getLeaveBalance(leaveTypeBalanceField);

        // Update the leave balance
        int totalDays = DateTimeCalculator.totalDays(startDate, endDate);
        if (leaveBalanceValue < totalDays){
            ErrorMessages.LeaveModuleError_INSUFFICIENT_BALANCE();
            throw new RuntimeException("Insufficient " + leaveType.toLowerCase() + " leave balance");
        } else {
            leaveBalanceDataService.updateLeaveBalance(employeeID,leaveType.toUpperCase() + "_LEAVE", leaveBalanceValue - totalDays);
        }

        // Add the new leave record
        leaveDataService.addLeaveRecord(new LeaveRecord(
                currentDate + "-" + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + "-" + employeeID,
                employeeID,
                currentDate,
                leaveType,
                startDate,
                endDate,
                totalDays,
                reasons,
                "PENDING"
        ));
    }
}

