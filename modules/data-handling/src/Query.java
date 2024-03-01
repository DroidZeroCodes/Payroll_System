public class Query {
    /**
     * Returns the file path for the corresponding class.
     *
     * @return the file path for the class
     */
    public String filePath() {
        String database = "src/com/mmdc_group10_oop/dataHandlingModule/database/";
        if (getClass() == EmployeeRecord.class) {
            return database + "EmployeeData.csv";
        } else if (getClass() == AttendanceRecord.class) {
            return database + "AttendanceData.csv";
        } else if (getClass() == LeaveRecord.class) {
            return database + "LeaveRecords.csv";
        } else if (getClass() == LeaveBalance.class) {
            return database + "LeaveBalanceData.csv";
        } else if (getClass() == PayrollRecords.class) {
            return database + "PayslipRecords.csv";
        } else if (getClass() == UserCredentials.class) {
            return database + "UserCredentials.csv";
        }
        throw new IllegalArgumentException("Invalid class: " + getClass().getName());
    }

    /**
     * Returns the primary key for the given class.
     *
     * @return the primary key
     */
    public String primaryKey() {
        if (getClass() == UserCredentials.class) {
            return "USERNAME";
        } else if (getClass() == EmployeeRecord.class || getClass() == LeaveBalance.class) {
            return "EMPLOYEE_NO";
        } else if (getClass() == AttendanceRecord.class){
            return "ATTENDANCE_ID";
        } else if (getClass() == LeaveRecord.class) {
            return "LEAVE_ID";
        } else if (getClass() == PayrollRecords.class) {
            return "PAYSLIP_ID";
        } else {
            throw new IllegalArgumentException("Invalid class: " + getClass().getName());
        }
    }
    public String employeeNo() {
        return "EMPLOYEE_NO";
    }
}
