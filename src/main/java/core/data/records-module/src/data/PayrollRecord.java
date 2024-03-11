package data;

import util.Convert;

import java.time.LocalDate;

public record PayrollRecord(
        String payrollID,
        int employeeID,
        String employeeName,
        LocalDate periodStart,
        LocalDate periodEnd,
        String positionDepartment,
        double monthlySalary,
        double hourlyRate,
        double hoursWorked,
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
                Convert.doubleToCurrency(monthlySalary),
                Convert.doubleToCurrency(hourlyRate),
                Convert.doubleToString(hoursWorked),
                Convert.doubleToCurrency(overTimePay),
                Convert.doubleToCurrency(riceAllowance),
                Convert.doubleToCurrency(phoneAllowance),
                Convert.doubleToCurrency(clothingAllowance),
                Convert.doubleToCurrency(sssDeduction),
                Convert.doubleToCurrency(philHealthDeduction),
                Convert.doubleToCurrency(pagIbigDeduction),
                Convert.doubleToCurrency(taxDeduction),
                Convert.doubleToCurrency(totalBenefits),
                Convert.doubleToCurrency(totalDeductions),
                Convert.doubleToCurrency(grossIncome),
                Convert.doubleToCurrency(netIncome)
        };
    }
}
