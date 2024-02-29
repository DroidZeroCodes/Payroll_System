package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.AttendanceRecord;
import com.mmdc_group10_oop.dataHandlingModule.EmployeeRecord;
import com.mmdc_group10_oop.dataHandlingModule.PayrollRecords;
import com.mmdc_group10_oop.dataHandlingModule.util.Convert;
import com.mmdc_group10_oop.service.actions.interfaces.PayrollAdminActions;
import com.mmdc_group10_oop.service.logic.PayrollCalculator;
import com.mmdc_group10_oop.ui.payrollAdminUI.PayrollAdminUI;
import com.mmdc_group10_oop.ui.payrollAdminUI.PayrollReportPanel;
import com.mmdc_group10_oop.ui.payrollAdminUI.RunPayrollPanel;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class PayrollAdmin extends Employee implements PayrollAdminActions {
    private List<String[]> payrollRecords;
    private RunPayrollPanel payrollPage;
    private PayrollReportPanel reportPage;
    private List<String[]> tempPayrollRecords;
    private boolean isPayrollColumnsRemoved = false;
    PayrollAdminUI ui;
    public PayrollAdmin(int employeeID, PayrollAdminUI ui) {
        super(employeeID, null);
        this.ui = ui;
        initDetails();
        initComponents();
    }

    //Overloaded methods
    @Override
    protected void initDetails() {
        super.initDetails();
        payrollRecords =  new PayrollRecords().retrieveAllRecords();
        tempPayrollRecords = new ArrayList<>();
    }
    @Override
    protected void initComponents() {
        myProfilePage = ui.empProfilePanel();
        attendancePage = ui.empAttendancePanel();
        payslipPage = ui.empPayslipPanel();
        leavePage = ui.empLeavePanel();
        payrollPage = ui.payrollPanel();
        reportPage = ui.reportPanel();
    }

    public void runPayroll(){
//        LocalDate startDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
//        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        //Sample Date
        LocalDate startDate = LocalDate.of(2022, 3, 1).minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());

        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());


        System.out.println(endDate);
        System.out.println(startDate);

        //logic to calculate payroll for each employee

        //retrieve employee information specifically employee ID's
        Integer[] employeeIDList = new EmployeeRecord().retrieveEmployeeIDList();

        //calculate payroll for each employee

        for (Integer employeeID : employeeIDList){
            //retrieve hours worked and overtime for each employee for the specific period, and their hourly Rate, then calculate payroll for each
            Double hoursWorked = new AttendanceRecord(employeeID).retrieveHoursTotalWorked(startDate, endDate);
            Double overtimeHours = new AttendanceRecord(employeeID).retrieveOvertimeHours(startDate, endDate);
            if (hoursWorked > 0.0) {
                EmployeeRecord employeeRecord = new EmployeeRecord(employeeID);
                PayrollCalculator payrollCalculator = new PayrollCalculator(employeeID, hoursWorked, overtimeHours);
                //Retrieve and display results
                String[] result = new String[]{
                        startDate + " - " + employeeRecord.employeeID(),
                        String.valueOf(employeeRecord.employeeID()),
                        employeeRecord.lastName() + ", " + employeeRecord.firstName(),
                        startDate.toString(),
                        endDate.toString(),
                        employeeRecord.position() + " / " + employeeRecord.department(),
                        Convert.doubleToCurrency(employeeRecord.basicSalary()),
                        Convert.doubleToCurrency(employeeRecord.hourlyRate()),
                        Convert.doubleToString(hoursWorked),
                        Convert.doubleToCurrency(payrollCalculator.overTimePay()),
                        Convert.doubleToCurrency(payrollCalculator.riceSubsidy()),
                        Convert.doubleToCurrency(payrollCalculator.phoneAllowance()),
                        Convert.doubleToCurrency(payrollCalculator.clothingAllowance()),
                        Convert.doubleToCurrency(payrollCalculator.SSSContribution()),
                        Convert.doubleToCurrency(payrollCalculator.philhealthContribution()),
                        Convert.doubleToCurrency(payrollCalculator.pagIbigContribution()),
                        Convert.doubleToCurrency(payrollCalculator.withholdingTax()),
                        Convert.doubleToCurrency(payrollCalculator.totalAllowances()),
                        Convert.doubleToCurrency(payrollCalculator.totalDeduction()),
                        Convert.doubleToCurrency(payrollCalculator.grossPay()),
                        Convert.doubleToCurrency(payrollCalculator.netPay()),
                };
                tempPayrollRecords.add(result);
            }
        }
        displayPayroll();
    }

    public void submitPayroll() {
        PayrollRecords records = new PayrollRecords();
        records.addMultipleRecords(tempPayrollRecords);
    }

    public void displayPayroll() {
        // Clear existing rows from the table model
        payrollPage.payrollTableModel().setRowCount(0);

        if (!isPayrollColumnsRemoved){
            var payrollTable = payrollPage.payrollTable();
            var payslipId = payrollTable.getColumnModel().getColumn(0);
            var nameColumn = payrollTable.getColumnModel().getColumn(2);
            var periodStartColumn = payrollTable.getColumnModel().getColumn(3);
            var periodEndColumn = payrollTable.getColumnModel().getColumn(4);
            var positionColumn = payrollTable.getColumnModel().getColumn(5);
            var monthlyRateColumn = payrollTable.getColumnModel().getColumn(6);
            var riceSubsidyColumn = payrollTable.getColumnModel().getColumn(10);
            var phoneAllowanceColumn = payrollTable.getColumnModel().getColumn(11);
            var clothingAllowanceColumn = payrollTable.getColumnModel().getColumn(12);
            var sssColumn = payrollTable.getColumnModel().getColumn(13);
            var philHealthColumn = payrollTable.getColumnModel().getColumn(14);
            var pagibigColumn = payrollTable.getColumnModel().getColumn(15);
            var withholdingTaxColumn = payrollTable.getColumnModel().getColumn(16);

            payrollTable.removeColumn(payslipId);
            payrollTable.removeColumn(nameColumn);
            payrollTable.removeColumn(periodStartColumn);
            payrollTable.removeColumn(periodEndColumn);
            payrollTable.removeColumn(positionColumn);
            payrollTable.removeColumn(monthlyRateColumn);
            payrollTable.removeColumn(riceSubsidyColumn);
            payrollTable.removeColumn(phoneAllowanceColumn);
            payrollTable.removeColumn(clothingAllowanceColumn);
            payrollTable.removeColumn(sssColumn);
            payrollTable.removeColumn(philHealthColumn);
            payrollTable.removeColumn(pagibigColumn);
            payrollTable.removeColumn(withholdingTaxColumn);

            isPayrollColumnsRemoved = true;
        };

        for (String[] record : tempPayrollRecords){
            payrollPage.payrollTableModel().addRow(record);
        }
    }

    @Override
    public void generatePayrollReport() {

    }

    @Override
    public void exportPayrollReport() {

    }

    public void searchPayslip() {
    }

    public void searchPayroll() {
    }
}
