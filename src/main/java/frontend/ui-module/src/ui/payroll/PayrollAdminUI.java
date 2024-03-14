package ui.payroll;

import ui.DynamicComponents;
import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;

import javax.swing.*;

/**
 * Represents the main user interface for the payroll admin. This UI provides access to various features such as
 * viewing profiles, attendance, payslips, leave management, running payroll, and generating reports.
 * The UI includes panels for each feature and buttons to navigate between them.
 * <p>
 * Available methods:
 * - {@link #getMyProfilePage_Comp()} Returns the My Profile panel component.
 * - {@link #getAttendancePage_Comp()} Returns the Attendance panel component.
 * - {@link #getPayslipPage_Comp()} Returns the Payslip panel component.
 * - {@link #getLeavePage_Comp()} Returns the Leave panel component.
 * - {@link #getMyProfileBTN_Comp()} Returns the button for accessing My Profile.
 * - {@link #getAttendanceBTN_Comp()} Returns the button for accessing Attendance.
 * - {@link #getLeaveBTN_Comp()} Returns the button for accessing Leave.
 * - {@link #getPayslipBTN_Comp()} Returns the button for accessing Payslip.
 * - {@link #getPayrollPanel()} Returns the Run Payroll panel component.
 * - {@link #getReportPanel()} Returns the Payroll Report panel component.
 * - {@link #getLogoutBtn()} Returns the button for logging out.
 * - {@link #getPayrollReportBTN()} Returns the button for accessing Payroll Reports.
 * - {@link #getRunPayrollBTN()} Returns the button for running payroll.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "MagicConstant", "DataFlowIssue", "FieldMayBeFinal"})

public class PayrollAdminUI extends javax.swing.JFrame implements DynamicComponents {
    private MyProfilePanel myProfilePanel;
    private AttendancePanel attendancePanel;
    private MyPayslipPanel payslipPanel;
    private LeavePanel leavePanel;
    private RunPayrollPanel payrollPanel;
    private PayrollReportPanel reportPanel;

    /**
     * Creates new form PayrollAdminUI
     */
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

    /**
     * Retrieves the MyProfilePanel component.
     *
     * @return The MyProfilePanel component.
     */
    @Override
    public MyProfilePanel getMyProfilePage_Comp() {
        return myProfilePanel;
    }

    /**
     * Retrieves the AttendancePanel component.
     *
     * @return The AttendancePanel component.
     */
    @Override
    public AttendancePanel getAttendancePage_Comp() {
        return attendancePanel;
    }

    /**
     * Retrieves the MyPayslipPanel component.
     *
     * @return The MyPayslipPanel component.
     */
    @Override
    public MyPayslipPanel getPayslipPage_Comp() {
        return payslipPanel;
    }

    /**
     * Retrieves the LeavePanel component.
     *
     * @return The LeavePanel component.
     */
    @Override
    public LeavePanel getLeavePage_Comp() {
        return leavePanel;
    }

    /**
     * Retrieves the button for navigating to the MyProfilePanel.
     *
     * @return The MyProfile button component.
     */
    @Override
    public JButton getMyProfileBTN_Comp() {
        return myProfileBTN;
    }

    /**
     * Retrieves the button for navigating to the AttendancePanel.
     *
     * @return The Attendance button component.
     */
    @Override
    public JButton getAttendanceBTN_Comp() {
        return attendanceBTN;
    }

    /**
     * Retrieves the button for navigating to the LeavePanel.
     *
     * @return The Leave button component.
     */
    @Override
    public JButton getLeaveBTN_Comp() {
        return leaveBTN;
    }

    /**
     * Retrieves the button for navigating to the MyPayslipPanel.
     *
     * @return The Payslip button component.
     */
    @Override
    public JButton getPayslipBTN_Comp() {
        return payslipBTN;
    }

    /**
     * Retrieves the RunPayrollPanel component.
     *
     * @return The RunPayrollPanel component.
     */
    public RunPayrollPanel getPayrollPanel() {
        return payrollPanel;
    }

    /**
     * Retrieves the PayrollReportPanel component.
     *
     * @return The PayrollReportPanel component.
     */
    public PayrollReportPanel getReportPanel() {
        return reportPanel;
    }

    /**
     * Retrieves the button for logging out.
     *
     * @return The logout button component.
     */
    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    /**
     * Retrieves the button for navigating to the payroll report.
     *
     * @return The payroll report button component.
     */
    public JButton getPayrollReportBTN() {
        return payrollReportBTN;
    }

    /**
     * Retrieves the button for navigating to the run payroll panel.
     *
     * @return The run payroll button component.
     */
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        topBarPanel = new javax.swing.JPanel();
        motorPHmainLabel1 = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        myProfileBTN = new javax.swing.JButton();
        attendanceBTN = new javax.swing.JButton();
        payslipBTN = new javax.swing.JButton();
        leaveBTN = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        motorPHmainLabel2 = new javax.swing.JLabel();
        runPayrollBTN = new javax.swing.JButton();
        payrollReportBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MotorPH Employee Portal");
        setMinimumSize(new java.awt.Dimension(1300, 800));

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(myProfileBTN, gridBagConstraints);

        attendanceBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        attendanceBTN.setText("Attendance");
        attendanceBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        attendanceBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        attendanceBTN.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(attendanceBTN, gridBagConstraints);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attendanceBTN;
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
