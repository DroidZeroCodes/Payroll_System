package ui.hr;

import ui.DynamicComponents;
import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;

import javax.swing.*;

public class HRAdminUI extends javax.swing.JFrame implements DynamicComponents {
    private MyProfilePanel myProfilePanel;
    private AttendancePanel attendancePanel;
    private MyPayslipPanel payslipPanel;
    private LeavePanel leavePanel;
    private ManageEmpPanel employeeManagementPanel;
    private ProfileManagementPanel profileManagementPanel;
    private LeaveInfoFrame leaveInfoFrame;
    private AttendanceReportPanel attendanceReportPanel;

    public HRAdminUI() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            java.util.logging.Logger.getLogger(HRAdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        initComponents();
        setLocationRelativeTo(null);
        ImageIcon appIcon = new ImageIcon("MotorPH logo.png");
        this.setIconImage(appIcon.getImage());
        initializePanels();

//        empPayslipPanel.enableAdminActions(true);
//        empProfilePanel.enableAdminActions(true);
//        empAttendancePanel.enableAdminActions(true);
    }

    @Override
    public MyProfilePanel getMyProfilePage_Comp() {
        return myProfilePanel;
    }

    @Override
    public AttendancePanel getAttendancePage_Comp() {
        return attendancePanel;
    }

    @Override
    public MyPayslipPanel getPayslipPage_Comp() {
        return payslipPanel;
    }

    @Override
    public LeavePanel getLeavePage_Comp() {
        return leavePanel;
    }

    public ManageEmpPanel getEmployeeManagementPanel() {
        return employeeManagementPanel;
    }

    public ProfileManagementPanel getProfileManagementPanel() {
        return profileManagementPanel;
    }

    public AttendanceReportPanel getAttendanceReportPanel() {
        return attendanceReportPanel;
    }

    public JButton getAttendanceReportBTN() {
        return attendanceReportBTN;
    }

    @Override
    public JButton getAttedanceBTN_Comp() {
        return attedanceBTN;
    }

    @Override
    public JButton getLeaveBTN_Comp() {
        return leaveBTN;
    }

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public JButton getMngEmpBTN() {
        return mngEmpBTN;
    }

    @Override
    public JButton getMyProfileBTN_Comp() {
        return myProfileBTN;
    }

    @Override
    public JButton getPayslipBTN_Comp() {
        return payslipBTN;
    }

    public LeaveInfoFrame getLeaveInfoFrame() {
        return leaveInfoFrame;
    }

    // This method intializes the panels
    private void initializePanels() {
        myProfilePanel = new MyProfilePanel();
        attendancePanel = new AttendancePanel();
        payslipPanel = new MyPayslipPanel();
        leavePanel = new LeavePanel();
        employeeManagementPanel = new ManageEmpPanel();
        profileManagementPanel = new ProfileManagementPanel();
        leaveInfoFrame = new LeaveInfoFrame();
        attendanceReportPanel = new AttendanceReportPanel();

        mainPanel.add(myProfilePanel, "profile");
        mainPanel.add(attendancePanel, "attendance");
        mainPanel.add(payslipPanel, "payslip");
        mainPanel.add(leavePanel, "leave");
        mainPanel.add(employeeManagementPanel, "Manage Employees");
        mainPanel.add(profileManagementPanel, "Employee Profile");
        mainPanel.add(attendanceReportPanel, "attendanceReport");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        topBarPanel = new javax.swing.JPanel();
        motorPHmainLabel = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        motorPHmainLabel1 = new javax.swing.JLabel();
        myProfileBTN = new javax.swing.JButton();
        attedanceBTN = new javax.swing.JButton();
        payslipBTN = new javax.swing.JButton();
        leaveBTN = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        mngEmpBTN = new javax.swing.JButton();
        attendanceReportBTN = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MotorPH HR Admin Portal");
        setSize(new java.awt.Dimension(1300, 800));

        topBarPanel.setBackground(new java.awt.Color(255, 255, 255));
        topBarPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        topBarPanel.setPreferredSize(new java.awt.Dimension(100, 50));
        topBarPanel.setLayout(new java.awt.GridBagLayout());

        motorPHmainLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 3, 24)); // NOI18N
        motorPHmainLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        motorPHmainLabel.setText("MotorPH");
        motorPHmainLabel.setToolTipText("");
        motorPHmainLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        topBarPanel.add(motorPHmainLabel, gridBagConstraints);

        getContentPane().add(topBarPanel, java.awt.BorderLayout.PAGE_START);

        sidePanel.setBackground(new java.awt.Color(255, 255, 255));
        sidePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        sidePanel.setMinimumSize(new java.awt.Dimension(0, 0));
        sidePanel.setPreferredSize(new java.awt.Dimension(165, 0));
        sidePanel.setLayout(new java.awt.GridBagLayout());

        motorPHmainLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 20)); // NOI18N
        motorPHmainLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/channels4_profile (1).png"))); // NOI18N
        motorPHmainLabel1.setAlignmentY(0.0F);
        motorPHmainLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        motorPHmainLabel1.setIconTextGap(0);
        motorPHmainLabel1.setPreferredSize(new java.awt.Dimension(165, 125));
        motorPHmainLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        sidePanel.add(motorPHmainLabel1, gridBagConstraints);

        myProfileBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        myProfileBTN.setText("My Profile");
        myProfileBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myProfileBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        myProfileBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        myProfileBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myProfileBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(myProfileBTN, gridBagConstraints);

        attedanceBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        attedanceBTN.setText("Attendance");
        attedanceBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        attedanceBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(attedanceBTN, gridBagConstraints);

        payslipBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payslipBTN.setText("Payslip");
        payslipBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payslipBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(payslipBTN, gridBagConstraints);

        leaveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveBTN.setText("Leave");
        leaveBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leaveBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        leaveBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        leaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(leaveBTN, gridBagConstraints);

        logoutBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setActionCommand("");
        logoutBtn.setMinimumSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 35, 0);
        sidePanel.add(logoutBtn, gridBagConstraints);

        mngEmpBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        mngEmpBTN.setText("Employees");
        mngEmpBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        mngEmpBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngEmpBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(mngEmpBTN, gridBagConstraints);

        attendanceReportBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        attendanceReportBTN.setText("Reports");
        attendanceReportBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        attendanceReportBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        attendanceReportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollReportBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(attendanceReportBTN, gridBagConstraints);

        getContentPane().add(sidePanel, java.awt.BorderLayout.WEST);

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));
        mainPanel.setPreferredSize(new java.awt.Dimension(1135, 700));
        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myProfileBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myProfileBTNActionPerformed
    }//GEN-LAST:event_myProfileBTNActionPerformed

    private void leaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveBTNActionPerformed
    }//GEN-LAST:event_leaveBTNActionPerformed

    private void mngEmpBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngEmpBTNActionPerformed
    }//GEN-LAST:event_mngEmpBTNActionPerformed

    private void payrollReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollReportBTNActionPerformed
    }//GEN-LAST:event_payrollReportBTNActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            HRAdminUI frame;
            frame = new HRAdminUI();
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
    private javax.swing.JLabel motorPHmainLabel1;
    private javax.swing.JButton myProfileBTN;
    private javax.swing.JButton attendanceReportBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel topBarPanel;
    // End of variables declaration//GEN-END:variables
}


