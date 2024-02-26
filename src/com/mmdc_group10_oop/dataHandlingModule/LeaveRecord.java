package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.DateTimeCalculator;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LeaveRecord extends Record {

    private String leaveID;
    private int employeeID;
    private String leaveType, requestDate;
    private String startDate, endDate;
    private String leaveReason;
    private String status;
    public LeaveRecord(String leaveID, int employeeID, String leaveType, String requestDate, String startDate, String endDate, String leaveReason, String status) {
        this.leaveID = leaveID;
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.requestDate = requestDate;
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

    public String requestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String startDate() {
        return startDate;
    }

    public String endDate() {
        return endDate;
    }

    public String leaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
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
    public void addRecord() {
        try {
            List<String[]> existingRecords = retrieveAllPersonalRecord();

            // Check for conflicts with existing records
            for (String[] record : existingRecords) {
                String existingStartDate = record[4];
                String existingEndDate = record[5];

                // Check if the new record's start-end dates overlap with any existing record
                if (datesOverlap(startDate, endDate, existingStartDate, existingEndDate)) {
                    throw new RuntimeException("Conflicting leave request detected");
                }
            }

            DataHandler dataHandler = new DataHandler(filePath());
            String[] newRecord = {
                    leaveID,
                    String.valueOf(employeeID),
                    requestDate,
                    leaveType,
                    DateTimeCalculator.convertLocalDateToMDY(LocalDate.parse(startDate)),
                    DateTimeCalculator.convertLocalDateToMDY(LocalDate.parse(endDate)),
                    leaveReason,
                    status
            };

            // No conflicts, add the new record
            dataHandler.createData(newRecord, false);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to check if dates overlap
    private boolean datesOverlap(String startDate1, String endDate1, String startDate2, String endDate2) {
        // Convert string dates to LocalDate or any other date representation and check for overlap
        LocalDate newStartDate1 = LocalDate.parse(startDate1, DateTimeFormatter.ISO_DATE);
        LocalDate newEndDate1 = LocalDate.parse(endDate1, DateTimeFormatter.ISO_DATE);
        LocalDate existingStartDate = DateTimeCalculator.convertMDYtoLocalDate(startDate2);
        LocalDate existingEndDate = DateTimeCalculator.convertMDYtoLocalDate(endDate2);
        return !newEndDate1.isBefore(existingStartDate) && !newStartDate1.isAfter(existingEndDate);
    }

    public List<String[]> retrieveAllPersonalRecord() { // TODO: implement this function
        try {
            DataHandler dataHandler = new DataHandler(filePath());

            List<String[]> csv = dataHandler.retrieveMultipleData(primaryKey(), String.valueOf(employeeID));

            if (csv == null || csv.isEmpty()) {
                System.out.println("No leave record found for employee ID: " + employeeID);
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
