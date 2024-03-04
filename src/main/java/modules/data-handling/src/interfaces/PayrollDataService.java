package interfaces;


import data.PayrollRecords;

import java.time.LocalDate;
import java.util.List;

public interface PayrollDataService {
    PayrollRecords getPayroll_ByPayrollID(String payrollID);
    PayrollRecords getPayroll_ByEmployeeID(int employeeID);
    List<PayrollRecords> getPayrollRecords_ByEmployeeID(String employeeID);
    List<PayrollRecords> getPayrollRecords_ByPeriodDate(LocalDate startDate);
    List<PayrollRecords> getAllPayrollRecords();

    void addPayrollRecord(PayrollRecords newRecord);

}
