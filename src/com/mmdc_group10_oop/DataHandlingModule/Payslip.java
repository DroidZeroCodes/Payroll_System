package com.mmdc_group10_oop.DataHandlingModule;

import com.mmdc_group10_oop.service.util.DataHandler;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Payslip extends Record {

    private String payslipNo;
    private int employeeID;
    private String employeeName;
    private LocalDate periodStart, periodEnd;

    private String positionDepartment;
    private Double monthlySalary, dailyRate;
    private int daysWorked;
    private Double overTimePay;
    private Double riceAllowance, phoneAllowance, clothingAllowance;

    private Double sssDeduction, philHealthDeduction, pagIbigDeduction;
    private Double taxDeduction;
    private Double grossIncome, totalBenefits, totalDeductions, netIncome;

    public Payslip(String payslipNo) throws CsvValidationException, IOException {
        this.payslipNo = payslipNo;
        retrieveRecord();
    }

    public String payslipNo() {
        return payslipNo;
    }

    public void setPayslipNo(String payslipNo) {
        this.payslipNo = payslipNo;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String employeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate periodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate periodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String positionDepartment() {
        return positionDepartment;
    }

    public void setPositionDepartment(String positionDepartment) {
        this.positionDepartment = positionDepartment;
    }

    public Double monthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Double dailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int daysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public Double overTimePay() {
        return overTimePay;
    }

    public void setOverTimePay(Double overTimePay) {
        this.overTimePay = overTimePay;
    }

    public Double riceAllowance() {
        return riceAllowance;
    }

    public void setRiceAllowance(Double riceAllowance) {
        this.riceAllowance = riceAllowance;
    }

    public Double phoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(Double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public Double clothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(Double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public Double sssDeduction() {
        return sssDeduction;
    }

    public void setSssDeduction(Double sssDeduction) {
        this.sssDeduction = sssDeduction;
    }

    public Double philHealthDeduction() {
        return philHealthDeduction;
    }

    public void setPhilHealthDeduction(Double philHealthDeduction) {
        this.philHealthDeduction = philHealthDeduction;
    }

    public Double pagIbigDeduction() {
        return pagIbigDeduction;
    }

    public void setPagIbigDeduction(Double pagIbigDeduction) {
        this.pagIbigDeduction = pagIbigDeduction;
    }

    public Double taxDeduction() {
        return taxDeduction;
    }

    public void setTaxDeduction(Double taxDeduction) {
        this.taxDeduction = taxDeduction;
    }

    public Double grossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Double totalBenefits() {
        return totalBenefits;
    }

    public void setTotalBenefits(Double totalBenefits) {
        this.totalBenefits = totalBenefits;
    }

    public Double totalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(Double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public Double netIncome() {
        return netIncome;
    }

    public void setNetIncome(Double netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    void retrieveRecord() throws CsvValidationException, IOException {
        if (isValidKey(payslipNo) && doesExist(filePath(), primaryKey(), payslipNo)) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), payslipNo);

                if (csv == null || csv.isEmpty()) {
                    System.out.println("Payslip with reference number: " + payslipNo + " not found.");
                } else {
                    String[] row = csv.get(0);

                    setPayslipNo(row[0]);
                    setEmployeeID(Integer.parseInt(row[1]));
                    setEmployeeName(row[2]);
                    setPeriodStart(parseDate(row[3]));
                    setPeriodEnd(parseDate(row[4]));
                    setPositionDepartment(row[5]);
                    setMonthlySalary(parseFinancialValue(row[6]));
                    setDailyRate(parseFinancialValue(row[7]));
                    setDaysWorked(Integer.parseInt(row[8]));
                    setOverTimePay(parseFinancialValue(row[9]));
                    setRiceAllowance(parseFinancialValue(row[10]));
                    setPhoneAllowance(parseFinancialValue(row[11]));
                    setClothingAllowance(parseFinancialValue(row[12]));
                    setSssDeduction(parseFinancialValue(row[13]));
                    setPhilHealthDeduction(parseFinancialValue(row[14]));
                    setPagIbigDeduction(parseFinancialValue(row[15]));
                    setTaxDeduction(parseFinancialValue(row[16]));
                    setGrossIncome(parseFinancialValue(row[17]));
                    setTotalBenefits(parseFinancialValue(row[18]));
                    setTotalDeductions(parseFinancialValue(row[19]));
                    setNetIncome(parseFinancialValue(row[20]));

                }
            } catch (IOException | CsvException | NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Payslip{" +
                "payslipID='" + payslipNo +
                ", employeeID=" + employeeID +
                ", periodStart=" + periodStart +
                ", periodEnd=" + periodEnd +
                ", monthlySalary=" + monthlySalary +
                ", dailyRate=" + dailyRate +
                ", daysWorked=" + daysWorked +
                ", overTimePay=" + overTimePay +
                ", grossIncome=" + grossIncome +
                ", riceAllowance=" + riceAllowance +
                ", clothingAllowance=" + clothingAllowance +
                ", sssDeduction=" + sssDeduction +
                ", philHealthDeduction=" + philHealthDeduction +
                ", pagIbigDeduction=" + pagIbigDeduction +
                ", taxDeduction=" + taxDeduction +
                ", totalBenefits=" + totalBenefits +
                ", totalDeductions=" + totalDeductions +
                ", netIncome=" + netIncome;
    }

    public static void main(String[] args) throws CsvValidationException, IOException {
        Payslip payslip = new Payslip("15-2023-12-30");
        System.out.println(payslip);
    }
}
