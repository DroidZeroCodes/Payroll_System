package interfaces;


import data.PayrollRecords;

import java.time.LocalDate;
import java.util.List;

public interface PayrollDataService {
    PayrollRecords getPayroll_ByPayrollID(String payrollID);

    PayrollRecords getPayroll_ByEmployeeID(int employeeID);

    List<PayrollRecords> getPayrollRecords_ByEmployeeID(String employeeID);

    List<PayrollRecords> getAll_PayrollRecords_ForPeriod(LocalDate startDate);

    List<PayrollRecords> getAll_PayrollRecords();

    void addPayrollRecord(PayrollRecords newRecord);

}
