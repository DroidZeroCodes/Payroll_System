package com.mmdc_group10_oop.service.logic;

import com.mmdc_group10_oop.dataHandlingModule.EmployeeRecord;

public class PayrollCalculator {
    private final int employeeID;
    private final double hoursWorked;
    private final double hourlyRate;
    private final double overTimeHours;
    private final double overTimePay;
    private final double currentSalary;
    private final double riceSubsidy;
    private final double phoneAllowance;
    private final double clothingAllowance;
    private final double totalAllowances;
    private final double grossPay;
    private final double SSSContribution;
    private final double philhealthContribution;
    private final double pagIbigContribution;
    private double withholdingTax;
    private final double totalDeduction;
    private final double netPay;
    EmployeeRecord record;

    // Constructor
    public PayrollCalculator(final int employeeID, final double hoursWorked, final double overTimeHours) {
        this.employeeID = employeeID;

        record = new EmployeeRecord(employeeID);

        this.hourlyRate = record.hourlyRate();
        this.hoursWorked = hoursWorked;
        this.overTimeHours = overTimeHours;
        this.overTimePay = 1.5 * hourlyRate * overTimeHours;
        this.currentSalary = hoursWorked * hourlyRate + overTimePay;
        this.riceSubsidy = record.riceSubsidy();
        this.phoneAllowance = record.phoneAllowance();
        this.clothingAllowance = record.clothingAllowance();
        this.totalAllowances = calculateTotalAllowances();
        this.grossPay = calculateGrossPay();
        this.SSSContribution = calculateSSS();
        this.philhealthContribution = calculatePhilhealth();
        this.pagIbigContribution = calculatePagIbig();
        this.withholdingTax = calculateWitholdingTax();
        this.totalDeduction = calculateTotalDeduction();
        this.netPay = calculateNetPay();
    }

    // Method to calculate total allowances
    private double calculateTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    // Method to calculate total deduction
    private double calculateTotalDeduction() {
        return SSSContribution + philhealthContribution + pagIbigContribution + withholdingTax;
    }

    // Method to calculate SSS contribution
    private double calculateSSS() {
        double baseCompensation = 0; // Base compensation
        double baseContribution = 135.00; // Initial contribution value
        double incrementCompensation = 500.00; // Increment for each step
        double incrementContribution = 22.50; // Increment for each step
        int steps = 44; // Number of steps in the table

        // Calculate compensation range and contribution table
        double[] sssCompensationRange = new double[steps];
        double[] sssContributionTable = new double[steps];

        for (int i = 0; i < steps; i++) {
            if (i  > 0){
                baseCompensation = 2750.0;
            }
            sssCompensationRange[i] = baseCompensation + i * incrementCompensation ;
            sssContributionTable[i] = baseContribution + i * incrementContribution;
        }

        // Find the appropriate contribution for the given salary
        for (int i = 0; i < steps; i++) {
            if (currentSalary <= sssCompensationRange[i]) {
                return sssContributionTable[i];
            }
        }
        return 1125.0; // If the salary exceeds the last range
    }

    // Method to calculate Philhealth contribution
    private double calculatePhilhealth() {
        return currentSalary * 0.03 * 0.5;
    }

    private double calculatePagIbig() {
        double pagibigContributionRateEmployee = (currentSalary <= 1500) ? 0.01 : 0.02;
        return Math.min(pagibigContributionRateEmployee * currentSalary, 100.00);
    }

    // Method to calculate withholding tax
    private double calculateWitholdingTax() {
        double partialDeductions = SSSContribution + philhealthContribution + pagIbigContribution;

        double taxableIncome = grossPay - partialDeductions;

        if (taxableIncome <= 0) {
            withholdingTax = 0;
        } else if (taxableIncome <= 20833.33) {
            withholdingTax = taxableIncome * 0.20;
        } else if (taxableIncome <= 33333.33) {
            withholdingTax = 20833.33 * 0.20 + (taxableIncome - 20833.33) * 0.25;
        } else if (taxableIncome <= 66666.67) {
            withholdingTax = 20833.33 * 0.20 + 12500 * 0.25 + (taxableIncome - 33333.33) * 0.30;
        } else if (taxableIncome <= 166666.67) {
            withholdingTax = 20833.33 * 0.20 + 12500 * 0.25 + 33333.33 * 0.30 + (taxableIncome - 66666.67) * 0.32;
        } else if (taxableIncome <= 666666.67) {
            withholdingTax = 20833.33 * 0.20 + 12500 * 0.25 + 33333.33 * 0.30 + 100000.00 * 0.32 + (taxableIncome - 166666.67) * 0.35;
        } else {
            withholdingTax = 20833.33 * 0.20 + 12500 * 0.25 + 33333.33 * 0.30 + 100000.00 * 0.32 + 500000.00 * 0.35 + (taxableIncome - 666666.67) * 0.40;
        }
        return withholdingTax;
    }

    // Method to calculate gross pay
    private double calculateGrossPay() {
        return currentSalary + totalAllowances;
    }

    // Method to calculate net pay
    private double calculateNetPay() {
        return grossPay - totalDeduction;
    }

    public int employeeID() {
        return employeeID;
    }

    public double hoursWorked() {
        return hoursWorked;
    }

    public double hourlyRate() {
        return hourlyRate;
    }

    public double overTimeHours() {
        return overTimeHours;
    }

    public double overTimePay() {
        return overTimePay;
    }

    public double currentSalary() {
        return currentSalary;
    }

    public double riceSubsidy() {
        return riceSubsidy;
    }

    public double phoneAllowance() {
        return phoneAllowance;
    }

    public double clothingAllowance() {
        return clothingAllowance;
    }

    public double totalAllowances() {
        return totalAllowances;
    }

    public double grossPay() {
        return grossPay;
    }

    public double SSSContribution() {
        return SSSContribution;
    }

    public double philhealthContribution() {
        return philhealthContribution;
    }

    public double pagIbigContribution() {
        return pagIbigContribution;
    }

    public double withholdingTax() {
        return withholdingTax;
    }

    public double totalDeduction() {
        return totalDeduction;
    }

    public double netPay() {
        return netPay;
    }

    // Main method for testing
    public static void main(final String[] args) {
        final PayrollCalculator payroll = new PayrollCalculator(1, 160, 0); // Example hourly rate and hours worked
        System.out.println("Gross Pay: PHP " + payroll.calculateGrossPay());
        System.out.println("Total Allowances: PHP " + payroll.calculateTotalAllowances());
        System.out.println("SSS Contribution: PHP " + payroll.calculateSSS());
        System.out.println("Philhealth Contribution: PHP " + payroll.calculatePhilhealth());
        System.out.println("Witholding Tax: PHP " + payroll.calculateWitholdingTax());
        System.out.println("Net Pay: PHP " + payroll.calculateNetPay());
    }
}
