package interfaces;

import data.PayrollRecords;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;

import java.time.YearMonth;
import java.util.List;

public interface PayrollManagement {
    public void runPayroll(List<PayrollRecords> tempPayrollRecords, String payrollPeriod) throws EmployeeRecordsException, PayrollException;

    void submitPayroll(List<PayrollRecords> tempPayrollRecords) throws PayrollException;

    List<PayrollRecords> getCurrentPeriodPayrollRecord();

    List<PayrollRecords> getAllPayrollRecords();

    List<String> getPayrollIDList();

    PayrollRecords getPayrollRecord(int employeeID, YearMonth yearMonth);

    PayrollRecords getPayrollRecord(String payrollID);
}
