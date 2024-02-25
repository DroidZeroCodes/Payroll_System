package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class LeaveRecord extends Record {

    private String leaveID;
    private int employeeID;
    private String leaveType;
    private Date startDate, endDate;

    private String status;
    public LeaveRecord(int employeeID, String leaveType, Date startDate, Date endDate, String status) {
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    public LeaveRecord(int employeeID) {
        this.employeeID = employeeID;
        retrieveRecord();
    }

    public String leaveID() {
        return leaveID;
    }

    public void setLeaveID(String leaveID) {
        this.leaveID = leaveID;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    @Override
    protected void retrieveRecord() {

    }
    @Override
    protected void addRecord() throws CsvException, IOException {
        DataHandler dataHandler = new DataHandler(filePath());

    }

    public List<String[]> retrieveAllPersonalRecord() throws CsvValidationException, IOException { // TODO: implement this function
        try {
            DataHandler dataHandler = new DataHandler(filePath());

            List<String[]> csv = dataHandler.retrieveMultipleData(primaryKey(), String.valueOf(employeeID));

            if (csv == null || csv.isEmpty()) {
                System.out.println("No attendance record found for employee ID: " + employeeID);
            } else {
                return csv;
            }
        } catch (IOException | CsvException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String toString() {
        return "LeaveRecord{" +
                "leaveID='" + leaveID + '\'' +
                ", employeeID=" + employeeID +
                ", leaveType='" + leaveType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }

    public static void main(String[] args) {
        try {
            LeaveRecord leaveRecord = new LeaveRecord(1);
            var leaveRecordList = leaveRecord.retrieveAllPersonalRecord();

            for (String[] record : leaveRecordList) {
                for (String field : record) {
                    System.out.print(field + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
