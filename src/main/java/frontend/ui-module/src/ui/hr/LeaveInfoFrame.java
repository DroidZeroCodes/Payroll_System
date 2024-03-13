package ui.hr;

import javax.swing.*;

/**
 * @author Ibra
 */
public class LeaveInfoFrame extends javax.swing.JFrame {

    /**
     * Creates new form LeaveInfoPanel
     */
    public LeaveInfoFrame() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        leaveInfoMainPanel = new javax.swing.JPanel();
        empIDLabel = new javax.swing.JLabel();
        empIDTxtField = new javax.swing.JTextField();
        empNameLabel = new javax.swing.JLabel();
        empNameTxtField = new javax.swing.JTextField();
        supervisorLabel = new javax.swing.JLabel();
        supervisorTxtField = new javax.swing.JTextField();
        departmentLabel = new javax.swing.JLabel();
        departmentTxtField = new javax.swing.JTextField();
        leaveIDLabel = new javax.swing.JLabel();
        leaveIDTxtField = new javax.swing.JTextField();
        startDateLabel = new javax.swing.JLabel();
        startDateTxtField = new javax.swing.JTextField();
        endDataLabel = new javax.swing.JLabel();
        endDateTxtField = new javax.swing.JTextField();
        durationLabel = new javax.swing.JLabel();
        durationTxtField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonTxtArea = new javax.swing.JTextArea();
        approveBTN = new javax.swing.JButton();
        rejectBTN = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        statusTxtField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeTxtField = new javax.swing.JTextField();
        requestDateLabel = new javax.swing.JLabel();
        requestDateTxtField = new javax.swing.JTextField();
        backBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        leaveInfoMainPanel.setMinimumSize(new java.awt.Dimension(700, 600));
        leaveInfoMainPanel.setPreferredSize(new java.awt.Dimension(700, 600));
        leaveInfoMainPanel.setRequestFocusEnabled(false);
        leaveInfoMainPanel.setLayout(new java.awt.GridBagLayout());

        empIDLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        empIDLabel.setText("Employee ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 49, 0, 0);
        leaveInfoMainPanel.add(empIDLabel, gridBagConstraints);

        empIDTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 50);
        leaveInfoMainPanel.add(empIDTxtField, gridBagConstraints);

        empNameLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        empNameLabel.setText("Employee Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        leaveInfoMainPanel.add(empNameLabel, gridBagConstraints);

        empNameTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 50);
        leaveInfoMainPanel.add(empNameTxtField, gridBagConstraints);

        supervisorLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        supervisorLabel.setText("Supervisor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        leaveInfoMainPanel.add(supervisorLabel, gridBagConstraints);

        supervisorTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 50);
        leaveInfoMainPanel.add(supervisorTxtField, gridBagConstraints);

        departmentLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        departmentLabel.setText("Department:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        leaveInfoMainPanel.add(departmentLabel, gridBagConstraints);

        departmentTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        leaveInfoMainPanel.add(departmentTxtField, gridBagConstraints);

        leaveIDLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        leaveIDLabel.setText("Leave ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 49, 0, 0);
        leaveInfoMainPanel.add(leaveIDLabel, gridBagConstraints);

        leaveIDTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        leaveInfoMainPanel.add(leaveIDTxtField, gridBagConstraints);

        startDateLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        startDateLabel.setText("Start Date: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 49, 0, 0);
        leaveInfoMainPanel.add(startDateLabel, gridBagConstraints);

        startDateTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 50);
        leaveInfoMainPanel.add(startDateTxtField, gridBagConstraints);

        endDataLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        endDataLabel.setText("End Date: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 49, 0, 0);
        leaveInfoMainPanel.add(endDataLabel, gridBagConstraints);

        endDateTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 50);
        leaveInfoMainPanel.add(endDateTxtField, gridBagConstraints);

        durationLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        durationLabel.setText("Duration:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 49, 0, 0);
        leaveInfoMainPanel.add(durationLabel, gridBagConstraints);

        durationTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 50);
        leaveInfoMainPanel.add(durationTxtField, gridBagConstraints);

        reasonTxtArea.setEditable(false);
        reasonTxtArea.setColumns(20);
        reasonTxtArea.setRows(5);
        jScrollPane1.setViewportView(reasonTxtArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 566;
        gridBagConstraints.ipady = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 50, 0, 50);
        leaveInfoMainPanel.add(jScrollPane1, gridBagConstraints);

        approveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        approveBTN.setText("Approve");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 9, 50);
        leaveInfoMainPanel.add(approveBTN, gridBagConstraints);

        rejectBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        rejectBTN.setText("Reject");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 9, 0);
        leaveInfoMainPanel.add(rejectBTN, gridBagConstraints);

        statusLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        statusLabel.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        leaveInfoMainPanel.add(statusLabel, gridBagConstraints);

        statusTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 50);
        leaveInfoMainPanel.add(statusTxtField, gridBagConstraints);

        typeLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        typeLabel.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        leaveInfoMainPanel.add(typeLabel, gridBagConstraints);

        typeTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        leaveInfoMainPanel.add(typeTxtField, gridBagConstraints);

        requestDateLabel.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        requestDateLabel.setText("Request Date: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        leaveInfoMainPanel.add(requestDateLabel, gridBagConstraints);

        requestDateTxtField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        leaveInfoMainPanel.add(requestDateTxtField, gridBagConstraints);

        backBTN.setText("Back");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 50, 20, 0);
        leaveInfoMainPanel.add(backBTN, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        jLabel1.setText("Reason:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        leaveInfoMainPanel.add(jLabel1, gridBagConstraints);

        getContentPane().add(leaveInfoMainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaveInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaveInfoFrame().setVisible(true);
            }
        });
    }

    public JButton getApproveBTN() {
        return approveBTN;
    }

    public JButton getBackBTN() {
        return backBTN;
    }

    public JTextField getDepartmentTxtField() {
        return departmentTxtField;
    }

    public JTextField getDurationTxtField() {
        return durationTxtField;
    }

    public JTextField getEmpIDTxtField() {
        return empIDTxtField;
    }

    public JTextField getEmpNameTxtField() {
        return empNameTxtField;
    }

    public JTextField getEndDateTxtField() {
        return endDateTxtField;
    }

    public JTextField getLeaveIDTxtField() {
        return leaveIDTxtField;
    }

    public JTextArea getReasonTxtArea() {
        return reasonTxtArea;
    }

    public JButton getRejectBTN() {
        return rejectBTN;
    }

    public JTextField getStartDateTxtField() {
        return startDateTxtField;
    }

    public JTextField getSupervisorTxtField() {
        return supervisorTxtField;
    }

    public JTextField getStatusTxtField() {
        return statusTxtField;
    }

    public JTextField getTypeTxtField() {
        return typeTxtField;
    }

    public JTextField getRequestDateTxtField() {
        return requestDateTxtField;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBTN;
    private javax.swing.JButton backBTN;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JTextField departmentTxtField;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationTxtField;
    private javax.swing.JLabel empIDLabel;
    private javax.swing.JTextField empIDTxtField;
    private javax.swing.JLabel empNameLabel;
    private javax.swing.JTextField empNameTxtField;
    private javax.swing.JLabel endDataLabel;
    private javax.swing.JTextField endDateTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leaveIDLabel;
    private javax.swing.JTextField leaveIDTxtField;
    private javax.swing.JPanel leaveInfoMainPanel;
    private javax.swing.JTextArea reasonTxtArea;
    private javax.swing.JButton rejectBTN;
    private javax.swing.JLabel requestDateLabel;
    private javax.swing.JTextField requestDateTxtField;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTxtField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusTxtField;
    private javax.swing.JLabel supervisorLabel;
    private javax.swing.JTextField supervisorTxtField;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JTextField typeTxtField;
    // End of variables declaration//GEN-END:variables


}