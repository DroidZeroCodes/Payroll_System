package user;

import data.*;
import exceptions.AttendanceException;
import exceptions.LeaveException;
import interfaces.*;
import service.DateTimeCalculator;
import service.FileDataService;
import util.Convert;
import util.TimeUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Employee implements AttendanceManagement, LeaveManagement {
    private final int employeeID;
    protected final String payrollID;
    protected final String attendanceID;
    protected EmployeeRecord personalRecord;
    protected List<LeaveRecord> leaveRecords;
    protected List<AttendanceRecord> attendanceRecords;
    protected AttendanceRecord currentAttendanceRecord;
    protected LeaveRecord currentLeaveRecord;
    protected PayrollRecords payslip;
    protected LeaveBalanceRecord leaveBalance;

    //data services
    protected EmployeeDataService employeeDataService;
    protected AttendanceDataService attendanceDataService;
    protected LeaveDataService leaveDataService;
    protected LeaveBalanceDataService leaveBalanceDataService;
    protected PayrollDataService payrollDataService;
    public Employee(FileDataService dataService, int employeeID) {
        //generate IDs
        this.employeeID = employeeID;
        this.payrollID = generate_PayrollID(employeeID);
        this.attendanceID = generate_AttendanceID(employeeID);
        //data services
        this.employeeDataService = dataService;
        this.attendanceDataService = dataService;
        this.leaveDataService = dataService;
        this.leaveBalanceDataService = dataService;
        this.payrollDataService = dataService;

        //load data
        try {
            this.personalRecord = employeeDataService.getEmployeeRecord_ByEmployeeID(employeeID);
        } catch (Exception e) {
            this.personalRecord = null;
            System.out.println("Employee record not found");
        }

        try {
            this.leaveRecords = leaveDataService.getLeaveRecords_ByEmployeeID(employeeID);
        } catch (Exception e) {
            this.leaveRecords = new ArrayList<>();
            System.out.println("Leave record not found");
        }

        try {
            this.currentAttendanceRecord = attendanceDataService.getAttendanceRecord_ByAttendanceID(attendanceID);
        } catch (Exception e) {
            this.currentAttendanceRecord = null;
            System.out.println("Attendance record not found");
        }

        try {
            this.attendanceRecords = attendanceDataService.getAttendanceRecords_ByEmployeeID(employeeID);
        } catch (Exception e) {
            this.attendanceRecords = new ArrayList<>();
            System.out.println("Attendance record not found");
        }

        try {
            this.leaveBalance = leaveBalanceDataService.getLeaveBalance_ByEmployeeID(employeeID);
        } catch (Exception e) {
            this.leaveBalance = null;
            System.out.println("Leave balance record not found");
        }

        try {
            this.payslip = payrollDataService.getPayroll_ByPayrollID(payrollID);
        } catch (Exception e) {
            try {
                this.payslip = payrollDataService.getPayroll_ByEmployeeID(employeeID);
            } catch (Exception ex) {
                this.payslip = null;
                System.out.println("Payroll record not found");
            }
        }
    }
    protected String generate_PayrollID(int employeeID){
        return TimeUtils.getCurrentPeriod_Year() +
                Convert.MonthValueToString(TimeUtils.getCurrentPeriod_Month()) +
                "-" +
                employeeID;
    }
    //ID GENERATOR
    protected String generate_PayrollID(int employeeID, YearMonth yearMonth) {
        return yearMonth.getYear() + yearMonth.getMonthValue() + "-" + employeeID;
    }
    protected String generate_AttendanceID(int employeeID){
        return LocalDate.now() + "-" + employeeID;
    }
    protected String previous_AttendanceID(int employeeID){
        return LocalDate.now().minusDays(1) + "-" + employeeID;
    }
    public String generate_LeaveID(int employeeID) {
        return LocalDate.now() + "-" + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + "-" + employeeID;
    }

    protected LocalTime currentTime(){
        return LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
    }


    private int deductLeaveBalance(LeaveRecord leaveRecord, int days) {
        return getLeaveBalance(leaveRecord.leaveType()) - days;
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
    protected void updateLeaveBalance(LeaveBalanceRecord updatedRecord) {
        //update database
        leaveBalanceDataService.updateLeaveBalance(updatedRecord);
        //update display
        leaveBalance = updatedRecord;
    }
    protected void addLeaveRecord(LeaveRecord newRecord) {
        System.out.println("Adding leave record: " + newRecord);

        //add on database
        leaveDataService.addLeaveRecord(newRecord);

        //add on display
        leaveRecords.add(0, newRecord);

        //deduct leave balance
        int newBalance = deductLeaveBalance(newRecord, newRecord.totalDays());

        //update leave balance depending on leave type
        switch (newRecord.leaveType()) {
            case "SICK" -> {
                leaveBalance = leaveBalance.withSickBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalance);
            }
            case "VACATION" -> {
                leaveBalance = leaveBalance.withVacationBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalance);
            }
            case "PATERNAL" -> {
                leaveBalance = leaveBalance.withPaternalBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalance);
            }
            case "BEREAVEMENT" -> {
                leaveBalance = leaveBalance.withBereavementBalance(newBalance);
                leaveBalanceDataService.updateLeaveBalance(leaveBalance);
            }
        }


    }
    protected void addAttendanceRecord(AttendanceRecord newRecord) {
        System.out.println("Adding attendance record: " + newRecord);
        //add on database/
        attendanceDataService.addAttendanceRecord(newRecord);
        //add on display
        attendanceRecords.add(0, newRecord);
    }
    protected void updateAttendanceRecord(AttendanceRecord updatedRecord) {
        System.out.println("Updating attendance record: " + updatedRecord);
        //update database
        attendanceDataService.updateAttendanceRecord(updatedRecord);
        //update display
        attendanceRecords.set(attendanceRecords.indexOf(updatedRecord), updatedRecord);
    }

    //Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }
    public String getPayrollID() {
        return payrollID;
    }

    public String getAttendanceID() {
        return attendanceID;
    }

    public AttendanceRecord getCurrentAttendanceRecord() {
        return currentAttendanceRecord;
    }

    public LeaveRecord getCurrentLeaveRecord() {
        return currentLeaveRecord;
    }

    public PayrollRecords getPayslip() {
        return payslip;
    }

    public EmployeeRecord getPersonalRecord() {
        return personalRecord;
    }
    public List<LeaveRecord> getLeaveRecords() {
        return leaveRecords;
    }

    public List<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public PayrollRecords getPayslip(YearMonth yearMonth) {
        String payrollID = generate_PayrollID(employeeID, yearMonth); // Generate the payrollID based on the employeeID and the yearMonth parameter

        try {
            return payrollDataService.getPayroll_ByPayrollID(payrollID);
        } catch (Exception e) {
            System.out.println("Payroll record not found for " + yearMonth);
            return null;
        }
    }

    public LeaveBalanceRecord getLeaveBalance() {
        return leaveBalance;
    }

    /**
     * Method to clock in the employee.
     * It retrieves the current time and date, generates a unique attendance ID,
     * creates a new attendance record, and checks if the employee has already clocked in for the day.
     * If the employee has not clocked in, it adds a new attendance record and updates the display of attendance records.
     * If the employee has already clocked in, it displays an error message and prompts the employee to clock out first.
     */
    @Override
    public void clockIn() throws AttendanceException {
        // Retrieve the current time and date
        LocalTime timeIn = currentTime();
        LocalDate currentDate = LocalDate.now();

        // Retrieve the attendance record
        if (currentAttendanceRecord != null) {
            // Display an error message
            AttendanceException.throwError_ALREADY_CLOCKED_IN();
        }

        // Add the new attendance record
        addAttendanceRecord(new AttendanceRecord(
                attendanceID,
                currentDate,
                employeeID,
                personalRecord.lastName(),
                personalRecord.firstName(),
                timeIn,
                LocalTime.MIN,
                LocalTime.MIN,
                LocalTime.MIN
        ));
    }

    @Override
    public void clockOut() throws AttendanceException {
        LocalTime timeOut = currentTime();

        if (currentAttendanceRecord == null) {
            AttendanceException.throwError_NOT_CLOCKEDIN();
            return;
        }

        if (!currentAttendanceRecord.timeOut().equals(LocalTime.MIN)) {
            AttendanceException.throwError_ALREADY_CLOCKED_OUT();
            return;
        }


        LocalTime hoursWorked = DateTimeCalculator.calculateRegularHoursWorked(currentAttendanceRecord.timeIn(), timeOut);
        LocalTime overtimeHours = DateTimeCalculator.calculateOvertimeHours(currentAttendanceRecord.timeIn(), timeOut);

        updateAttendanceRecord(currentAttendanceRecord.withTimeOut(timeOut).withHoursWorked(hoursWorked).withOverTimeHours(overtimeHours));
        }

    /**
     * Submit a leave request based on the selected leave type, start date, end date, and reasons.
     */
    @Override
    public void submitLeaveRequest(LeaveRecord leaveRecord) throws LeaveException {
        LocalDate startDate = leaveRecord.startDate();
        LocalDate endDate = leaveRecord.endDate();

        if (startDate == null || endDate == null) {
            LeaveException.throwError_INVALID_DATE();
            return;
        }

        if (startDate.isAfter(endDate)) {
            LeaveException.throwError_INVALID_DATE_RANGE();
            return;
        }

        if (leaveRecords.stream().anyMatch(record ->
                TimeUtils.datesOverlap(startDate, endDate, record.startDate(), record.endDate()))){
            LeaveException.throwError_CONFLICTING_DATES();
        }

        int leaveBalanceValue = getLeaveBalance(leaveRecord.leaveType());

        int totalDays = DateTimeCalculator.totalDays(startDate, endDate);

        if (leaveBalanceValue < totalDays) {
            LeaveException.throwError_INSUFFICIENT_BALANCE();
        }

        addLeaveRecord(leaveRecord);
    }
}

