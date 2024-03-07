package ui.hr;

import ui.GeneralComponents;
import ui.employee.AttendancePanel;
import ui.employee.LeavePanel;
import ui.employee.MyPayslipPanel;
import ui.employee.MyProfilePanel;

import javax.swing.*;

public class HRAdminUI extends javax.swing.JFrame implements GeneralComponents {
    private MyProfilePanel myProfilePanel;
    private AttendancePanel attendancePanel;
    private MyPayslipPanel payslipPanel;
    private LeavePanel leavePanel;
    private ManageEmpPanel employeeManagementPanel;
    private ProfileManagementPanel profileManagementPanel;
    private LeaveInfoFrame leaveInfoFrame;

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
        setResizable(false);
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

        mainPanel.add(myProfilePanel, "profile");
        mainPanel.add(attendancePanel, "attendance");
        mainPanel.add(payslipPanel, "payslip");
        mainPanel.add(leavePanel, "leave");
        mainPanel.add(employeeManagementPanel, "Manage Employees");
        mainPanel.add(profileManagementPanel, "Employee Profile");
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
        payslipBTN.setText("PayrollRecords");

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

        sidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{attedanceBTN, leaveBTN, logoutBtn, mngEmpBTN, myProfileBTN, payslipBTN});

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

        sidePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{attedanceBTN, leaveBTN, logoutBtn, myProfileBTN, payslipBTN});

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 700));

        mainPanel.setMaximumSize(new java.awt.Dimension(820, 700));
        mainPanel.setMinimumSize(new java.awt.Dimension(820, 700));
        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 820, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JButton myProfileBTN;
    private javax.swing.JButton payslipBTN;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}


