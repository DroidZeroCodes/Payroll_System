package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class AttendanceRecord extends Record {
    private int employeeID;
    private String date;
    private String timeIn;
    private String timeOut;
    private String hoursWorked;
    private String overTime;
    private String totalHours;

    public AttendanceRecord(int employeeID) throws CsvValidationException, IOException {
        this.employeeID = employeeID;
        retrieveRecord();
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
        if (isValidKey(employeeID) && doesExist( primaryKey(), String.valueOf(employeeID))) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

                if (csv == null || csv.isEmpty()) {
                    System.out.println("No data found for employee ID: " + employeeID);
                } else {
                    String[] row = csv.get(0);

                    setDate((row[0]));
                    setEmployeeID(Integer.parseInt(row[1]));
                    setTimeIn((row[4]));
                    setTimeOut((row[5]));
                    setHoursWorked((row[6]));
                    setOverTime((row[7]));
                    setTotalHours((row[8]));
                }
            } catch (IOException | CsvException | NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String[]> retrieveAllPersonalRecord() throws CsvValidationException, IOException { // TODO: implement this function
        if (isValidKey(employeeID) && doesExist( primaryKey(), String.valueOf(employeeID))) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveMultipleData(primaryKey(), String.valueOf(employeeID));

                if (csv == null || csv.isEmpty()) {
                    System.out.println("No data found for employee ID: " + employeeID);
                } else {
                    return csv;
                }
            } catch (IOException | CsvException | NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Attendance record for employeeID: " + employeeID +
                ", date: " + date +
                ", timeIn: " + timeIn +
                ", timeOut: " + timeOut +
                ", hoursWorked: " + hoursWorked +
                ", overTime: " + overTime +
                ", totalHours: " + totalHours;
    }

    public static void main(String[] args) throws CsvValidationException, IOException {
        AttendanceRecord record = new AttendanceRecord(1);

        System.out.println(record);

        List<String[]> personalRecord = record.retrieveAllPersonalRecord();
        for (String[] row : personalRecord){
            System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3] + " " + row[4] + " " + row[5] + " " + row[6] + " " + row[7] + " " + row[8]);
        }


    }
}
