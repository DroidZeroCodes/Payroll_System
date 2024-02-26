package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class AttendanceRecord extends Record {
    private String attendanceID;
    private String date;
    private int employeeID;
    private String lastName;
    private String firstName;
    private String timeIn;
    private String timeOut;
    private String hoursWorked;
    private String overTime;
    private String totalHours;

    public AttendanceRecord(int employeeID) {
        this.employeeID = employeeID;
    }

    public AttendanceRecord(String attendanceID, String date, int employeeID, String lastName, String firstName,
                            String timeIn, String timeOut, String hoursWorked, String overTime, String totalHours) {
        this.attendanceID = attendanceID;
        this.date = date;
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.hoursWorked = hoursWorked;
        this.overTime = overTime;
        this.totalHours = totalHours;
    }

    public String attendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(String attendanceID) {
        this.attendanceID = attendanceID;
    }
    public int employeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String date() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String timeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String timeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String hoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(String hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String overTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String totalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }
    @Override
    public void retrieveRecord() throws CsvValidationException, IOException {

    }
    @Override
    public void addRecord() {
        DataHandler dataHandler = new DataHandler(filePath());
        String[] newRecord = {
                attendanceID,
                date,
                String.valueOf(employeeID),
                lastName,
                firstName,
                timeIn,
                timeOut,
                hoursWorked,
                overTime,
                totalHours
        };
        try {
            if (doesExist("ATTENDANCE_ID", attendanceID)){
                System.out.println("You have already clocked in for this employee today. Please clock out first.");
                return;
            }
            dataHandler.createData(newRecord, false);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> retrieveAllPersonalRecord()  { // TODO: implement this function
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
        return "AttendanceRecord{" +
                "attendanceID='" + attendanceID + '\'' +
                ", employeeID=" + employeeID +
                ", date='" + date + '\'' +
                ", timeIn='" + timeIn + '\'' +
                ", timeOut='" + timeOut + '\'' +
                ", hoursWorked='" + hoursWorked + '\'' +
                ", overTime='" + overTime + '\'' +
                ", totalHours='" + totalHours + '\'' +
                '}';
    }

    public static void main(String[] args) throws CsvValidationException, IOException {
        AttendanceRecord record = new AttendanceRecord(1);

        List<String[]> personalRecord = record.retrieveAllPersonalRecord();
        for (String[] row : personalRecord){
            for (String field : row) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }
}
