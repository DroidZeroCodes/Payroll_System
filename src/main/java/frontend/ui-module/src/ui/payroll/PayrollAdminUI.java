package ui.payroll;

import ui.DynamicComponents;
import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;

import javax.swing.*;

public class PayrollAdminUI extends javax.swing.JFrame implements DynamicComponents {
    private MyProfilePanel myProfilePanel;
    private AttendancePanel attendancePanel;
    private MyPayslipPanel payslipPanel;
    private LeavePanel leavePanel;
    private RunPayrollPanel payrollPanel;
    private PayrollReportPanel reportPanel;

    public PayrollAdminUI() {
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
            java.util.logging.Logger.getLogger(PayrollAdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        initComponents();
        setLocationRelativeTo(null);
        ImageIcon appIcon = new ImageIcon("MotorPH logo.png");
        this.setIconImage(appIcon.getImage());
        initializePanels();

        payslipPanel.setSearchVisibility(true);
    }


    //Getter methods to modify components
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

    @Override
    public JButton getMyProfileBTN_Comp() {
        return myProfileBTN;
    }

    @Override
    public JButton getAttedanceBTN_Comp() {
        return attedanceBTN;
    }

    @Override
    public JButton getLeaveBTN_Comp() {
        return leaveBTN;
    }

    @Override
    public JButton getPayslipBTN_Comp() {
        return payslipBTN;
    }

    public RunPayrollPanel getPayrollPanel() {
        return payrollPanel;
    }

    public PayrollReportPanel getReportPanel() {
        return reportPanel;
    }

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public JButton getPayrollReportBTN() {
        return payrollReportBTN;
    }

    public JButton getRunPayrollBTN() {
        return runPayrollBTN;
    }

    // This method intializes the panels
    private void initializePanels() {
        myProfilePanel = new MyProfilePanel();
        attendancePanel = new AttendancePanel();
        payslipPanel = new MyPayslipPanel();
        leavePanel = new LeavePanel();
        payrollPanel = new RunPayrollPanel();
        reportPanel = new PayrollReportPanel();

        mainPanel.add(myProfilePanel, "profile");
        mainPanel.add(attendancePanel, "attendance");
        mainPanel.add(payslipPanel, "payslip");
        mainPanel.add(leavePanel, "leave");
        mainPanel.add(payrollPanel, "Run Payroll");
        mainPanel.add(reportPanel, "Payroll report");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        topBarPanel = new javax.swing.JPanel();
        motorPHmainLabel1 = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        myProfileBTN = new javax.swing.JButton();
        attedanceBTN = new javax.swing.JButton();
        payslipBTN = new javax.swing.JButton();
        leaveBTN = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        motorPHmainLabel2 = new javax.swing.JLabel();
        runPayrollBTN = new javax.swing.JButton();
        payrollReportBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MotorPH Employee Portal");
        setMinimumSize(new java.awt.Dimension(1300, 800));
        setPreferredSize(new java.awt.Dimension(1300, 800));

        mainPanel.setBackground(new java.awt.Color(244, 245, 247));
        mainPanel.setMinimumSize(new java.awt.Dimension(1135, 700));
        mainPanel.setPreferredSize(new java.awt.Dimension(1135, 700));
        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        topBarPanel.setBackground(new java.awt.Color(255, 255, 255));
        topBarPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        topBarPanel.setPreferredSize(new java.awt.Dimension(100, 50));
        topBarPanel.setLayout(new java.awt.GridBagLayout());

        motorPHmainLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 3, 24)); // NOI18N
        motorPHmainLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        motorPHmainLabel1.setText("MotorPH");
        motorPHmainLabel1.setToolTipText("");
        motorPHmainLabel1.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        topBarPanel.add(motorPHmainLabel1, gridBagConstraints);

        getContentPane().add(topBarPanel, java.awt.BorderLayout.PAGE_START);

        sidePanel.setBackground(new java.awt.Color(255, 255, 255));
        sidePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        sidePanel.setMinimumSize(new java.awt.Dimension(0, 0));
        sidePanel.setPreferredSize(new java.awt.Dimension(165, 0));
        sidePanel.setLayout(new java.awt.GridBagLayout());

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
        attedanceBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(attedanceBTN, gridBagConstraints);

        payslipBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payslipBTN.setText("Payslip");
        payslipBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payslipBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        payslipBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(payslipBTN, gridBagConstraints);

        leaveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveBTN.setText("Leave");
        leaveBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leaveBTN.setMaximumSize(new java.awt.Dimension(100, 30));
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

        motorPHmainLabel2.setFont(new java.awt.Font("Montserrat Medium", 1, 20)); // NOI18N
        motorPHmainLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/channels4_profile (1).png"))); // NOI18N
        motorPHmainLabel2.setAlignmentY(0.0F);
        motorPHmainLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        motorPHmainLabel2.setIconTextGap(0);
        motorPHmainLabel2.setPreferredSize(new java.awt.Dimension(165, 125));
        motorPHmainLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        sidePanel.add(motorPHmainLabel2, gridBagConstraints);

        runPayrollBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        runPayrollBTN.setText("Run Payroll");
        runPayrollBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        runPayrollBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(runPayrollBTN, gridBagConstraints);

        payrollReportBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payrollReportBTN.setText("Reports");
        payrollReportBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        payrollReportBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        payrollReportBTN.addActionListener(new java.awt.event.ActionListener() {
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
        sidePanel.add(payrollReportBTN, gridBagConstraints);

        getContentPane().add(sidePanel, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myProfileBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myProfileBTNActionPerformed
    }//GEN-LAST:event_myProfileBTNActionPerformed

    private void leaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveBTNActionPerformed
    }//GEN-LAST:event_leaveBTNActionPerformed

    private void payrollReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollReportBTNActionPerformed
    }//GEN-LAST:event_payrollReportBTNActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            PayrollAdminUI frame = null;
            frame = new PayrollAdminUI();
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attedanceBTN;
    private javax.swing.JButton leaveBTN;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel motorPHmainLabel1;
    private javax.swing.JLabel motorPHmainLabel2;
    private javax.swing.JButton myProfileBTN;
    private javax.swing.JButton payrollReportBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JButton runPayrollBTN;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel topBarPanel;
    // End of variables declaration//GEN-END:variables
}