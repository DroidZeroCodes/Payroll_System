package com.mmdc_group10_oop.dataHandlingModule;


import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class UserCredentials extends Record {
    String username, lastName, firstName, position, role, department, password;
    int employeeID;

    public UserCredentials(String username) throws CsvValidationException, IOException {
        this.username = username;
        retrieveRecord();
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String position() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String role() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String department() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    protected void retrieveRecord() throws CsvValidationException, IOException {
        if (!isValidKey(primaryKey()) || !doesExist( primaryKey(), username)) {
            System.out.println("Invalid user credentials");
            return;
        }

        try {
            DataHandler dataHandler = new DataHandler(filePath());
            List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), username);

            if (csv == null || csv.isEmpty()) {
                System.out.println("Invalid user credentials");
            } else if (csv.size() > 1) {
                System.out.println("Multiple records found");
            } else {
                String[] row = csv.get(0);
                setUsername(row[0]);
                setLastName(row[1]);
                setFirstName(row[2]);
                setPosition(row[3]);
                setRole(row[4]);
                setDepartment(row[5]);
                setPassword(row[6]);
                setEmployeeID(Integer.parseInt(row[7]));
                System.out.println();
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
        return "UserCredentials{" +
                "username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", employeeID=" + employeeID +
                "}";
    }
}