package com.mmdc_group10_oop.ui.ITAdminUI;

import com.mmdc_group10_oop.dataHandlingModule.UserCredentials;
import com.mmdc_group10_oop.service.user.ITAdmin;
import com.mmdc_group10_oop.ui.LoginUI;
import com.mmdc_group10_oop.ui.employeeUI.AttendancePanel;
import com.mmdc_group10_oop.ui.employeeUI.LeavePanel;
import com.mmdc_group10_oop.ui.employeeUI.MyPayslipPanel;
import com.mmdc_group10_oop.ui.employeeUI.MyProfilePanel;

import javax.swing.*;

public class ITAdminUI extends javax.swing.JFrame {
    private MyProfilePanel empProfilePanel;
    private AttendancePanel empAttendancePanel;
    private MyPayslipPanel empPayslipPanel;
    private LeavePanel empLeavePanel;
    private ManageUserPanel manageUserPanel;

    protected ITAdmin itAdmin;


    public ITAdminUI(int itAdminID) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        initializePanels();
        actions();

        itAdmin = new ITAdmin(itAdminID, this);
        itAdmin.displayProfile();
    }

    // This method initializes the panels
    private void initializePanels() {
        empProfilePanel = new MyProfilePanel();
        empAttendancePanel = new AttendancePanel();
        empPayslipPanel = new MyPayslipPanel();
        empLeavePanel = new LeavePanel();
        manageUserPanel = new ManageUserPanel();

        mainPanel.add(empProfilePanel, "profile");
        mainPanel.add(empAttendancePanel, "attendance");
        mainPanel.add(empPayslipPanel, "payslip");
        mainPanel.add(empLeavePanel, "leave");
        mainPanel.add(manageUserPanel, "Manage Users");
    }

    private void actions() {
        myProfileBTN.addActionListener(e -> {
            resetPanelVisibility();
            itAdmin.displayProfile();
            empProfilePanel.setVisible(true);
        });

        attedanceBTN.addActionListener(e -> {
            resetPanelVisibility();
            itAdmin.displayAttendanceRecord();
            empAttendancePanel.setVisible(true);
        });

        leaveBTN.addActionListener(e -> {
            resetPanelVisibility();
            itAdmin.displayLeaveHistory();
            itAdmin.displayLeaveBalance();
            empLeavePanel.setVisible(true);
        });

        payslipBTN.addActionListener(e -> {
            resetPanelVisibility();
            itAdmin.displayPayslip();
            empPayslipPanel.setVisible(true);
        });

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginUI().setVisible(true);
        });

        empAttendancePanel.clockInBTN().addActionListener(e -> {
            itAdmin.clockIn();
        });

        empAttendancePanel.clockOutBTN().addActionListener(e -> {
            itAdmin.clockOut();
        });

        // IT specific functions
        mngUserBTN.addActionListener(e -> {
            resetPanelVisibility();
            itAdmin.displayUserRecord();
            manageUserPanel.setVisible(true);
        });

        // Manage User Panel
        manageUserPanel.createUserBTN().addActionListener(e -> {
            itAdmin.createUser();
        });

        manageUserPanel.deleteUserBTN().addActionListener(e -> {
            // implement logic
        });

        manageUserPanel.searchBTN().addActionListener(e -> {
            // implement logic
        });
        
        manageUserPanel.updateBTN().addActionListener(e -> {
            String newUsername = manageUserPanel.usernameTxtField().getText();
            String newPassword = new String(manageUserPanel.passwordField1().getPassword());
            String newPassword2 = new String(manageUserPanel.passwordField2().getPassword());

            if (!newPassword.equals(newPassword2)) {
                System.out.println("Password not matching");
                return;
            }
            
                itAdmin.updateUsername(newUsername);
                itAdmin.updatePassword(newPassword);
        });

    }
    
    public MyProfilePanel getEmpProfilePanel() {
        return empProfilePanel;
    }

    public AttendancePanel getEmpAttendancePanel() {
        return empAttendancePanel;
    }

    public MyPayslipPanel getEmpPayslipPanel() {
        return empPayslipPanel;
    }

    public LeavePanel getEmpLeavePanel() {
        return empLeavePanel;
    }
    
    public ManageUserPanel getManageUserPanel() {
        return manageUserPanel;
    }

    public JButton getAttedanceBTN() {
        return attedanceBTN;
    }

    public JButton getLeaveBTN() {
        return leaveBTN;
    }

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public JButton getMngUserBTN() {
        return mngUserBTN;
    }

    public JButton getMyProfileBTN() {
        return myProfileBTN;
    }

    public JButton getPayslipBTN() {
        return payslipBTN;
    }

    //Method to set panels visible
    private void resetPanelVisibility() {
        empProfilePanel.setVisible(false);
        empAttendancePanel.setVisible(false);
        empPayslipPanel.setVisible(false);
        empLeavePanel.setVisible(false);
        manageUserPanel.setVisible(false);
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
        setTitle("MotorPH itAdmin Portal");
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

        sidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{attedanceBTN, leaveBTN, logoutBtn, mngUserBTN, myProfileBTN, payslipBTN});

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

        sidePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{attedanceBTN, leaveBTN, logoutBtn, mngUserBTN, myProfileBTN, payslipBTN});

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 700));

        mainPanel.setMaximumSize(new java.awt.Dimension(820, 700));
        mainPanel.setMinimumSize(new java.awt.Dimension(820, 700));
        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 820, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ITAdminUI frame = null;
            frame = new ITAdminUI(1);
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
