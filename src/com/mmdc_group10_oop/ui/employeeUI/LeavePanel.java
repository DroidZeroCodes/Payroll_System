/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mmdc_group10_oop.ui.employeeUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 *
 * @author Lenovo
 */
public class LeavePanel extends javax.swing.JPanel {

    /**
     * Creates new form LeavePanel
     */
    public LeavePanel() {
        initComponents();
    }

    //Getter methods to modify the components


    public TableModel leaveHistoryModel() {
        return leaveHistoryModel;
    }

    public JButton submitBTN() {
        return submitBTN;
    }

    public JComboBox<String> leaveTypeComboBox() {
        return leaveTypeComboBox;
    }

    public JDateChooser startDateChooser() {
        return startDateChooser;
    }

    public JDateChooser endDateChooser() {
        return endDateChooser;
    }

    public JTextArea leaveReasonsTxtArea() {
        return leaveReasonsTxtArea;
    }

    public JTextField sickLeaveTxtField() {
        return sickLeaveTxtField;
    }

    public JTextField vaccationLeaveTxtField() {
        return vaccationLeaveTxtField;
    }

    public JTextField paternityLeaveTxtField() {
        return paternityLeaveTxtField;
    }

    public JTextField bereavementLeaveTxtField() {
        return bereavementLeaveTxtField;
    }

    public JTable leaveHistoryTable() {
        return leaveHistoryTable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestLeaveLabel = new javax.swing.JLabel();
        requestLeavePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        leaveTypeComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        leaveReasonsTxtArea = new javax.swing.JTextArea();
        submitBTN = new javax.swing.JButton();
        leaveCreditsLabel = new javax.swing.JLabel();
        leaveCreditsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        sickLeaveTxtField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        vaccationLeaveTxtField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        paternityLeaveTxtField = new javax.swing.JTextField();
        bereavementLeaveTxtField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        leaveHistoryLabel = new javax.swing.JLabel();
        leaveHistoryPanel = new javax.swing.JScrollPane();
        leaveHistoryTable = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(820, 700));
        setMinimumSize(new java.awt.Dimension(820, 700));
        setPreferredSize(new java.awt.Dimension(820, 700));

        requestLeaveLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        requestLeaveLabel.setText("Request Leave");

        requestLeavePanel.setBackground(new java.awt.Color(153, 153, 153));
        requestLeavePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Leave Type");

        leaveTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick Leave", "Vacation Leave", "Paternal Leave", "Bereavement Leave" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Start date:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("End date:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel10.setText("Reason:");

        leaveReasonsTxtArea.setColumns(20);
        leaveReasonsTxtArea.setRows(5);
        jScrollPane5.setViewportView(leaveReasonsTxtArea);

        submitBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        submitBTN.setText("Submit");

        javax.swing.GroupLayout requestLeavePanelLayout = new javax.swing.GroupLayout(requestLeavePanel);
        requestLeavePanel.setLayout(requestLeavePanelLayout);
        requestLeavePanelLayout.setHorizontalGroup(
            requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestLeavePanelLayout.createSequentialGroup()
                .addGroup(requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(requestLeavePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(requestLeavePanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(requestLeavePanelLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(submitBTN)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        requestLeavePanelLayout.setVerticalGroup(
            requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestLeavePanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(submitBTN)
                .addGap(38, 38, 38))
        );

        leaveCreditsLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveCreditsLabel.setText("Leave Credits");

        leaveCreditsPanel.setBackground(new java.awt.Color(153, 153, 153));
        leaveCreditsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("Sick Leaves:");

        jLabel12.setText("Vacation Leaves:");

        jLabel13.setText("Paternal Leaves:");

        jLabel14.setText("Bereavement Leaves:");

        javax.swing.GroupLayout leaveCreditsPanelLayout = new javax.swing.GroupLayout(leaveCreditsPanel);
        leaveCreditsPanel.setLayout(leaveCreditsPanelLayout);
        leaveCreditsPanelLayout.setHorizontalGroup(
            leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paternityLeaveTxtField)
                            .addComponent(bereavementLeaveTxtField)))
                    .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sickLeaveTxtField)
                            .addComponent(vaccationLeaveTxtField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        leaveCreditsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel14});

        leaveCreditsPanelLayout.setVerticalGroup(
            leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sickLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(vaccationLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paternityLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bereavementLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        leaveCreditsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {sickLeaveTxtField, vaccationLeaveTxtField, paternityLeaveTxtField, bereavementLeaveTxtField});

        leaveCreditsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel14});

        leaveHistoryLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveHistoryLabel.setText("Leave History");

        leaveHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request Date", "Start Date", "End Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leaveHistoryPanel.setViewportView(leaveHistoryTable);
        if (leaveHistoryTable.getColumnModel().getColumnCount() > 0) {
            leaveHistoryTable.getColumnModel().getColumn(0).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(1).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(2).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestLeaveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestLeavePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(leaveCreditsLabel)
                    .addComponent(leaveHistoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(leaveHistoryLabel)
                    .addComponent(leaveCreditsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leaveCreditsLabel)
                    .addComponent(requestLeaveLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leaveCreditsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(leaveHistoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leaveHistoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(requestLeavePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private TableModel leaveHistoryModel;
    private javax.swing.JButton submitBTN;
    private javax.swing.JComboBox<String> leaveTypeComboBox;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea leaveReasonsTxtArea;
    private javax.swing.JTextField sickLeaveTxtField;
    private javax.swing.JTextField vaccationLeaveTxtField;
    private javax.swing.JTextField paternityLeaveTxtField;
    private javax.swing.JTextField bereavementLeaveTxtField;
    private javax.swing.JLabel leaveCreditsLabel;
    private javax.swing.JPanel leaveCreditsPanel;
    private javax.swing.JLabel leaveHistoryLabel;
    private javax.swing.JScrollPane leaveHistoryPanel;
    private javax.swing.JTable leaveHistoryTable;
    private javax.swing.JLabel requestLeaveLabel;
    private javax.swing.JPanel requestLeavePanel;
    // End of variables declaration//GEN-END:variables
}
