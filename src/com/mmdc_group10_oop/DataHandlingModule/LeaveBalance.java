package com.mmdc_group10_oop.DataHandlingModule;

import com.mmdc_group10_oop.DataHandlingModule.util.Record;

public class LeaveBalance extends Record {
    int employeeID;
    int balance;
    public LeaveBalance() {
    }
    public LeaveBalance(int employeeID, int balance) {
        this.employeeID = employeeID;
        this.balance = balance;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int balance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    protected void retrieveRecord() {

    }

    //Method to update balance
    public void updateBalance(int balance) {
        this.balance = balance;
    }

    //Method to add balance
    public void addBalance(int balance) {
        this.balance += balance;
    }

    //Method to deduct balance
    public void deductBalance(int balance) {
        this.balance -= balance;
    }
}
