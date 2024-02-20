package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.DataHandlingModule.AttendanceRecord;
import com.mmdc_group10_oop.DataHandlingModule.EmployeeProfile;
import com.mmdc_group10_oop.DataHandlingModule.LeaveRecord;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class HRAdmin extends Employee implements HRActions {
    List <EmployeeProfile> allEmployees;
    List <LeaveRecord> allLeaveRequests;
    List <AttendanceRecord> allAttendanceRecords;
    public HRAdmin(int employeeID) throws IOException, CsvException {
        super(employeeID);
    }
    @Override
    public void viewEmployeeProfile(int employeeID) {

    }

    @Override
    public void changeEmployeePersonalInfo(int employeeID) {

    }

    @Override
    public void changeEmployeeEmploymentInfo(int employeeID) {

    }

    @Override
    public void enterAttendance() {

    }

    @Override
    public void deleteAttendance() {

    }

    @Override
    public void updateAttendance() {

    }

    @Override
    public void viewAllAttendanceReports() {

    }

    @Override
    public void viewEmployeeAttendanceReport(int employeeID) {

    }

    @Override
    public void viewAllLeaveBalances() {

    }

    @Override
    public void submitEmployeeLeaveRequest(int employeeID) {

    }

    @Override
    public void approveEmployeeLeave(int employeeID) {

    }

    @Override
    public void rejectEmployeeLeave(int employeeID) {

    }

    @Override
    public void viewEmployeeLeaveStatus(int employeeID) {

    }

    @Override
    public void viewAllLeaveStatus() {

    }

    @Override
    public void requestPayslip(int employeeID) {

    }

    @Override
    public void generateAttendanceReport() {

    }

    @Override
    public void exportAttendanceReport() {

    }

    @Override
    public void addEmployee() {

    }

    @Override
    public void removeEmployee(int employeeID) {

    }

    //Overloaded methods
    public void viewProfile(int employee) {
        super.viewProfile();
    }

    public void changePersonalInfo(int employee) {
        super.changePersonalInfo();
    }
    public void clockIn(int employee) {
        super.clockIn();
    }

    public void clockOut(int employee) {
        super.clockOut();
    }
    public void viewAttendanceReport(int employee) {
        super.viewAttendanceReport();
    }
    public void viewLeaveBalance(int employee) {
        super.viewLeaveBalance();
    }
    public void submitLeaveRequest(int employee) {
        super.submitLeaveRequest();
    }
    public void viewLeaveStatus(int employee) {
        super.viewLeaveStatus();
    }
    public void viewPayslip(int employee) {
        super.viewPayslip();
    }
}
