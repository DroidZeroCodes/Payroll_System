package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class PayrollRecords extends Record {

    private String payslipNo;
    private int employeeID;
    private String employeeName;
    private String periodStart, periodEnd;

    private String positionDepartment;
    private String monthlySalary, dailyRate;
    private int daysWorked;
    private String overTimePay;
    private String riceAllowance, phoneAllowance, clothingAllowance;

    private String sssDeduction, philHealthDeduction, pagIbigDeduction;
    private String taxDeduction;
    private String grossIncome, totalBenefits, totalDeductions, netIncome;

    public PayrollRecords(int employeeID) throws CsvValidationException, IOException {
        this.employeeID = employeeID;
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

    public String periodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public String periodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String positionDepartment() {
        return positionDepartment;
    }

    public void setPositionDepartment(String positionDepartment) {
        this.positionDepartment = positionDepartment;
    }

    public String monthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String dailyRate() {
        return dailyRate;
    }

    public void setDailyRate(String dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int daysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public String overTimePay() {
        return overTimePay;
    }

    public void setOverTimePay(String overTimePay) {
        this.overTimePay = overTimePay;
    }

    public String riceAllowance() {
        return riceAllowance;
    }

    public void setRiceAllowance(String riceAllowance) {
        this.riceAllowance = riceAllowance;
    }

    public String phoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(String phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public String clothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(String clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public String sssDeduction() {
        return sssDeduction;
    }

    public void setSssDeduction(String sssDeduction) {
        this.sssDeduction = sssDeduction;
    }

    public String philHealthDeduction() {
        return philHealthDeduction;
    }

    public void setPhilHealthDeduction(String philHealthDeduction) {
        this.philHealthDeduction = philHealthDeduction;
    }

    public String pagIbigDeduction() {
        return pagIbigDeduction;
    }

    public void setPagIbigDeduction(String pagIbigDeduction) {
        this.pagIbigDeduction = pagIbigDeduction;
    }

    public String taxDeduction() {
        return taxDeduction;
    }

    public void setTaxDeduction(String taxDeduction) {
        this.taxDeduction = taxDeduction;
    }

    public String grossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(String grossIncome) {
        this.grossIncome = grossIncome;
    }

    public String totalBenefits() {
        return totalBenefits;
    }

    public void setTotalBenefits(String totalBenefits) {
        this.totalBenefits = totalBenefits;
    }

    public String totalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(String totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public String netIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    protected void retrieveRecord() {
        try {
            DataHandler dataHandler = new DataHandler(filePath());

            List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

            if (csv == null || csv.isEmpty()) {
                System.out.println("Payslip for employee: " + employeeID + " not found.");
            } else {
                String[] row = csv.get(0);

                setPayslipNo(row[0]);
                setEmployeeID(Integer.parseInt(row[1]));
                setEmployeeName(row[2]);
                setPeriodStart((row[3]));
                setPeriodEnd((row[4]));
                setPositionDepartment(row[5]);
                setMonthlySalary((row[6]));
                setDailyRate((row[7]));
                setDaysWorked(Integer.parseInt(row[8]));
                setOverTimePay((row[9]));
                setRiceAllowance((row[10]));
                setPhoneAllowance((row[11]));
                setClothingAllowance((row[12]));
                setSssDeduction((row[13]));
                setPhilHealthDeduction((row[14]));
                setPagIbigDeduction((row[15]));
                setTaxDeduction((row[16]));
                setGrossIncome((row[17]));
                setTotalBenefits((row[18]));
                setTotalDeductions((row[19]));
                setNetIncome((row[20]));

            }
        } catch (IOException | CsvException | NumberFormatException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void addRecord(){

    }

    @Override
    public String toString() {
        return "PayrollRecords{" +
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
        PayrollRecords payrollRecords = new PayrollRecords(15);
        System.out.println(payrollRecords);
    }
}
