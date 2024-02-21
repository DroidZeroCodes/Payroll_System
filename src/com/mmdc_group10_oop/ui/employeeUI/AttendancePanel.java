package com.mmdc_group10_oop.ui.employeeUI;

public class AttendancePanel extends javax.swing.JPanel {

    /**
     * Creates new form AttendancePanel
     */
    public AttendancePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        clockInBTN = new javax.swing.JButton();
        clockOutBTN = new javax.swing.JButton();
        recordDate = new com.toedter.calendar.JDateChooser();

        setMaximumSize(new java.awt.Dimension(820, 700));
        setMinimumSize(new java.awt.Dimension(820, 700));
        setPreferredSize(new java.awt.Dimension(820, 700));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(550, 500));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(550, 500));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(550, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Time In", "Time Out", "Overtime Hours", "Hours Worked"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Attadance Record");

        clockInBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        clockInBTN.setText("Clock In");
        clockInBTN.setActionCommand("");
        clockInBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockInBTNActionPerformed(evt);
            }
        });

        clockOutBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        clockOutBTN.setText("Clock Out");
        clockOutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockOutBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clockInBTN)
                        .addGap(18, 18, 18)
                        .addComponent(clockOutBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recordDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recordDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clockOutBTN)
                    .addComponent(clockInBTN))
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clockInBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockInBTNActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_clockInBTNActionPerformed

    private void clockOutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockOutBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clockOutBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton clockInBTN;
    private javax.swing.JButton clockOutBTN;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser recordDate;
    // End of variables declaration//GEN-END:variables
}
