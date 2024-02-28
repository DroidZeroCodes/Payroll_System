package com.mmdc_group10_oop.dataHandlingModule;

import com.mmdc_group10_oop.dataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.dataHandlingModule.util.Record;

import java.util.Arrays;
import java.util.List;

public class PayrollRecords extends Record {

    private String payslipNo;
    private int employeeID;
    private String employeeName;
    private String periodStart, periodEnd;

    private String positionDepartment;
    private String monthlySalary, hourlyRate;
    private Double hoursWorked;
    private String overTimePay;
    private String riceAllowance, phoneAllowance, clothingAllowance;

    private String sssDeduction, philHealthDeduction, pagIbigDeduction;
    private String taxDeduction;
    private String grossIncome, totalBenefits, totalDeductions, netIncome;

    public PayrollRecords() {
    }

    public PayrollRecords(int employeeID) {
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

    public String hourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double hoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
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
        DataHandler dataHandler = new DataHandler(filePath());

        String[] record = dataHandler.retrieveRowData(employeeNo(), String.valueOf(employeeID));

        if (record == null) {
            System.out.println("Recent payslip for employee: " + employeeID + " not found.");
        } else {
            setPayslipNo(record[0]);
            setEmployeeID(Integer.parseInt(record[1]));
            setEmployeeName(record[2]);
            setPeriodStart((record[3]));
            setPeriodEnd((record[4]));
            setPositionDepartment(record[5]);
            setMonthlySalary((record[6]));
            setHourlyRate((record[7]));
            setHoursWorked(Double.parseDouble(record[8]));
            setOverTimePay((record[9]));
            setRiceAllowance((record[10]));
            setPhoneAllowance((record[11]));
            setClothingAllowance((record[12]));
            setSssDeduction((record[13]));
            setPhilHealthDeduction((record[14]));
            setPagIbigDeduction((record[15]));
            setTaxDeduction((record[16]));
            setTotalBenefits((record[17]));
            setTotalDeductions((record[18]));
            setGrossIncome((record[19]));
            setNetIncome((record[20]));

        }

    }

    @Override
    protected void addRecord() {
        DataHandler dataHandler = new DataHandler(filePath());
        String[] newRecord = {
                payslipNo,
                String.valueOf(employeeID),
                employeeName,
                periodStart,
                periodEnd,
                positionDepartment,
                monthlySalary,
                hourlyRate,
                String.valueOf(hoursWorked),
                overTimePay,
                riceAllowance,
                phoneAllowance,
                clothingAllowance,
                sssDeduction,
                philHealthDeduction,
                pagIbigDeduction,
                taxDeduction,
                totalBenefits,
                totalDeductions,
                grossIncome,
                netIncome
        };

        dataHandler.createData(newRecord, false);
    }

    public void addMultipleRecords(List <String[]> recordList) {
        DataHandler dataHandler = new DataHandler(filePath());
        for (String[] record : recordList){
            System.out.println(Arrays.toString(record));
            dataHandler.createData(record, true);
        }
    }

    @Override
    public String toString() {
        return "PayrollRecords{" +
                "payslipID='" + payslipNo +
                ", employeeID=" + employeeID +
                ", periodStart=" + periodStart +
                ", periodEnd=" + periodEnd +
                ", monthlySalary=" + monthlySalary +
                ", dailyRate=" + hourlyRate +
                ", daysWorked=" + hoursWorked +
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

    public static void main(String[] args){
        PayrollRecords payrollRecords = new PayrollRecords(15);
        System.out.println(payrollRecords);
    }
}
