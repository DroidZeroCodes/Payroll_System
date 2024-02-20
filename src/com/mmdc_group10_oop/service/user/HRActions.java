package com.mmdc_group10_oop.service.user;

public interface HRActions {

    void viewEmployeeProfile(int employeeID);
    void changeEmployeePersonalInfo(int employeeID);
    void changeEmployeeEmploymentInfo(int employeeID);
    void enterAttendance();
    void deleteAttendance();
    void updateAttendance();
    void viewAllAttendanceReports();
    void viewEmployeeAttendanceReport(int employeeID);
    void viewAllLeaveBalances();
    void submitEmployeeLeaveRequest(int employeeID);
    void approveEmployeeLeave(int employeeID);
    void rejectEmployeeLeave(int employeeID);
    void viewEmployeeLeaveStatus(int employeeID);
    void viewAllLeaveStatus();
    void requestPayslip(int employeeID);
    void generateAttendanceReport();
    void exportAttendanceReport();
    void addEmployee();
    void removeEmployee(int employeeID);
}
