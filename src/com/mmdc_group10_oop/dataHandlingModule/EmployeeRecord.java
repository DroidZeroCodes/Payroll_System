package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;

import java.util.Arrays;

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

    public EmployeeRecord(){

    }
    public EmployeeRecord(int employeeID) {
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
    protected void retrieveRecord() {
            DataHandler dataHandler = new DataHandler(filePath());

            String[] record = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

            if (record == null) {
                System.out.println("No Employee data found for Employee ID: " + employeeID);
            } else {
                setEmployeeID(Integer.parseInt(record[0]));
                setLastName(record[1]);
                setFirstName(record[2]);
                setDob(record[3]);
                setAddress(record[4]);
                setPhoneNum(record[5]);
                setSssNo(record[6]);
                setPhilHealthNo(record[7]);
                setTinNo(record[8]);
                setPagIbigNo(record[9]);
                setStatus(record[10]);
                setDepartment(record[11]);
                setPosition(record[12]);
                setSupervisor(record[13]);
                setBasicSalary(parseDoubleValue(record[14]));
                setRiceSubsidy(parseDoubleValue(record[15]));
                setPhoneAllowance(parseDoubleValue(record[16]));
                setClothingAllowance(parseDoubleValue(record[17]));
                setSemiMonthlyRate(parseDoubleValue(record[18]));
                setHourlyRate(parseDoubleValue(record[19]));
            }
    }

    @Override
    protected void addRecord() {

    }

    public Integer[] retrieveEmployeeIDList() {
        DataHandler dataHandler = new DataHandler(filePath());

        return dataHandler.retrieveColumnData_AsInt(primaryKey());
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

    public static void main(String[] args) {
        EmployeeRecord employeeList = new EmployeeRecord(1);

        System.out.println(employeeList);

        System.out.println(Arrays.toString(employeeList.retrieveEmployeeIDList()));
    }
}
