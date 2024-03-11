package interfaces;

import exceptions.PayrollException;

import java.util.List;

public interface PayrollReport {
    List<String[]> generatePayrollReport(String reportType) throws PayrollException;
}
