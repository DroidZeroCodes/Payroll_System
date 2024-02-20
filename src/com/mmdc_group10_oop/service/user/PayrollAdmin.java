package com.mmdc_group10_oop.service.user;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class PayrollAdmin extends Employee implements PayrollAdminActions {
    public PayrollAdmin(int employeeID) throws IOException, CsvException {
        super(employeeID);
    }
    @Override
    public void viewEmployeeEmploymentInfo(int employeeID) {

    }

    @Override
    public void generatePayrollReport() {

    }

    @Override
    public void exportPayrollReport() {

    }
}
