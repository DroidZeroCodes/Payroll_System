/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mmdc_group10_oop.ui.hrAdminUI;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ManageEmpPanel extends javax.swing.JPanel {
    
    public ManageEmpPanel() {
        initComponents();
    }

    public JButton TermEmpBTN() {
        return TermEmpBTN;
    }

    public JButton addEmpBTN() {
        return addEmpBTN;
    }

    public JButton searchBTN() {
        return searchBTN;
    }

    public JButton updateEmpBTN() {
        return updateEmpBTN;
    }

    public DefaultTableModel empRecordTableModel() {
        return empRecordTableModel;
    }

    public JTable empRecordTable() {
        return empRecordTable;
    }

    public JTextField searchField() {
        return searchField;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        empRecordTableModel = new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                        new String [] {
                                "Employee ID", "Last Name", "First Name", "Birthday","Address","Phone No",
                                "SSS#","PHILHEALTH#", "PAG-IBIG#", "TIN#","Department","Position","Supervisor", "STATUS",
                                "BASIC_SALARY","RICE_SUBSIDY","PHONE_ALLOWANCE","CLOTHING_ALLOWANCE","GROSS_SEMI-MONTHLY_RATE","HOURLY_RATE"
                        });

        jScrollPane2 = new javax.swing.JScrollPane();
        empRecordTable = new javax.swing.JTable();
        addEmpBTN = new javax.swing.JButton();
        updateEmpBTN = new javax.swing.JButton();
        TermEmpBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchBTN = new javax.swing.JButton();

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane2.setViewportView(empRecordTable);
        empRecordTable().setModel(empRecordTableModel);
        addEmpBTN.setText("Add");

        updateEmpBTN.setText("Update");
        updateEmpBTN.setEnabled(false);

        TermEmpBTN.setText("Terminate");

        searchBTN.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBTN))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addEmpBTN)
                            .addGap(18, 18, 18)
                            .addComponent(updateEmpBTN)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TermEmpBTN))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TermEmpBTN, addEmpBTN, updateEmpBTN});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TermEmpBTN)
                    .addComponent(updateEmpBTN)
                    .addComponent(addEmpBTN))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TermEmpBTN, addEmpBTN, updateEmpBTN});

    }// </editor-fold>//GEN-END:initComponents

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DefaultTableModel empRecordTableModel;
    private javax.swing.JButton TermEmpBTN;
    private javax.swing.JButton addEmpBTN;
    private javax.swing.JTable empRecordTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateEmpBTN;
    // End of variables declaration//GEN-END:variables
}
