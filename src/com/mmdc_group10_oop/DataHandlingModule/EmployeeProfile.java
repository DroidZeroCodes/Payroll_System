package com.mmdc_group10_oop.DataHandlingModule;

import com.mmdc_group10_oop.service.util.DataHandler;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

public class EmployeeProfile extends Record {
    public int employeeID;
    String firstName, lastName, address, phoneNum;
    LocalDate dob;

    public EmployeeProfile(int employeeID) throws CsvException, IOException {
        this.employeeID = employeeID;
        retrieveRecord();
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate dob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String phoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }



    @Override
    void retrieveRecord() throws CsvException, IOException {
        if (isValidKey(employeeID) && doesExist(filePath(), primaryKey(),String.valueOf(employeeID))) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

                if (csv == null || csv.isEmpty()) {
                    System.out.println("No data found for employee ID: " + employeeID);
                } else if (csv.size() > 1) {
                    System.out.println("Multiple records found for employee ID: " + employeeID);
                } else {
                    String[] row = csv.get(0);

                    DecimalFormat format = new DecimalFormat("#,##0.0#");
                    format.setParseBigDecimal(true);

                    setEmployeeID(Integer.parseInt(row[0]));
                    setLastName(row[1]);
                    setFirstName(row[2]);
                    setDob(parseDate(row[3]));
                    setAddress(row[4]);
                    setPhoneNum(row[5]);
                }
            } catch (IOException | CsvException | NumberFormatException e ) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Employee Profile{" +
                "employeeID=" + employeeID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, CsvException {
        EmployeeProfile employeeProfile = new EmployeeProfile(1);

        System.out.println(employeeProfile);
    }
}
