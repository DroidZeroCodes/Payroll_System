package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.AttendanceRecord;
import com.mmdc_group10_oop.dataHandlingModule.EmployeeProfile;
import com.mmdc_group10_oop.dataHandlingModule.LeaveRecord;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class HRAdmin extends Employee {
    List <EmployeeProfile> allEmployees;
    List <LeaveRecord> allLeaveRequests;
    List <AttendanceRecord> allAttendanceRecords;
    public HRAdmin(int employeeID) throws IOException, CsvException {
        super(employeeID, null);
    }


    //Overloaded methods
    public void viewProfile(int employee) {
//        super.viewProfile();
    }


}
