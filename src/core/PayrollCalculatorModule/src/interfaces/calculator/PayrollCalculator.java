package interfaces.calculator;

import interfaces.Allowance;
import interfaces.Payroll;
import interfaces.SalaryAdjustment;
import interfaces.TaxAndDeductions;

import java.util.Map;
import java.util.TreeMap;


/**
 * A class representing a payroll calculator that implements salary adjustments, allowances, tax, and deductions.
 * It calculates various components of payroll including overtime pay, salary, contributions, deductions, and net pay.
 * Implements the following interfaces:
 * <ul>
 *     <li>{@link SalaryAdjustment}</li>
 *     <li>{@link Allowance}</li>
 *     <li>{@link TaxAndDeductions}</li>
 *     <li>{@link Payroll}</li>
 * </ul>
 */

@SuppressWarnings("unused")
public class PayrollCalculator implements SalaryAdjustment, Allowance, TaxAndDeductions, Payroll {
    // Constants
    private static final double PHILHEALTH_RATE = 0.03 * 0.5;
    private static final double PAGIBIG_RATE_BELOW_1500 = 0.01;
    private static final double PAGIBIG_RATE_ABOVE_1500 = 0.02;
    private static final double PAGIBIG_MAX_CONTRIBUTION = 100.00;
    private static final Map<Double, Double> SSS_CONTRIBUTION_TABLE = initializeSSSContributionTable();
    // Properties
    private final double hourlyRate;
    private final double hoursWorked;
    private final double overTimeHours;
    private final double riceSubsidy;
    private final double phoneAllowance;
    private final double clothingAllowance;

    // Constructor
    public PayrollCalculator(double hoursWorked, double overTimeHours, double hourlyRate, double riceSubsidy, double phoneAllowance, double clothingAllowance) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overTimeHours = overTimeHours;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    /**
     * Initializes and populates a contribution table based on compensation ranges.
     *
     * @return a map containing compensation ranges as keys and corresponding contributions as values
     */
    private static Map<Double, Double> initializeSSSContributionTable() {
        Map<Double, Double> table = new TreeMap<>();
        double baseContribution = 135.00;
        double incrementContribution = 22.50;
        int steps = 44;

        for (int i = 0; i < steps; i++) {
            double compensationRange = 2750.0 + i * 500.0;
            double contribution = baseContribution + i * incrementContribution;
            table.put(compensationRange, contribution);
        }
        return table;
    }


    /**
     * A method to calculate overtime pay.
     *
     * @return the calculated overtime pay
     */
    @Override
    public double overtimePay() {
        return 1.5 * hourlyRate * overTimeHours;
    }

    /**
     * Calculate the salary based on the hours worked, hourly rate, and overtime pay.
     *
     * @return the calculated salary
     */
    @Override
    public double salary() {
        return hoursWorked * hourlyRate + overtimePay();
    }

    /**
     * Calculate the Social Security contribution based on the salary using a predefined table.
     *
     * @return the Social Security contribution amount
     */
    @Override
    public double calculateSSS() {
        for (Map.Entry<Double, Double> entry : SSS_CONTRIBUTION_TABLE.entrySet()) {
            if (salary() <= entry.getKey()) {
                return entry.getValue();
            }
        }
        return 1125.0; // Default value if not found in the table
    }

    /**
     * Calculate the PhilHealth contribution based on the salary.
     *
     * @return the calculated PhilHealth contribution
     */
    @Override
    public double calculatePhilHealth() {
        return salary() * PHILHEALTH_RATE;
    }

    /**
     * Calculates the PagIbig contribution based on the salary.
     *
     * @return the calculated PagIbig contribution
     */
    @Override
    public double calculatePagIbig() {
        double pagIbigContributionRate = (salary() <= 1500) ? PAGIBIG_RATE_BELOW_1500 : PAGIBIG_RATE_ABOVE_1500;
        return Math.min(pagIbigContributionRate * salary(), PAGIBIG_MAX_CONTRIBUTION);
    }

    /**
     * Calculate the partial deduction by adding the calculated SSS, PhilHealth, and PagIbig contributions.
     *
     * @return the total partial deduction
     */
    @Override
    public double calculatePartialDeduction() {
        return calculateSSS() + calculatePhilHealth() + calculatePagIbig();
    }

    /**
     * Calculate the total deduction by summing up the results of partial deduction and withholding tax calculation.
     *
     * @return the total deduction amount
     */
    @Override
    public double calculateTotalDeduction() {
        return calculatePartialDeduction() + calculateWithholdingTax();
    }

    /**
     * Calculates the withholding tax based on the gross pay and partial deduction.
     *
     * @return the withholding tax amount
     */
    @Override
    public double calculateWithholdingTax() {
        double taxableIncome = calculateGrossPay() - calculatePartialDeduction();
        return TaxCalculator.calculateTax(taxableIncome);
    }

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    @Override
    public double calculateGrossPay() {
        return salary() + calculateTotalAllowances();
    }

    /**
     * Calculate the net pay by subtracting the total deduction from the gross pay.
     *
     * @return the net pay calculated
     */
    @Override
    public double calculateNetPay() {
        return calculateGrossPay() - calculateTotalDeduction();
    }

    /**
     * Calculate the total allowances by summing up the rice subsidy, phone allowance, and clothing allowance.
     *
     * @return the total allowances calculated
     */
    @Override
    public double calculateTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    /**
     * A class to calculate the tax based on the taxable income.
     */
    public static class TaxCalculator {

        /**
         * The tax brackets.
         */
        private static final double[][] taxBrackets = {
                {0, 20832, 0.20},
                {20833, 33333, 0.25},
                {33334, 66667, 0.30},
                {66668, 166667, 0.32},
                {166668, 666667, 0.35}
        };


        /**
         * Calculate the tax based on the taxable income.
         *
         * @return the tax amount
         */
        public static double calculateTax(double taxableIncome) {
            double tax = 0;
            for (double[] bracket : taxBrackets) {
                if (taxableIncome <= bracket[1]) {
                    tax += (taxableIncome - bracket[0]) * bracket[2];
                    break;
                } else {
                    tax += (bracket[1] - bracket[0]) * bracket[2];
                }
            }
            return tax;
        }
    }
}
