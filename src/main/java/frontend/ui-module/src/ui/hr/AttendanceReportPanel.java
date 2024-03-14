/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.hr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 * Represents the panel for generating and displaying attendance reports.
 * It provides functionalities to generate reports based on different time periods and search for specific records.
 * <p>
 * Available methods:
 * - {@link #AttendanceReportPanel()}
 * - {@link #getPeriodType()}
 * - {@link #getGenerateBTN()}
 * - {@link #getAttendanceReportTable()}
 * - {@link #getSearchBTN()}
 * - {@link #getSearchField()}
 * - {@link #getAttendanceReportTableModel()}
 * - {@link #getReportTableSorter()}
 * - {@link #getAttendanceReportTableScroll()}
 * <p>
 * Note: This class contains auto-generated code generated by the NetBeans GUI Builder.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "MagicConstant", "FieldMayBeFinal"})


public class AttendanceReportPanel extends javax.swing.JPanel {
    private DefaultTableModel reportTableModel;
    private TableRowSorter<DefaultTableModel> reportTableSorter;

    /**
     * Creates new form payrollReportPanel
     */
    public AttendanceReportPanel() {
        initComponents();
        initTable();
    }

    /**
     * Initializes the table for attendance report display.
     */
    private void initTable() {
        reportTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Employee ID", "Full Name", "Position", "Department", "Days Worked", "Total Hours", "Overtime Hours"
                }
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false,
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        attendanceReportTable.setModel(reportTableModel);

        reportTableSorter = new TableRowSorter<>(reportTableModel);
        attendanceReportTable.setRowSorter(reportTableSorter);
    }

    /**
     * Gets the period type.
     *
     * @return the period type
     */
    public JComboBox<String> getPeriodType() {
        return periodType;
    }

    /**
     * Get the generate button.
     *
     * @return the generate button
     */
    public JButton getGenerateBTN() {
        return generateBTN;
    }

    /**
     * Gets the attendance report table.
     *
     * @return the attendance report table
     */
    public JTable getAttendanceReportTable() {
        return attendanceReportTable;
    }

    /**
     * Gets the search button.
     *
     * @return the search button
     */
    public JButton getSearchBTN() {
        return searchBTN;
    }

    /**
     * Gets the search field.
     *
     * @return the search field
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * Gets the attendance report table model.
     *
     * @return the attendance report table model
     */
    public DefaultTableModel getAttendanceReportTableModel() {
        return reportTableModel;
    }

    /**
     * Gets the report table sorter.
     *
     * @return the report table sorter
     */
    public TableRowSorter<DefaultTableModel> getReportTableSorter() {
        return reportTableSorter;
    }

    /**
     * Gets the attendance report table scroll pane.
     *
     * @return the attendance report table scroll pane
     */
    public JScrollPane getAttendanceReportTableScroll() {
        return attendanceReportTableScroll;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        attendanceReportTableScroll = new javax.swing.JScrollPane();
        attendanceReportTable = new javax.swing.JTable();
        generateBTN = new javax.swing.JButton();
        periodType = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        attendanceReportLabel = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(244, 245, 247));
        setLayout(new java.awt.GridBagLayout());

        attendanceReportTableScroll.setAutoscrolls(true);
        attendanceReportTableScroll.setViewportView(attendanceReportTable);

        attendanceReportTable.setAutoCreateRowSorter(true);
        attendanceReportTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        attendanceReportTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        attendanceReportTable.setAutoscrolls(false);
        attendanceReportTable.setDragEnabled(true);
        attendanceReportTable.setEnabled(false);
        attendanceReportTable.setRowHeight(30);
        attendanceReportTable.setRowMargin(1);
        attendanceReportTable.setVerifyInputWhenFocusTarget(false);
        attendanceReportTableScroll.setViewportView(attendanceReportTable);
        if (attendanceReportTable.getColumnModel().getColumnCount() > 0) {
            attendanceReportTable.getColumnModel().getColumn(0).setMinWidth(50);
            attendanceReportTable.getColumnModel().getColumn(0).setPreferredWidth(25);
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
        add(attendanceReportTableScroll, gridBagConstraints);

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

        attendanceReportLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        attendanceReportLabel.setText("ATTENDANCE REPORT");
        attendanceReportLabel.setMaximumSize(new java.awt.Dimension(350, 30));
        attendanceReportLabel.setMinimumSize(new java.awt.Dimension(350, 30));
        attendanceReportLabel.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(36, 50, 34, 19);
        jPanel1.add(attendanceReportLabel, gridBagConstraints);

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
    private javax.swing.JLabel attendanceReportLabel;
    private javax.swing.JTable attendanceReportTable;
    private javax.swing.JScrollPane attendanceReportTableScroll;
    private javax.swing.JButton generateBTN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> periodType;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
