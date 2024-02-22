/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.HRAdminUI;


public class ManageEmpPanel extends javax.swing.JPanel {
    
    private EmpProfile empProfile;
    
    public ManageEmpPanel() {
        initComponents();
        empProfile = new EmpProfile();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        empRecordTable = new javax.swing.JTable();
        addEmpBTN = new javax.swing.JButton();
        updateEmpBTN = new javax.swing.JButton();
        TermEmpBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchBTN = new javax.swing.JButton();

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        empRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Department", "Position", "Supervisor", "Status"
            }
        ));
        jScrollPane2.setViewportView(empRecordTable);

        addEmpBTN.setText("Add");
        addEmpBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmpBTNActionPerformed(evt);
            }
        });

        updateEmpBTN.setText("Update");
        updateEmpBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmpBTNActionPerformed(evt);
            }
        });

        TermEmpBTN.setText("Terminate");
        TermEmpBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TermEmpBTNActionPerformed(evt);
            }
        });

        searchBTN.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addEmpBTN)
                        .addGap(18, 18, 18)
                        .addComponent(updateEmpBTN)
                        .addGap(18, 18, 18)
                        .addComponent(TermEmpBTN))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TermEmpBTN, addEmpBTN, updateEmpBTN});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TermEmpBTN)
                    .addComponent(updateEmpBTN)
                    .addComponent(addEmpBTN))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TermEmpBTN, addEmpBTN, updateEmpBTN});

    }// </editor-fold>//GEN-END:initComponents

    private void TermEmpBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TermEmpBTNActionPerformed

    }//GEN-LAST:event_TermEmpBTNActionPerformed

    private void addEmpBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmpBTNActionPerformed
        this.setVisible(false);
        empProfile.setVisible(true);
    }//GEN-LAST:event_addEmpBTNActionPerformed

    private void updateEmpBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmpBTNActionPerformed
        this.setVisible(false);
        empProfile.setVisible(true);
    }//GEN-LAST:event_updateEmpBTNActionPerformed

    public javax.swing.JButton getTermEmpBTN(){
        return this.TermEmpBTN;
    }
    
    public javax.swing.JButton getaddEmpBTN(){
    
        return this.addEmpBTN;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TermEmpBTN;
    private javax.swing.JButton addEmpBTN;
    private javax.swing.JTable empRecordTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateEmpBTN;
    // End of variables declaration//GEN-END:variables
}
