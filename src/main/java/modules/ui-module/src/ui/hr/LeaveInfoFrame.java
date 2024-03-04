/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.hr;

/**
 *
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

        leaveInfoMainPanel = new javax.swing.JPanel();
        empIDLabel = new javax.swing.JLabel();
        empIDTxtField = new javax.swing.JTextField();
        empNameLabel = new javax.swing.JLabel();
        empNameTxtField = new javax.swing.JTextField();
        supervisorLabel = new javax.swing.JLabel();
        superVisorTxtField = new javax.swing.JTextField();
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
        reasonLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonTxtArea = new javax.swing.JTextArea();
        approveBTN = new javax.swing.JButton();
        rejectBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));

        leaveInfoMainPanel.setBackground(new java.awt.Color(204, 204, 204));
        leaveInfoMainPanel.setMaximumSize(new java.awt.Dimension(500, 360));
        leaveInfoMainPanel.setMinimumSize(new java.awt.Dimension(500, 360));
        leaveInfoMainPanel.setPreferredSize(new java.awt.Dimension(500, 360));

        empIDLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        empIDLabel.setText("Employee ID:");

        empNameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        empNameLabel.setText("Employee Name:");

        supervisorLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        supervisorLabel.setText("Supervisor:");

        departmentLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        departmentLabel.setText("Department:");

        leaveIDLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveIDLabel.setText("Leave ID:");

        startDateLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        startDateLabel.setText("Start Date: ");

        endDataLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        endDataLabel.setText("End Date: ");

        durationLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        durationLabel.setText("Duration:");

        reasonLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        reasonLabel.setText("Reason:");

        reasonTxtArea.setColumns(20);
        reasonTxtArea.setRows(5);
        jScrollPane1.setViewportView(reasonTxtArea);

        approveBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        approveBTN.setText("Approve");

        rejectBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        rejectBTN.setText("Reject");

        javax.swing.GroupLayout leaveInfoMainPanelLayout = new javax.swing.GroupLayout(leaveInfoMainPanel);
        leaveInfoMainPanel.setLayout(leaveInfoMainPanelLayout);
        leaveInfoMainPanelLayout.setHorizontalGroup(
            leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(approveBTN)
                        .addGap(18, 18, 18)
                        .addComponent(rejectBTN))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leaveInfoMainPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                                .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addComponent(reasonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83))
                                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addComponent(empNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(empNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addComponent(empIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(empIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addComponent(supervisorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(superVisorTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(departmentTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addComponent(endDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(endDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addComponent(durationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(durationTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leaveInfoMainPanelLayout.createSequentialGroup()
                                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(leaveIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(startDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(startDateTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(leaveIDTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(49, 49, 49))
        );

        leaveInfoMainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {departmentLabel, empIDLabel, empNameLabel, reasonLabel, supervisorLabel});

        leaveInfoMainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {departmentTxtField, durationTxtField, empIDTxtField, empNameTxtField, endDateTxtField, leaveIDTxtField, superVisorTxtField});

        leaveInfoMainPanelLayout.setVerticalGroup(
            leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leaveIDLabel)
                            .addComponent(leaveIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateLabel)
                            .addComponent(startDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDataLabel))
                        .addGap(18, 18, 18)
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(durationTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(durationLabel)))
                    .addGroup(leaveInfoMainPanelLayout.createSequentialGroup()
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empIDLabel)
                            .addComponent(empIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empNameLabel)
                            .addComponent(empNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supervisorLabel)
                            .addComponent(superVisorTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(departmentTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departmentLabel))))
                .addGap(18, 18, 18)
                .addComponent(reasonLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(leaveInfoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveBTN)
                    .addComponent(rejectBTN))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        leaveInfoMainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {departmentLabel, durationLabel, empIDLabel, empNameLabel, endDataLabel, reasonLabel, startDateLabel, supervisorLabel});

        leaveInfoMainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {departmentTxtField, durationTxtField, empIDTxtField, empNameTxtField, endDateTxtField, leaveIDTxtField, superVisorTxtField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leaveInfoMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leaveInfoMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeaveInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaveInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaveInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBTN;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leaveIDLabel;
    private javax.swing.JTextField leaveIDTxtField;
    private javax.swing.JPanel leaveInfoMainPanel;
    private javax.swing.JLabel reasonLabel;
    private javax.swing.JTextArea reasonTxtArea;
    private javax.swing.JButton rejectBTN;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTxtField;
    private javax.swing.JTextField superVisorTxtField;
    private javax.swing.JLabel supervisorLabel;
    // End of variables declaration//GEN-END:variables
}