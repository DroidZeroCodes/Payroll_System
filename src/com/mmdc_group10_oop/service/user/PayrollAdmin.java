package com.mmdc_group10_oop.service.user;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class PayrollAdmin extends Employee{
    public PayrollAdmin(int employeeID) throws IOException, CsvException {
        super(employeeID, null);
    }
}
