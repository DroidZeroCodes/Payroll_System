package ui;

import actions.EmployeeViewHandler;
import actions.HRAdminViewHandler;
import actions.ITAdminViewHandler;
import actions.PayrollAdminViewHandler;
import exceptions.SystemLoginException;
import interfaces.UserCredentialsDataService;
import logic.AuthenticationLogic;
import roles.Employee;
import roles.HRAdmin;
import roles.ITAdmin;
import roles.PayrollAdmin;
import service.FileDataService;
import ui.employee.EmployeeUI;
import ui.hr.HRAdminUI;
import ui.it.ITAdminUI;
import ui.payroll.PayrollAdminUI;

import javax.swing.*;

public class LoginUI extends javax.swing.JFrame {
    private final AuthenticationLogic authLogic;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel motorphLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTxtField;

    public LoginUI(AuthenticationLogic authLogic) {
        this.authLogic = authLogic;
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void initUI() {
        loginButton.addActionListener(this::loginButtonActionPerformed);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameTxtField.getText();
        String password = new String(passwordField.getPassword());

        boolean loginSuccessful = true;
        try {
            loginSuccessful = authLogic.login(username, password);
        } catch (SystemLoginException e) {
            System.out.println("Could not login: " + e.getMessage());
        }

        if (loginSuccessful) {
            dispose();
            int employeeID = authLogic.getEmployeeID(username);
            String role = authLogic.getUserRole(username);
            switch (role) {
                case "EMPLOYEE":
                    showEmployeeUI(employeeID);
                    break;
                case "HR_ADMIN":
                    showHRAdminUI(employeeID);
                    break;
                case "PAYROLL_ADMIN":
                    showPayrollAdminUI(employeeID);
                    break;
                case "IT_ADMIN":
                    showITAdminUI(employeeID);
                    break;
                default:
                    // Handle invalid role
            }
        }
    }

    private void showEmployeeUI(int employeeID) {
        Employee employee = new Employee(new FileDataService(), employeeID);
        EmployeeUI employeeUI = new EmployeeUI();
        new EmployeeViewHandler(employee, employeeUI);
        showUI(employeeUI);
    }

    private void showHRAdminUI(int employeeID) {
        HRAdmin hrAdmin = new HRAdmin(new FileDataService(), employeeID);
        HRAdminUI hrAdminUI = new HRAdminUI();
        new HRAdminViewHandler(hrAdmin, hrAdminUI);
        showUI(hrAdminUI);
    }

    private void showPayrollAdminUI(int employeeID) {
        PayrollAdmin payrollAdmin = new PayrollAdmin(new FileDataService(), employeeID);
        PayrollAdminUI payrollAdminUI = new PayrollAdminUI();
        new PayrollAdminViewHandler(payrollAdmin, payrollAdminUI);
        showUI(payrollAdminUI);
    }

    private void showITAdminUI(int employeeID) {
        ITAdmin itAdmin = new ITAdmin(new FileDataService(), employeeID);
        ITAdminUI itAdminUI = new ITAdminUI();
        new ITAdminViewHandler(itAdmin, itAdminUI);
        showUI(itAdminUI);
    }

    private void showUI(javax.swing.JFrame ui) {
        ui.setVisible(true);
        if (ui instanceof EmployeeUI) {
            ((EmployeeUI) ui).getLogoutBtn().addActionListener(e -> {
                ui.dispose();
                LoginUI.main(null);
            });
        } else if (ui instanceof HRAdminUI) {
            ((HRAdminUI) ui).getLogoutBtn().addActionListener(e -> {
                ui.dispose();
                LoginUI.main(null);
            });
        } else if (ui instanceof ITAdminUI) {
            ((ITAdminUI) ui).getLogoutBtn().addActionListener(e -> {
                ui.dispose();
                LoginUI.main(null);
            });
        } else if (ui instanceof PayrollAdminUI) {
            ((PayrollAdminUI) ui).getLogoutBtn().addActionListener(e -> {
                ui.dispose();
                LoginUI.main(null);
            });
        }
    }

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserCredentialsDataService userCredentialsDataService = new FileDataService();
                AuthenticationLogic authenticationLogic = new AuthenticationLogic(userCredentialsDataService);
                LoginUI loginUI = new LoginUI(authenticationLogic);
                loginUI.initUI();
                loginUI.setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        motorphLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameTxtField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        motorphLabel.setFont(new java.awt.Font("Magneto", 0, 36)); // NOI18N
        motorphLabel.setText("MotorPH");
        jPanel1.add(motorphLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 190, 60));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        loginButton.setText("Login");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passwordLabel)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(usernameLabel)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addComponent(loginButton)))
                                .addGap(105, 105, 105))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, passwordField, usernameTxtField);

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, passwordLabel, usernameLabel);

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(loginButton)
                                .addContainerGap(112, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, passwordField, usernameTxtField);

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, passwordLabel, usernameLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables
}
