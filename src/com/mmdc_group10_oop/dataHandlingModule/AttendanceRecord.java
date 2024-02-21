package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AttendanceRecord extends Record {
    private int employeeID;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;

    private double overTime;
    private double totalHours;

    public AttendanceRecord() {

    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate date() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime timeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime timeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public double overTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public double totalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public void retrieveRecord() throws CsvValidationException, IOException {
        if (isValidKey(employeeID) && doesExist(filePath(), primaryKey(), employeeID)) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

                if (csv == null || csv.isEmpty()) {
                    System.out.println("No data found for employee ID: " + employeeID);
                } else {
                    String[] row = csv.get(0);

                    setEmployeeID(Integer.parseInt(row[0]));
                    setDate(parseDate(row[3]));
                    setTimeIn(parseDateTime(row[3]));
                    setTimeOut(parseDateTime(row[4]));
                    setOverTime(parseFinancialValue(row[5]));
                    setTotalHours(parseFinancialValue(row[6]));

                }
            } catch (IOException | CsvException | NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
