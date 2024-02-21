package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.Record;

import java.util.Date;

public class LeaveRecord extends Record {

    private int leaveID, employeeID, supervisorID;
    private String leaveType;
    private Date startDate, endDate;
    private String status;
    private int newBalance;
    public LeaveRecord() {
    }

    public LeaveRecord(int leaveID, int employeeID, int supervisorID, String leaveType, Date startDate, Date endDate, String status, int newBalance) {
        this.leaveID = leaveID;
        this.employeeID = employeeID;
        this.supervisorID = supervisorID;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.newBalance = newBalance;
    }

    public int leaveID() {
        return leaveID;
    }

    public void setLeaveID(int leaveID) {
        this.leaveID = leaveID;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int supervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(int supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String leaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date startDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date endDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int newBalance() {
        return newBalance;
    }

    public void setNewBalance(int newBalance) {
        this.newBalance = newBalance;
    }

    @Override
    protected void retrieveRecord() {

    }
}
