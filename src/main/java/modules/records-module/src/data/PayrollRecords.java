package data;

import java.time.LocalDate;

public record PayrollRecords(
        String payrollID,
        int employeeID,
        String employeeName,
        LocalDate periodStart,
        LocalDate periodEnd,
        String positionDepartment,
        double monthlySalary,
        double hourlyRate,
        java.time.LocalTime hoursWorked,
        double overTimePay,
        double riceAllowance,
        double phoneAllowance,
        double clothingAllowance,
        double sssDeduction,
        double philHealthDeduction,
        double pagIbigDeduction,
        double taxDeduction,
        double totalBenefits,
        double totalDeductions,
        double grossIncome,
        double netIncome
) {
    public String[] toArray() {
        return new String[]{
                payrollID,
                String.valueOf(employeeID),
                employeeName,
                String.valueOf(periodStart),
                String.valueOf(periodEnd),
                positionDepartment,
                String.valueOf(monthlySalary),
                String.valueOf(hourlyRate),
                String.valueOf(hoursWorked),
                String.valueOf(overTimePay),
                String.valueOf(riceAllowance),
                String.valueOf(phoneAllowance),
                String.valueOf(clothingAllowance),
                String.valueOf(sssDeduction),
                String.valueOf(philHealthDeduction),
                String.valueOf(pagIbigDeduction),
                String.valueOf(taxDeduction),
                String.valueOf(totalBenefits),
                String.valueOf(totalDeductions),
                String.valueOf(grossIncome),
        };
    }
}
