package actions;

import data.PayrollRecords;
import interfaces.PayrollAdminActions;
import ui.payroll.PayrollAdminUI;
import ui.payroll.PayrollReportPanel;
import ui.payroll.RunPayrollPanel;
import user.PayrollAdmin;

public class PayrollAdminHandler extends EmployeeHandler implements PayrollAdminActions {
    private final PayrollAdmin payrollAdmin;
    private RunPayrollPanel runPayrollPage;
    private PayrollReportPanel payrollReportPage;
    private boolean isPayrollColumnsRemoved = false;
    private final PayrollAdminUI payrollAdminUI;
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
            resetPanelVisibility();
            displayPayroll();
            runPayrollPage.setVisible(true);
        });

        payrollAdminUI.getPayrollReportBTN().addActionListener(e -> {
            resetPanelVisibility();
            runPayrollPage.setVisible(true);
        });

        payslipPage.searchBTN().addActionListener(e -> {
            payrollAdmin.searchPayslip();
        });

        //Payroll Panel
        runPayrollPage.processBTN().addActionListener(e -> {
            payrollAdmin.runPayroll();
        });

        runPayrollPage.searchBTN().addActionListener(e -> {
            payrollAdmin.searchPayroll();
        });

        runPayrollPage.submitBTN().addActionListener(e -> {
            payrollAdmin.submitPayroll();
        });

    }

    @Override
    protected void resetPanelVisibility() {
        super.resetPanelVisibility();
        runPayrollPage.setVisible(false);
        payrollReportPage.setVisible(false);
    }

    @Override
    public void displayPayroll() {
        // Clear existing rows from the table model
        runPayrollPage.payrollTableModel().setRowCount(0);

        if (!isPayrollColumnsRemoved){
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
        };

        for (PayrollRecords record : payrollAdmin.getTempPayrollRecords()){
            String[] recordArray = (String[]) record.toArray();
            runPayrollPage.payrollTableModel().addRow(recordArray);
        }
    }
}
