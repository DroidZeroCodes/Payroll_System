package com.mmdc_group10_oop;

import com.mmdc_group10_oop.ui.LoginPage;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class PayrollSystem {
    public static void main(String[] args) throws IOException, CsvException {
        // Create an instance of the login page
        LoginPage loginPage = new LoginPage();

        // Display the login page
        loginPage.setVisible(true);
    }
}


//User tries to login
//User tries to register
//User tries to change password
//User tries to change username
//User successfully logs in

//System determines the user's role and calls the appropriate method

//User is an Employee

//Employee Views their personal information
//Employee Views their employment information
//Employee changes their personal information, the HR notification is sent
//Employee clocks in
//Employee clocks out
//Employee Views their attendance report
//Employee Views their leave balance
//Employee submits a leave request
//Employee Views their leave status
//Employee Views their payslip

//User is an HR Admin

//HR Admin Views their personal information
//HR Admin Views their employment information
//HR Admin Views an employee's personal information
//HR Admin Views an employee's employment information
//HR Admin Changes an employee's personal information, the change directly changes the database
//HR Admin Changes an employee's employment information, the change directly changes the database
//HR Admin Clocks in
//HR Admin Clocks out
//HR Admin Enters an employee's attendance
//HR Admin Deletes an employee's attendance
//HR Admin Updates an employee's attendance
//HR Admin Views their attendance report
//HR Admin Views an employee's attendance report
//HR Admin Views all attendance reports
//HR Admin Views their leave balance
//HR Admin Views an employee's leave balance
//HR Admin Views all leave balances
//HR Admin Submits a leave request
//HR Admin Submits an employee's leave request, Manager notification is sent
//HR Admin Approves a leave
//HR Admin Rejects a leave
//HR Admin Views their leave status
//HR Admin Views an employee's leave status
//HR Admin Views all leave status
//HR Admin Views their payslip
//HR Admin Requests an employee's payslip
//HR Admin Generates an Attendance Report
//HR Admin Exports an Attendance Report
//HR Admin Adds an employee
//HR Admin Removes an employee


//User is a Payroll Admin

//Payroll Admin Views their personal information
//Payroll Admin Views their employment information
//Payroll Admin Views an employee's employment information
//Payroll Admin Changes an employee's employment information, the change directly changes the database
//Payroll Admin Clocks in
//Payroll Admin Clocks out
//Payroll Admin Views their attendance report
//Payroll Admin Views an employee's attendance report
//Payroll Admin Views all attendance reports
//Payroll Admin Views their leave balance
//Payroll Admin Submits a leave request
//Payroll Admin Views their leave status
//Payroll Admin generates a payslip
//Payroll Admin Views their payslip
//Payroll Admin Views an employee's payslip
//Payroll Admin Views all payslips
//Payroll Admin Generates a payroll report
//Payroll Admin Exports a payroll report

//User is an IT Admin
//IT Admin Views their personal information
//IT Admin Views their employment information
//IT Admin changes their personal information, the HR notification is sent
//IT Admin clocks in
//IT Admin clocks out
//IT Admin Views their attendance report
//IT Admin Views their leave balance
//IT Admin submits a leave request
//IT Admin Views their leave status
//IT Admin Views their payslip
//IR Admin Creates a User
//IT Admin Updates a Username
//IT Admin Updates a Password