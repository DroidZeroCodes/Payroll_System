package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class EmploymentInformation extends Record {
    public int employeeID;
    private String position;
    private String department;
    private String supervisor;
    private String status;

    public EmploymentInformation(int employeeID) throws CsvValidationException, IOException {
        this.employeeID = employeeID;
        retrieveRecord();
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String position() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String department() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String supervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected void retrieveRecord() throws CsvValidationException, IOException {
        if (isValidKey(employeeID) && doesExist(primaryKey(),String.valueOf(employeeID))) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

                if (csv == null || csv.isEmpty()) {
                    System.out.println("No data found for employee ID: " + employeeID);
                } else if (csv.size() > 1) {
                    System.out.println("Multiple records found for employee ID: " + employeeID);
                } else {
                    String[] row = csv.get(0);

                    setEmployeeID(Integer.parseInt(row[0]));
                    setPosition(row[1]);
                    setDepartment(row[2]);
                    setSupervisor(row[3]);
                    setStatus(row[4]);
                }
            } catch (IOException | CsvException | NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "EmploymentInformation{" +
                "employeeID=" + employeeID +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static void main(String[] args) {
        EmploymentInformation employmentInformation = null;
        try {
            employmentInformation = new EmploymentInformation(1);
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        System.out.println(employmentInformation.toString());
    }
}
