package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.Convert;
import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    public AttendanceRecord() {
    }

    public AttendanceRecord(int employeeID) {
        this.employeeID = employeeID;
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
    @Override
    public void retrieveRecord() {

    }

    public List<String[]> retrieveAllPersonalRecord() {
        DataHandler dataHandler = new DataHandler(filePath());

        List<String[]> csv = dataHandler.retrieveMultipleData(employeeNo(), String.valueOf(employeeID));

        if (csv == null || csv.isEmpty()) {
            System.out.println("No attendance record found for employee ID: " + employeeID);
        } else {
            return csv;
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
                '}';
    }

    public static void main(String[] args) throws CsvValidationException, IOException {
        AttendanceRecord record = new AttendanceRecord(1);

        System.out.println(record.retrieveHoursTotalWorked(LocalDate.of(2022, 11, 1), LocalDate.of(2022, 11, 30)));
    }

    public Double retrieveHoursTotalWorked(LocalDate startDate, LocalDate endDate) {
        List <String[]> records = retrieveAllPersonalRecord();
        if (records == null || records.isEmpty()) {
            return 0.0;
        }

        List <String[]> filteredRecords = new ArrayList<>();

        for (String[] row : records) {
            LocalDate recordDate = Convert.StringToLocalDate(row[1]);
            if ((recordDate.isEqual(startDate) || recordDate.isEqual(endDate))
                    || (recordDate.isAfter(startDate) && recordDate.isBefore(endDate))) {
                filteredRecords.add(row);
            }
        }

        double totalHoursWorked = 0.0;
        for (String[] row : filteredRecords) {
            LocalTime hoursWorked_temp = Convert.StringToLocalTime(row[7]);;
            totalHoursWorked += hoursWorked_temp.getHour() + (hoursWorked_temp.getMinute() / 60.0);
        }
        return totalHoursWorked;
    }

    public Double retrieveOvertimeHours(LocalDate startDate, LocalDate endDate) {
        List <String[]> records = retrieveAllPersonalRecord();
        if (records == null || records.isEmpty()) {
            return 0.0;
        }

        List <String[]> filteredRecords = new ArrayList<>();

        for (String[] row : records) {
            LocalDate recordDate = Convert.StringToLocalDate(row[1]);
            if ((recordDate.isEqual(startDate) || recordDate.isEqual(endDate))
                    || (recordDate.isAfter(startDate) && recordDate.isBefore(endDate))) {
                filteredRecords.add(row);
            }
        }

        double overtimeHours = 0.0;
        for (String[] row : filteredRecords) {
            LocalTime overtimeHours_Temp = Convert.StringToLocalTime(row[8]);;
            overtimeHours += overtimeHours_Temp.getHour() + (overtimeHours_Temp.getMinute() / 60.0);
        }
        return overtimeHours;
    }
}
