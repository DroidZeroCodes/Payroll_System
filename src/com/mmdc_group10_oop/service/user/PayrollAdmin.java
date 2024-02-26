package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.PayrollRecords;
import com.mmdc_group10_oop.service.actions.interfaces.PayrollAdminActions;
import com.mmdc_group10_oop.ui.payrollAdminUI.PayrollAdminUI;
import com.mmdc_group10_oop.ui.payrollAdminUI.PayrollReportPanel;
import com.mmdc_group10_oop.ui.payrollAdminUI.RunPayrollPanel;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class PayrollAdmin extends Employee implements PayrollAdminActions {
    protected List<String[]> payrollRecords;
    protected RunPayrollPanel payrollPage;
    protected PayrollReportPanel reportPage;
    PayrollAdminUI ui;
    public PayrollAdmin(int employeeID, PayrollAdminUI ui) throws IOException, CsvException {
        super(employeeID, null);
        this.ui = ui;
        initDetails();
        initComponents();
    }

    //Overloaded methods
    @Override
    protected void initDetails() throws IOException, CsvException {
        super.initDetails();
        payrollRecords =  new PayrollRecords(employeeID).retrieveAllRecords();
    }
    @Override
    protected void initComponents() {
        profilePage = ui.empProfilePanel();
        attendancePage = ui.empAttendancePanel();
        payslipPage = ui.empPayslipPanel();
        leavePage = ui.empLeavePanel();
        payrollPage = ui.payrollPanel();
        reportPage = ui.reportPanel();
    }

    @Override
    public void generatePayrollReport() {

    }

    @Override
    public void exportPayrollReport() {

    }
}
