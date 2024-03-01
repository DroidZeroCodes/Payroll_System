package user.interfaces;

public interface HRActions {

    void displayEmployeeProfile(int employeeID);
    void changeEmployeePersonalInfo(int employeeID);
    void changeEmployeeEmploymentInfo(int employeeID);
    void enterAttendance();
    void deleteAttendance();
    void updateAttendance();
    void displayAllAttendanceRecord();
    void displayEmployeeAttendanceRecord(int employeeID);
    void displayAllLeaveBalances();
    void submitEmployeeLeaveRequest(int employeeID);
    void approveEmployeeLeave(int employeeID);
    void rejectEmployeeLeave(int employeeID);
    void displayEmployeeLeaveStatus(int employeeID);
    void displayAllLeaveStatus();
    void requestPayslip(int employeeID);
    void generateAttendanceReport();
    void exportAttendanceReport();
    void addEmployee();
    void removeEmployee(int employeeID);
}
