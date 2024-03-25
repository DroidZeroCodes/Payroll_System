package ui.it;

import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;
import ui.interfaces.DynamicComponents;

import javax.swing.*;

/**
 * Represents the user interface for IT administrators, providing access to various employee management functionalities.
 * Users can view their profile, attendance, payslip, leave, and manage other users.
 * <p>
 * Available methods:
 * - {@link #getMyProfilePage_Comp()} Returns the component for the My Profile page.
 * - {@link #getAttendancePage_Comp()} Returns the component for the Attendance page.
 * - {@link #getPayslipPage_Comp()} Returns the component for the Payslip page.
 * - {@link #getLeavePage_Comp()} Returns the component for the Leave page.
 * - {@link #getAttendanceBTN_Comp()} Returns the button for accessing the Attendance page.
 * - {@link #getLeaveBTN_Comp()} Returns the button for accessing the Leave page.
 * - {@link #getMyProfileBTN_Comp()} Returns the button for accessing the My Profile page.
 * - {@link #getPayslipBTN_Comp()} Returns the button for accessing the Payslip page.
 * - {@link #getLogoutBtn()} Returns the button for logging out.
 * - {@link #getMngUserBTN()} Returns the button for managing users.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "MagicConstant", "DataFlowIssue", "FieldMayBeFinal"})


public class ITAdminUI extends javax.swing.JFrame implements DynamicComponents {
    private MyProfilePanel myProfilePanel;
    private AttendancePanel attendancePanel;
    private MyPayslipPanel payslipPanel;
    private LeavePanel leavePanel;
    private ManageUserPanel manageUserPanel;

    /**
     * Constructs a new instance of the ITAdminUI class.
     */
    public ITAdminUI() {
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
            java.util.logging.Logger.getLogger(ITAdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        initComponents();
        setLocationRelativeTo(null);
        setResizable(true);
        initializePanels();
    }

    /**
     * Initializes the panels for the different functionalities.
     */
    private void initializePanels() {
        myProfilePanel = new MyProfilePanel();
        attendancePanel = new AttendancePanel();
        payslipPanel = new MyPayslipPanel();
        leavePanel = new LeavePanel();
        manageUserPanel = new ManageUserPanel();

        mainPanel.add(myProfilePanel, "profile");
        mainPanel.add(attendancePanel, "attendance");
        mainPanel.add(payslipPanel, "payslip");
        mainPanel.add(leavePanel, "leave");
        mainPanel.add(manageUserPanel, "Manage Users");
    }

    /**
     * Retrieves the component representing the My Profile page.
     *
     * @return The MyProfilePanel component.
     */
    @Override
    public MyProfilePanel getMyProfilePage_Comp() {
        return myProfilePanel;
    }

    /**
     * Retrieves the component representing the Attendance page.
     *
     * @return The AttendancePanel component.
     */
    @Override
    public AttendancePanel getAttendancePage_Comp() {
        return attendancePanel;
    }

    /**
     * Retrieves the component representing the Payslip page.
     *
     * @return The MyPayslipPanel component.
     */
    @Override
    public MyPayslipPanel getPayslipPage_Comp() {
        return payslipPanel;
    }

    /**
     * Retrieves the component representing the Leave page.
     *
     * @return The LeavePanel component.
     */
    @Override
    public LeavePanel getLeavePage_Comp() {
        return leavePanel;
    }

    /**
     * Retrieves the button for navigating to the Attendance page.
     *
     * @return The Attendance button component.
     */
    @Override
    public JButton getAttendanceBTN_Comp() {
        return attendanceBTN;
    }

    /**
     * Retrieves the button for navigating to the Leave page.
     *
     * @return The Leave button component.
     */
    @Override
    public JButton getLeaveBTN_Comp() {
        return leaveBTN;
    }

    /**
     * Retrieves the button for navigating to the My Profile page.
     *
     * @return The My Profile button component.
     */
    @Override
    public JButton getMyProfileBTN_Comp() {
        return myProfileBTN;
    }

    /**
     * Retrieves the button for navigating to the Payslip page.
     *
     * @return The Payslip button component.
     */
    @Override
    public JButton getPayslipBTN_Comp() {
        return payslipBTN;
    }

    /**
     * Retrieves the logout button.
     *
     * @return The logout button component.
     */
    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    /**
     * Retrieves the button for managing users.
     *
     * @return The Manage User button component.
     */
    public JButton getMngUserBTN() {
        return mngUserBTN;
    }

    /**
     * Retrieves the panel for managing users.
     *
     * @return The ManageUserPanel component.
     */
    public ManageUserPanel getManageUserPanel() {
        return manageUserPanel;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        myProfileBTN = new javax.swing.JButton();
        attendanceBTN = new javax.swing.JButton();
        payslipBTN = new javax.swing.JButton();
        leaveBTN = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        motorPHmainLabel1 = new javax.swing.JLabel();
        mngUserBTN = new javax.swing.JButton();
        motorPHmainLabel2 = new javax.swing.JLabel();
        topBarPanel = new javax.swing.JPanel();
        motorPHmainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MotorPH Employee Portal");
        setMinimumSize(new java.awt.Dimension(1300, 800));
        setPreferredSize(new java.awt.Dimension(1300, 800));

        mainPanel.setMaximumSize(new java.awt.Dimension(820, 700));
        mainPanel.setMinimumSize(new java.awt.Dimension(820, 700));
        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(attendanceBTN, gridBagConstraints);

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
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 35, 0);
        sidePanel.add(logoutBtn, gridBagConstraints);

        motorPHmainLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 20)); // NOI18N
        motorPHmainLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/channels4_profile (1).png"))); // NOI18N
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

        mngUserBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        mngUserBTN.setText("Users");
        mngUserBTN.setMinimumSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidePanel.add(mngUserBTN, gridBagConstraints);

        motorPHmainLabel2.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        motorPHmainLabel2.setText("Welcome IT Admin");
        motorPHmainLabel2.setAlignmentY(0.0F);
        motorPHmainLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        motorPHmainLabel2.setIconTextGap(0);
        motorPHmainLabel2.setPreferredSize(new java.awt.Dimension(165, 125));
        motorPHmainLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        sidePanel.add(motorPHmainLabel2, gridBagConstraints);

        getContentPane().add(sidePanel, java.awt.BorderLayout.WEST);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attendanceBTN;
    private javax.swing.JButton leaveBTN;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton mngUserBTN;
    private javax.swing.JLabel motorPHmainLabel;
    private javax.swing.JLabel motorPHmainLabel1;
    private javax.swing.JLabel motorPHmainLabel2;
    private javax.swing.JButton myProfileBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel topBarPanel;
    // End of variables declaration//GEN-END:variables
}
