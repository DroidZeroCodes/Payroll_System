package records;

import util.Convert;

import java.time.LocalDate;

/**
 * Represents a payroll record.
 * It contains various financial details such as salary, deductions, and benefits.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link PayrollRecord#toArray()}</li>
 * </ul>
 *
 * @author [Author Name]
 */

public record PayrollRecord(
        String payrollID,
        int employeeID,
        String employeeName,
        LocalDate periodStart,
        LocalDate periodEnd,
        String positionDepartment,
        double salary,
        double hourlyRate,
        double hoursWorked,
        double overTimePay,
        double riceSubsidy,
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
    /**
     * Returns an array containing payroll information for the employee.
     *
     * @return an array of strings representing the payroll information
     */
    @SuppressWarnings("unused")
    public String[] toArray() {
        return new String[]{
                payrollID,
                String.valueOf(employeeID),
                employeeName,
                String.valueOf(periodStart),
                String.valueOf(periodEnd),
                positionDepartment,
                Convert.doubleToString(salary),
                Convert.doubleToString(hourlyRate),
                Convert.doubleToString(hoursWorked),
                Convert.doubleToString(overTimePay),
                Convert.doubleToString(riceSubsidy),
                Convert.doubleToString(phoneAllowance),
                Convert.doubleToString(clothingAllowance),
                Convert.doubleToString(sssDeduction),
                Convert.doubleToString(philHealthDeduction),
                Convert.doubleToString(pagIbigDeduction),
                Convert.doubleToString(taxDeduction),
                Convert.doubleToString(totalBenefits),
                Convert.doubleToString(totalDeductions),
                Convert.doubleToString(grossIncome),
                Convert.doubleToString(netIncome)
        };
    }
}
