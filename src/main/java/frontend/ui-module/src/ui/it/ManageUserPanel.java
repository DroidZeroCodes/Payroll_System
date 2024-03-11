package ui.it;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Ibra
 */
public class ManageUserPanel extends javax.swing.JPanel {
    private TableRowSorter<DefaultTableModel> userTableSorter;
    private DefaultTableModel mngUserTableModel;

    public ManageUserPanel() {
        initComponents();
        initializeTableModel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        userCredentialTable = new javax.swing.JTable();
        createUserBTN = new javax.swing.JButton();
        createUserPanel = new javax.swing.JPanel();
        empIDLabel = new javax.swing.JLabel();
        empIDTxtField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameTxtField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        roleDropBox = new javax.swing.JComboBox<>();
        roleLabel = new javax.swing.JLabel();
        confirmPassLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPassField = new javax.swing.JPasswordField();
        lastModifiedLabel = new javax.swing.JLabel();
        lastModifiedTxtField = new javax.swing.JTextField();
        updateUserBTN = new javax.swing.JButton();
        deleteUserBTN = new javax.swing.JButton();
        clearBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        myPayslipLabel = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(244, 245, 247));
        setPreferredSize(new java.awt.Dimension(1135, 700));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.GridBagLayout());

        userCredentialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Employee ID", "Position", "Department", "Role"
            }
        ));
        jScrollPane2.setViewportView(userCredentialTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 666;
        gridBagConstraints.ipady = 353;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 15, 50);
        add(jScrollPane2, gridBagConstraints);

        createUserBTN.setText("Create User");
        createUserBTN.setActionCommand("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 50, 50, 0);
        add(createUserBTN, gridBagConstraints);

        createUserPanel.setBackground(new java.awt.Color(249, 249, 249));
        createUserPanel.setMinimumSize(new java.awt.Dimension(330, 150));
        createUserPanel.setPreferredSize(new java.awt.Dimension(330, 150));
        createUserPanel.setLayout(new java.awt.GridBagLayout());

        empIDLabel.setText("Employee ID: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 100, 8, 15);
        createUserPanel.add(empIDLabel, gridBagConstraints);

        empIDTxtField.setMinimumSize(new java.awt.Dimension(250, 30));
        empIDTxtField.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        createUserPanel.add(empIDTxtField, gridBagConstraints);

        usernameLabel.setText("Username: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 100, 8, 15);
        createUserPanel.add(usernameLabel, gridBagConstraints);

        usernameTxtField.setMinimumSize(new java.awt.Dimension(250, 30));
        usernameTxtField.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        createUserPanel.add(usernameTxtField, gridBagConstraints);

        passwordLabel.setText("Password: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 18, 8, 15);
        createUserPanel.add(passwordLabel, gridBagConstraints);

        roleDropBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLOYEE", "PAYROLL_ADMIN", "HR_ADMIN", "IT_ADMIN" }));
        roleDropBox.setMinimumSize(new java.awt.Dimension(250, 30));
        roleDropBox.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        createUserPanel.add(roleDropBox, gridBagConstraints);

        roleLabel.setText("Role: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 100, 8, 15);
        createUserPanel.add(roleLabel, gridBagConstraints);

        confirmPassLabel.setText("Confirm Password: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 18, 8, 15);
        createUserPanel.add(confirmPassLabel, gridBagConstraints);

        passwordField.setMinimumSize(new java.awt.Dimension(250, 30));
        passwordField.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 100);
        createUserPanel.add(passwordField, gridBagConstraints);

        confirmPassField.setMinimumSize(new java.awt.Dimension(250, 30));
        confirmPassField.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 100);
        createUserPanel.add(confirmPassField, gridBagConstraints);

        lastModifiedLabel.setText("Last Modified: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 18, 8, 15);
        createUserPanel.add(lastModifiedLabel, gridBagConstraints);

        lastModifiedTxtField.setEditable(false);
        lastModifiedTxtField.setMinimumSize(new java.awt.Dimension(250, 30));
        lastModifiedTxtField.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 100);
        createUserPanel.add(lastModifiedTxtField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 15, 50);
        add(createUserPanel, gridBagConstraints);

        updateUserBTN.setText("Update");
        updateUserBTN.setMaximumSize(new java.awt.Dimension(90, 23));
        updateUserBTN.setMinimumSize(new java.awt.Dimension(90, 23));
        updateUserBTN.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 50, 0);
        add(updateUserBTN, gridBagConstraints);

        deleteUserBTN.setText("Delete");
        deleteUserBTN.setMaximumSize(new java.awt.Dimension(90, 23));
        deleteUserBTN.setMinimumSize(new java.awt.Dimension(90, 23));
        deleteUserBTN.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 50, 52);
        add(deleteUserBTN, gridBagConstraints);

        clearBTN.setText("Clear");
        clearBTN.setMaximumSize(new java.awt.Dimension(90, 23));
        clearBTN.setMinimumSize(new java.awt.Dimension(90, 23));
        clearBTN.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 50, 20);
        add(clearBTN, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        myPayslipLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        myPayslipLabel.setText("USER MANAGEMENT");
        myPayslipLabel.setMaximumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setMinimumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(36, 50, 34, 19);
        jPanel1.add(myPayslipLabel, gridBagConstraints);

        searchBTN.setText("Search");
        searchBTN.setMaximumSize(new java.awt.Dimension(90, 23));
        searchBTN.setMinimumSize(new java.awt.Dimension(90, 23));
        searchBTN.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 50);
        jPanel1.add(searchBTN, gridBagConstraints);

        searchField.setMinimumSize(new java.awt.Dimension(200, 30));
        searchField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(searchField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    public void initializeTableModel() {
        mngUserTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Employee ID", "Username", "Password", "Position", "Department", "Role", "Last Modified"
                }
        );

        userTableSorter = new TableRowSorter<>(mngUserTableModel);
        userCredentialTable.setRowSorter(userTableSorter);
        userCredentialTable.setModel(mngUserTableModel);
    }

    public JTextField getEmpIDTxtField() {
        return empIDTxtField;
    }

    public JTable getUserCredentialTable() {
        return userCredentialTable;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConfirmPassField() {
        return confirmPassField;
    }

    public JComboBox<String> getRoleDropBox() {
        return roleDropBox;
    }

    public JTextField getLastModifiedTxtField() {
        return lastModifiedTxtField;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getUpdateUserBTN() {
        return updateUserBTN;
    }

    public JTextField getUsernameTxtField() {
        return usernameTxtField;
    }

    public DefaultTableModel getMngUserTableModel() {
        return mngUserTableModel;
    }

    public JButton getCreateUserBTN() {
        return createUserBTN;
    }

    public JButton getDeleteUserBTN() {
        return deleteUserBTN;
    }

    public JButton getSearchBTN() {
        return searchBTN;
    }

    public JButton getClearBTN() {
        return clearBTN;
    }

    public TableRowSorter<DefaultTableModel> getUserTableSorter() {
        return userTableSorter;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBTN;
    private javax.swing.JPasswordField confirmPassField;
    private javax.swing.JLabel confirmPassLabel;
    private javax.swing.JButton createUserBTN;
    private javax.swing.JPanel createUserPanel;
    private javax.swing.JButton deleteUserBTN;
    private javax.swing.JLabel empIDLabel;
    private javax.swing.JTextField empIDTxtField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastModifiedLabel;
    private javax.swing.JTextField lastModifiedTxtField;
    private javax.swing.JLabel myPayslipLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox<String> roleDropBox;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateUserBTN;
    private javax.swing.JTable userCredentialTable;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTxtField;
    // End of variables declaration//GEN-END:variables
}
