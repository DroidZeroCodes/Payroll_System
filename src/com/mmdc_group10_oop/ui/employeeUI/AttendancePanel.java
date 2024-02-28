package com.mmdc_group10_oop.ui.employeeUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AttendancePanel extends javax.swing.JPanel {

    /**
     * Creates new form AttendancePanel
     */
    public AttendancePanel() {
        initComponents();
        //TODO: search button
    }

    //Getter methods to modify components


    public DefaultTableModel attendanceTableModel() {
        return attendanceTableModel;
    }

    public JButton clockInBTN() {
        return clockInBTN;
    }

    public JButton clockOutBTN() {
        return clockOutBTN;
    }

    public JTable attendanceTable() {
        return attendanceTable;
    }

    public JDateChooser recordDate() {
        return recordDate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        attendanceTableModel = (new javax.swing.table.DefaultTableModel(
                new Object [][]{},
                new String [] {
                      "Attendance ID","Date", "Employee ID", "LastName", "FirstName", "Time In", "Time Out", "Hours Worked", "Overtime Hours"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        jScrollPane2 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
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

        attendanceTable.setModel(attendanceTableModel);
        jScrollPane2.setViewportView(attendanceTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Attendance Record");

        clockInBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        clockInBTN.setText("Clock In");
        clockInBTN.setActionCommand("");

        clockOutBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        clockOutBTN.setText("Clock Out");

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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DefaultTableModel attendanceTableModel; //Manually Added
    private javax.swing.JButton clockInBTN;
    private javax.swing.JButton clockOutBTN;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable attendanceTable;
    private com.toedter.calendar.JDateChooser recordDate;
    // End of variables declaration//GEN-END:variables
}
