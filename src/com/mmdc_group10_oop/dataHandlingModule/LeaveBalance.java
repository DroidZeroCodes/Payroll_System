package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class LeaveBalance extends Record {
    int employeeID;
    int sickBalance;
    int vacationBalance;
    int paternityBalance;
    int bereavementBalance;

    public LeaveBalance(int employeeID) throws CsvValidationException, IOException {
        this.employeeID = employeeID;
        retrieveRecord();
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int sickBalance() {
        return sickBalance;
    }

    public void setSickBalance(int sickBalance) {
        this.sickBalance = sickBalance;
    }

    public int vacationBalance() {
        return vacationBalance;
    }

    public void setVacationBalance(int vacationBalance) {
        this.vacationBalance = vacationBalance;
    }

    public int paternityBalance() {
        return paternityBalance;
    }

    public void setPaternityBalance(int paternityBalance) {
        this.paternityBalance = paternityBalance;
    }

    public int bereavementBalance() {
        return bereavementBalance;
    }

    public void setBereavementBalance(int bereavementBalance) {
        this.bereavementBalance = bereavementBalance;
    }

    @Override
    protected void retrieveRecord() throws CsvValidationException, IOException {
        try {
            DataHandler dataHandler = new DataHandler(filePath());

            List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

            if (csv == null || csv.isEmpty()) {
                System.out.println("Leave balance data not found for employee ID: " + employeeID);
            } else {
                String[] row = csv.get(0);

                setEmployeeID(Integer.parseInt(row[0]));
                setSickBalance(Integer.parseInt(row[1]));
                setVacationBalance(Integer.parseInt(row[2]));
                setPaternityBalance(Integer.parseInt(row[3]));
                setBereavementBalance(Integer.parseInt(row[4]));
            }
        } catch (IOException | CsvException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void addRecord() throws CsvException, IOException {

    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                ", Sick Balance: " + sickBalance +
                ", Vacation Balance: " + vacationBalance +
                ", Paternity Balance: " + paternityBalance +
                ", Bereavement Balance: " + bereavementBalance;
    }

    public static void main(String[] args) {
        try {
            LeaveBalance leaveBalance = new LeaveBalance(15);
            System.out.println(leaveBalance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
