package com.mmdc_group10_oop.DataHandlingModule;

import com.mmdc_group10_oop.DataHandlingModule.util.DataHandler;
import com.mmdc_group10_oop.DataHandlingModule.util.Record;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public class PayrollInformation extends Record {
    int employeeID;
    String sssNo, philHealthNo, pagIbigNo, tinNo;
    private Double riceSubsidy, phoneAllowance, clothingAllowance;
    private Double basicSalary, semiMonthlyRate, hourlyRate;
    public PayrollInformation(int employeeID) throws CsvValidationException, IOException {
        this.employeeID = employeeID;
        retrieveRecord();
    }
    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String sssNo() {
        return sssNo;
    }

    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    public String philHealthNo() {
        return philHealthNo;
    }

    public void setPhilHealthNo(String philHealthNo) {
        this.philHealthNo = philHealthNo;
    }

    public String pagIbigNo() {
        return pagIbigNo;
    }

    public void setPagIbigNo(String pagIbigNo) {
        this.pagIbigNo = pagIbigNo;
    }

    public String tinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public Double riceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(Double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
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

    public Double basicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double semiMonthlyRate() {
        return semiMonthlyRate;
    }

    public void setSemiMonthlyRate(Double semiMonthlyRate) {
        this.semiMonthlyRate = semiMonthlyRate;
    }

    public Double hourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected void retrieveRecord() throws CsvValidationException, IOException {
        if (isValidKey(employeeID) && doesExist(primaryKey(),String.valueOf(employeeID))) {
            try {
                DataHandler dataHandler = new DataHandler(filePath());

                List<String[]> csv = dataHandler.retrieveRowData(primaryKey(), String.valueOf(employeeID));

                if (csv == null || csv.isEmpty()) {
                    System.out.println("No data found for employee ID: " + employeeID);
                } else if (csv.size() > 1) {
                    System.out.println("Multiple records found for employee ID: " + employeeID);
                } else {
                    String[] row = csv.get(0);

                    setEmployeeID(Integer.parseInt(row[0]));
                    setSssNo(row[6]);
                    setPhilHealthNo(row[7]);
                    setPagIbigNo(row[8]);
                    setTinNo(row[9]);
                    setPagIbigNo(row[10]);
                    setBasicSalary(parseFinancialValue(row[13]));
                    setRiceSubsidy(parseFinancialValue(row[14]));
                    setPhoneAllowance(parseFinancialValue(row[15]));
                    setClothingAllowance(parseFinancialValue(row[16]));
                    setSemiMonthlyRate(parseFinancialValue(row[17]));
                    setHourlyRate(parseFinancialValue(row[18]));

                }
            } catch (IOException | CsvException | NumberFormatException e ) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "PayrollInformation{" +
                "employeeID=" + employeeID +
                ", sssNo='" + sssNo + '\'' +
                ", philHealthNo='" + philHealthNo + '\'' +
                ", pagIbigNo='" + pagIbigNo + '\'' +
                ", tinNo='" + tinNo + '\'' +
                ", riceSubsidy=" + riceSubsidy +
                ", phoneAllowance=" + phoneAllowance +
                ", clothingAllowance=" + clothingAllowance +
                ", basicSalary=" + basicSalary +
                ", semiMonthlyRate=" + semiMonthlyRate +
                ", hourlyRate=" + hourlyRate +
                '}';
    }

    public static void main(String[] args) throws CsvValidationException, IOException {
        PayrollInformation payroll = new PayrollInformation(1);
        System.out.println(payroll);
    }
}
