package ui.payroll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunPayrollPanel extends javax.swing.JPanel {

    /**
     * Creates new form runPayrollPanel
     */

    private DefaultTableModel payrollTableModel;
    private TableRowSorter<DefaultTableModel> payrollTableSorter;

    public RunPayrollPanel() {
        initComponents();
        initTableModel();
        initTimeAndDate();
    }


    private void initTableModel() {
        payrollTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Payslip ID", "Employee ID", "Employee Name", "Start Date", "End Date", "Position/Department",
                        "Monthly Rate", "Hourly Rate", "Hours Worked", "Overtime Pay",
                        "Rice Subsidy", "Phone Allowance", "Clothing Allowance",
                        "SSS", "PhilHealth", "Pag-ibig", "Withholding Tax",
                        "Allowances", "Deductions", "Gross", "Net"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, true, true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };


        //Sorter
        payrollTableSorter = new TableRowSorter<>(payrollTableModel);
        payrollTable.setRowSorter(payrollTableSorter);
        payrollTable.setModel(payrollTableModel);
    }

    public void initTimeAndDate() {
        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/dd/yyyy");
        String currentDate = sdf2.format(new Date());
        String dayOfWeek = new SimpleDateFormat("EEEE").format(new Date());
        dateLabel.setText(dayOfWeek.toUpperCase() + ", " + currentDate);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        payrollTable = new javax.swing.JTable();
        submitBTN = new javax.swing.JButton();
        processBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        myPayslipLabel = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        periodType = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(244, 245, 247));
        setMinimumSize(new java.awt.Dimension(1135, 700));
        setLayout(new java.awt.GridBagLayout());

        payrollTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Hourly Rate", "Hours Worked", "Overtime ", "Total Hours", "Allowances", "Deductions", "Gross", "Net"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(payrollTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 15, 50);
        add(jScrollPane1, gridBagConstraints);

        submitBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        submitBTN.setText("Submit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 50);
        add(submitBTN, gridBagConstraints);

        processBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        processBTN.setText("Process");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 20);
        add(processBTN, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        dateLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        dateLabel.setText("DATE");
        dateLabel.setMinimumSize(new java.awt.Dimension(250, 23));
        dateLabel.setPreferredSize(new java.awt.Dimension(250, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(dateLabel, gridBagConstraints);

        myPayslipLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        myPayslipLabel.setText("PAYROLL RUN");
        myPayslipLabel.setMaximumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setMinimumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(36, 50, 34, 0);
        jPanel1.add(myPayslipLabel, gridBagConstraints);

        searchBTN.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 50);
        jPanel1.add(searchBTN, gridBagConstraints);

        searchField.setMinimumSize(new java.awt.Dimension(200, 30));
        searchField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(searchField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1041;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);

        periodType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        periodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weekly", "Semi-Monthly", "Monthly" }));
        periodType.setMinimumSize(new java.awt.Dimension(72, 23));
        periodType.setPreferredSize(new java.awt.Dimension(72, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 50, 0, 0);
        add(periodType, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    //Getter method to modify the components

    public DefaultTableModel getPayrollTableModel() {
        return payrollTableModel;
    }

    public JTable getPayrollTable() {
        return payrollTable;
    }

    public JButton getProcessBTN() {
        return processBTN;
    }

    public JButton getSearchBTN() {
        return searchBTN;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSubmitBTN() {
        return submitBTN;
    }

    public JComboBox<String> getPeriodType() {
        return periodType;
    }

    public TableRowSorter<DefaultTableModel> getPayrollTableSorter() {
        return payrollTableSorter;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myPayslipLabel;
    private javax.swing.JTable payrollTable;
    private javax.swing.JComboBox<String> periodType;
    private javax.swing.JButton processBTN;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton submitBTN;
    // End of variables declaration//GEN-END:variables
}
