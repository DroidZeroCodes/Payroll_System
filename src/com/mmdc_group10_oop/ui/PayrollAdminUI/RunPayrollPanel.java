package com.mmdc_group10_oop.ui.payrollAdminUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RunPayrollPanel extends javax.swing.JPanel {
    DefaultTableModel payrollTableModel;

    /**
     * Creates new form runPayrollPanel
     */
    public RunPayrollPanel() {
        initComponents();
        initTableModel();
    }

    //Getter method to modify the components
    
    public DefaultTableModel payrollTableModel() {
         return payrollTableModel;
    }

    public JTable payrollTable() {
        return payrollTable;
    }

    public JButton processBTN() {
        return processBTN;
    }

    public JButton searchBTN() {
        return searchBTN;
    }

    public JTextField searchField() {
        return searchField;
    }

    public JButton submitBTN() {
        return submitBTN;
    }

    private void initTableModel() {
        payrollTableModel = new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Payslip ID", "Employee ID", "Employee Name", "Start Date", "End Date", "Position/Department",
                        "Monthly Rate", "Hourly Rate", "Hours Worked", "Overtime Pay",
                        "Rice Subsidy", "Phone Allowance", "Clothing Allowance",
                        "SSS", "Philhealth", "Pag-ibig", "Withholding Tax",
                        "Allowances", "Deductions", "Gross", "Net"

                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true, true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        payrollTable.setModel(payrollTableModel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        payrollTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchBTN = new javax.swing.JButton();
        submitBTN = new javax.swing.JButton();
        processBTN = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(820, 700));
        setMinimumSize(new java.awt.Dimension(820, 700));

        payrollTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
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

        searchBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        searchBTN.setText("Search");

        submitBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        submitBTN.setText("Submit");

        processBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        processBTN.setText("Process");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBTN))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(processBTN)
                            .addGap(18, 18, 18)
                            .addComponent(submitBTN))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {processBTN, searchBTN, submitBTN});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBTN))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBTN)
                    .addComponent(processBTN))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {processBTN, searchBTN, submitBTN});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable payrollTable;
    private javax.swing.JButton processBTN;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton submitBTN;
    // End of variables declaration//GEN-END:variables
}
