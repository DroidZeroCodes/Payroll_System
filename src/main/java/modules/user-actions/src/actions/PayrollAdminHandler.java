package actions;

import data.PayrollRecords;
import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import ui.payroll.PayrollAdminUI;
import ui.payroll.PayrollReportPanel;
import ui.payroll.RunPayrollPanel;
import user.PayrollAdmin;

import javax.swing.*;

public class PayrollAdminHandler extends EmployeeHandler {
    private final PayrollAdmin payrollAdmin;
    private final PayrollAdminUI payrollAdminUI;
    private RunPayrollPanel runPayrollPage;
    private PayrollReportPanel payrollReportPage;
    private boolean isPayrollColumnsRemoved = false;

    public PayrollAdminHandler(PayrollAdmin payrollAdmin, PayrollAdminUI payrollAdminUI) {
        super(payrollAdmin, null);
        this.payrollAdmin = payrollAdmin;
        this.payrollAdminUI = payrollAdminUI;
        this.generalComponents = payrollAdminUI;
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

        payslipPage.searchBTN().addActionListener(e -> searchPayroll());

        //Payroll Panel
        runPayrollPage.processBTN().addActionListener(e -> {
            try {
                payrollAdmin.runPayroll();
                JOptionPane.showMessageDialog(null, "Payroll Processed Successfully", "Payroll Processed", JOptionPane.INFORMATION_MESSAGE);
            } catch (EmployeeRecordsException | PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }

            showRunPayrollPage();
        });

        runPayrollPage.searchBTN().addActionListener(e -> {
            searchPayroll();
        });

        runPayrollPage.submitBTN().addActionListener(e -> {
            try {
                payrollAdmin.submitPayroll();

                JOptionPane.showMessageDialog(null, "Payroll Submitted Successfully", "Payroll Submitted", JOptionPane.INFORMATION_MESSAGE);
            } catch (PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
            showRunPayrollPage();
        });

    }

    @Override
    protected void resetPanelVisibility() {
        super.resetPanelVisibility();
        runPayrollPage.setVisible(false);
        payrollReportPage.setVisible(false);
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

    public void displayPayroll() {
        // Clear existing rows from the table model
        runPayrollPage.payrollTableModel().setRowCount(0);

        if (!isPayrollColumnsRemoved) {
            var payrollTable = runPayrollPage.payrollTable();
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

        for (PayrollRecords record : payrollAdmin.getTempPayrollRecords()) {
            String[] recordArray = record.toArray();
            runPayrollPage.payrollTableModel().addRow(recordArray);
        }
    }
}
