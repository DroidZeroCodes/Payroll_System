package com.mmdc_group10_oop;

import com.mmdc_group10_oop.service.user.Employee;
import com.mmdc_group10_oop.service.user.User;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class SelfServicePortal {
    public static void main(String[] args) throws IOException, CsvException {
        // User interaction
        User user = new User("MGarcia1", "P2bG!8Fm");

        System.out.println(user);

        if (user.login("MGarcia1", "P2bG!8Fm")) {
            switch (user.role) {
                case "EMPLOYEE":
                    Employee employee = new Employee(user.employeeID);
                    // Open Employee Homepage
                    // Employee actions
                    break;
                case "HR_ADMIN":
                    // Open HR Admin Homepage
                    // HR Admin actions
                    break;
                case "PAYROLL_ADMIN":

                    // Open Payroll Admin Homepage
                    // Payroll Admin actions
                    break;
                case "IT_ADMIN":
                    // Open IT Admin Homepage
                    // IT Admin actions
                    break;
                default:
                    // Handle invalid role
            }
        } else {
            // Handle login failure
        }
    }
}
