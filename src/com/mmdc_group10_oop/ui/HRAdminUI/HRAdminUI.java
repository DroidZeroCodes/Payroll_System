package com.mmdc_group10_oop.ui.HRAdminUI;

import com.mmdc_group10_oop.service.user.HRAdmin;
import com.mmdc_group10_oop.ui.employeeUI.AttendancePanel;
import com.mmdc_group10_oop.ui.employeeUI.LeavePanel;
import com.mmdc_group10_oop.ui.employeeUI.MyPayslipPanel;
import com.mmdc_group10_oop.ui.employeeUI.MyProfilePanel;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.io.IOException;

public class HRAdminUI extends javax.swing.JFrame {
    private MyProfilePanel empProfilePanel;
    private AttendancePanel empAttendancePanel;
    private MyPayslipPanel empPayslipPanel;
    private LeavePanel empLeavePanel;
    private ManageEmpPanel manageEmpPanel;
    private EmpProfile empProfile;
    private final HRAdmin hrAdmin;

    public HRAdminUI(int employeeID) throws IOException, CsvException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon appIcon = new ImageIcon("MotorPH logo.png");
        this.setIconImage(appIcon.getImage());
        initializePanels();
        actions();
//        empPayslipPanel.enableAdminActions(true);
//        empProfilePanel.enableAdminActions(true);
//        empAttendancePanel.enableAdminActions(true);

        this.hrAdmin = new HRAdmin(employeeID, this);
        hrAdmin.displayProfile();
    }

    public MyProfilePanel empProfilePanel() {
        return empProfilePanel;
    }

    public AttendancePanel empAttendancePanel() {
        return empAttendancePanel;
    }

    public MyPayslipPanel empPayslipPanel() {
        return empPayslipPanel;
    }

    public LeavePanel empLeavePanel() {
        return empLeavePanel;
    }
        
        // This method intializes the panels
        private void initializePanels() {
        empProfilePanel = new MyProfilePanel();
        empAttendancePanel = new AttendancePanel();
        empPayslipPanel = new MyPayslipPanel();
        empLeavePanel = new LeavePanel();
        manageEmpPanel = new ManageEmpPanel();
        empProfile = new EmpProfile();
        
        mainPanel.add(empProfilePanel, "profile");
        mainPanel.add(empAttendancePanel, "attendance");
        mainPanel.add(empPayslipPanel, "payslip");
        mainPanel.add(empLeavePanel, "leave");
        mainPanel.add(manageEmpPanel, "Manage Employees");
        mainPanel.add(empProfile, "Employee Profile");
    }

    //Method to set panels visible
    private void resetPanelVisibility() {
        empProfilePanel.setVisible(false);
        empAttendancePanel.setVisible(false);
        empPayslipPanel.setVisible(false);
        empLeavePanel.setVisible(false);
        manageEmpPanel.setVisible(false);
    }

    private void actions(){
        //Side Menu Actions
        myProfileBTN.addActionListener(e -> {
            resetPanelVisibility();
            empProfilePanel.setVisible(true);
        });

        attedanceBTN.addActionListener(e -> {
            resetPanelVisibility();
            hrAdmin.displayAttendanceRecord();
            empAttendancePanel.setVisible(true);
        });

        leaveBTN.addActionListener(e -> {
            resetPanelVisibility();
            empLeavePanel.setVisible(true);
        });

        payslipBTN.addActionListener(e -> {
            resetPanelVisibility();
            empPayslipPanel.setVisible(true);
        });

        mngEmpBTN.addActionListener(e -> {
            resetPanelVisibility();
            manageEmpPanel.setVisible(true);
        });

        logoutBtn.addActionListener(e -> {
            dispose();
        });

        //Panel Actions
        empAttendancePanel.clockInBTN().addActionListener(e -> {
            try {
                hrAdmin.clockIn();
            } catch (CsvValidationException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        empAttendancePanel.clockOutBTN().addActionListener(e -> {
            hrAdmin.clockOut();
        });

        manageEmpPanel.addEmpBTN().addActionListener(e -> {
            resetPanelVisibility();
            empProfile.setVisible(true);
        });

        manageEmpPanel.updateEmpBTN().addActionListener(e -> {
            resetPanelVisibility();
            empProfile.setVisible(true);
        });

        manageEmpPanel.TermEmpBTN().addActionListener(e -> {
            //Add logic
        });
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
        mngEmpBTN = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MotorPH HR Admin Portal");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(153, 153, 153));
        sidePanel.setMaximumSize(new java.awt.Dimension(180, 700));
        sidePanel.setMinimumSize(new java.awt.Dimension(180, 700));
        sidePanel.setPreferredSize(new java.awt.Dimension(180, 700));

        myProfileBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        myProfileBTN.setText("My Profile");

        attedanceBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        attedanceBTN.setText("Attendance");

        payslipBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payslipBTN.setText("Payslip");

        leaveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveBTN.setText("Leave");

        logoutBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setActionCommand("");

        motorPHmainLabel.setFont(new java.awt.Font("Magneto", 0, 20)); // NOI18N
        motorPHmainLabel.setText("MotorPH");

        mngEmpBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        mngEmpBTN.setText("Manage Employees");

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(motorPHmainLabel))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(myProfileBTN)
                            .addComponent(attedanceBTN)
                            .addComponent(payslipBTN)
                            .addComponent(leaveBTN)
                            .addComponent(mngEmpBTN)
                            .addComponent(logoutBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {attedanceBTN, leaveBTN, logoutBtn, mngEmpBTN, myProfileBTN, payslipBTN});

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
                .addComponent(mngEmpBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addGap(71, 71, 71))
        );

        sidePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {attedanceBTN, leaveBTN, logoutBtn, myProfileBTN, payslipBTN});

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

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            HRAdminUI frame = null;
            try {
                frame = new HRAdminUI(6);
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
    private javax.swing.JButton mngEmpBTN;
    private javax.swing.JLabel motorPHmainLabel;
    private javax.swing.JButton myProfileBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}


