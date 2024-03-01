package hr;

import service.actions.EmployeeRecord;
import user.HRAdmin;
import ui.LoginUI;
import ui.employeeUI.AttendancePanel;
import ui.employeeUI.LeavePanel;
import ui.employeeUI.MyPayslipPanel;
import ui.employeeUI.MyProfilePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.YearMonth;

public class HRAdminUI extends javax.swing.JFrame {
    private MyProfilePanel empProfilePanel;
    private AttendancePanel empAttendancePanel;
    private MyPayslipPanel empPayslipPanel;
    private LeavePanel empLeavePanel;
    private ManageEmpPanel manageEmpPanel;
    private ProfileManagementPanel profileManagementPanel;
    private final HRAdmin hrAdmin;

    public HRAdminUI(int employeeID) {
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

    private void actions(){
        //Side Menu Actions
        myProfileBTN.addActionListener(e -> {
            resetPanelVisibility();
            hrAdmin.displayProfile();
            empProfilePanel.setVisible(true);
        });

        attedanceBTN.addActionListener(e -> {
            resetPanelVisibility();
            hrAdmin.displayAttendanceRecord();
            empAttendancePanel.setVisible(true);
        });

        leaveBTN.addActionListener(e -> {
            resetPanelVisibility();
            hrAdmin.displayLeaveBalance();
            hrAdmin.displayLeaveHistory();
            empLeavePanel.setVisible(true);
        });

        payslipBTN.addActionListener(e -> {
            resetPanelVisibility();
            YearMonth yearMonth = YearMonth.now();
            hrAdmin.displayPayslip(yearMonth);
            empPayslipPanel.setVisible(true);
        });

        mngEmpBTN.addActionListener(e -> {
            resetPanelVisibility();
            hrAdmin.displayEmployeeList();
            manageEmpPanel.setVisible(true);
        });

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginUI().setVisible(true);
        });

        //Panel Actions
        empAttendancePanel.clockInBTN().addActionListener(e -> hrAdmin.clockIn());
        empAttendancePanel.clockOutBTN().addActionListener(e -> hrAdmin.clockOut());

        //Manage Employee Panel
        manageEmpPanel.addEmpBTN().addActionListener(e -> {
            profileManagementPanel.saveBTN().setText("Save");

            Integer[] employeeIDList = new EmployeeRecord().retrieveEmployeeIDList();
            String employeeID = employeeIDList[employeeIDList.length - 1] + 1 + "";

            profileManagementPanel.empIDTxtField().setEditable(false);
            profileManagementPanel.empIDTxtField().setText(employeeID);
            resetPanelVisibility();
            profileManagementPanel.setVisible(true);
        });

        manageEmpPanel.updateEmpBTN().addActionListener(e -> {
            profileManagementPanel.saveBTN().setText("Update");


            JTable table = manageEmpPanel.empRecordTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {
                table.setSelectionBackground(Color.YELLOW);
                table.setSelectionForeground(Color.BLACK);

                profileManagementPanel.empIDTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 0)));
                profileManagementPanel.lastNameTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 1)));
                profileManagementPanel.firstNameTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 2)));
                profileManagementPanel.birthdayTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 3)));
                profileManagementPanel.addressTxtArea().setText(String.valueOf(model.getValueAt(selectedRow, 4)));
                profileManagementPanel.phoneNoTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 5)));

                profileManagementPanel.sssNoTextField().setText(String.valueOf(model.getValueAt(selectedRow, 6)));
                profileManagementPanel.philHealthNoTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 7)));
                profileManagementPanel.pagibigNoTxtArea().setText(String.valueOf(model.getValueAt(selectedRow, 8)));
                profileManagementPanel.tinNoTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 9)));

                profileManagementPanel.departmentTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 10)));
                profileManagementPanel.positionTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 11)));
                profileManagementPanel.supervisorTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 12)));
                profileManagementPanel.statusTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 13)));

                profileManagementPanel.basicSalaryTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 14)));
                profileManagementPanel.riceSubsidyTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 15)));
                profileManagementPanel.phoneAllowanceTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 16)));
                profileManagementPanel.clothingAllowanceTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 17)));
                profileManagementPanel.semiMonthlyTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 18)));
                profileManagementPanel.hourlyRateTxtField().setText(String.valueOf(model.getValueAt(selectedRow, 19)));
            }

            manageEmpPanel.setVisible(false);
            profileManagementPanel.setVisible(true);
            manageEmpPanel.updateEmpBTN().setEnabled(false);
        });

        manageEmpPanel.TermEmpBTN().addActionListener(e -> {
            //Add logic
        });

        //Profile Management Panel
        profileManagementPanel.saveBTN().addActionListener(e -> {
            if (profileManagementPanel.saveBTN().getText().equals("Save")) {
                hrAdmin.addEmployee();
            } else if (profileManagementPanel.saveBTN().getText().equals("Update")) {
                hrAdmin.updateEmployee();
            }
            hrAdmin.addEmployee();
        });
    }
    public void enableAdminActions(){
        empPayslipPanel.setSearchVisibility(true);
//        profileManagementPanel.set
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

    public ManageEmpPanel manageEmpPanel() {
        return manageEmpPanel;
    }

    public ProfileManagementPanel profileManagementPanel() {
        return profileManagementPanel;
    }

    // This method intializes the panels
        private void initializePanels() {
        empProfilePanel = new MyProfilePanel();
        empAttendancePanel = new AttendancePanel();
        empPayslipPanel = new MyPayslipPanel();
        empLeavePanel = new LeavePanel();
        manageEmpPanel = new ManageEmpPanel();
        profileManagementPanel = new ProfileManagementPanel();
        
        mainPanel.add(empProfilePanel, "profile");
        mainPanel.add(empAttendancePanel, "attendance");
        mainPanel.add(empPayslipPanel, "payslip");
        mainPanel.add(empLeavePanel, "leave");
        mainPanel.add(manageEmpPanel, "Manage Employees");
        mainPanel.add(profileManagementPanel, "Employee Profile");
    }

    //Method to set panels visible
    private void resetPanelVisibility() {
        empProfilePanel.setVisible(false);
        empAttendancePanel.setVisible(false);
        empPayslipPanel.setVisible(false);
        empLeavePanel.setVisible(false);
        manageEmpPanel.setVisible(false);
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

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            HRAdminUI frame = null;
            frame = new HRAdminUI(6);
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


