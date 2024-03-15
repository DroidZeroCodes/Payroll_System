package service;

import handlers.CSVHandler;
import interfaces.*;
import records.*;
import util.Convert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for handling file-based data.
 */
@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class FileDataService implements EmployeeDataService, AttendanceDataService, LeaveBalanceDataService, LeaveDataService, PayrollDataService, UserCredentialsDataService {
    private final String employeeDataPath = "database/EmployeeData.csv";
    private final String employeeKey = "EMPLOYEE_NO";
    private final String attendancePath = "database/AttendanceData.csv";
    private final String activeEmployeePath = "database/ActiveEmployees.csv";
    private final String attendanceKey = "ATTENDANCE_ID";
    private final String leaveBalancePath = "database/LeaveBalanceData.csv";
    private final String leavePath = "database/LeaveRecords.csv";
    private final String leaveRequestDateKey = "REQUEST_DATE";
    private final String leaveKey = "LEAVE_ID";
    private final String payrollPath = "database/PayrollData.csv";
    private final String payrollDateKey = "PERIOD_START_DATE";
    private final String payrollKey = "PAYSLIP_ID";
    private final String userCredentialsPath = "database/UserCredentials.csv";
    private final String userNameKey = "USERNAME";
    private final String roleKey = "ROLE";
    private final String positionKey = "POSITION";
    private final String departmentKey = "DEPARTMENT";

    //Record creator methods

    private EmployeeRecord createEmployeeRecord_DATA(String[] record) {
        if (record == null) return null;

        return new EmployeeRecord(
                Integer.parseInt(record[0]),
                record[1],
                record[2],
                record[3],
                record[4],
                record[5],
                record[6],
                record[7],
                record[8],
                record[9],
                record[10],
                record[11],
                record[12],
                record[13],
                Convert.StringToDouble(record[14]),
                Convert.StringToDouble(record[15]),
                Convert.StringToDouble(record[16]),
                Convert.StringToDouble(record[17]),
                Convert.StringToDouble(record[18]),
                Convert.StringToDouble(record[19])
        );
    }

    private List<EmployeeRecord> createEmployeeRecord_LIST(List<String[]> records) {
        if (records == null) return null;
        List<EmployeeRecord> employeeRecords = new ArrayList<>();
        for (String[] record : records) {
            employeeRecords.add(createEmployeeRecord_DATA(record));
        }
        return employeeRecords;
    }


    private AttendanceRecord createAttendanceRecord_DATA(String[] record) {
        return new AttendanceRecord(
                record[0],
                Convert.StringToLocalDate_yyyyMMdd(record[1]),
                Integer.parseInt(record[2]),
                record[3],
                record[4],
                Convert.StringToLocalTime(record[5]),
                Convert.StringToLocalTime(record[6]),
                Convert.StringToLocalTime(record[7]),
                Convert.StringToLocalTime(record[8])
        );
    }


    private List<AttendanceRecord> createAttendanceRecord_LIST(List<String[]> records) {
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();
        for (String[] record : records) {
            attendanceRecords.add(createAttendanceRecord_DATA(record));
        }
        return attendanceRecords;
    }


    private LeaveRecord createLeaveRecord_DATA(String[] record) {
        return new LeaveRecord(
                record[0],
                Integer.parseInt(record[1]),
                Convert.StringToLocalDate_yyyyMMdd(record[2]),
                record[3],
                Convert.StringToLocalDate_yyyyMMdd(record[4]),
                Convert.StringToLocalDate_yyyyMMdd(record[5]),
                Integer.parseInt(record[6]),
                record[7],
                record[8]
        );
    }


    private List<LeaveRecord> createLeaveRecord_LIST(List<String[]> records) {
        List<LeaveRecord> leaveRecords = new ArrayList<>();
        for (String[] record : records) {
            leaveRecords.add(createLeaveRecord_DATA(record));
        }
        return leaveRecords;
    }


    private PayrollRecord createPayrollRecord_DATA(String[] record) {
        return new PayrollRecord(
                record[0],
                Integer.parseInt(record[1]),
                record[2],
                Convert.StringToLocalDate_yyyyMMdd(record[3]),
                Convert.StringToLocalDate_yyyyMMdd(record[4]),
                record[5],
                Convert.StringToDouble(record[6]),
                Convert.StringToDouble(record[7]),
                Convert.StringToDouble(record[8]),
                Convert.StringToDouble(record[9]),
                Convert.StringToDouble(record[10]),
                Convert.StringToDouble(record[11]),
                Convert.StringToDouble(record[12]),
                Convert.StringToDouble(record[13]),
                Convert.StringToDouble(record[14]),
                Convert.StringToDouble(record[15]),
                Convert.StringToDouble(record[16]),
                Convert.StringToDouble(record[17]),
                Convert.StringToDouble(record[18]),
                Convert.StringToDouble(record[19]),
                Convert.StringToDouble(record[20])
        );
    }

    private List<LeaveBalanceRecord> createLeaveBalanceRecords_LIST(List<String[]> records) {
        List<LeaveBalanceRecord> leaveRecords = new ArrayList<>();
        for (String[] record : records) {
            leaveRecords.add(createLeaveBalanceRecord_DATA(record));
        }
        return leaveRecords;
    }

    private LeaveBalanceRecord createLeaveBalanceRecord_DATA(String[] record) {
        return new LeaveBalanceRecord(
                Integer.parseInt(record[0]),
                Integer.parseInt(record[1]),
                Integer.parseInt(record[2]),
                Integer.parseInt(record[3]),
                Integer.parseInt(record[4])
        );
    }


    private UserCredentials createUserCredentials_DATA(String[] record) {
        return new UserCredentials(
                Integer.parseInt(record[0]),
                record[1],
                record[2],
                record[3],
                record[4],
                record[5],
                LocalDateTime.parse(record[6])
        );
    }


    private List<UserCredentials> createUserCredentials_LIST(List<String[]> records) {
        List<UserCredentials> userCredentials = new ArrayList<>();
        for (String[] record : records) {
            userCredentials.add(createUserCredentials_DATA(record));
        }
        return userCredentials;
    }


    //Employee Record
    @Override

    public EmployeeRecord getEmployeeRecord_ByEmployeeID(int employeeID) {
        CSVHandler CSVHandler = new CSVHandler(activeEmployeePath);

        String[] record = CSVHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));

        if (record == null) {
            throw new IllegalArgumentException("No Employee data found for Employee ID: " + employeeID);
        } else {
            return createEmployeeRecord_DATA(record);
        }
    }

    @Override

    public Integer[] getEmployeeID_List() {
        CSVHandler CSVHandler = new CSVHandler(employeeDataPath);

        return CSVHandler.retrieveColumnData_AsInt(employeeKey);
    }

    @Override

    public Integer[] getActive_EmployeesID_List() {
        CSVHandler CSVHandler = new CSVHandler(activeEmployeePath);

        return CSVHandler.retrieveColumnData_AsInt(employeeKey);
    }

    @Override

    public List<EmployeeRecord> getEmployeeList_ByPosition(String position) {
        CSVHandler CSVHandler = new CSVHandler(activeEmployeePath);

        List<String[]> csv = CSVHandler.retrieveMultipleData("POSITION", position);

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found for Position: " + position);
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    @Override

    public List<EmployeeRecord> getEmployee_ByDepartment(String department) {
        CSVHandler CSVHandler = new CSVHandler(activeEmployeePath);

        List<String[]> csv = CSVHandler.retrieveMultipleData("DEPARTMENT", department);

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found for Department: " + department);
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    @Override

    public List<EmployeeRecord> getAll_Active_Employees() {
        CSVHandler CSVHandler = new CSVHandler(activeEmployeePath);
        List<String[]> csv = CSVHandler.retrieveAllData();
        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found");
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    @Override

    public List<EmployeeRecord> getAll_Employees() {
        CSVHandler CSVHandler = new CSVHandler(employeeDataPath);
        List<String[]> csv = CSVHandler.retrieveAllData();
        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found");
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    @Override

    public void addEmployeeRecord(EmployeeRecord employeeRecord) {
        CSVHandler CSVHandler = new CSVHandler(employeeDataPath);
        String[] newRecord = employeeRecord.toArray();
        CSVHandler.createData(newRecord);

        CSVHandler.setCsvFile_OR_FolderPath(activeEmployeePath);
        CSVHandler.createData(newRecord);
    }

    @Override

    public void updateEmployeeRecord(EmployeeRecord employeeRecord) {
        CSVHandler CSVHandler = new CSVHandler(employeeDataPath);
        String[] newRecord = employeeRecord.toArray();
        CSVHandler.updateRowData(employeeKey, String.valueOf(employeeRecord.employeeID()), newRecord);

        CSVHandler.setCsvFile_OR_FolderPath(activeEmployeePath);
        CSVHandler.updateRowData(employeeKey, String.valueOf(employeeRecord.employeeID()), newRecord);
    }

    @Override

    public void deleteEmployeeRecord(EmployeeRecord selectedEmployee) {
        CSVHandler CSVHandler = new CSVHandler(activeEmployeePath);
        CSVHandler.deleteRowData(employeeKey, String.valueOf(selectedEmployee.employeeID()));
    }

    @Override

    public void addEmployeeCSV(String employeeCSVPath) {
        CSVHandler fullList = new CSVHandler(employeeDataPath);
        CSVHandler activeList = new CSVHandler(activeEmployeePath);
        fullList.insertDataFromCSV(employeeCSVPath);
        activeList.insertDataFromCSV(employeeCSVPath);
    }


    //Attendance
    @Override

    public AttendanceRecord getAttendanceRecord_ByAttendanceID(String attendanceID) {
        CSVHandler CSVHandler = new CSVHandler(attendancePath);

        String[] record = CSVHandler.retrieveRowData(attendanceKey, attendanceID);
        if (record == null) {
            throw new IllegalArgumentException("No attendance data found for attendance ID: " + attendanceID);
        } else {
            return createAttendanceRecord_DATA(record);
        }
    }

    @Override

    public AttendanceRecord getAttendanceRecord_ByEmployeeID(int employeeID) {
        CSVHandler CSVHandler = new CSVHandler(attendancePath);
        String[] record = CSVHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));
        if (record == null) {
            throw new IllegalArgumentException("No attendance data found for employee ID: " + employeeID);
        } else {
            return createAttendanceRecord_DATA(record);
        }
    }

    @Override

    public List<AttendanceRecord> getAllAttendance_ByEmployeeID(int employeeID) {
        CSVHandler CSVHandler = new CSVHandler(attendancePath);

        List<String[]> csv = CSVHandler.retrieveMultipleData(employeeKey, String.valueOf(employeeID));

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No attendance record found for employee ID: " + employeeID);
        } else {
            return createAttendanceRecord_LIST(csv);
        }
    }

    @Override

    public List<AttendanceRecord> getAllAttendanceRecords() {
        CSVHandler CSVHandler = new CSVHandler(attendancePath);
        List<String[]> record = CSVHandler.retrieveAllData();

        if (record == null || record.isEmpty()) {
            throw new IllegalArgumentException("No attendance record found");
        } else {
            return createAttendanceRecord_LIST(record);
        }
    }

    @Override

    public List<AttendanceRecord> getAll_AttendanceRecord_ForPeriod(LocalDate periodStart, LocalDate periodEnd) {
        List<AttendanceRecord> attendanceRecords = getAllAttendanceRecords();

        attendanceRecords.removeIf(record -> record.date().isBefore(periodStart) || record.date().isAfter(periodEnd));
        return attendanceRecords;
    }

    @Override

    public void updateAttendanceRecord(AttendanceRecord attendance) {
        CSVHandler CSVHandler = new CSVHandler(attendancePath);
        String[] newRecord = attendance.toArray();
        CSVHandler.updateRowData(attendanceKey, attendance.attendanceID(), newRecord);
    }

    @Override

    public void addAttendanceRecord(AttendanceRecord attendance) {
        CSVHandler CSVHandler = new CSVHandler(attendancePath);
        String[] newRecord = attendance.toArray();
        CSVHandler.createData(newRecord);
    }


    //Leave
    @Override

    public LeaveRecord getLeaveByLeaveID(String leaveID) {
        CSVHandler CSVHandler = new CSVHandler(leavePath);

        String[] record = CSVHandler.retrieveRowData(leaveKey, leaveID);

        if (record == null) {
            throw new IllegalArgumentException("No Leave data found for Leave ID: " + leaveID);
        } else {
            return createLeaveRecord_DATA(record);
        }
    }

    @Override

    public List<LeaveRecord> getLeaveRecords_ByEmployeeID(int employeeID) {
        CSVHandler CSVHandler = new CSVHandler(leavePath);

        List<String[]> csv = CSVHandler.retrieveMultipleData(employeeKey, String.valueOf(employeeID));

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No leave record found for employee ID: " + employeeID);
        } else {
            return createLeaveRecord_LIST(csv);
        }
    }

    @Override

    public List<LeaveRecord> getLeaveRecordsByDate(LocalDate requestDate) {
        CSVHandler CSVHandler = new CSVHandler(leavePath);

        List<String[]> csv = CSVHandler.retrieveMultipleData(leaveRequestDateKey, requestDate.toString());

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No leave records requested on: " + requestDate);
        } else {
            return createLeaveRecord_LIST(csv);
        }
    }

    @Override

    public List<LeaveRecord> getAllLeaveRecords() {
        CSVHandler CSVHandler = new CSVHandler(leavePath);

        List<String[]> records = CSVHandler.retrieveAllData();
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No leave records found");
        } else {
            return createLeaveRecord_LIST(records);
        }
    }

    @Override

    public void updateLeaveRecord(LeaveRecord leaveRecord) {
        CSVHandler CSVHandler = new CSVHandler(leavePath);
        String[] newRecord = leaveRecord.toArray();
        CSVHandler.updateRowData(leaveKey, leaveRecord.leaveID(), newRecord);
    }

    @Override

    public List<LeaveRecord> allLeaveRecords() {
        CSVHandler CSVHandler = new CSVHandler(leavePath);

        List<String[]> records = CSVHandler.retrieveAllData();
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No leave records found");
        } else {
            return createLeaveRecord_LIST(records);
        }
    }

    @Override

    public void addLeaveRecord(LeaveRecord leaveRecord) {
        CSVHandler CSVHandler = new CSVHandler(leavePath);
        String[] newRecord = leaveRecord.toArray();
        CSVHandler.createData(newRecord);
    }


    //LeaveBalance
    @Override

    public LeaveBalanceRecord getLeaveBalance_ByEmployeeID(int employeeID) {
        CSVHandler CSVHandler = new CSVHandler(leaveBalancePath);

        String[] record = CSVHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));
        if (record == null) {
            throw new IllegalArgumentException("No leave balance found for employee ID: " + employeeID);
        }
        return createLeaveBalanceRecord_DATA(record);
    }

    @Override

    public void updateLeaveBalance(LeaveBalanceRecord leaveBalanceRecord) {
        CSVHandler CSVHandler = new CSVHandler(leaveBalancePath);
        String[] updatedLeaveBalance = leaveBalanceRecord.toArray();
        CSVHandler.updateRowData(employeeKey, String.valueOf(leaveBalanceRecord.employeeID()), updatedLeaveBalance);
    }

    @Override

    public void addLeaveBalance(LeaveBalanceRecord leaveBalanceRecord) {
        CSVHandler CSVHandler = new CSVHandler(leaveBalancePath);
        String[] record = leaveBalanceRecord.toArray();
        CSVHandler.createData(record);
    }


    //Payroll
    @Override
    public PayrollRecord getPayroll_ByPayrollID(String payrollID) {
        CSVHandler CSVHandler = new CSVHandler(payrollPath);

        String[] record = CSVHandler.retrieveRowData(payrollKey, payrollID);

        if (record == null) {
            throw new IllegalArgumentException("No Payroll data found for Payroll ID: " + payrollID);
        }

        return createPayrollRecord_DATA(record);
    }

    @Override
    public PayrollRecord getPayroll_ByEmployeeID(int employeeID) {
        CSVHandler CSVHandler = new CSVHandler(payrollPath);

        String[] record = CSVHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));

        if (record == null) {
            throw new IllegalArgumentException("Recent Payroll data not found for Employee ID: " + employeeID);
        }
        return createPayrollRecord_DATA(record);
    }

    @Override

    public List<PayrollRecord> getAll_Payroll_ByEmployeeID(String employeeID) {
        CSVHandler CSVHandler = new CSVHandler(payrollPath);

        List<String[]> csv = CSVHandler.retrieveMultipleData(employeeKey, String.valueOf(employeeID));

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No payroll record found for employee ID: " + employeeID);
        } else {
            return createPayrollRecord_LIST(csv);
        }
    }

    private List<PayrollRecord> createPayrollRecord_LIST(List<String[]> records) {
        List<PayrollRecord> payrollRecords = new ArrayList<>();
        for (String[] record : records) {
            payrollRecords.add(createPayrollRecord_DATA(record));
        }
        return payrollRecords;
    }

    @Override

    public List<PayrollRecord> getAll_PayrollRecords_ForPeriod(LocalDate startDate, LocalDate endDate) {
        CSVHandler CSVHandler = new CSVHandler(payrollPath);

        List<String[]> csv = CSVHandler.retrieveMultipleData(payrollDateKey, String.valueOf(startDate));

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No payroll record found on date: " + startDate);
        } else {
            List<PayrollRecord> payrollRecordList = createPayrollRecord_LIST(csv);

            if (endDate == null) {
                return payrollRecordList; //Skips filtering by end date
            }

            //Filter by end date
            payrollRecordList.removeIf(records -> !records.periodEnd().isEqual(endDate));
            return payrollRecordList;
        }
    }

    @Override

    public List<PayrollRecord> getAll_PayrollRecords() {
        CSVHandler CSVHandler = new CSVHandler(payrollPath);
        List<String[]> records = CSVHandler.retrieveAllData();

        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No payroll records found");
        } else {
            return createPayrollRecord_LIST(records);
        }
    }

    @Override

    public void addPayrollRecord(PayrollRecord payrollRecords) {
        CSVHandler CSVHandler = new CSVHandler(payrollPath);
        String[] newRecord = payrollRecords.toArray();
        CSVHandler.createData(newRecord);
    }


    //User Credentials
    @Override
    public UserCredentials getUserCredentials_ByEmployeeID(String employeeID) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);
        String[] record = CSVHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));
        if (record == null) {
            throw new IllegalArgumentException("No service credentials found for employee ID: " + employeeID);
        } else {
            return createUserCredentials_DATA(record);
        }
    }

    @Override
    public UserCredentials getUserCredentials_ByUserName(String userName) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);
        String[] record = CSVHandler.retrieveRowData(userNameKey, userName);
        if (record == null) {
            throw new IllegalArgumentException("No service credentials found for service name: " + userName);
        } else {
            return createUserCredentials_DATA(record);
        }
    }

    @Override
    public List<UserCredentials> getUserCredentials_ByRole(String role) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);

        List<String[]> records = CSVHandler.retrieveMultipleData(roleKey, role);
        assert records != null;
        if (records.isEmpty()) {
            throw new IllegalArgumentException("No service credentials found for role: " + role);
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    @Override
    public List<UserCredentials> getUserCredentials_ByPosition(String position) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);

        List<String[]> records = CSVHandler.retrieveMultipleData(positionKey, position);
        assert records != null;
        if (records.isEmpty()) {
            throw new IllegalArgumentException("No service credentials found for position: " + position);
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    @Override
    public List<UserCredentials> getUserCredentials_ByDepartment(String department) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);

        List<String[]> records = CSVHandler.retrieveMultipleData(departmentKey, department);
        assert records != null;
        if (records.isEmpty()) {
            throw new IllegalArgumentException("No service credentials found for department: " + department);
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    @Override
    public List<UserCredentials> getAllUserCredentials() {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);
        List<String[]> records = CSVHandler.retrieveAllData();
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No service credentials found");
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    @Override
    public void updateUserCredentials(UserCredentials userCredential) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);
        String[] newRecord = userCredential.toArray();
        CSVHandler.updateRowData(employeeKey, String.valueOf(userCredential.employeeID()), newRecord);
    }

    @Override
    public void addUserCredentials(UserCredentials userCredentials) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);
        String[] newRecord = userCredentials.toArray();
        CSVHandler.createData(newRecord);
    }

    @Override
    public void deleteUserCredentials_ByEmployeeID(String employeeID) {
        CSVHandler CSVHandler = new CSVHandler(userCredentialsPath);
        CSVHandler.deleteRowData(employeeKey, String.valueOf(employeeID));
    }
}
