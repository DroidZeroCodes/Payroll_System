package com.mmdc_group10_oop.ui.ITAdminUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ibra
 */
public class ManageUserPanel extends javax.swing.JPanel {

    private DefaultTableModel mngUserTableModel;
    
    public ManageUserPanel() {
        initComponents();
        intializeTableModel();
    }
    
    @SuppressWarnings("unchecked")
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
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();
        lastModifiedLabel = new javax.swing.JLabel();
        lastModifiedTxtField = new javax.swing.JTextField();
        updateUserBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchBTN = new javax.swing.JButton();
        deleteUserBTN = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(820, 700));
        setMinimumSize(new java.awt.Dimension(820, 700));
        setPreferredSize(new java.awt.Dimension(820, 700));

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

        createUserBTN.setText("Create User");
        createUserBTN.setActionCommand("");

        createUserPanel.setBackground(new java.awt.Color(204, 204, 204));
        createUserPanel.setMaximumSize(new java.awt.Dimension(330, 200));
        createUserPanel.setMinimumSize(new java.awt.Dimension(330, 200));
        createUserPanel.setPreferredSize(new java.awt.Dimension(330, 200));

        empIDLabel.setText("Employee ID: ");

        usernameLabel.setText("Username: ");

        passwordLabel.setText("Password: ");

        roleDropBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLOYEE", "PAYROLL_ADMIN", "HR_ADMIN", "IT_ADMIN" }));

        roleLabel.setText("Role: ");

        confirmPassLabel.setText("Confirm Password: ");

        passwordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordField1ActionPerformed(evt);
            }
        });

        lastModifiedLabel.setText("Last Modified: ");

        lastModifiedTxtField.setEditable(false);

        javax.swing.GroupLayout createUserPanelLayout = new javax.swing.GroupLayout(createUserPanel);
        createUserPanel.setLayout(createUserPanelLayout);
        createUserPanelLayout.setHorizontalGroup(
            createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createUserPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empIDLabel)
                    .addComponent(roleLabel)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(usernameTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empIDTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleDropBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(createUserPanelLayout.createSequentialGroup()
                        .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastModifiedLabel))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lastModifiedTxtField)
                    .addComponent(passwordField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(193, 193, 193))
        );

        createUserPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {empIDTxtField, lastModifiedTxtField, passwordField1, passwordField2, roleDropBox, usernameTxtField});

        createUserPanelLayout.setVerticalGroup(
            createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createUserPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createUserPanelLayout.createSequentialGroup()
                        .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empIDLabel)
                            .addComponent(empIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLabel)
                            .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(createUserPanelLayout.createSequentialGroup()
                        .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel))
                        .addGap(15, 15, 15)
                        .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmPassLabel))))
                .addGap(18, 18, 18)
                .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(roleDropBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roleLabel)
                        .addComponent(lastModifiedLabel))
                    .addComponent(lastModifiedTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        createUserPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {empIDTxtField, lastModifiedTxtField, passwordField1, passwordField2, roleDropBox, usernameTxtField});

        updateUserBTN.setText("Update");

        searchBTN.setText("Search");

        deleteUserBTN.setText("Delete");
        deleteUserBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(deleteUserBTN)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBTN)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(createUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserBTN)
                    .addComponent(deleteUserBTN)
                    .addComponent(updateUserBTN))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteUserBTNActionPerformed(ActionEvent evt) {
    }

    private void passwordField1ActionPerformed(ActionEvent evt) {
    }

    public void intializeTableModel(){
        mngUserTableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Employee ID", "Username", "Password", "Position", "Department", "Role"
            }
        );
        userCredentialTable.setModel(mngUserTableModel);
    }
    
    public DefaultTableModel mngUserTableModel() {
        return mngUserTableModel;
    }
    
    public JButton createUserBTN() {
        return createUserBTN;
    }
    public JTextField empIDTxtField() {
        return empIDTxtField;
    }

    public JTable userCredentialTable() {
        return userCredentialTable;
    }

    public JPasswordField passwordField1() {
        return passwordField1;
    }

    public JPasswordField passwordField2() {
        return passwordField2;
    }

    public JComboBox<String> roleDropBox() {
        return roleDropBox;
    }
    public JButton searchBTN() {
        return searchBTN;
    }

    public JButton deleteUserBTN() {
        return deleteUserBTN;
    }

    public JTextField lastModifiedTxtField() {
        return lastModifiedTxtField;
    }

    public JTextField searchField() {
        return searchField;
    }

    public JButton updateUserBTN() {
        return updateUserBTN;
    }

    public JTextField usernameTxtField() {
        return usernameTxtField;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmPassLabel;
    private javax.swing.JButton createUserBTN;
    private javax.swing.JPanel createUserPanel;
    private javax.swing.JButton deleteUserBTN;
    private javax.swing.JLabel empIDLabel;
    private javax.swing.JTextField empIDTxtField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastModifiedLabel;
    private javax.swing.JTextField lastModifiedTxtField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
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
