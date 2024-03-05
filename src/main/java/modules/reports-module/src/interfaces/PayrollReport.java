package interfaces;

import java.time.LocalDate;
import java.util.List;

public interface PayrollReport {
    List<String[]> generatePayrollReport(String reportType, LocalDate periodStart, LocalDate endDate);
}
