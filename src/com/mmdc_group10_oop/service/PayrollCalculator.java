package com.mmdc_group10_oop.service;

public class PayrollCalculator {
    protected int employeeID;
    protected int hoursWorked;
    protected double basicSalary;

    public PayrollCalculator(int employeeID, double basicSalary) {
        this.employeeID = employeeID;
        this.basicSalary = basicSalary;
    }


}

class AdjustmentsCalculator {
    private double adjustmentAmount;
    public void addBonus(double bonusAmount) {
        this.adjustmentAmount += bonusAmount;
    }

    public void applyPenalty(double penaltyAmount) {
        this.adjustmentAmount -= penaltyAmount;
    }

    public double getAdjustmentAmount() {
        return adjustmentAmount;
    }
}

interface DeductionCalculator  {

    public double calculateTaxDeduction();
}

interface GrossPayCalculator {
    public double calculateGrossPay();
}

interface NetPayCalculator {
    public double calculateNetPay();

}
