/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend.ui.payroll;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * Represents a panel for displaying payroll reports. Users can generate reports based on different periods and search for specific data.
 * The panel includes a table to display payroll information such as employee ID, full name, position, department, gross income, deductions, and net pay.
 * <p>
 * Available methods:
 * - {@link #getPeriodType()} Returns the combo box for selecting the period type.
 * - {@link #getGenerateBTN()} Returns the button for generating the report.
 * - {@link #getPayrollReportTable()} Returns the table displaying the payroll report.
 * - {@link #getSearchBTN()} Returns the button for searching within the report.
 * - {@link #getSearchField()} Returns the text field for entering search queries.
 * - {@link #getPayrollReportTableModel()} Returns the table model for the payroll report.
 * - {@link #getReportTableSorter()} Returns the sorter for the payroll report table.
 * - {@link #getPayrollReportTableScroll()} Returns the scroll pane containing the payroll report table.
 * - {@link #setDataTableColumnWidth()} Sets the preferred column width for the table.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "MagicConstant", "FieldMayBeFinal"})

public class PayrollReportPanel extends javax.swing.JPanel {
    private DefaultTableModel reportTableModel;
    private TableRowSorter<DefaultTableModel> reportTableSorter;

    /**
     * Creates new form payrollReportPanel
     */
    public PayrollReportPanel() {
        initComponents();
        initTable();
        setDataTableColumnWidth();
    }

    private void initTable() {
        reportTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Employee ID", "Full Name", "Position", "Department", "Gross Income", "SSS No.", "SSS Cont.", "PhilHealth No.", "PhilHealth Cont.", "Pag-Ibig No.", "Pag-Ibig Cont.", "TIN", "Withholding Tax", "NetPay"
                }
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        payrollReportTable.setModel(reportTableModel);

        reportTableSorter = new TableRowSorter<>(reportTableModel);
        payrollReportTable.setRowSorter(reportTableSorter);
    }

    /**
     * Retrieves the period type combo box.
     *
     * @return The period type combo box component.
     */
    public JComboBox<String> getPeriodType() {
        return periodType;
    }

    /**
     * Retrieves the button for generating the report.
     *
     * @return The generate button component.
     */
    public JButton getGenerateBTN() {
        return generateBTN;
    }

    /**
     * Retrieves the table displaying payroll reports.
     *
     * @return The payroll report table component.
     */
    public JTable getPayrollReportTable() {
        return payrollReportTable;
    }

    /**
     * Retrieves the button for searching.
     *
     * @return The search button component.
     */
    public JButton getSearchBTN() {
        return searchBTN;
    }

    /**
     * Retrieves the text field for search queries.
     *
     * @return The search field component.
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * Retrieves the model for the payroll report table.
     *
     * @return The payroll report table model.
     */
    public DefaultTableModel getPayrollReportTableModel() {
        return reportTableModel;
    }

    /**
     * Retrieves the sorter for the payroll report table.
     *
     * @return The payroll report table sorter.
     */
    public TableRowSorter<DefaultTableModel> getReportTableSorter() {
        return reportTableSorter;
    }

    /**
     * Retrieves the scroll pane containing the payroll report table.
     *
     * @return The payroll report table scroll pane.
     */
    private JScrollPane getPayrollReportTableScroll() {
        return payrollReportTableScroll;
    }

    /**
     * Sets the preferred column width for the table.
     */
    public void setDataTableColumnWidth() {
        // Calculate and set preferred column width
        TableColumnModel columnModel = payrollReportTable.getColumnModel();
        for (int column = 0; column < payrollReportTable.getColumnCount(); column++) {
            TableColumn tableColumn = columnModel.getColumn(column);
            int preferredWidth = 0;

            // Get the width of the header
            TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = payrollReportTable.getTableHeader().getDefaultRenderer();
            }
            Component headerComponent = headerRenderer.getTableCellRendererComponent(
                    payrollReportTable, tableColumn.getHeaderValue(), false, false, 0, column
            );
            int headerWidth = headerComponent.getPreferredSize().width;
            preferredWidth = Math.max(preferredWidth, headerWidth);

            // Get the width of the cells
            for (int row = 0; row < payrollReportTable.getRowCount(); row++) {
                TableCellRenderer cellRenderer = payrollReportTable.getCellRenderer(row, column);
                Component cellComponent = payrollReportTable.prepareRenderer(cellRenderer, row, column);
                int cellWidth = cellComponent.getPreferredSize().width;
                preferredWidth = Math.max(preferredWidth, cellWidth);
            }
            // Set the preferred width for the column
            tableColumn.setPreferredWidth(preferredWidth + 5);

            // Set a minimum width for the column
            tableColumn.setMinWidth(80); // Adjust the value as needed
        }

        int lastColumnIndex = payrollReportTable.getColumnCount() - 1;
        TableColumn lastColumn = payrollReportTable.getColumnModel().getColumn(lastColumnIndex);
        lastColumn.setMinWidth(130); // Set the minimum width as needed
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        payrollReportTableScroll = new javax.swing.JScrollPane();
        payrollReportTable = new javax.swing.JTable();
        generateBTN = new javax.swing.JButton();
        periodType = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        myPayslipLabel = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(244, 245, 247));
        setLayout(new java.awt.GridBagLayout());

        payrollReportTableScroll.setAutoscrolls(true);
        payrollReportTableScroll.setViewportView(payrollReportTable);

        payrollReportTable.setAutoCreateRowSorter(true);
        payrollReportTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        payrollReportTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        payrollReportTable.setAutoscrolls(false);
        payrollReportTable.setDragEnabled(true);
        payrollReportTable.setEnabled(false);
        payrollReportTable.setRowHeight(30);
        payrollReportTable.setRowMargin(1);
        payrollReportTable.setVerifyInputWhenFocusTarget(false);
        payrollReportTableScroll.setViewportView(payrollReportTable);
        if (payrollReportTable.getColumnModel().getColumnCount() > 0) {
            payrollReportTable.getColumnModel().getColumn(0).setMinWidth(50);
            payrollReportTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 15, 50);
        add(payrollReportTableScroll, gridBagConstraints);

        generateBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        generateBTN.setText("Generate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 50);
        add(generateBTN, gridBagConstraints);

        periodType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        periodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Weekly", "Semi-Monthly", "Monthly", "Annual"}));
        periodType.setMinimumSize(new java.awt.Dimension(72, 23));
        periodType.setPreferredSize(new java.awt.Dimension(72, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 50, 0, 0);
        add(periodType, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        myPayslipLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        myPayslipLabel.setText("PAYROLL REPORT");
        myPayslipLabel.setMaximumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setMinimumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(36, 50, 34, 19);
        jPanel1.add(myPayslipLabel, gridBagConstraints);

        searchBTN.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 50);
        jPanel1.add(searchBTN, gridBagConstraints);

        searchField.setMinimumSize(new java.awt.Dimension(200, 30));
        searchField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(searchField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generateBTN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myPayslipLabel;
    private javax.swing.JTable payrollReportTable;
    private javax.swing.JScrollPane payrollReportTableScroll;
    private javax.swing.JComboBox<String> periodType;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
