package com.mmdc_group10_oop.ui.ITAdminUI;

import com.mmdc_group10_oop.ui.employeeUI.*;
import com.mmdc_group10_oop.service.user.Employee;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.io.IOException;

public class ITAdminUI extends javax.swing.JFrame {
    public MyProfilePanel empProfilePanel;
    public AttendancePanel empAttendancePanel;
    public MyPayslipPanel empPayslipPanel;
    public LeavePanel empLeavePanel;

    protected Employee employee;

    
    public ITAdminUI(int employeeID) throws IOException, CsvException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon appIcon = new ImageIcon("MotorPH logo.png");
        this.setIconImage(appIcon.getImage());
        initializePanels();
        actions();

        employee = new Employee(employeeID, this);
        employee.displayProfile();
        employee.displayAttendanceRecord();
    }

    // This method initializes the panels
        private void initializePanels() {
        empProfilePanel = new MyProfilePanel();
        empAttendancePanel = new AttendancePanel();
        empPayslipPanel = new MyPayslipPanel();
        empLeavePanel = new LeavePanel();

        mainPanel.add(empProfilePanel, "profile");
        mainPanel.add(empAttendancePanel, "attendance");
        mainPanel.add(empPayslipPanel, "payslip");
        mainPanel.add(empLeavePanel, "leave");
    }
        
        
        //Method to set panels visible
        private void resetPanelVisibility() {
        empProfilePanel.setVisible(false);
        empAttendancePanel.setVisible(false);
        empPayslipPanel.setVisible(false);
        empLeavePanel.setVisible(false);
        }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        myProfileBTN = new javax.swing.JButton();
        attedanceBTN = new javax.swing.JButton();
        payslipBTN = new javax.swing.JButton();
        leaveBTN = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        motorPHmainLabel = new javax.swing.JLabel();
        mngUserBTN = new javax.swing.JButton();
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

        mngUserBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        mngUserBTN.setText("Manage Users");

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
                        .addComponent(leaveBTN)
                        .addComponent(mngUserBTN)
                        .addComponent(logoutBtn))
                    .addComponent(motorPHmainLabel))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        sidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {attedanceBTN, leaveBTN, logoutBtn, mngUserBTN, myProfileBTN, payslipBTN});

        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(motorPHmainLabel)
                .addGap(141, 141, 141)
                .addComponent(myProfileBTN)
                .addGap(18, 18, 18)
                .addComponent(attedanceBTN)
                .addGap(18, 18, 18)
                .addComponent(payslipBTN)
                .addGap(18, 18, 18)
                .addComponent(leaveBTN)
                .addGap(18, 18, 18)
                .addComponent(mngUserBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addGap(68, 68, 68))
        );

        sidePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {attedanceBTN, leaveBTN, logoutBtn, mngUserBTN, myProfileBTN, payslipBTN});

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 700));

        mainPanel.setMaximumSize(new java.awt.Dimension(820, 700));
        mainPanel.setMinimumSize(new java.awt.Dimension(820, 700));
        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 820, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actions(){
        myProfileBTN.addActionListener(e -> {
            resetPanelVisibility();
            empProfilePanel.setVisible(true);
        });

        attedanceBTN.addActionListener(e -> {
            resetPanelVisibility();
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

        logoutBtn.addActionListener(e -> {
            dispose();
        });

        empAttendancePanel.clockInBTN.addActionListener(e -> {
            try {
                employee.clockIn();
            } catch (CsvValidationException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        empAttendancePanel.clockOutBTN.addActionListener(e -> {
            employee.clockOut();
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ITAdminUI frame = null;
            try {
                frame = new ITAdminUI(1);
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
    private javax.swing.JButton mngUserBTN;
    private javax.swing.JLabel motorPHmainLabel;
    private javax.swing.JButton myProfileBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
