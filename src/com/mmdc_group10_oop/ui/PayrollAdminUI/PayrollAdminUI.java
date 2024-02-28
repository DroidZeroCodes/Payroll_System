package com.mmdc_group10_oop.ui.payrollAdminUI;

import com.mmdc_group10_oop.service.user.PayrollAdmin;
import com.mmdc_group10_oop.ui.LoginUI;
import com.mmdc_group10_oop.ui.employeeUI.AttendancePanel;
import com.mmdc_group10_oop.ui.employeeUI.LeavePanel;
import com.mmdc_group10_oop.ui.employeeUI.MyPayslipPanel;
import com.mmdc_group10_oop.ui.employeeUI.MyProfilePanel;

import javax.swing.*;

public class PayrollAdminUI extends javax.swing.JFrame {
    private MyProfilePanel empProfilePanel;
    private AttendancePanel empAttendancePanel;
    private MyPayslipPanel empPayslipPanel;
    private LeavePanel empLeavePanel;
    private RunPayrollPanel payrollPanel;
    private PayrollReportPanel reportPanel;
    private PayrollAdmin payrollAdmin;
    
    public PayrollAdminUI(int employeeID) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon appIcon = new ImageIcon("MotorPH logo.png");
        this.setIconImage(appIcon.getImage());
        initializePanels();
        actions();

        payrollAdmin = new PayrollAdmin(employeeID,this);
        payrollAdmin.displayProfile();
        empPayslipPanel.setSearchVisibility(true);
    }


    private void actions(){
        //Side Menu Actions
        myProfileBTN.addActionListener(e -> {
            resetPanelVisibility();
            payrollAdmin.displayProfile();
            empProfilePanel.setVisible(true);
        });

        attedanceBTN.addActionListener(e -> {
            resetPanelVisibility();
            payrollAdmin.displayAttendanceRecord();
            empAttendancePanel.setVisible(true);
        });

        payslipBTN.addActionListener(e -> {
            resetPanelVisibility();
            payrollAdmin.displayPayslip();
            empPayslipPanel.setVisible(true);
        });

        leaveBTN.addActionListener(e -> {
            resetPanelVisibility();
            payrollAdmin.displayLeaveBalance();
            payrollAdmin.displayLeaveHistory();
            empLeavePanel.setVisible(true);
        });

        runPayrollBTN.addActionListener(e -> {
            resetPanelVisibility();
            payrollPanel.setVisible(true);
        });

        payrollReportBTN.addActionListener(e -> {
            resetPanelVisibility();
            reportPanel.setVisible(true);
        });

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginUI().setVisible(true);
        });


        //Panel actions
        //Attendance Panel
        empAttendancePanel.clockInBTN().addActionListener(e -> {
            payrollAdmin.clockIn();
        });

        empAttendancePanel.clockOutBTN().addActionListener(e -> {
            payrollAdmin.clockOut();
        });

        //Leave Panel
        empLeavePanel.submitBTN().addActionListener(e -> {
            payrollAdmin.submitLeaveRequest();
        });

        //Payslip Panel
        empPayslipPanel.searchBTN().addActionListener(e -> {
            payrollAdmin.searchPayslip();
        });

        //Payroll Panel
        payrollPanel.processBTN().addActionListener(e -> {
            payrollAdmin.runPayroll();
        });

        payrollPanel.searchBTN().addActionListener(e -> {
            payrollAdmin.searchPayroll();
        });

        payrollPanel.submitBTN().addActionListener(e -> {
            payrollAdmin.submitPayroll();
        });
    }


    //Getter methods to modify components


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

    public RunPayrollPanel payrollPanel() {
        return payrollPanel;
    }

    public PayrollReportPanel reportPanel() {
        return reportPanel;
    }

    public JButton attedanceBTN() {
        return attedanceBTN;
    }

    public JButton leaveBTN() {
        return leaveBTN;
    }

    public JButton logoutBtn() {
        return logoutBtn;
    }

    public JButton myProfileBTN() {
        return myProfileBTN;
    }

    public JButton payrollReportnBTN() {
        return payrollReportBTN;
    }

    public JButton payslipBTN() {
        return payslipBTN;
    }

    public JButton runPayrollBTN() {
        return runPayrollBTN;
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


    private void resetPanelVisibility() {
        empProfilePanel.setVisible(false);
        empAttendancePanel.setVisible(false);
        empPayslipPanel.setVisible(false);
        empLeavePanel.setVisible(false);
        payrollPanel.setVisible(false);
        reportPanel.setVisible(false);
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
        payrollReportBTN = new javax.swing.JButton();
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

        attedanceBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        attedanceBTN.setText("Attendance");

        payslipBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payslipBTN.setText("PayrollRecords");

        leaveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveBTN.setText("Leave");

        logoutBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setActionCommand("");

        motorPHmainLabel.setFont(new java.awt.Font("Magneto", 0, 20)); // NOI18N
        motorPHmainLabel.setText("MotorPH");

        runPayrollBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        runPayrollBTN.setText("Run Payroll");

        payrollReportBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payrollReportBTN.setText("Payroll Report");

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
                    .addComponent(payrollReportBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(motorPHmainLabel))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        sidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {attedanceBTN, leaveBTN, logoutBtn, myProfileBTN, payrollReportBTN, payslipBTN, runPayrollBTN});

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
                .addComponent(payrollReportBTN)
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            PayrollAdminUI frame = null;
            frame = new PayrollAdminUI(15);
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
    private javax.swing.JButton payrollReportBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JButton runPayrollBTN;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
