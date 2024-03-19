package user.actions;

import exceptions.EmployeeRecordsException;
import exceptions.PayrollException;
import records.EmployeeRecord;
import records.PayrollRecord;
import ui.payroll.ManualPayrollPanel;
import ui.payroll.PayrollAdminUI;
import ui.payroll.PayrollReportPanel;
import ui.payroll.BatchPayrollPanel;
import user.roles.PayrollAdmin;
import records.util.Convert;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

/**
 * Handles the actions and UI interactions for the PayrollAdmin role.
 */
public class PayrollAdminViewHandler extends EmployeeViewHandler {
    private final PayrollAdmin payrollAdmin;
    private final PayrollAdminUI payrollAdminUI;
    private BatchPayrollPanel batchPayrollPanel;
    private ManualPayrollPanel manualPayrollPage;
    private PayrollReportPanel payrollReportPage;
    private boolean isPayrollColumnsRemoved = false;

    /**
     * Creates a new PayrollAdminViewHandler instance.
     *
     * @param payrollAdmin   the PayrollAdmin instance
     * @param payrollAdminUI the PayrollAdminUI instance
     */
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
        this.batchPayrollPanel = payrollAdminUI.getPayrollPanel();
        this.manualPayrollPage = payrollAdminUI.getManualPayrollPanel();
        this.payrollReportPage = payrollAdminUI.getReportPanel();
    }

    @Override
    protected void initActions() {
        super.initActions();

        payrollAdminUI.getRunPayrollBTN().addActionListener(e -> showRunPayrollPage());

        payrollAdminUI.getPayrollReportBTN().addActionListener(e -> showPayrollReportPage());

        payslipPage.getSearchBTN().addActionListener(e -> {
            try {
                searchPayslip();
            } catch (EmployeeRecordsException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });

        //Payroll Panel
        batchPayrollPanel.getProcessBTN().addActionListener(e -> {
            try {
                payrollAdmin.getTempPayrollRecords_Batch().clear();
                payrollAdmin.runBatchPayroll(Objects.requireNonNull(batchPayrollPanel.getPeriodType().getSelectedItem()).toString());
                JOptionPane.showMessageDialog(null, "Payroll Processed Successfully", "Payroll Processed", JOptionPane.INFORMATION_MESSAGE);
            } catch (EmployeeRecordsException | PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }

            showRunPayrollPage();
        });

        batchPayrollPanel.getSubmitBTN().addActionListener(e -> {
            try {
                payrollAdmin.submitBatchPayroll();

                JOptionPane.showMessageDialog(null, "Payroll Submitted Successfully", "Payroll Submitted", JOptionPane.INFORMATION_MESSAGE);
            } catch (PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });

        batchPayrollPanel.getManualBTN().addActionListener(e -> showManualPayrollPage());

        //Manual Payroll Panel
        manualPayrollPage.getSearchBTN().addActionListener(e -> {
            searchEmployeeForManualPayroll();
        });

        manualPayrollPage.getResetBTN().addActionListener(e -> clearManualPayrollPage());

        manualPayrollPage.getProcessBTN().addActionListener(e -> {
            try {
                displayCalculatedPayroll(payrollAdmin.runManualPayroll(getTempPayroll(),Objects.requireNonNull(batchPayrollPanel.getPeriodType().getSelectedItem()).toString()));
                JOptionPane.showMessageDialog(null, "Payroll Processed Successfully", "Payroll Processed", JOptionPane.INFORMATION_MESSAGE);
            } catch (EmployeeRecordsException | PayrollException ex) {
                System.err.println("Error: " + ex.getMessage());
            }

            showManualPayrollPage();
        });

        manualPayrollPage.getSubmitBTN().addActionListener(e -> {
            payrollAdmin.submitManualPayroll();
            JOptionPane.showMessageDialog(null, "Payroll Submitted Successfully", "Payroll Submitted", JOptionPane.INFORMATION_MESSAGE);
        });

        manualPayrollPage.getBatchBTN().addActionListener(e -> showRunPayrollPage());

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


        batchPayrollPanel.getSearchBTN().addActionListener(e -> {
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

    private void searchEmployeeForManualPayroll(){
        int empID = Integer.parseInt(manualPayrollPage.getSearchField().getText());
        String periodType = (String) manualPayrollPage.getPeriodType().getSelectedItem();
        double hoursWorked = payrollAdmin.getHoursWorked(empID, periodType);

        if (hoursWorked <= 0){
            int option = JOptionPane.showConfirmDialog(null, "Employee has no hours worked. Do you want to continue?", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION){
                return;
            }
        }

        double overTimeHours = payrollAdmin.getOvertimeHours(empID,periodType);
        EmployeeRecord employeeRecord = payrollAdmin.getEmployeeRecord(empID);

        manualPayrollPage.getEmpIDTxtField().setText("" + empID);
        manualPayrollPage.getPositionTxtField().setText(employeeRecord.position());
        manualPayrollPage.getHoursWorkedTxtField().setText("" + hoursWorked);
        manualPayrollPage.getHourlyRateTxtField().setText("" + employeeRecord.hourlyRate());
        manualPayrollPage.getOvertimeHoursTxtField().setText("" + overTimeHours);
        manualPayrollPage.getOvertimeRateTxtField().setText(1.5 * employeeRecord.hourlyRate() + "");
        manualPayrollPage.getRiceSubsidyTxtField().setText("" + employeeRecord.riceSubsidy());
        manualPayrollPage.getPhoneAllowanceTxtField().setText("" + employeeRecord.phoneAllowance());
        manualPayrollPage.getClothingAllowanceTxtField().setText("" + employeeRecord.clothingAllowance());
    }

    private void displayCalculatedPayroll(PayrollRecord calculatedPayroll) {
        manualPayrollPage.getSssTextField().setText("" + calculatedPayroll.sssDeduction());
        manualPayrollPage.getPagIbigTxtField().setText("" + calculatedPayroll.pagIbigDeduction());
        manualPayrollPage.getPhilHealthTxtField().setText("" + calculatedPayroll.philHealthDeduction());
        manualPayrollPage.getSalaryTxtField().setText("" + calculatedPayroll.salary());
        manualPayrollPage.getTotalAllowancesTxtField().setText("" + calculatedPayroll.totalBenefits());
        manualPayrollPage.getWithholdingTaxTxtField().setText("" + calculatedPayroll.taxDeduction());
        manualPayrollPage.getTotalDeductionsTxtField().setText("" + calculatedPayroll.totalDeductions());
        manualPayrollPage.getGrossPayTxtField().setText("" + calculatedPayroll.grossIncome());
        manualPayrollPage.getNetPayTxtField().setText("" + calculatedPayroll.netIncome());
    }

    private PayrollRecord getTempPayroll() throws PayrollException {
        try {
            return new PayrollRecord(
                    null,
                    Integer.parseInt(manualPayrollPage.getEmpIDTxtField().getText()),
                    null,
                    null,
                    null,
                    null,
                    0.0,
                    Convert.StringToDouble(manualPayrollPage.getHourlyRateTxtField().getText()),
                    Convert.StringToDouble(manualPayrollPage.getHoursWorkedTxtField().getText()),
                    0.0,
                    Convert.StringToDouble(manualPayrollPage.getRiceSubsidyTxtField().getText()),
                    Convert.StringToDouble( manualPayrollPage.getPhoneAllowanceTxtField().getText()),
                    Convert.StringToDouble(manualPayrollPage.getClothingAllowanceTxtField().getText()),
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0
            );
        } catch (NumberFormatException e) {
            PayrollException.throwError_INVALID_MANUAL_PAYROLL_DATA();
            return null;
        }
    }

    private void showManualPayrollPage() {
        resetPanelVisibility();
        manualPayrollPage.setVisible(true);
    }

    private void clearManualPayrollPage() {
        manualPayrollPage.getEmpIDTxtField().setText("");
        manualPayrollPage.getPositionTxtField().setText("");
        manualPayrollPage.getSssTextField().setText("");
        manualPayrollPage.getPagIbigTxtField().setText("");
        manualPayrollPage.getPhilHealthTxtField().setText("");
        manualPayrollPage.getHoursWorkedTxtField().setText("");
        manualPayrollPage.getHourlyRateTxtField().setText("");
        manualPayrollPage.getOvertimeHoursTxtField().setText("");
        manualPayrollPage.getOvertimeRateTxtField().setText("");
        manualPayrollPage.getRiceSubsidyTxtField().setText("");
        manualPayrollPage.getPhoneAllowanceTxtField().setText("");
        manualPayrollPage.getClothingAllowanceTxtField().setText("");
        manualPayrollPage.getSalaryTxtField().setText("");
        manualPayrollPage.getTotalAllowancesTxtField().setText("");
        manualPayrollPage.getWithholdingTaxTxtField().setText("");
        manualPayrollPage.getTotalDeductionsTxtField().setText("");
        manualPayrollPage.getGrossPayTxtField().setText("");
        manualPayrollPage.getNetPayTxtField().setText("");
    }

    private void searchPayslip() throws EmployeeRecordsException {
        int employeeID = Integer.parseInt(payslipPage.getSearchField().getText());

        if (!payrollAdmin.getEmployeeIDList().contains(employeeID)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        String period = (String) payslipPage.getPeriodType().getSelectedItem();
        int month = payslipPage.getPayMonthChooser().getSelectedIndex();
        displayPayslip(period, month, employeeID);
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
        batchPayrollPanel.setVisible(true);
    }

    private void showPayrollReportPage() {
        resetPanelVisibility();
        payrollReportPage.setVisible(true);
    }

    private void showFilteredPayrollTable() throws PayrollException, EmployeeRecordsException {
        int employeeID = 0;

        try {
            employeeID = Integer.parseInt(batchPayrollPanel.getSearchField().getText());
        } catch (NumberFormatException ignore) {
        }

        if (employeeID <= 0) {
            try {
                employeeID = Integer.parseInt(payrollReportPage.getSearchField().getText());

            } catch (NumberFormatException e) {
                PayrollException.throwError_INVALID_SEARCH_FIELD();
                batchPayrollPanel.getPayrollTableSorter().setRowFilter(null);
                payrollReportPage.getReportTableSorter().setRowFilter(null);
                return;
            }
        }

        if (!payrollAdmin.getEmployeeIDList().contains(employeeID)) {
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            batchPayrollPanel.getPayrollTableSorter().setRowFilter(null);
            payrollReportPage.getReportTableSorter().setRowFilter(null);
            return;
        }

        try {
            batchPayrollPanel.getPayrollTableSorter().setRowFilter(RowFilter.regexFilter(String.valueOf(employeeID)));
            payrollReportPage.getReportTableSorter().setRowFilter(RowFilter.regexFilter(String.valueOf(employeeID)));
        } catch (Exception e) {
            PayrollException.throwError_INVALID_SEARCH_FIELD();
            batchPayrollPanel.getPayrollTableSorter().setRowFilter(null);
            payrollReportPage.getReportTableSorter().setRowFilter(null);
        }
    }

    private void displayPayroll() {
        // Clear existing rows from the table model
        batchPayrollPanel.getPayrollTableModel().setRowCount(0);

        if (!isPayrollColumnsRemoved) {
            var payrollTable = batchPayrollPanel.getPayrollTable();
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

        for (PayrollRecord record : payrollAdmin.getTempPayrollRecords_Batch()) {
            String[] recordArray = record.toArray();
            batchPayrollPanel.getPayrollTableModel().addRow(recordArray);
        }
    }

    @Override
    protected void resetPanelVisibility() {
        super.resetPanelVisibility();
        batchPayrollPanel.setVisible(false);
        payrollReportPage.setVisible(false);
        manualPayrollPage.setVisible(false);
    }
}
