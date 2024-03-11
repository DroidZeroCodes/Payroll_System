package users;


import data.PayrollRecords;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import interfaces.AttendanceManagement;
import interfaces.EmployeeManagement;
import interfaces.PayrollManagement;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class PayrollAdmin extends Employee {
    private final List<PayrollRecords> tempPayrollRecords = new ArrayList<>();
    private final ReportGenerator reportGenerator;
    private final PayrollManagement payrollManager;
    private final EmployeeManagement employeeManager;
    private final AttendanceManagement attendanceManager;

    public PayrollAdmin(FileDataService dataService, int employeeID) {
        super(dataService, employeeID);

        this.reportGenerator = new ReportGenerator(dataService);
        this.employeeManager = new EmployeeManager(dataService);
        this.attendanceManager = new AttendanceManager(dataService);
        this.payrollManager = new PayrollManager(dataService, employeeManager, attendanceManager);
    }

    //Getters
    public List<PayrollRecords> getTempPayrollRecords() {
        return tempPayrollRecords;
    }

    public List<Integer> getEmployeeIDList() {
        return employeeManager.getEmployeeIDList();
    }

    //Methods
    public void runPayroll(String payrollPeriod) throws EmployeeRecordsException, PayrollException {
        payrollManager.runPayroll(tempPayrollRecords, payrollPeriod);
    }

    public List<String[]> generatePayrollReport(String reportPeriod) throws PayrollException {
        return reportGenerator.generatePayrollReport(reportPeriod);
    }

    public void submitPayroll() throws PayrollException {
        payrollManager.submitPayroll(tempPayrollRecords);
    }
}

