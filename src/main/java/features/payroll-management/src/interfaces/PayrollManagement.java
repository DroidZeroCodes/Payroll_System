package interfaces;

import data.PayrollRecord;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;

import java.time.YearMonth;
import java.util.List;

public interface PayrollManagement {
    void runPayroll(List<PayrollRecord> tempPayrollRecords, String payrollPeriod) throws EmployeeRecordsException, PayrollException;

    void submitPayroll(List<PayrollRecord> tempPayrollRecords) throws PayrollException;

    List<PayrollRecord> getAllPayrollRecords();

    List<String> getPayrollIDList(String period);

    PayrollRecord getPayrollRecord(int employeeID, YearMonth yearMonth);

    PayrollRecord getPayrollRecord(String payrollID);
}
