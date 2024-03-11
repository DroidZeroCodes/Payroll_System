package ui.hr;

import javax.swing.*;

public class ProfileManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddEmpPanel
     */
    public ProfileManagementPanel() {
        initComponents();
    }

    //Getter methods to modify components

    public JButton getSaveBTN() {
        return saveBTN;
    }

    public JButton getCancelBTN() {
        return cancelBTN;
    }

    public JTextField lastNameTxtField() {
        return lastNameTxtField;
    }

    public JTextField firstNameTxtField() {
        return firstNameTxtField;
    }

    public JTextField sssNoTextField() {
        return sssNoTextField;
    }

    public JTextField philHealthNoTxtField() {
        return philHealthNoTxtField;
    }

    public JTextField addressTxtField() {
        return addressTxtField;
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

    public JTextField pagibigNoTxtArea() {
        return pagibigNoTxtField;
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

    public JTextField supervisorTxtField() {
        return supervisoTxtField;
    }

    public JTextField tinNoTxtField() {
        return tinNoTxtField;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        myPayslipLabel = new javax.swing.JLabel();
        cancelBTN = new javax.swing.JButton();
        saveBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        sssNoLabel = new javax.swing.JLabel();
        sssNoTextField = new javax.swing.JTextField();
        philhealthNoLabel = new javax.swing.JLabel();
        philHealthNoTxtField = new javax.swing.JTextField();
        pagibigNoLabel = new javax.swing.JLabel();
        pagibigNoTxtField = new javax.swing.JTextField();
        tinNoTxtField = new javax.swing.JTextField();
        tinNoLabel = new javax.swing.JLabel();
        contributionIDsLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        riceSubsidyLabel = new javax.swing.JLabel();
        riceSubsidyTxtField = new javax.swing.JTextField();
        phoneAllowanceLabel = new javax.swing.JLabel();
        clothingAllowanceLabel = new javax.swing.JLabel();
        clothingAllowanceTxtField = new javax.swing.JTextField();
        phoneAllowanceTxtField = new javax.swing.JTextField();
        allowancesLabel = new javax.swing.JLabel();
        payPanel = new javax.swing.JPanel();
        basicSalaryLabel = new javax.swing.JLabel();
        basicSalaryTxtField = new javax.swing.JTextField();
        hourlyRateLabel = new javax.swing.JLabel();
        hourlyRateTxtField = new javax.swing.JTextField();
        semiMonthlyLabel = new javax.swing.JLabel();
        semiMonthlyTxtField = new javax.swing.JTextField();
        payLabel = new javax.swing.JLabel();
        employmentPanel = new javax.swing.JPanel();
        empIDLabel1 = new javax.swing.JLabel();
        empIDTxtField = new javax.swing.JTextField();
        departmentLabel1 = new javax.swing.JLabel();
        departmentTxtField = new javax.swing.JTextField();
        positionLabel = new javax.swing.JLabel();
        positionTxtField = new javax.swing.JTextField();
        supervisorLabel1 = new javax.swing.JLabel();
        supervisoTxtField = new javax.swing.JTextField();
        statusLabel1 = new javax.swing.JLabel();
        statusTxtField = new javax.swing.JTextField();
        payLabel1 = new javax.swing.JLabel();
        personalPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        lastNameTxtField = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        birthdayTxtField = new javax.swing.JTextField();
        phoneNoLabel = new javax.swing.JLabel();
        addressTxtField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        phoneNoTxtField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        firstNameTxtField = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(1135, 900));
        setPreferredSize(new java.awt.Dimension(1135, 900));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(1135, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(1135, 900));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        myPayslipLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        myPayslipLabel.setText("EMPLOYEE MANAGEMENT");
        myPayslipLabel.setMaximumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setMinimumSize(new java.awt.Dimension(350, 30));
        myPayslipLabel.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(36, 50, 34, 19);
        jPanel2.add(myPayslipLabel, gridBagConstraints);

        cancelBTN.setText("Cancel");
        cancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 30);
        jPanel2.add(cancelBTN, gridBagConstraints);

        saveBTN.setText("Save");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 50);
        jPanel2.add(saveBTN, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(249, 249, 249));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(249, 249, 249), new java.awt.Color(102, 102, 102)));
        jPanel4.setMinimumSize(new java.awt.Dimension(533, 220));
        jPanel4.setPreferredSize(new java.awt.Dimension(533, 220));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        sssNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        sssNoLabel.setText("SSS NO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel4.add(sssNoLabel, gridBagConstraints);

        sssNoTextField.setBackground(new java.awt.Color(229, 229, 229));
        sssNoTextField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        sssNoTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sssNoTextField.setMinimumSize(new java.awt.Dimension(250, 20));
        sssNoTextField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 63, 5, 0);
        jPanel4.add(sssNoTextField, gridBagConstraints);

        philhealthNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        philhealthNoLabel.setText("PHILHEALTH NO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel4.add(philhealthNoLabel, gridBagConstraints);

        philHealthNoTxtField.setBackground(new java.awt.Color(229, 229, 229));
        philHealthNoTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        philHealthNoTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        philHealthNoTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        philHealthNoTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 63, 5, 0);
        jPanel4.add(philHealthNoTxtField, gridBagConstraints);

        pagibigNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        pagibigNoLabel.setText("PAGIBIG NO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel4.add(pagibigNoLabel, gridBagConstraints);

        pagibigNoTxtField.setBackground(new java.awt.Color(229, 229, 229));
        pagibigNoTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        pagibigNoTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pagibigNoTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        pagibigNoTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 63, 5, 0);
        jPanel4.add(pagibigNoTxtField, gridBagConstraints);

        tinNoTxtField.setBackground(new java.awt.Color(229, 229, 229));
        tinNoTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tinNoTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tinNoTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        tinNoTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        tinNoTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinNoTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 63, 5, 0);
        jPanel4.add(tinNoTxtField, gridBagConstraints);

        tinNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        tinNoLabel.setText("TIN NO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        jPanel4.add(tinNoLabel, gridBagConstraints);

        contributionIDsLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        contributionIDsLabel.setText("Contribution ID's");
        contributionIDsLabel.setMinimumSize(new java.awt.Dimension(250, 25));
        contributionIDsLabel.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 0);
        jPanel4.add(contributionIDsLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 18, 50);
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(249, 249, 249));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(249, 249, 249), new java.awt.Color(102, 102, 102)));
        jPanel3.setMinimumSize(new java.awt.Dimension(533, 200));
        jPanel3.setPreferredSize(new java.awt.Dimension(533, 200));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        riceSubsidyLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        riceSubsidyLabel.setText("RICE SUBSIDY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        jPanel3.add(riceSubsidyLabel, gridBagConstraints);

        riceSubsidyTxtField.setBackground(new java.awt.Color(229, 229, 229));
        riceSubsidyTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        riceSubsidyTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        riceSubsidyTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        riceSubsidyTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        jPanel3.add(riceSubsidyTxtField, gridBagConstraints);

        phoneAllowanceLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        phoneAllowanceLabel.setText("PHONE ALLOWANCE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        jPanel3.add(phoneAllowanceLabel, gridBagConstraints);

        clothingAllowanceLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        clothingAllowanceLabel.setText("CLOTHING ALLOWANCE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        jPanel3.add(clothingAllowanceLabel, gridBagConstraints);

        clothingAllowanceTxtField.setBackground(new java.awt.Color(229, 229, 229));
        clothingAllowanceTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        clothingAllowanceTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        clothingAllowanceTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        clothingAllowanceTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        jPanel3.add(clothingAllowanceTxtField, gridBagConstraints);

        phoneAllowanceTxtField.setBackground(new java.awt.Color(229, 229, 229));
        phoneAllowanceTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        phoneAllowanceTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        phoneAllowanceTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        phoneAllowanceTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        jPanel3.add(phoneAllowanceTxtField, gridBagConstraints);

        allowancesLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        allowancesLabel.setText("Allowances");
        allowancesLabel.setMinimumSize(new java.awt.Dimension(250, 25));
        allowancesLabel.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 0);
        jPanel3.add(allowancesLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 39, 50);
        jPanel1.add(jPanel3, gridBagConstraints);

        payPanel.setBackground(new java.awt.Color(249, 249, 249));
        payPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(249, 249, 249), new java.awt.Color(102, 102, 102)));
        payPanel.setToolTipText("");
        payPanel.setMinimumSize(new java.awt.Dimension(533, 200));
        payPanel.setPreferredSize(new java.awt.Dimension(533, 200));
        payPanel.setLayout(new java.awt.GridBagLayout());

        basicSalaryLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        basicSalaryLabel.setText("BASIC SALARY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        payPanel.add(basicSalaryLabel, gridBagConstraints);

        basicSalaryTxtField.setBackground(new java.awt.Color(229, 229, 229));
        basicSalaryTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        basicSalaryTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        basicSalaryTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        basicSalaryTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        payPanel.add(basicSalaryTxtField, gridBagConstraints);

        hourlyRateLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        hourlyRateLabel.setText("HOURLY RATE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        payPanel.add(hourlyRateLabel, gridBagConstraints);

        hourlyRateTxtField.setBackground(new java.awt.Color(229, 229, 229));
        hourlyRateTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        hourlyRateTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hourlyRateTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        hourlyRateTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        payPanel.add(hourlyRateTxtField, gridBagConstraints);

        semiMonthlyLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        semiMonthlyLabel.setText("SEMI-MONTHLY RATE");
        semiMonthlyLabel.setMinimumSize(new java.awt.Dimension(200, 15));
        semiMonthlyLabel.setPreferredSize(new java.awt.Dimension(150, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        payPanel.add(semiMonthlyLabel, gridBagConstraints);

        semiMonthlyTxtField.setBackground(new java.awt.Color(229, 229, 229));
        semiMonthlyTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        semiMonthlyTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        semiMonthlyTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        semiMonthlyTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 15, 0);
        payPanel.add(semiMonthlyTxtField, gridBagConstraints);

        payLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        payLabel.setText("Salary");
        payLabel.setMinimumSize(new java.awt.Dimension(250, 25));
        payLabel.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 0);
        payPanel.add(payLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 50, 39, 50);
        jPanel1.add(payPanel, gridBagConstraints);

        employmentPanel.setBackground(new java.awt.Color(249, 249, 249));
        employmentPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(249, 249, 249), new java.awt.Color(102, 102, 102)));
        employmentPanel.setMinimumSize(new java.awt.Dimension(533, 220));
        employmentPanel.setPreferredSize(new java.awt.Dimension(533, 220));
        employmentPanel.setLayout(new java.awt.GridBagLayout());

        empIDLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        empIDLabel1.setText("EMPLOYEE ID");
        empIDLabel1.setMinimumSize(new java.awt.Dimension(200, 15));
        empIDLabel1.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(empIDLabel1, gridBagConstraints);

        empIDTxtField.setBackground(new java.awt.Color(229, 229, 229));
        empIDTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        empIDTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        empIDTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        empIDTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 74, 5, 0);
        employmentPanel.add(empIDTxtField, gridBagConstraints);

        departmentLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        departmentLabel1.setText("DEPARTMENT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(departmentLabel1, gridBagConstraints);

        departmentTxtField.setBackground(new java.awt.Color(229, 229, 229));
        departmentTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        departmentTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        departmentTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        departmentTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 74, 5, 0);
        employmentPanel.add(departmentTxtField, gridBagConstraints);

        positionLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        positionLabel.setText("POSITION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(positionLabel, gridBagConstraints);

        positionTxtField.setBackground(new java.awt.Color(229, 229, 229));
        positionTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        positionTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        positionTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        positionTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 74, 5, 0);
        employmentPanel.add(positionTxtField, gridBagConstraints);

        supervisorLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        supervisorLabel1.setText("SUPERVISOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(supervisorLabel1, gridBagConstraints);

        supervisoTxtField.setBackground(new java.awt.Color(229, 229, 229));
        supervisoTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        supervisoTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        supervisoTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        supervisoTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 74, 5, 0);
        employmentPanel.add(supervisoTxtField, gridBagConstraints);

        statusLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        statusLabel1.setText("STATUS ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        employmentPanel.add(statusLabel1, gridBagConstraints);

        statusTxtField.setBackground(new java.awt.Color(229, 229, 229));
        statusTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        statusTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusTxtField.setMinimumSize(new java.awt.Dimension(250, 20));
        statusTxtField.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 74, 5, 0);
        employmentPanel.add(statusTxtField, gridBagConstraints);

        payLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        payLabel1.setText("Employment");
        payLabel1.setMinimumSize(new java.awt.Dimension(250, 25));
        payLabel1.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 0);
        employmentPanel.add(payLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 50, 18, 50);
        jPanel1.add(employmentPanel, gridBagConstraints);

        personalPanel.setBackground(new java.awt.Color(249, 249, 249));
        personalPanel.setMinimumSize(new java.awt.Dimension(10, 185));
        personalPanel.setPreferredSize(new java.awt.Dimension(10, 185));
        personalPanel.setLayout(new java.awt.GridBagLayout());

        nameLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        nameLabel.setText("LAST NAME");
        nameLabel.setMinimumSize(new java.awt.Dimension(100, 20));
        nameLabel.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        personalPanel.add(nameLabel, gridBagConstraints);

        lastNameTxtField.setBackground(new java.awt.Color(229, 229, 229));
        lastNameTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        lastNameTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lastNameTxtField.setMinimumSize(new java.awt.Dimension(350, 20));
        lastNameTxtField.setPreferredSize(new java.awt.Dimension(350, 20));
        lastNameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 3, 4, 0);
        personalPanel.add(lastNameTxtField, gridBagConstraints);

        birthdayLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        birthdayLabel.setText("DOB");
        birthdayLabel.setMinimumSize(new java.awt.Dimension(100, 20));
        birthdayLabel.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        personalPanel.add(birthdayLabel, gridBagConstraints);

        birthdayTxtField.setBackground(new java.awt.Color(229, 229, 229));
        birthdayTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        birthdayTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        birthdayTxtField.setMinimumSize(new java.awt.Dimension(350, 20));
        birthdayTxtField.setPreferredSize(new java.awt.Dimension(350, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 3, 4, 0);
        personalPanel.add(birthdayTxtField, gridBagConstraints);

        phoneNoLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        phoneNoLabel.setText("PHONE NO");
        phoneNoLabel.setMinimumSize(new java.awt.Dimension(100, 20));
        phoneNoLabel.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        personalPanel.add(phoneNoLabel, gridBagConstraints);

        addressTxtField.setBackground(new java.awt.Color(229, 229, 229));
        addressTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        addressTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addressTxtField.setMinimumSize(new java.awt.Dimension(350, 20));
        addressTxtField.setPreferredSize(new java.awt.Dimension(350, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 3, 4, 0);
        personalPanel.add(addressTxtField, gridBagConstraints);

        addressLabel.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        addressLabel.setText("ADDRESS");
        addressLabel.setMinimumSize(new java.awt.Dimension(100, 20));
        addressLabel.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        personalPanel.add(addressLabel, gridBagConstraints);

        phoneNoTxtField.setBackground(new java.awt.Color(229, 229, 229));
        phoneNoTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        phoneNoTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        phoneNoTxtField.setMinimumSize(new java.awt.Dimension(350, 20));
        phoneNoTxtField.setPreferredSize(new java.awt.Dimension(350, 20));
        phoneNoTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 3, 4, 0);
        personalPanel.add(phoneNoTxtField, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setMinimumSize(new java.awt.Dimension(125, 125));
        jPanel5.setPreferredSize(new java.awt.Dimension(125, 125));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/userIcon.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        personalPanel.add(jPanel5, gridBagConstraints);

        nameLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        nameLabel1.setText("FIRST NAME");
        nameLabel1.setMinimumSize(new java.awt.Dimension(100, 20));
        nameLabel1.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        personalPanel.add(nameLabel1, gridBagConstraints);

        firstNameTxtField.setBackground(new java.awt.Color(229, 229, 229));
        firstNameTxtField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        firstNameTxtField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        firstNameTxtField.setMinimumSize(new java.awt.Dimension(350, 20));
        firstNameTxtField.setPreferredSize(new java.awt.Dimension(350, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 3, 4, 0);
        personalPanel.add(firstNameTxtField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        jPanel1.add(personalPanel, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBTNActionPerformed

    private void tinNoTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinNoTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tinNoTxtFieldActionPerformed

    private void lastNameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTxtFieldActionPerformed

    private void phoneNoTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoTxtFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTxtField;
    private javax.swing.JLabel allowancesLabel;
    private javax.swing.JLabel basicSalaryLabel;
    private javax.swing.JTextField basicSalaryTxtField;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField birthdayTxtField;
    private javax.swing.JButton cancelBTN;
    private javax.swing.JLabel clothingAllowanceLabel;
    private javax.swing.JTextField clothingAllowanceTxtField;
    private javax.swing.JLabel contributionIDsLabel;
    private javax.swing.JLabel departmentLabel1;
    private javax.swing.JTextField departmentTxtField;
    private javax.swing.JLabel empIDLabel1;
    private javax.swing.JTextField empIDTxtField;
    private javax.swing.JPanel employmentPanel;
    private javax.swing.JTextField firstNameTxtField;
    private javax.swing.JLabel hourlyRateLabel;
    private javax.swing.JTextField hourlyRateTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameTxtField;
    private javax.swing.JLabel myPayslipLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel pagibigNoLabel;
    private javax.swing.JTextField pagibigNoTxtField;
    private javax.swing.JLabel payLabel;
    private javax.swing.JLabel payLabel1;
    private javax.swing.JPanel payPanel;
    private javax.swing.JPanel personalPanel;
    private javax.swing.JTextField philHealthNoTxtField;
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
    private javax.swing.JLabel statusLabel1;
    private javax.swing.JTextField statusTxtField;
    private javax.swing.JTextField supervisoTxtField;
    private javax.swing.JLabel supervisorLabel1;
    private javax.swing.JLabel tinNoLabel;
    private javax.swing.JTextField tinNoTxtField;
    // End of variables declaration//GEN-END:variables
}
