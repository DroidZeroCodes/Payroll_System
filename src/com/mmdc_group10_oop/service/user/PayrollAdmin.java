package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.ui.payrollAdminUI.PayrollAdminUI;
import com.mmdc_group10_oop.ui.payrollAdminUI.PayrollReportPanel;
import com.mmdc_group10_oop.ui.payrollAdminUI.RunPayrollPanel;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class PayrollAdmin extends Employee{
    protected RunPayrollPanel payrollPage;
    protected PayrollReportPanel reportPage;
    public PayrollAdmin(int employeeID, PayrollAdminUI ui) throws IOException, CsvException {
        super(employeeID, null);

        profilePage = ui.empProfilePanel;
        attendancePage = ui.empAttendancePanel;
        payslipPage = ui.empPayslipPanel;
        leavePage = ui.empLeavePanel;
        payrollPage = ui.payrollPanel;
        reportPage = ui.reportPanel;
    }


}
