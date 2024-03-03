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
        this.payrollID = generate_PayrollID(employeeID);
        this.attendanceID = generate_AttendanceID(employeeID);

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
    private String generate_LeaveRecordID(int employeeID) {
        return LocalDate.now() + "-" + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) + "-" + employeeID;
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
    protected void updateLeaveBalance(LeaveBalanceRecord updatedRecord) {
        //update database
        leaveBalanceDataService.updateLeaveBalance(updatedRecord);
        //update display
        leaveBalance = updatedRecord;
    }
    protected void addLeaveRecord(LeaveRecord newRecord, LeaveBalanceRecord leaveBalanceRecord) {
        System.out.println("Adding leave record: " + newRecord);

        //add on database
        leaveDataService.addLeaveRecord(newRecord);
        updateLeaveBalance(leaveBalanceRecord);

        //add on display
        leaveRecords.add(0, newRecord);
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
        attendanceRecords.set(0, updatedRecord);
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
    public void clockIn() {
        // Retrieve the current time and date
        LocalTime timeIn = currentTime();
        LocalDate currentDate = LocalDate.now();

        // Check if the attendance record already exists
        try {
            // Retrieve the attendance record
            attendanceDataService.getAttendanceRecord_ByAttendanceID(attendanceID);

            // Display an error message
            System.out.println("Error: You have already clocked in for the day. Please clock out first.");
        } catch (IllegalArgumentException ignored) {
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
    }

    @Override
    public void clockOut() throws AttendanceException {
        LocalTime timeOut = currentTime();

        try {
            AttendanceRecord attendanceRecord = attendanceDataService.getAttendanceRecord_ByAttendanceID(attendanceID);

            if (attendanceRecord != null && !attendanceRecord.timeOut().equals(LocalTime.MIN)) {
                AttendanceException.throwAttendanceError_AlreadyClocked_OUT();
                return;
            }

            assert attendanceRecord != null;
            LocalTime hoursWorked = DateTimeCalculator.calculateRegularHoursWorked(attendanceRecord.timeIn(), timeOut);
            LocalTime overtimeHours = DateTimeCalculator.calculateOvertimeHours(attendanceRecord.timeIn(), timeOut);

            updateAttendanceRecord(attendanceRecord.withTimeOut(timeOut).withHoursWorked(hoursWorked).withOverTimeHours(overtimeHours));
        } catch (IllegalArgumentException | AttendanceException e) {
            try {
                AttendanceRecord attendanceRecord = attendanceDataService.getAttendanceRecord_ByAttendanceID(previous_AttendanceID(employeeID));

                if (attendanceRecord != null && !attendanceRecord.timeOut().equals(LocalTime.MIN)) {
                    AttendanceException.throwAttendanceError_AlreadyClocked_OUT();
                    return;
                }

                assert attendanceRecord != null;
                LocalTime hoursWorked = DateTimeCalculator.calculateRegularHoursWorked(attendanceRecord.timeIn(), timeOut);
                LocalTime overtimeHours = DateTimeCalculator.calculateOvertimeHours(attendanceRecord.timeIn(), timeOut);

                updateAttendanceRecord(attendanceRecord.withTimeOut(timeOut).withHoursWorked(hoursWorked).withOverTimeHours(overtimeHours));
            } catch (IllegalArgumentException | AttendanceException ex) {
                AttendanceException.throwAttendanceError_HasNotClocked_IN();
            }
        }
    }

    /**
     * Submit a leave request based on the selected leave type, start date, end date, and reasons.
     */
    @Override
    public void submitLeaveRequest(String leaveType, LocalDate startDate, LocalDate endDate, String reasons) {
        try {
            if (startDate == null || endDate == null){
                LeaveException.throwLeaveError_INVALID_DATE();
                return;
            }

            if (startDate.isAfter(endDate)){
                LeaveException.throwLeaveError_INVALID_DATE_RANGE();
                return;
            }

            if (leaveRecords.stream().anyMatch(record ->
                    TimeUtils.datesOverlap(startDate, endDate, record.startDate(), record.endDate()))) {
                LeaveException.throwLeaveError_CONFLICTING_DATES();
            }

            int leaveBalanceValue = getLeaveBalance(leaveType.toUpperCase());

            int totalDays = DateTimeCalculator.totalDays(startDate, endDate);

            if (leaveBalanceValue < totalDays){
                LeaveException.throwLeaveError_INSUFFICIENT_BALANCE();
            }

            addLeaveRecord(new LeaveRecord(
                    generate_LeaveRecordID(employeeID),
                    employeeID,
                    LocalDate.now(),
                    leaveType,
                    startDate,
                    endDate,
                    totalDays,
                    reasons,
                    "PENDING"
            ), switch (leaveType.toUpperCase()) {
                case "SICK" -> leaveBalance.withSickBalance(leaveBalanceValue - totalDays);
                case "VACATION" -> leaveBalance.withVacationBalance(leaveBalanceValue - totalDays);
                case "PATERNAL" -> leaveBalance.withPaternalBalance(leaveBalanceValue - totalDays);
                case "BEREAVEMENT" -> leaveBalance.withBereavementBalance(leaveBalanceValue - totalDays);
                default -> throw new IllegalStateException("Unexpected value: " + leaveType.toUpperCase());
            });

        } catch (LeaveException e) {
            System.out.println("Cannot submit leave request: " + e.getMessage());
        }
    }
}

