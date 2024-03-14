package frontend.ui.login;


import exceptions.SystemLoginException;
import frontend.ui.employee.EmployeeUI;
import frontend.ui.hr.HRAdminUI;
import frontend.ui.it.ITAdminUI;
import frontend.ui.payroll.PayrollAdminUI;
import interfaces.UserCredentialsDataService;
import logic.AuthenticationLogic;
import service.FileDataService;
import users.actions.EmployeeViewHandler;
import users.actions.HRAdminViewHandler;
import users.actions.ITAdminViewHandler;
import users.actions.PayrollAdminViewHandler;
import users.roles.Employee;
import users.roles.HRAdmin;
import users.roles.ITAdmin;
import users.roles.PayrollAdmin;

import javax.swing.*;

/**
 * Represents the login user interface.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal", "MagicConstant", "FieldMayBeFinal"})
public class LoginUI extends javax.swing.JFrame {

    /**
     * The authentication logic.
     */
    private final AuthenticationLogic authLogic;

    /**
     * Creates a new login user interface.
     *
     * @param authLogic the authentication logic
     */
    public LoginUI(AuthenticationLogic authLogic) {
        this.authLogic = authLogic;
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Initializes the user interface.
     */
    private void initUI() {
        loginButton.addActionListener(this::loginButtonActionPerformed);
    }

    /**
     * Performs the login action when the login button is clicked.
     *
     * @param evt the action event triggered by the login button
     */
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

    /**
     * Show the employee user interface.
     *
     * @param employeeID the ID of the employee
     */
    private void showEmployeeUI(int employeeID) {
        Employee employee = new Employee(new FileDataService(), employeeID);
        EmployeeUI employeeUI = new EmployeeUI();
        new EmployeeViewHandler(employee, employeeUI);
        showUI(employeeUI);
    }

    /**
     * Show the HR admin user interface.
     *
     * @param employeeID the ID of the employee
     */
    private void showHRAdminUI(int employeeID) {
        HRAdmin hrAdmin = new HRAdmin(new FileDataService(), employeeID);
        HRAdminUI hrAdminUI = new HRAdminUI();
        new HRAdminViewHandler(hrAdmin, hrAdminUI);
        showUI(hrAdminUI);
    }

    /**
     * Show the payroll admin user interface.
     *
     * @param employeeID the ID of the employee
     */
    private void showPayrollAdminUI(int employeeID) {
        PayrollAdmin payrollAdmin = new PayrollAdmin(new FileDataService(), employeeID);
        PayrollAdminUI payrollAdminUI = new PayrollAdminUI();
        new PayrollAdminViewHandler(payrollAdmin, payrollAdminUI);
        showUI(payrollAdminUI);
    }

    /**
     * Show the IT admin user interface.
     *
     * @param employeeID the ID of the employee
     */
    private void showITAdminUI(int employeeID) {
        ITAdmin itAdmin = new ITAdmin(new FileDataService(), employeeID);
        ITAdminUI itAdminUI = new ITAdminUI();
        new ITAdminViewHandler(itAdmin, itAdminUI);
        showUI(itAdminUI);
    }

    /**
     * Show the user interface.
     *
     * @param ui the user interface
     */
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


    /**
     * Launch the application.
     *
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> {
            UserCredentialsDataService userCredentialsDataService = new FileDataService();
            AuthenticationLogic authenticationLogic = new AuthenticationLogic(userCredentialsDataService);
            LoginUI loginUI = new LoginUI(authenticationLogic);
            loginUI.initUI();
            loginUI.setVisible(true);
        });
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel motorphLabel = new JLabel();
        JPanel jPanel2 = new JPanel();
        JLabel usernameLabel = new JLabel();
        usernameTxtField = new javax.swing.JTextField();
        JLabel passwordLabel = new JLabel();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTxtField;
    // End of variables declaration//GEN-END:variables
}
