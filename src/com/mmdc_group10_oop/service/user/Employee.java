package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.DataHandlingModule.*;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.List;

public class Employee implements ProfileManagement, AttendanceManagement, LeaveManagement, PayslipManagement {
    int employeeID;
    String firstName;
    String lastName;
    private EmployeeProfile personalInfo;
    private EmploymentInformation employmentInfo;
    private List<LeaveRecord> leaveRequests;
    private List<AttendanceRecord> attendanceRecords;
    private Payslip payslip;
    private LeaveBalance leaveBalance;
    public Employee(int employeeID) throws IOException, CsvException {
        this.employeeID = employeeID;

        // Logic to retrieve employee leave and attendance records
    }



    @Override
    public void viewProfile() {

    }

    @Override
    public void changePersonalInfo() {

    }

    @Override
    public void clockIn() {

    }

    @Override
    public void clockOut() {

    }

    @Override
    public void viewAttendanceReport() {

    }

    @Override
    public void viewLeaveBalance() {

    }

    @Override
    public void submitLeaveRequest() {

    }

    @Override
    public void viewLeaveStatus() {

    }

    @Override
    public void viewPayslip() {

    }
}
