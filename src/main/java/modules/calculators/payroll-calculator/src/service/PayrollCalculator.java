package service;


import interfaces.Allowance;
import interfaces.Payroll;
import interfaces.SalaryAdjustment;
import interfaces.TaxAndDeductions;

import java.util.Map;
import java.util.TreeMap;


public class PayrollCalculator implements SalaryAdjustment, Allowance, TaxAndDeductions, Payroll {
    private static final double PHILHEALTH_RATE = 0.03 * 0.5;
    private static final double PAGIBIG_RATE_BELOW_1500 = 0.01;
    private static final double PAGIBIG_RATE_ABOVE_1500 = 0.02;
    private static final double PAGIBIG_MAX_CONTRIBUTION = 100.00;
    private static final Map<Double, Double> SSS_CONTRIBUTION_TABLE = initializeSSSContributionTable();
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

    @Override
    public double overtimePay() {
        return 1.5 * hourlyRate * overTimeHours;
    }

    @Override
    public double salary() {
        return hoursWorked * hourlyRate + overtimePay();
    }

    @Override
    public double calculateSSS() {
        for (Map.Entry<Double, Double> entry : SSS_CONTRIBUTION_TABLE.entrySet()) {
            if (salary() <= entry.getKey()) {
                return entry.getValue();
            }
        }
        return 1125.0; // Default value if not found in the table
    }

    @Override
    public double calculatePhilhealth() {
        return salary() * PHILHEALTH_RATE;
    }

    @Override
    public double calculatePagIbig() {
        double pagIbigContributionRate = (salary() <= 1500) ? PAGIBIG_RATE_BELOW_1500 : PAGIBIG_RATE_ABOVE_1500;
        return Math.min(pagIbigContributionRate * salary(), PAGIBIG_MAX_CONTRIBUTION);
    }

    @Override
    public double calculatePartialDeduction() {
        return calculateSSS() + calculatePhilhealth() + calculatePagIbig();
    }

    @Override
    public double calculateTotalDeduction() {
        return calculatePartialDeduction() + calculateWithholdingTax();
    }

    @Override
    public double calculateWithholdingTax() {
        double taxableIncome = calculateGrossPay() - calculatePartialDeduction();
        return TaxCalculator.calculateTax(taxableIncome);
    }

    @Override
    public double calculateGrossPay() {
        return salary() + calculateTotalAllowances();
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay() - calculateTotalDeduction();
    }

    @Override
    public double calculateTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    public static class TaxCalculator {
        private static final double[][] taxBrackets = {
                {0, 20832, 0.20},
                {20833, 33333, 0.25},
                {33334, 66667, 0.30},
                {66668, 166667, 0.32},
                {166668, 666667, 0.35}
        };

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
