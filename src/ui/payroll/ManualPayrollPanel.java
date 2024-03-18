package ui.payroll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a panel for manual payroll. Users can manually input records for payroll data, and search for specific entries.
 * The panel includes a table to display payroll information such as employee ID, rates, hours worked, allowances, deductions, gross, and net pay.
 * <p>
 * Available methods:
 * - {@link #getPayrollTableModel()} Returns the table model for the payroll data.
 * - {@link #getProcessBTN()} Returns the button for processing payroll.
 * - {@link #getSearchBTN()} Returns the button for searching within the payroll data.
 * - {@link #getSearchField()} Returns the text field for entering search queries.
 * - {@link #getSubmitBTN()} Returns the button for submitting payroll data.
 * - {@link #getPeriodType()} Returns the combo box for selecting the period type.
 * - {@link #getPayrollTableSorter()} Returns the sorter for the payroll table.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "MagicConstant", "FieldMayBeFinal"})

public class ManualPayrollPanel extends javax.swing.JPanel {
    private DefaultTableModel payrollTableModel;
    private TableRowSorter<DefaultTableModel> payrollTableSorter;

    /**
     * Creates new form runPayrollPanel
     */
    public ManualPayrollPanel() {
        initComponents();
        initTimeAndDate();
    }

    /**
     * Initializes the current date and day of the week.
     */
    private void initTimeAndDate() {
        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/dd/yyyy");
        String currentDate = sdf2.format(new Date());
        String dayOfWeek = new SimpleDateFormat("EEEE").format(new Date());
        dateLabel.setText(dayOfWeek.toUpperCase() + ", " + currentDate);
    }

    //Getter method to modify the components

    /**
     * Retrieves the combo box for selecting the period type.
     *
     * @return The period type combo box component.
     */
    public JComboBox<String> getPeriodType() {
        return periodType;
    }

    /**
     * Retrieves the button for submitting payroll data.
     *
     * @return The submit button component.
     */
    public JButton getSubmitBTN() {
        return saveBTN;
    }

    /**
     * Retrieves the button for processing payroll.
     *
     * @return The process button component.
     */
    public JButton getProcessBTN() {
        return calculateBTN;
    }

    /**
     * Retrieves the button for searching payroll data.
     *
     * @return The search button component.
     */
    public JButton getSearchBTN() {
        return searchBTN;
    }

    /**
     * Retrieves the text field for entering search queries.
     *
     * @return The search field component.
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * Retrieves the table model for payroll data.
     *
     * @return The payroll table model.
     */
    public DefaultTableModel getPayrollTableModel() {
        return payrollTableModel;
    }

    /**
     * Retrieves the sorter for the payroll table.
     *
     * @return The payroll table sorter.
     */
    public TableRowSorter<DefaultTableModel> getPayrollTableSorter() {
        return payrollTableSorter;
    }

    /**
     * Retrieves the button for returning to the batch payroll panel.
     * @return The batch button
     */
    public JButton getBatchBTN() {
        return batchBTN;
    }

    //Getters for the text fields

    /**
     * Retrieves the text field for entering clothing allowance.
     * @return The clothing allowance text field
     */
    public JTextField getClothingAllowanceTxtField() {
        return clothingAllowanceTxtField;
    }

    /**
     * Retrieves the text field for entering employee ID.
     * @return The employee ID text field
     */
    public JTextField getEmpIDTxtField() {
        return empIDTxtField;
    }

    /**
     * Retrieves the text field for entering overtime rate.
     * @return The overtime rate text field
     */
    public JTextField getOvertimeRateTxtField() {
        return overtimeRateTxtField;
    }

    /**
     * Retrieves the text field for entering gross pay.
     * @return The gross pay text field
     */
    public JTextField getGrossPayTxtField() {
        return grossPayTxtField;
    }


    /**
     * Retrieves the text field for entering hourly rate.
     * @return The hourly rate text field
     */
    public JTextField getHourlyRateTxtField() {
        return hourlyRateTxtField;
    }

    /**
     * Retrieves the text field for entering hours worked.
     * @return The hours worked text field
     */
    public JTextField getHoursWorkedTxtField() {
        return hoursWorkedTxtField;
    }

    /**
     * Retrieves the text field for displaying net pay.
     * @return The net pay text field
     */
    public JTextField getNetPayTxtField() {
        return netPayTxtField;
    }

    /**
     * Retrieves the text field for entering overtime hours.
     * @return The overtime hours text field
     */
    public JTextField getOvertimeHoursTxtField() {
        return overtimeHoursTxtField;
    }

    /**
     * Retrieves the text field for entering Pag-IBIG contribution.
     * @return The Pag-IBIG contribution text field
     */
    public JTextField getPagIbigTxtField() {
        return pagIbigTxtField;
    }

    /**
     * Retrieves the text field for entering PhilHealth contribution.
     * @return The PhilHealth contribution text field
     */
    public JTextField getPhilHealthTxtField() {
        return philHealthTxtField;
    }

    /**
     * Retrieves the text field for entering phone allowance.
     * @return The phone allowance text field
     */
    public JTextField getPhoneAllowanceTxtField() {
        return phoneAllowanceTxtField;
    }

    /**
     * Retrieves the text field for entering position.
     * @return The position text field
     */
    public JTextField getPositionTxtField() {
        return positionTxtField;
    }

    /**
     * Retrieves the text field for entering rice subsidy.
     * @return The rice subsidy text field
     */
    public JTextField getRiceSubsidyTxtField() {
        return riceSubsidyTxtField;
    }

    /**
     * Retrieves the text field for entering salary.
     * @return The salary text field
     */
    public JTextField getSalaryTxtField() {
        return salaryTxtField;
    }

    /**
     * Retrieves the text field for entering SSS contribution.
     * @return The SSS contribution text field
     */
    public JTextField getSssTextField() {
        return sssTextField;
    }

    /**
     * Retrieves the text field for displaying total allowances.
     * @return The total allowances text field
     */
    public JTextField getTotalAllowancesTxtField() {
        return totalAllowancesTxtField;
    }

    /**
     * Retrieves the text field for displaying total deductions.
     * @return The total deductions text field
     */
    public JTextField getTotalDeductionsTxtField() {
        return totalDeductionsTxtField;
    }

    /**
     * Retrieves the text field for entering withholding tax.
     * @return The withholding tax text field
     */
    public JTextField getWithholdingTaxTxtField() {
        return withholdingTaxTxtField;
    }

    /**
     * Retrieves the reset button
     * @return The reset button
     */
    public JButton getResetBTN() {
        return resetBTN;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        payPanel = new javax.swing.JPanel();
        basicSalaryLabel = new javax.swing.JLabel();
        hoursWorkedTxtField = new javax.swing.JTextField();
        hourlyRateLabel = new javax.swing.JLabel();
        hourlyRateTxtField = new javax.swing.JTextField();
        semiMonthlyLabel = new javax.swing.JLabel();
        overtimeHoursTxtField = new javax.swing.JTextField();
        payLabel = new javax.swing.JLabel();
        semiMonthlyLabel2 = new javax.swing.JLabel();
        overtimeRateTxtField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        riceSubsidyLabel = new javax.swing.JLabel();
        riceSubsidyTxtField = new javax.swing.JTextField();
        phoneAllowanceLabel = new javax.swing.JLabel();
        clothingAllowanceLabel = new javax.swing.JLabel();
        clothingAllowanceTxtField = new javax.swing.JTextField();
        phoneAllowanceTxtField = new javax.swing.JTextField();
        allowancesLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        sssNoLabel = new javax.swing.JLabel();
        sssTextField = new javax.swing.JTextField();
        philhealthNoLabel = new javax.swing.JLabel();
        philHealthTxtField = new javax.swing.JTextField();
        pagibigNoLabel = new javax.swing.JLabel();
        pagIbigTxtField = new javax.swing.JTextField();
        contributionIDsLabel = new javax.swing.JLabel();
        employmentPanel = new javax.swing.JPanel();
        empIDLabel = new javax.swing.JLabel();
        empIDTxtField = new javax.swing.JTextField();
        positionLabel = new javax.swing.JLabel();
        positionTxtField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        payLabel1 = new javax.swing.JLabel();
        periodType = new javax.swing.JComboBox<>();
        payPanel1 = new javax.swing.JPanel();
        basicSalaryLabel1 = new javax.swing.JLabel();
        totalDeductionsTxtField = new javax.swing.JTextField();
        hourlyRateLabel1 = new javax.swing.JLabel();
        totalAllowancesTxtField = new javax.swing.JTextField();
        semiMonthlyLabel1 = new javax.swing.JLabel();
        grossPayTxtField = new javax.swing.JTextField();
        payLabel2 = new javax.swing.JLabel();
        semiMonthlyLabel3 = new javax.swing.JLabel();
        netPayTxtField = new javax.swing.JTextField();
        resetBTN = new javax.swing.JButton();
        saveBTN = new javax.swing.JButton();
        basicSalaryLabel2 = new javax.swing.JLabel();
        withholdingTaxTxtField = new javax.swing.JTextField();
        basicSalaryLabel3 = new javax.swing.JLabel();
        salaryTxtField = new javax.swing.JTextField();
        calculateBTN = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        myPayslipLabel = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        batchBTN = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 245, 247));
        setMinimumSize(new java.awt.Dimension(1135, 700));
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        payPanel.setBackground(new java.awt.Color(249, 249, 249));
        payPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        payPanel.setToolTipText("");
        payPanel.setMinimumSize(new java.awt.Dimension(533, 200));
        payPanel.setPreferredSize(new java.awt.Dimension(533, 200));
        payPanel.setLayout(new java.awt.GridBagLayout());

        basicSalaryLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        basicSalaryLabel.setText("HOURS WORKED");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel.add(basicSalaryLabel, gridBagConstraints);

        hoursWorkedTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        hoursWorkedTxtField.setBorder(null);
        hoursWorkedTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        hoursWorkedTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 10, 30);
        payPanel.add(hoursWorkedTxtField, gridBagConstraints);

        hourlyRateLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        hourlyRateLabel.setText("HOURLY RATE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel.add(hourlyRateLabel, gridBagConstraints);

        hourlyRateTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        hourlyRateTxtField.setBorder(null);
        hourlyRateTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        hourlyRateTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 10, 30);
        payPanel.add(hourlyRateTxtField, gridBagConstraints);

        semiMonthlyLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        semiMonthlyLabel.setText("OVERTIME HOURS");
        semiMonthlyLabel.setMinimumSize(new java.awt.Dimension(150, 15));
        semiMonthlyLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel.add(semiMonthlyLabel, gridBagConstraints);

        overtimeHoursTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        overtimeHoursTxtField.setBorder(null);
        overtimeHoursTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        overtimeHoursTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 10, 30);
        payPanel.add(overtimeHoursTxtField, gridBagConstraints);

        payLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        payLabel.setText("Attendance");
        payLabel.setMinimumSize(new java.awt.Dimension(250, 25));
        payLabel.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 0, 0);
        payPanel.add(payLabel, gridBagConstraints);

        semiMonthlyLabel2.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        semiMonthlyLabel2.setText("OVERTIME RATE");
        semiMonthlyLabel2.setMinimumSize(new java.awt.Dimension(150, 15));
        semiMonthlyLabel2.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 10, 0);
        payPanel.add(semiMonthlyLabel2, gridBagConstraints);

        overtimeRateTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        overtimeRateTxtField.setBorder(null);
        overtimeRateTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        overtimeRateTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 10, 30);
        payPanel.add(overtimeRateTxtField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 18, 5);
        jPanel2.add(payPanel, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(249, 249, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMinimumSize(new java.awt.Dimension(533, 180));
        jPanel3.setPreferredSize(new java.awt.Dimension(533, 180));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        riceSubsidyLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        riceSubsidyLabel.setText("RICE SUBSIDY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel3.add(riceSubsidyLabel, gridBagConstraints);

        riceSubsidyTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        riceSubsidyTxtField.setBorder(null);
        riceSubsidyTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        riceSubsidyTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 17, 5, 30);
        jPanel3.add(riceSubsidyTxtField, gridBagConstraints);

        phoneAllowanceLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        phoneAllowanceLabel.setText("PHONE ALLOWANCE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel3.add(phoneAllowanceLabel, gridBagConstraints);

        clothingAllowanceLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        clothingAllowanceLabel.setText("CLOTHING ALLOWANCE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel3.add(clothingAllowanceLabel, gridBagConstraints);

        clothingAllowanceTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        clothingAllowanceTxtField.setBorder(null);
        clothingAllowanceTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        clothingAllowanceTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 17, 5, 30);
        jPanel3.add(clothingAllowanceTxtField, gridBagConstraints);

        phoneAllowanceTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        phoneAllowanceTxtField.setBorder(null);
        phoneAllowanceTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        phoneAllowanceTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 17, 5, 30);
        jPanel3.add(phoneAllowanceTxtField, gridBagConstraints);

        allowancesLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        allowancesLabel.setText("Allowances");
        allowancesLabel.setMinimumSize(new java.awt.Dimension(250, 25));
        allowancesLabel.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 0, 0);
        jPanel3.add(allowancesLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 18, 5);
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(249, 249, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setMinimumSize(new java.awt.Dimension(533, 180));
        jPanel4.setPreferredSize(new java.awt.Dimension(533, 180));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        sssNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        sssNoLabel.setText("SSS");
        sssNoLabel.setMaximumSize(new java.awt.Dimension(150, 15));
        sssNoLabel.setMinimumSize(new java.awt.Dimension(150, 15));
        sssNoLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel4.add(sssNoLabel, gridBagConstraints);

        sssTextField.setEditable(false);
        sssTextField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        sssTextField.setBorder(null);
        sssTextField.setMinimumSize(new java.awt.Dimension(200, 20));
        sssTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        jPanel4.add(sssTextField, gridBagConstraints);

        philhealthNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        philhealthNoLabel.setText("PHILHEALTH");
        philhealthNoLabel.setMaximumSize(new java.awt.Dimension(150, 15));
        philhealthNoLabel.setMinimumSize(new java.awt.Dimension(150, 15));
        philhealthNoLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel4.add(philhealthNoLabel, gridBagConstraints);

        philHealthTxtField.setEditable(false);
        philHealthTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        philHealthTxtField.setBorder(null);
        philHealthTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        philHealthTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        jPanel4.add(philHealthTxtField, gridBagConstraints);

        pagibigNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        pagibigNoLabel.setText("PAGIBIG");
        pagibigNoLabel.setMaximumSize(new java.awt.Dimension(150, 15));
        pagibigNoLabel.setMinimumSize(new java.awt.Dimension(150, 15));
        pagibigNoLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel4.add(pagibigNoLabel, gridBagConstraints);

        pagIbigTxtField.setEditable(false);
        pagIbigTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        pagIbigTxtField.setBorder(null);
        pagIbigTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        pagIbigTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        jPanel4.add(pagIbigTxtField, gridBagConstraints);

        contributionIDsLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        contributionIDsLabel.setText("Deductions");
        contributionIDsLabel.setMinimumSize(new java.awt.Dimension(150, 25));
        contributionIDsLabel.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 0, 0);
        jPanel4.add(contributionIDsLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 18, 10);
        jPanel2.add(jPanel4, gridBagConstraints);

        employmentPanel.setBackground(new java.awt.Color(249, 249, 249));
        employmentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employmentPanel.setMinimumSize(new java.awt.Dimension(533, 180));
        employmentPanel.setPreferredSize(new java.awt.Dimension(533, 180));
        employmentPanel.setLayout(new java.awt.GridBagLayout());

        empIDLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        empIDLabel.setText("EMPLOYEE ID");
        empIDLabel.setMinimumSize(new java.awt.Dimension(150, 15));
        empIDLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        empIDLabel.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(empIDLabel, gridBagConstraints);

        empIDTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        empIDTxtField.setBorder(null);
        empIDTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        empIDTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 30);
        employmentPanel.add(empIDTxtField, gridBagConstraints);

        positionLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        positionLabel.setText("POSITION");
        positionLabel.setMinimumSize(new java.awt.Dimension(150, 15));
        positionLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(positionLabel, gridBagConstraints);

        positionTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        positionTxtField.setBorder(null);
        positionTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        positionTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 30);
        employmentPanel.add(positionTxtField, gridBagConstraints);

        statusLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        statusLabel.setText("PERIOD");
        statusLabel.setMinimumSize(new java.awt.Dimension(150, 15));
        statusLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(statusLabel, gridBagConstraints);

        payLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        payLabel1.setText("Employment");
        payLabel1.setMinimumSize(new java.awt.Dimension(250, 25));
        payLabel1.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 0, 0);
        employmentPanel.add(payLabel1, gridBagConstraints);

        periodType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        periodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weekly", "Semi-Monthly", "Monthly" }));
        periodType.setMinimumSize(new java.awt.Dimension(200, 20));
        periodType.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 30);
        employmentPanel.add(periodType, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 18, 5);
        jPanel2.add(employmentPanel, gridBagConstraints);

        payPanel1.setBackground(new java.awt.Color(249, 249, 249));
        payPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        payPanel1.setToolTipText("");
        payPanel1.setMinimumSize(new java.awt.Dimension(533, 200));
        payPanel1.setPreferredSize(new java.awt.Dimension(533, 200));
        payPanel1.setLayout(new java.awt.GridBagLayout());

        basicSalaryLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        basicSalaryLabel1.setText("TOTAL DEDUCTIONS");
        basicSalaryLabel1.setMaximumSize(new java.awt.Dimension(150, 15));
        basicSalaryLabel1.setMinimumSize(new java.awt.Dimension(150, 15));
        basicSalaryLabel1.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel1.add(basicSalaryLabel1, gridBagConstraints);

        totalDeductionsTxtField.setEditable(false);
        totalDeductionsTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        totalDeductionsTxtField.setBorder(null);
        totalDeductionsTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        totalDeductionsTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        payPanel1.add(totalDeductionsTxtField, gridBagConstraints);

        hourlyRateLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        hourlyRateLabel1.setText("TOTAL ALLOWANCES");
        hourlyRateLabel1.setMaximumSize(new java.awt.Dimension(150, 15));
        hourlyRateLabel1.setMinimumSize(new java.awt.Dimension(150, 15));
        hourlyRateLabel1.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel1.add(hourlyRateLabel1, gridBagConstraints);

        totalAllowancesTxtField.setEditable(false);
        totalAllowancesTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        totalAllowancesTxtField.setBorder(null);
        totalAllowancesTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        totalAllowancesTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        payPanel1.add(totalAllowancesTxtField, gridBagConstraints);

        semiMonthlyLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        semiMonthlyLabel1.setText("GROSS ");
        semiMonthlyLabel1.setMaximumSize(new java.awt.Dimension(150, 15));
        semiMonthlyLabel1.setMinimumSize(new java.awt.Dimension(150, 15));
        semiMonthlyLabel1.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel1.add(semiMonthlyLabel1, gridBagConstraints);

        grossPayTxtField.setEditable(false);
        grossPayTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        grossPayTxtField.setBorder(null);
        grossPayTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        grossPayTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        payPanel1.add(grossPayTxtField, gridBagConstraints);

        payLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        payLabel2.setText("Calculation");
        payLabel2.setMinimumSize(new java.awt.Dimension(150, 25));
        payLabel2.setPreferredSize(new java.awt.Dimension(150, 25));
        payLabel2.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 0, 0);
        payPanel1.add(payLabel2, gridBagConstraints);

        semiMonthlyLabel3.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        semiMonthlyLabel3.setText("NET PAY");
        semiMonthlyLabel3.setMaximumSize(new java.awt.Dimension(150, 15));
        semiMonthlyLabel3.setMinimumSize(new java.awt.Dimension(150, 15));
        semiMonthlyLabel3.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel1.add(semiMonthlyLabel3, gridBagConstraints);

        netPayTxtField.setEditable(false);
        netPayTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        netPayTxtField.setBorder(null);
        netPayTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        netPayTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        payPanel1.add(netPayTxtField, gridBagConstraints);

        resetBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        resetBTN.setText("Reset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel1.add(resetBTN, gridBagConstraints);

        saveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        saveBTN.setText("Save");
        saveBTN.setPreferredSize(new java.awt.Dimension(100, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 30);
        payPanel1.add(saveBTN, gridBagConstraints);

        basicSalaryLabel2.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        basicSalaryLabel2.setText("WITHHOLDING TAX");
        basicSalaryLabel2.setMaximumSize(new java.awt.Dimension(150, 15));
        basicSalaryLabel2.setMinimumSize(new java.awt.Dimension(150, 15));
        basicSalaryLabel2.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel1.add(basicSalaryLabel2, gridBagConstraints);

        withholdingTaxTxtField.setEditable(false);
        withholdingTaxTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        withholdingTaxTxtField.setBorder(null);
        withholdingTaxTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        withholdingTaxTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        payPanel1.add(withholdingTaxTxtField, gridBagConstraints);

        basicSalaryLabel3.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        basicSalaryLabel3.setText("SALARY");
        basicSalaryLabel3.setMaximumSize(new java.awt.Dimension(150, 15));
        basicSalaryLabel3.setMinimumSize(new java.awt.Dimension(150, 15));
        basicSalaryLabel3.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        payPanel1.add(basicSalaryLabel3, gridBagConstraints);

        salaryTxtField.setEditable(false);
        salaryTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        salaryTxtField.setBorder(null);
        salaryTxtField.setMinimumSize(new java.awt.Dimension(200, 20));
        salaryTxtField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 30);
        payPanel1.add(salaryTxtField, gridBagConstraints);

        calculateBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        calculateBTN.setText("Calculate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 10);
        payPanel1.add(calculateBTN, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 18, 10);
        jPanel2.add(payPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 15, 50);
        add(jPanel2, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        dateLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        dateLabel.setText("DATE");
        dateLabel.setMinimumSize(new java.awt.Dimension(250, 23));
        dateLabel.setPreferredSize(new java.awt.Dimension(250, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(dateLabel, gridBagConstraints);

        myPayslipLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        myPayslipLabel.setText("PAYROLL RUN (MANUAL)");
        myPayslipLabel.setMaximumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setMinimumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(36, 50, 34, 0);
        jPanel5.add(myPayslipLabel, gridBagConstraints);

        searchBTN.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel5.add(searchBTN, gridBagConstraints);

        searchField.setMinimumSize(new java.awt.Dimension(200, 30));
        searchField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel5.add(searchField, gridBagConstraints);

        batchBTN.setText("Batch");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 50);
        jPanel5.add(batchBTN, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1041;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel5, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allowancesLabel;
    private javax.swing.JLabel basicSalaryLabel;
    private javax.swing.JLabel basicSalaryLabel1;
    private javax.swing.JLabel basicSalaryLabel2;
    private javax.swing.JLabel basicSalaryLabel3;
    private javax.swing.JButton batchBTN;
    private javax.swing.JButton calculateBTN;
    private javax.swing.JLabel clothingAllowanceLabel;
    private javax.swing.JTextField clothingAllowanceTxtField;
    private javax.swing.JLabel contributionIDsLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel empIDLabel;
    private javax.swing.JTextField empIDTxtField;
    private javax.swing.JPanel employmentPanel;
    private javax.swing.JTextField grossPayTxtField;
    private javax.swing.JLabel hourlyRateLabel;
    private javax.swing.JLabel hourlyRateLabel1;
    private javax.swing.JTextField hourlyRateTxtField;
    private javax.swing.JTextField hoursWorkedTxtField;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel myPayslipLabel;
    private javax.swing.JTextField netPayTxtField;
    private javax.swing.JTextField overtimeHoursTxtField;
    private javax.swing.JTextField overtimeRateTxtField;
    private javax.swing.JTextField pagIbigTxtField;
    private javax.swing.JLabel pagibigNoLabel;
    private javax.swing.JLabel payLabel;
    private javax.swing.JLabel payLabel1;
    private javax.swing.JLabel payLabel2;
    private javax.swing.JPanel payPanel;
    private javax.swing.JPanel payPanel1;
    private javax.swing.JComboBox<String> periodType;
    private javax.swing.JTextField philHealthTxtField;
    private javax.swing.JLabel philhealthNoLabel;
    private javax.swing.JLabel phoneAllowanceLabel;
    private javax.swing.JTextField phoneAllowanceTxtField;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JTextField positionTxtField;
    private javax.swing.JButton resetBTN;
    private javax.swing.JLabel riceSubsidyLabel;
    private javax.swing.JTextField riceSubsidyTxtField;
    private javax.swing.JTextField salaryTxtField;
    private javax.swing.JButton saveBTN;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel semiMonthlyLabel;
    private javax.swing.JLabel semiMonthlyLabel1;
    private javax.swing.JLabel semiMonthlyLabel2;
    private javax.swing.JLabel semiMonthlyLabel3;
    private javax.swing.JLabel sssNoLabel;
    private javax.swing.JTextField sssTextField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField totalAllowancesTxtField;
    private javax.swing.JTextField totalDeductionsTxtField;
    private javax.swing.JTextField withholdingTaxTxtField;
    // End of variables declaration//GEN-END:variables
}
