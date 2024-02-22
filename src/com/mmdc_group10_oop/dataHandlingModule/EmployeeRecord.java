package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class EmployeeRecord extends Record {
    private int employeeID;
    private String firstName, lastName, dob, address, phoneNum;
    private String sssNo, philHealthNo, pagIbigNo, tinNo;
    private Double riceSubsidy, phoneAllowance, clothingAllowance;
    private Double basicSalary, semiMonthlyRate, hourlyRate;
    private String position;
    private String department;
    private String supervisor;
    private String status;

    public EmployeeRecord(int employeeID) throws CsvException, IOException {
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

    public String dob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public String sssNo() {
        return sssNo;
    }

    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    public String philHealthNo() {
        return philHealthNo;
    }

    public void setPhilHealthNo(String philHealthNo) {
        this.philHealthNo = philHealthNo;
    }

    public String pagIbigNo() {
        return pagIbigNo;
    }

    public void setPagIbigNo(String pagIbigNo) {
        this.pagIbigNo = pagIbigNo;
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

    public String tinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public Double riceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(Double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public Double phoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(Double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public Double clothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(Double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public Double basicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double semiMonthlyRate() {
        return semiMonthlyRate;
    }

    public void setSemiMonthlyRate(Double semiMonthlyRate) {
        this.semiMonthlyRate = semiMonthlyRate;
    }

    public Double hourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }


    @Override
    protected void retrieveRecord() throws CsvException, IOException {
        if (isValidKey(employeeID) && doesExist(primaryKey(),String.valueOf(employeeID))) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

                if (csv == null || csv.isEmpty()) {
                    System.out.println("No data found for employeeUI ID: " + employeeID);
                } else if (csv.size() > 1) {
                    System.out.println("Multiple records found for employeeUI ID: " + employeeID);
                } else {
                    String[] row = csv.get(0);

                    DecimalFormat format = new DecimalFormat("#,##0.0#");
                    format.setParseBigDecimal(true);

                    setEmployeeID(Integer.parseInt(row[0]));
                    setLastName(row[1]);
                    setFirstName(row[2]);
                    setDob(row[3]);
                    setAddress(row[4]);
                    setPhoneNum(row[5]);
                    setSssNo(row[6]);
                    setPhilHealthNo(row[7]);
                    setTinNo(row[8]);
                    setPagIbigNo(row[9]);
                    setStatus(row[10]);
                    setDepartment(row[11]);
                    setPosition(row[12]);
                    setSupervisor(row[13]);
                    setBasicSalary(parseDoubleValue(row[14]));
                    setRiceSubsidy(parseDoubleValue(row[15]));
                    setPhoneAllowance(parseDoubleValue(row[16]));
                    setClothingAllowance(parseDoubleValue(row[17]));
                    setSemiMonthlyRate(parseDoubleValue(row[18]));
                    setHourlyRate(parseDoubleValue(row[19]));
                }
            } catch (IOException | CsvException | NumberFormatException e ) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "employeeUI Profile{" +
                "employeeID=" + employeeID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, CsvException {
        EmployeeRecord employeeList = new EmployeeRecord(1);

        System.out.println(employeeList);
    }
}
