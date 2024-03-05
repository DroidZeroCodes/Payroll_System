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
        searchField = new javax.swing.JTextField();
        searchBTN = new javax.swing.JButton();
        deleteUserBTN = new javax.swing.JButton();
        clearBTN = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(820, 700));
        setMinimumSize(new java.awt.Dimension(820, 700));
        setPreferredSize(new java.awt.Dimension(820, 700));

        jScrollPane2.setViewportView(userCredentialTable);

        createUserBTN.setText("Create User");
        createUserBTN.setActionCommand("");

        createUserPanel.setBackground(new java.awt.Color(204, 204, 204));
        createUserPanel.setMaximumSize(new java.awt.Dimension(330, 200));
        createUserPanel.setMinimumSize(new java.awt.Dimension(330, 200));
        createUserPanel.setPreferredSize(new java.awt.Dimension(330, 200));

        empIDLabel.setText("Employee ID: ");

        empIDTxtField.setEditable(false);

        usernameLabel.setText("Username: ");

        passwordLabel.setText("Password: ");

        roleDropBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"EMPLOYEE", "PAYROLL_ADMIN", "HR_ADMIN", "IT_ADMIN"}));

        roleLabel.setText("Role: ");

        confirmPassLabel.setText("Confirm Password: ");

        lastModifiedLabel.setText("Last Modified: ");

        lastModifiedTxtField.setEditable(false);

        javax.swing.GroupLayout createUserPanelLayout = new javax.swing.GroupLayout(createUserPanel);
        createUserPanel.setLayout(createUserPanelLayout);
        createUserPanelLayout.setHorizontalGroup(
                createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createUserPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(empIDLabel)
                                        .addComponent(roleLabel)
                                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(empIDTxtField)
                                        .addComponent(usernameTxtField)
                                        .addComponent(roleDropBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(createUserPanelLayout.createSequentialGroup()
                                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(confirmPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lastModifiedLabel))
                                                .addGap(0, 7, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lastModifiedTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(confirmPassField)
                                        .addComponent(passwordField))
                                .addGap(45, 45, 45))
        );
        createUserPanelLayout.setVerticalGroup(
                createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createUserPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(createUserPanelLayout.createSequentialGroup()
                                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordLabel))
                                                .addGap(15, 15, 15)
                                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(confirmPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(confirmPassLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lastModifiedLabel)
                                                        .addComponent(lastModifiedTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(createUserPanelLayout.createSequentialGroup()
                                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(empIDLabel)
                                                        .addComponent(empIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15)
                                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(usernameLabel)
                                                        .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(roleDropBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(roleLabel))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        createUserPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{confirmPassField, empIDTxtField, lastModifiedTxtField, passwordField, roleDropBox, usernameTxtField});

        updateUserBTN.setText("Update");

        searchBTN.setText("Search");

        deleteUserBTN.setText("Delete");

        clearBTN.setText("Clear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(searchBTN))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(createUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(createUserBTN)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(updateUserBTN)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(clearBTN)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deleteUserBTN)))))
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchBTN)
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(createUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createUserBTN)
                                        .addComponent(deleteUserBTN)
                                        .addComponent(updateUserBTN)
                                        .addComponent(clearBTN))
                                .addGap(50, 50, 50))
        );
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastModifiedLabel;
    private javax.swing.JTextField lastModifiedTxtField;
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
