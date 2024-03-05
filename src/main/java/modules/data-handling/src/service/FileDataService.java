package service;

import data.*;
import interfaces.*;
import logic.DataHandler;
import util.Convert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileDataService implements EmployeeDataService, AttendanceDataService, LeaveBalanceDataService, LeaveDataService, PayrollDataService, UserCredentialsDataService {
    String employeeDataPath = "database/EmployeeData.csv";
    String employeeKey = "EMPLOYEE_NO";
    String attendancePath = "database/AttendanceData.csv";
    String activeEmployeePath = "database/ActiveEmployees.csv";
    String attendanceKey = "ATTENDANCE_ID";
    String leaveBalancePath = "database/LeaveBalanceData.csv";
    String leavePath = "database/LeaveRecords.csv";
    String leaveRequestDateKey = "REQUEST_DATE";
    String leaveKey = "LEAVE_ID";
    String payrollPath = "database/PayrollData.csv";
    String payrollDateKey = "PERIOD_START_DATE";
    String payrollKey = "PAYSLIP_ID";
    String userCredentialsPath = "database/UserCredentials.csv";
    String userNameKey = "USERNAME";
    String roleKey = "ROLE";
    String positionKey = "POSITION";
    String departmentKey = "DEPARTMENT";

    String payrollReportPath = "reports/payroll";
    String attendanceReportPath = "reports/attendance";
    String leaveReportPath = "reports/leave";

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

    @Override
    public EmployeeRecord getEmployeeRecord_ByEmployeeID(int employeeID) {
        DataHandler dataHandler = new DataHandler(activeEmployeePath);

        String[] record = dataHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));

        if (record == null) {
            throw new IllegalArgumentException("No Employee data found for Employee ID: " + employeeID);
        } else {
            return createEmployeeRecord_DATA(record);
        }
    }

    public EmployeeRecord createEmployeeRecord_DATA(String[] record) {
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

    @Override
    public Integer[] getEmployeeIDList() {
        DataHandler dataHandler = new DataHandler(employeeDataPath);

        return dataHandler.retrieveColumnData_AsInt(employeeKey);
    }

    @Override
    public Integer[] getActiveEmployeesIDList() {
        DataHandler dataHandler = new DataHandler(activeEmployeePath);

        return dataHandler.retrieveColumnData_AsInt(employeeKey);
    }

    @Override
    public List<EmployeeRecord> getEmployeeListByPosition(String position) {
        DataHandler dataHandler = new DataHandler(activeEmployeePath);

        List<String[]> csv = dataHandler.retrieveMultipleData("POSITION", position);

        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found for Position: " + position);
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    public List<EmployeeRecord> createEmployeeRecord_LIST(List<String[]> records) {
        if (records == null) return null;
        List<EmployeeRecord> employeeRecords = new ArrayList<>();
        for (String[] record : records) {
            employeeRecords.add(createEmployeeRecord_DATA(record));
        }
        return employeeRecords;
    }

    @Override
    public List<EmployeeRecord> getEmployeeByDepartment(String department) {
        DataHandler dataHandler = new DataHandler(activeEmployeePath);

        List<String[]> csv = dataHandler.retrieveMultipleData("DEPARTMENT", department);

        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found for Department: " + department);
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    @Override
    public List<EmployeeRecord> getAllActiveEmployees() {
        DataHandler dataHandler = new DataHandler(activeEmployeePath);
        List<String[]> csv = dataHandler.retrieveAllData();
        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found");
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    @Override
    public List<EmployeeRecord> getAllEmployees() {
        DataHandler dataHandler = new DataHandler(employeeDataPath);
        List<String[]> csv = dataHandler.retrieveAllData();
        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No Employee data found");
        } else {
            return createEmployeeRecord_LIST(csv);
        }
    }

    @Override
    public void addEmployeeRecord(EmployeeRecord employeeRecord) {
        DataHandler dataHandler = new DataHandler(employeeDataPath);
        String[] newRecord = employeeRecord.toArray();
        dataHandler.createData(newRecord, true);

        dataHandler.setCsvFilePath(activeEmployeePath);
        dataHandler.createData(newRecord, true);
    }

    @Override
    public void updateEmployeeRecord(EmployeeRecord employeeRecord) {
        DataHandler dataHandler = new DataHandler(employeeDataPath);
        String[] newRecord = employeeRecord.toArray();
        dataHandler.updateRowData(employeeKey, String.valueOf(employeeRecord.employeeID()), newRecord);

        dataHandler.setCsvFilePath(activeEmployeePath);
        dataHandler.updateRowData(employeeKey, String.valueOf(employeeRecord.employeeID()), newRecord);
    }

    @Override
    public void deleteEmployeeRecord(EmployeeRecord selectedEmployee) {
        DataHandler dataHandler = new DataHandler(activeEmployeePath);
        dataHandler.deleteRowData(employeeKey, String.valueOf(selectedEmployee.employeeID()));
    }

    @Override
    public AttendanceRecord getAttendanceRecord_ByAttendanceID(String attendanceID) {
        DataHandler dataHandler = new DataHandler(attendancePath);

        String[] record = dataHandler.retrieveRowData(attendanceKey, attendanceID);
        if (record == null) {
            throw new IllegalArgumentException("No attendance data found for attendance ID: " + attendanceID);
        } else {
            return createAttendanceRecord_DATA(record);
        }
    }

    private AttendanceRecord createAttendanceRecord_DATA(String[] record) {
        return new AttendanceRecord(
                record[0],
                Convert.StringToLocalDate(record[1]),
                Integer.parseInt(record[2]),
                record[3],
                record[4],
                Convert.StringToLocalTime(record[5]),
                Convert.StringToLocalTime(record[6]),
                Convert.StringToLocalTime(record[7]),
                Convert.StringToLocalTime(record[8])
        );
    }

    @Override
    public AttendanceRecord getAttendanceRecord_ByEmployeeID(int employeeID) {
        DataHandler dataHandler = new DataHandler(attendancePath);
        String[] record = dataHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));
        if (record == null) {
            throw new IllegalArgumentException("No attendance data found for employee ID: " + employeeID);
        } else {
            return createAttendanceRecord_DATA(record);
        }
    }

    @Override
    public List<AttendanceRecord> getAllAttendance_ByEmployeeID(int employeeID) {
        DataHandler dataHandler = new DataHandler(attendancePath);

        List<String[]> csv = dataHandler.retrieveMultipleData(employeeKey, String.valueOf(employeeID));

        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No attendance record found for employee ID: " + employeeID);
        } else {
            return createAttendanceRecord_LIST(csv);
        }
    }

    private List<AttendanceRecord> createAttendanceRecord_LIST(List<String[]> records) {
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();
        for (String[] record : records) {
            attendanceRecords.add(createAttendanceRecord_DATA(record));
        }
        return attendanceRecords;
    }

    @Override
    public List<AttendanceRecord> getAllAttendanceRecords() {
        DataHandler dataHandler = new DataHandler(attendancePath);
        List<String[]> record = dataHandler.retrieveAllData();

        if (record == null || record.isEmpty()) {
            throw new IllegalArgumentException("No attendance record found");
        } else {
            return createAttendanceRecord_LIST(record);
        }
    }

    @Override
    public void updateAttendanceRecord(AttendanceRecord attendance) {
        DataHandler dataHandler = new DataHandler(attendancePath);
        String[] newRecord = attendance.toArray();
        dataHandler.updateRowData(attendanceKey, attendance.attendanceID(), newRecord);
    }

    @Override
    public void addAttendanceRecord(AttendanceRecord attendance) {
        DataHandler dataHandler = new DataHandler(attendancePath);
        String[] newRecord = attendance.toArray();
        dataHandler.createData(newRecord, false);
    }

    @Override
    public List<AttendanceRecord> getAttendanceRecordsForPeriod(int employeeID, LocalDate periodStart, LocalDate periodEnd) {
        DataHandler dataHandler = new DataHandler(attendancePath);

        List<String[]> csv = dataHandler.retrieveMultipleData(employeeKey, String.valueOf(employeeID));

        assert csv != null;
        if (csv.isEmpty()) {
            throw new IllegalArgumentException("No attendance record found for employee ID: " + employeeID);
        } else {
            csv.removeIf(record -> {
                LocalDate date = Convert.StringToLocalDate(record[1]);
                return date.isBefore(periodStart) || date.isAfter(periodEnd);
            });
            return createAttendanceRecord_LIST(csv);
        }
    }

    @Override
    public LeaveBalanceRecord getLeaveBalance_ByEmployeeID(int employeeID) {
        DataHandler dataHandler = new DataHandler(leaveBalancePath);

        String[] record = dataHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));
        if (record == null) {
            throw new IllegalArgumentException("No leave balance found for employee ID: " + employeeID);
        }
        return createLeaveBalanceRecord_DATA(record);
    }

    @Override
    public void updateLeaveBalance(LeaveBalanceRecord leaveBalanceRecord) {
        DataHandler dataHandler = new DataHandler(leaveBalancePath);
        String[] updatedLeaveBalance = leaveBalanceRecord.toArray();
        dataHandler.updateRowData(employeeKey, String.valueOf(leaveBalanceRecord.employeeID()), updatedLeaveBalance);
    }

    @Override
    public void addLeaveBalance(LeaveBalanceRecord leaveBalanceRecord) {
        DataHandler dataHandler = new DataHandler(leaveBalancePath);
        String[] record = leaveBalanceRecord.toArray();
        dataHandler.createData(record, true);
    }

    @Override
    public LeaveRecord getLeaveByLeaveID(String leaveID) {
        DataHandler dataHandler = new DataHandler(leavePath);

        String[] record = dataHandler.retrieveRowData(leaveKey, leaveID);

        if (record == null) {
            throw new IllegalArgumentException("No Leave data found for Leave ID: " + leaveID);
        } else {
            return createAttendanceRecordFromData(record);
        }
    }

    private LeaveRecord createAttendanceRecordFromData(String[] record) {
        return new LeaveRecord(
                record[0],
                Integer.parseInt(record[1]),
                Convert.StringToLocalDate_MMMddYYYY(record[2]),
                record[3],
                Convert.StringToLocalDate_MMMddYYYY(record[4]),
                Convert.StringToLocalDate_MMMddYYYY(record[5]),
                Integer.parseInt(record[6]),
                record[7],
                record[8]
        );
    }

    @Override
    public List<LeaveRecord> getLeaveRecords_ByEmployeeID(int employeeID) {
        DataHandler dataHandler = new DataHandler(leavePath);

        List<String[]> csv = dataHandler.retrieveMultipleData(employeeKey, String.valueOf(employeeID));

        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No leave record found for employee ID: " + employeeID);
        } else {
            return createAttendanceRecordListFromData(csv);
        }
    }

    private List<LeaveRecord> createAttendanceRecordListFromData(List<String[]> records) {
        List<LeaveRecord> leaveRecords = new ArrayList<>();
        for (String[] record : records) {
            leaveRecords.add(createAttendanceRecordFromData(record));
        }
        return leaveRecords;
    }

    @Override
    public List<LeaveRecord> getLeaveRecordsByDate(LocalDate requestDate) {
        DataHandler dataHandler = new DataHandler(leavePath);

        List<String[]> csv = dataHandler.retrieveMultipleData(leaveRequestDateKey, requestDate.toString());

        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No leave records requested on: " + requestDate);
        } else {
            return createAttendanceRecordListFromData(csv);
        }
    }

    @Override
    public List<LeaveRecord> allLeaveRecords() {
        DataHandler dataHandler = new DataHandler(leavePath);

        List<String[]> records = dataHandler.retrieveAllData();
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No leave records found");
        } else {
            return createAttendanceRecordListFromData(records);
        }
    }

    @Override
    public void addLeaveRecord(LeaveRecord leaveRecord) {
        DataHandler dataHandler = new DataHandler(leavePath);
        String[] newRecord = leaveRecord.toArray();
        dataHandler.createData(newRecord, false);
    }

    @Override
    public List<LeaveRecord> getAllLeaveRecords() {
        DataHandler dataHandler = new DataHandler(leavePath);

        List<String[]> records = dataHandler.retrieveAllData();
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No leave records found");
        } else {
            return createAttendanceRecordListFromData(records);
        }
    }

    @Override
    public PayrollRecords getPayroll_ByPayrollID(String payrollID) {
        DataHandler dataHandler = new DataHandler(payrollPath);

        String[] record = dataHandler.retrieveRowData(payrollKey, payrollID);

        if (record == null) {
            throw new IllegalArgumentException("No Payroll data found for Payroll ID: " + payrollID);
        }
        return createPayrollRecord_DATA(record);
    }

    private PayrollRecords createPayrollRecord_DATA(String[] record) {
        return new PayrollRecords(
                record[0],
                Integer.parseInt(record[1]),
                record[2],
                Convert.StringToLocalDate(record[3]),
                Convert.StringToLocalDate(record[4]),
                record[5],
                Convert.CurrencyToDouble(record[6]),
                Convert.CurrencyToDouble(record[7]),
                Convert.StringToDouble(record[8]),
                Convert.CurrencyToDouble(record[9]),
                Convert.CurrencyToDouble(record[10]),
                Convert.CurrencyToDouble(record[11]),
                Convert.CurrencyToDouble(record[12]),
                Convert.CurrencyToDouble(record[13]),
                Convert.CurrencyToDouble(record[14]),
                Convert.CurrencyToDouble(record[15]),
                Convert.CurrencyToDouble(record[16]),
                Convert.CurrencyToDouble(record[17]),
                Convert.CurrencyToDouble(record[18]),
                Convert.CurrencyToDouble(record[19]),
                Convert.CurrencyToDouble(record[20])
        );
    }

    @Override
    public PayrollRecords getPayroll_ByEmployeeID(int employeeID) {
        DataHandler dataHandler = new DataHandler(payrollPath);

        String[] record = dataHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));

        if (record == null) {
            throw new IllegalArgumentException("Recent Payroll data not found for Employee ID: " + employeeID);
        }
        return createPayrollRecord_DATA(record);
    }

    @Override
    public List<PayrollRecords> getPayrollRecords_ByEmployeeID(String employeeID) {
        DataHandler dataHandler = new DataHandler(payrollPath);

        List<String[]> csv = dataHandler.retrieveMultipleData(employeeKey, String.valueOf(employeeID));

        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No payroll record found for employee ID: " + employeeID);
        } else {
            return createPayrollRecord_LIST(csv);
        }
    }

    private List<PayrollRecords> createPayrollRecord_LIST(List<String[]> records) {
        List<PayrollRecords> payrollRecords = new ArrayList<>();
        for (String[] record : records) {
            payrollRecords.add(createPayrollRecord_DATA(record));
        }
        return payrollRecords;
    }

    @Override
    public List<PayrollRecords> getPayrollRecords_ByPeriodDate(LocalDate startDate) {
        DataHandler dataHandler = new DataHandler(payrollPath);

        List<String[]> csv = dataHandler.retrieveMultipleData(payrollDateKey, String.valueOf(startDate));

        if (csv == null || csv.isEmpty()) {
            throw new IllegalArgumentException("No payroll record found on date: " + startDate);
        } else {
            return createPayrollRecord_LIST(csv);
        }
    }

    @Override
    public List<PayrollRecords> getAllPayrollRecords() {
        DataHandler dataHandler = new DataHandler(payrollPath);
        List<String[]> records = dataHandler.retrieveAllData();

        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No payroll records found");
        } else {
            return createPayrollRecord_LIST(records);
        }
    }

    @Override
    public void addPayrollRecord(PayrollRecords payrollRecords) {
        DataHandler dataHandler = new DataHandler(payrollPath);
        String[] newRecord = payrollRecords.toArray();
        dataHandler.createData(newRecord, false);
    }

    @Override
    public UserCredentials getUserCredentials_ByEmployeeID(String employeeID) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);
        String[] record = dataHandler.retrieveRowData(employeeKey, String.valueOf(employeeID));
        if (record == null) {
            throw new IllegalArgumentException("No user credentials found for employee ID: " + employeeID);
        } else {
            return createUserCredentials_DATA(record);
        }
    }

    private UserCredentials createUserCredentials_DATA(String[] record) {
        return new UserCredentials(
                Integer.parseInt(record[0]),
                record[1],
                record[2],
                record[3],
                record[4],
                record[5]
        );
    }

    @Override
    public UserCredentials getUserCredentials_ByUserName(String userName) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);
        String[] record = dataHandler.retrieveRowData(userNameKey, userName);
        if (record == null) {
            throw new IllegalArgumentException("No user credentials found for user name: " + userName);
        } else {
            return createUserCredentials_DATA(record);
        }
    }

    @Override
    public List<UserCredentials> getUserCredentials_ByRole(String role) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);

        List<String[]> records = dataHandler.retrieveMultipleData(roleKey, role);
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No user credentials found for role: " + role);
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    private List<UserCredentials> createUserCredentials_LIST(List<String[]> records) {
        List<UserCredentials> userCredentials = new ArrayList<>();
        for (String[] record : records) {
            userCredentials.add(createUserCredentials_DATA(record));
        }
        return userCredentials;
    }

    @Override
    public List<UserCredentials> getUserCredentials_ByPosition(String position) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);

        List<String[]> records = dataHandler.retrieveMultipleData(positionKey, position);
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No user credentials found for position: " + position);
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    @Override
    public List<UserCredentials> getUserCredentials_ByDepartment(String department) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);

        List<String[]> records = dataHandler.retrieveMultipleData(departmentKey, department);
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No user credentials found for department: " + department);
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    @Override
    public List<UserCredentials> getAllUserCredentials() {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);
        List<String[]> records = dataHandler.retrieveAllData();
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("No user credentials found");
        } else {
            return createUserCredentials_LIST(records);
        }
    }

    @Override
    public void updateUserCredentials(UserCredentials userCredential) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);
        String[] newRecord = userCredential.toArray();
        dataHandler.updateRowData(employeeKey, String.valueOf(userCredential.employeeID()), newRecord);
    }

    @Override
    public void addUserCredentials(UserCredentials userCredentials) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);
        String[] newRecord = userCredentials.toArray();
        dataHandler.createData(newRecord, true);
    }

    @Override
    public void deleteUserCredentials_ByEmployeeID(String employeeID) {
        DataHandler dataHandler = new DataHandler(userCredentialsPath);
        dataHandler.deleteRowData(employeeKey, String.valueOf(employeeID));
    }
}
