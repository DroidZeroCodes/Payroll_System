package com.mmdc_group10_oop.service;

interface NetPayCalculatorInterface{

    double getGrossPay();
    double getNetPay();
}
interface AllowanceCalculatorInterface{
    double getAllowanceTotal();
}

interface AdjustmentsCalculatorInterface {
    int getAdjustedWorkHours();

    double getAdjustedSalary();
}

interface TaxCalculatorInterface {
    double getSssContribution();
    double getPhilHealthContribution();
    double getPagIbigContribution();
    double getPartialDeductions();
    double getTax();
}