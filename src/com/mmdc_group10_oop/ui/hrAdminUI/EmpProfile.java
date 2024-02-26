package com.mmdc_group10_oop.ui.hrAdminUI;

import javax.swing.*;

public class EmpProfile extends javax.swing.JPanel {

    /**
     * Creates new form AddEmpPanel
     */
    public EmpProfile() {
        initComponents();
    }

    //Getter methods to modify components

    public JButton saveBTN() {
        return saveBTN;
    }

    public JTextField sssNoTextField() {
        return sssNoTextField;
    }

    public JTextField PhilhealthNoTxtField() {
        return PhilhealthNoTxtField;
    }

    public JTextArea addressTxtArea() {
        return addressTxtArea;
    }

    public JTextField basicSalaryTxtField() {
        return basicSalaryTxtField;
    }

    public JTextField birthdayTxtField() {
        return birthdayTxtField;
    }

    public JTextField clothingAllowanceTxtField() {
        return clothingAllowanceTxtField;
    }

    public JTextField departmentTxtField() {
        return departmentTxtField;
    }

    public JTextField empIDTxtField() {
        return empIDTxtField;
    }

    public JTextField hourlyRateTxtField() {
        return hourlyRateTxtField;
    }

    public JTextField nameTxtField() {
        return nameTxtField;
    }

    public JTextField pagibigNoTxtArea() {
        return pagibigNoTxtArea;
    }

    public JTextField phoneAllowanceTxtField() {
        return phoneAllowanceTxtField;
    }

    public JTextField phoneNoTxtField() {
        return phoneNoTxtField;
    }

    public JTextField positionTxtField() {
        return positionTxtField;
    }

    public JTextField riceSubsidyTxtField() {
        return riceSubsidyTxtField;
    }

    public JTextField semiMonthlyTxtField() {
        return semiMonthlyTxtField;
    }

    public JTextField statusTxtField() {
        return statusTxtField;
    }

    public JTextField supervisoTxtField() {
        return supervisoTxtField;
    }

    public JTextField tinNoTxtField() {
        return tinNoTxtField;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personalPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        birthdayTxtField = new javax.swing.JTextField();
        phoneNoLabel = new javax.swing.JLabel();
        phoneNoTxtField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTxtArea = new javax.swing.JTextArea();
        employmentPanel = new javax.swing.JPanel();
        empIDLabel = new javax.swing.JLabel();
        empIDTxtField = new javax.swing.JTextField();
        departmentLabel = new javax.swing.JLabel();
        departmentTxtField = new javax.swing.JTextField();
        positionLabel = new javax.swing.JLabel();
        positionTxtField = new javax.swing.JTextField();
        supervisorLabel = new javax.swing.JLabel();
        supervisoTxtField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusTxtField = new javax.swing.JTextField();
        payPanel = new javax.swing.JPanel();
        basicSalaryLabel = new javax.swing.JLabel();
        basicSalaryTxtField = new javax.swing.JTextField();
        hourlyRateLabel = new javax.swing.JLabel();
        hourlyRateTxtField = new javax.swing.JTextField();
        semiMonthlyLabel = new javax.swing.JLabel();
        semiMonthlyTxtField = new javax.swing.JTextField();
        riceSubsidyLabel = new javax.swing.JLabel();
        riceSubsidyTxtField = new javax.swing.JTextField();
        phoneAllowanceLabel = new javax.swing.JLabel();
        phoneAllowanceTxtField = new javax.swing.JTextField();
        clothingAllowanceLabel = new javax.swing.JLabel();
        clothingAllowanceTxtField = new javax.swing.JTextField();
        sssNoLabel = new javax.swing.JLabel();
        sssNoTextField = new javax.swing.JTextField();
        philhealthNoLabel = new javax.swing.JLabel();
        PhilhealthNoTxtField = new javax.swing.JTextField();
        pagibigNoLabel = new javax.swing.JLabel();
        pagibigNoTxtArea = new javax.swing.JTextField();
        tinNoLabel = new javax.swing.JLabel();
        tinNoTxtField = new javax.swing.JTextField();
        personalLabel = new javax.swing.JLabel();
        employmentLabel = new javax.swing.JLabel();
        payLabel = new javax.swing.JLabel();
        saveBTN = new javax.swing.JButton();

        personalPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nameLabel.setText("Name:");

        birthdayLabel.setText("Birthday:");

        phoneNoLabel.setText("Phone No.:");

        addressLabel.setText("Address:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        addressTxtArea.setColumns(20);
        addressTxtArea.setLineWrap(true);
        addressTxtArea.setRows(5);
        addressTxtArea.setAutoscrolls(false);
        jScrollPane1.setViewportView(addressTxtArea);

        javax.swing.GroupLayout personalPanelLayout = new javax.swing.GroupLayout(personalPanel);
        personalPanel.setLayout(personalPanelLayout);
        personalPanelLayout.setHorizontalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(birthdayTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(phoneNoTxtField)
                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTxtField))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        personalPanelLayout.setVerticalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(birthdayLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(birthdayTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phoneNoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(phoneNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addressLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        employmentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        employmentPanel.setMinimumSize(new java.awt.Dimension(320, 100));
        employmentPanel.setPreferredSize(new java.awt.Dimension(320, 0));

        empIDLabel.setText("Employee ID:");

        departmentLabel.setText("Department: ");

        positionLabel.setText("Position: ");

        supervisorLabel.setText("Supervisor: ");

        statusLabel.setText("Status: ");

        javax.swing.GroupLayout employmentPanelLayout = new javax.swing.GroupLayout(employmentPanel);
        employmentPanel.setLayout(employmentPanelLayout);
        employmentPanelLayout.setHorizontalGroup(
            employmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employmentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empIDTxtField)
                    .addComponent(departmentTxtField)
                    .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionTxtField)
                    .addComponent(supervisorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supervisoTxtField)
                    .addComponent(statusTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        employmentPanelLayout.setVerticalGroup(
            employmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employmentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(empIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(departmentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(departmentTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(positionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(positionTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supervisorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supervisoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        payPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        payPanel.setToolTipText("");
        payPanel.setMaximumSize(new java.awt.Dimension(660, 160));
        payPanel.setMinimumSize(new java.awt.Dimension(660, 160));

        basicSalaryLabel.setText("Basic Salary:");

        hourlyRateLabel.setText("Hourly Rate: ");

        semiMonthlyLabel.setText("Semi-Monthly Rate:");

        riceSubsidyLabel.setText("Rice Subsidy:");

        phoneAllowanceLabel.setText("Phone Allowance:");

        clothingAllowanceLabel.setText("Clothing Allowance: ");

        sssNoLabel.setText("SSS No.:");

        philhealthNoLabel.setText("Philhealth No.:");

        pagibigNoLabel.setText("Pagibig No.:");

        tinNoLabel.setText("TIN No.:");

        javax.swing.GroupLayout payPanelLayout = new javax.swing.GroupLayout(payPanel);
        payPanel.setLayout(payPanelLayout);
        payPanelLayout.setHorizontalGroup(
            payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, payPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(basicSalaryLabel)
                    .addComponent(hourlyRateLabel)
                    .addComponent(semiMonthlyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semiMonthlyTxtField)
                    .addComponent(hourlyRateTxtField)
                    .addComponent(basicSalaryTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(riceSubsidyLabel)
                        .addComponent(phoneAllowanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clothingAllowanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(riceSubsidyTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneAllowanceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clothingAllowanceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pagibigNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sssNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(philhealthNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sssNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhilhealthNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagibigNoTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tinNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tinNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        payPanelLayout.setVerticalGroup(
            payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basicSalaryLabel)
                    .addComponent(riceSubsidyLabel)
                    .addComponent(sssNoLabel)
                    .addComponent(tinNoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basicSalaryTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(riceSubsidyTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sssNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tinNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hourlyRateLabel)
                    .addComponent(phoneAllowanceLabel)
                    .addComponent(philhealthNoLabel))
                .addGap(5, 5, 5)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hourlyRateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneAllowanceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhilhealthNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semiMonthlyLabel)
                    .addComponent(clothingAllowanceLabel)
                    .addComponent(pagibigNoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semiMonthlyTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clothingAllowanceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagibigNoTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        personalLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        personalLabel.setText("Personal Profile");

        employmentLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        employmentLabel.setText("Employment Profile");

        payLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        payLabel.setText("Pay Profile");

        saveBTN.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(667, Short.MAX_VALUE)
                .addComponent(saveBTN)
                .addGap(81, 81, 81))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(payPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(personalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(personalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(employmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(employmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(payLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(79, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(saveBTN)
                .addContainerGap(646, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(personalLabel)
                        .addComponent(employmentLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(personalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(employmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(payLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(payPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PhilhealthNoTxtField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextArea addressTxtArea;
    private javax.swing.JLabel basicSalaryLabel;
    private javax.swing.JTextField basicSalaryTxtField;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField birthdayTxtField;
    private javax.swing.JLabel clothingAllowanceLabel;
    private javax.swing.JTextField clothingAllowanceTxtField;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JTextField departmentTxtField;
    private javax.swing.JLabel empIDLabel;
    private javax.swing.JTextField empIDTxtField;
    private javax.swing.JLabel employmentLabel;
    private javax.swing.JPanel employmentPanel;
    private javax.swing.JLabel hourlyRateLabel;
    private javax.swing.JTextField hourlyRateTxtField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JLabel pagibigNoLabel;
    private javax.swing.JTextField pagibigNoTxtArea;
    private javax.swing.JLabel payLabel;
    private javax.swing.JPanel payPanel;
    private javax.swing.JLabel personalLabel;
    private javax.swing.JPanel personalPanel;
    private javax.swing.JLabel philhealthNoLabel;
    private javax.swing.JLabel phoneAllowanceLabel;
    private javax.swing.JTextField phoneAllowanceTxtField;
    private javax.swing.JLabel phoneNoLabel;
    private javax.swing.JTextField phoneNoTxtField;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JTextField positionTxtField;
    private javax.swing.JLabel riceSubsidyLabel;
    private javax.swing.JTextField riceSubsidyTxtField;
    private javax.swing.JButton saveBTN;
    private javax.swing.JLabel semiMonthlyLabel;
    private javax.swing.JTextField semiMonthlyTxtField;
    private javax.swing.JLabel sssNoLabel;
    private javax.swing.JTextField sssNoTextField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusTxtField;
    private javax.swing.JTextField supervisoTxtField;
    private javax.swing.JLabel supervisorLabel;
    private javax.swing.JLabel tinNoLabel;
    private javax.swing.JTextField tinNoTxtField;
    // End of variables declaration//GEN-END:variables
}
