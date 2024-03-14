package users.actions;

import records.PayrollRecord;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import users.roles.PayrollAdmin;
import frontend.ui.payroll.PayrollAdminUI;
import frontend.ui.payroll.PayrollReportPanel;
import frontend.ui.payroll.RunPayrollPanel;

import javax.swing.*;
import java.time.YearMonth;
import java.util.List;
import java.util.Objects;

/**
 * Handles the actions and UI interactions for the PayrollAdmin role.
 */
public class PayrollAdminViewHandler extends EmployeeViewHandler {
    private final PayrollAdmin payrollAdmin;
    private final PayrollAdminUI payrollAdminUI;
    private RunPayrollPanel runPayrollPage;
    private PayrollReportPanel payrollReportPage;
    private boolean isPayrollColumnsRemoved = false;

    public PayrollAdminViewHandler(PayrollAdmin payrollAdmin, PayrollAdminUI payrollAdminUI) {
        super(payrollAdmin, null);
        this.payrollAdmin = payrollAdmin;
        this.payrollAdminUI = payrollAdminUI;
        this.dynamicComponents = payrollAdminUI;
        initComponents();
        initActions();
        showMyProfilePage();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        this.runPayrollPage = payrollAdminUI.getPayrollPanel();
        this.payrollReportPage = payrollAdminUI.getReportPanel();
    }

    @Override
    protected void initActions() {
        super.initActions();

        payrollAdminUI.getRunPayrollBTN().addActionListener(e -> {
            showRunPayrollPage();
        });

        payrollAdminUI.getPayrollReportBTN().addActionListener(e -> showPayrollReportPage());

        payslipPage.getSearchBTN().addActionListener(e -> {
            try {
                searchPayslip();
            } catch (EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });

        //Payroll Panel
        runPayrollPage.getProcessBTN().addActionListener(e -> {
            try {
                payrollAdmin.getTempPayrollRecords().clear();
                payrollAdmin.runPayroll(Objects.requireNonNull(runPayrollPage.getPeriodType().getSelectedItem()).toString());
                JOptionPane.showMessageDialog(null, "Payroll Processed Successfully", "Payroll Processed", JOptionPane.INFORMATION_MESSAGE);
            } catch (EmployeeRecordsException | PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }

            showRunPayrollPage();
        });

        runPayrollPage.getSearchBTN().addActionListener(e -> {
            searchPayroll();
        });

        runPayrollPage.getSubmitBTN().addActionListener(e -> {
            try {
                payrollAdmin.submitPayroll();

                JOptionPane.showMessageDialog(null, "Payroll Submitted Successfully", "Payroll Submitted", JOptionPane.INFORMATION_MESSAGE);
            } catch (PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
            showRunPayrollPage();
        });


        //Payroll Report Panel
        payrollReportPage.getGenerateBTN().addActionListener(e -> {
            try {
                String periodType = (String) payrollReportPage.getPeriodType().getSelectedItem();
                List<String[]> generatedReport = payrollAdmin.generatePayrollReport(periodType);

                showGeneratedPayrollReport(generatedReport);


            } catch (PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });


        runPayrollPage.getSearchBTN().addActionListener(e -> {
            try {
                showFilteredPayrollTable();
            } catch (PayrollException | EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });

        payrollReportPage.getSearchBTN().addActionListener(e -> {
            try {
                showFilteredPayrollTable();
            } catch (PayrollException | EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });
    }

    private void searchPayslip() throws EmployeeRecordsException {
        int employeeID = Integer.parseInt(payslipPage.getSearchField().getText());

        if (!payrollAdmin.getEmployeeIDList().contains(employeeID)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        displayPayslip(YearMonth.now(), employeeID);
    }

    private void showGeneratedPayrollReport(List<String[]> generatedReport) throws PayrollException {
        if (generatedReport != null) {
            for (String[] row : generatedReport) {
                payrollReportPage.getPayrollReportTableModel().addRow(row);
            }
        }

        payrollReportPage.setDataTableColumnWidth();
    }

    private void showRunPayrollPage() {
        resetPanelVisibility();
        displayPayroll();
        runPayrollPage.setVisible(true);
    }

    private void showPayrollReportPage() {
        resetPanelVisibility();
        payrollReportPage.setVisible(true);
    }

    private void searchPayroll() {
    }

    private void showFilteredPayrollTable() throws PayrollException, EmployeeRecordsException {
        int employeeID = 0;

        try {
            employeeID = Integer.parseInt(runPayrollPage.getSearchField().getText());
        } catch (NumberFormatException ignore) {
        }

        if (employeeID <= 0) {
            try {
                employeeID = Integer.parseInt(payrollReportPage.getSearchField().getText());

            } catch (NumberFormatException e) {
                PayrollException.throwError_INVALID_SEARCH_FIELD();
                runPayrollPage.getPayrollTableSorter().setRowFilter(null);
                payrollReportPage.getReportTableSorter().setRowFilter(null);
                return;
            }
        }

        if (!payrollAdmin.getEmployeeIDList().contains(employeeID)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            runPayrollPage.getPayrollTableSorter().setRowFilter(null);
            payrollReportPage.getReportTableSorter().setRowFilter(null);
            return;
        }

        try {
            runPayrollPage.getPayrollTableSorter().setRowFilter(RowFilter.regexFilter(String.valueOf(employeeID)));
            payrollReportPage.getReportTableSorter().setRowFilter(RowFilter.regexFilter(String.valueOf(employeeID)));
        } catch (Exception e) {
            PayrollException.throwError_INVALID_SEARCH_FIELD();
            runPayrollPage.getPayrollTableSorter().setRowFilter(null);
            payrollReportPage.getReportTableSorter().setRowFilter(null);
        }
    }

    public void displayPayroll() {
        // Clear existing rows from the table model
        runPayrollPage.getPayrollTableModel().setRowCount(0);

        if (!isPayrollColumnsRemoved) {
            var payrollTable = runPayrollPage.getPayrollTable();
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
        }

        for (PayrollRecord record : payrollAdmin.getTempPayrollRecords()) {
            String[] recordArray = record.toArray();
            runPayrollPage.getPayrollTableModel().addRow(recordArray);
        }
    }

    @Override
    protected void resetPanelVisibility() {
        super.resetPanelVisibility();
        runPayrollPage.setVisible(false);
        payrollReportPage.setVisible(false);
    }
}
