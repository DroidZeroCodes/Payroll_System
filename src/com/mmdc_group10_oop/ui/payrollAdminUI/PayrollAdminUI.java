package com.mmdc_group10_oop.ui.payrollAdminUI;

import com.mmdc_group10_oop.service.user.PayrollAdmin;
import com.mmdc_group10_oop.ui.employee.AttendancePanel;
import com.mmdc_group10_oop.ui.employee.LeavePanel;
import com.mmdc_group10_oop.ui.employee.MyPayslipPanel;
import com.mmdc_group10_oop.ui.employee.MyProfilePanel;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.io.IOException;

public class PayrollAdminUI extends javax.swing.JFrame {
    private MyProfilePanel empProfilePanel;
    private AttendancePanel empAttendancePanel;
    private MyPayslipPanel empPayslipPanel;
    private LeavePanel empLeavePanel;
    private RunPayrollPanel payrollPanel;
    private PayrollReportPanel reportPanel;
    private int employeeID;

    PayrollAdmin payrollAdmin;
    
    
    public PayrollAdminUI(int employeeID) throws IOException, CsvException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon appIcon = new ImageIcon("MotorPH logo.png");
        this.setIconImage(appIcon.getImage());
        initializePanels();

        payrollAdmin = new PayrollAdmin(employeeID);
        payrollAdmin.displayProfile(empProfilePanel);

        empPayslipPanel.setSearchVisibility(true);
    }
        
        // This method intializes the panels
        private void initializePanels() {
        empProfilePanel = new MyProfilePanel();
        empAttendancePanel = new AttendancePanel();
        empPayslipPanel = new MyPayslipPanel();
        empLeavePanel = new LeavePanel();
        payrollPanel = new RunPayrollPanel();
        reportPanel = new PayrollReportPanel();

        mainPanel.add(empProfilePanel, "profile");
        mainPanel.add(empAttendancePanel, "attendance");
        mainPanel.add(empPayslipPanel, "payslip");
        mainPanel.add(empLeavePanel, "leave");
        mainPanel.add(payrollPanel, "Run Payroll");
        mainPanel.add(reportPanel, "Payroll report");
    }
        
        
        //Method to set panels visible
        private void setPanelVisibility(boolean profileVisible, boolean attendanceVisible, boolean payslipVisible, boolean leaveVisible, 
                                        boolean runPayrollVisible, boolean reportPanelVisible) {
        empProfilePanel.setVisible(profileVisible);
        empAttendancePanel.setVisible(attendanceVisible);
        empPayslipPanel.setVisible(payslipVisible);
        empLeavePanel.setVisible(leaveVisible);
        payrollPanel.setVisible(runPayrollVisible);
        reportPanel.setVisible(reportPanelVisible);
            
        }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        myProfileBTN = new javax.swing.JButton();
        attedanceBTN = new javax.swing.JButton();
        payslipBTN = new javax.swing.JButton();
        leaveBTN = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        motorPHmainLabel = new javax.swing.JLabel();
        runPayrollBTN = new javax.swing.JButton();
        payrollReportnBTN = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MotorPH Employee Portal");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(153, 153, 153));
        sidePanel.setMaximumSize(new java.awt.Dimension(180, 700));
        sidePanel.setMinimumSize(new java.awt.Dimension(180, 700));
        sidePanel.setPreferredSize(new java.awt.Dimension(180, 700));

        myProfileBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        myProfileBTN.setText("My Profile");
        myProfileBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myProfileBTNActionPerformed(evt);
            }
        });

        attedanceBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        attedanceBTN.setText("Attendance");
        attedanceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attedanceBTNActionPerformed(evt);
            }
        });

        payslipBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payslipBTN.setText("Payslip");
        payslipBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payslipBTNActionPerformed(evt);
            }
        });

        leaveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveBTN.setText("Leave");
        leaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveBTNActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setActionCommand("");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        motorPHmainLabel.setFont(new java.awt.Font("Magneto", 0, 20)); // NOI18N
        motorPHmainLabel.setText("MotorPH");

        runPayrollBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        runPayrollBTN.setText("Run Payroll");
        runPayrollBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runPayrollBTNActionPerformed(evt);
            }
        });

        payrollReportnBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payrollReportnBTN.setText("Payroll Report");
        payrollReportnBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollReportnBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(myProfileBTN)
                        .addComponent(attedanceBTN)
                        .addComponent(payslipBTN)
                        .addComponent(leaveBTN))
                    .addComponent(runPayrollBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payrollReportnBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(motorPHmainLabel))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        sidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {attedanceBTN, leaveBTN, logoutBtn, myProfileBTN, payrollReportnBTN, payslipBTN, runPayrollBTN});

        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(motorPHmainLabel)
                .addGap(92, 92, 92)
                .addComponent(myProfileBTN)
                .addGap(18, 18, 18)
                .addComponent(attedanceBTN)
                .addGap(18, 18, 18)
                .addComponent(payslipBTN)
                .addGap(18, 18, 18)
                .addComponent(leaveBTN)
                .addGap(18, 18, 18)
                .addComponent(runPayrollBTN)
                .addGap(18, 18, 18)
                .addComponent(payrollReportnBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addGap(69, 69, 69))
        );

        sidePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {attedanceBTN, leaveBTN, logoutBtn, myProfileBTN, payslipBTN, runPayrollBTN});

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 700));

        mainPanel.setMaximumSize(new java.awt.Dimension(820, 700));
        mainPanel.setMinimumSize(new java.awt.Dimension(820, 700));
        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 820, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // Close current interface
        dispose();
        

    }//GEN-LAST:event_logoutBtnActionPerformed

    private void attedanceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attedanceBTNActionPerformed
        setPanelVisibility(false, true , false, false, false,false);
    }//GEN-LAST:event_attedanceBTNActionPerformed

    private void leaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveBTNActionPerformed
        setPanelVisibility(false, false, false, true, false,false);
    }//GEN-LAST:event_leaveBTNActionPerformed

    private void myProfileBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myProfileBTNActionPerformed
        setPanelVisibility(true, false, false, false, false,false);
    }//GEN-LAST:event_myProfileBTNActionPerformed

    private void payslipBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payslipBTNActionPerformed
        setPanelVisibility(false, false, true, false, false,false);
    }//GEN-LAST:event_payslipBTNActionPerformed

    private void runPayrollBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runPayrollBTNActionPerformed
        setPanelVisibility(false, false, false, false, true,false);
    }//GEN-LAST:event_runPayrollBTNActionPerformed

    private void payrollReportnBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollReportnBTNActionPerformed
        setPanelVisibility(false, false, false, false, false, true);
    }//GEN-LAST:event_payrollReportnBTNActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            PayrollAdminUI frame = null;
            try {
                frame = new PayrollAdminUI(1);
            } catch (IOException | CsvException e) {
                throw new RuntimeException(e);
            }
            frame.setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attedanceBTN;
    private javax.swing.JButton leaveBTN;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel motorPHmainLabel;
    private javax.swing.JButton myProfileBTN;
    private javax.swing.JButton payrollReportnBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JButton runPayrollBTN;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
