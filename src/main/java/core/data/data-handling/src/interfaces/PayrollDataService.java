package interfaces;


import data.PayrollRecord;

import java.time.LocalDate;
import java.util.List;

public interface PayrollDataService {
    PayrollRecord getPayroll_ByPayrollID(String payrollID);

    PayrollRecord getPayroll_ByEmployeeID(int employeeID);

    List<PayrollRecord> getAll_Payroll_ByEmployeeID(String employeeID);

    List<PayrollRecord> getAll_PayrollRecords_ForPeriod(LocalDate startDate, LocalDate endDate);

    List<PayrollRecord> getAll_PayrollRecords();

    void addPayrollRecord(PayrollRecord newRecord);

}
