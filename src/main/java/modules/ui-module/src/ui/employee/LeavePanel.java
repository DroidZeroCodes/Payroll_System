package ui.employee;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;

public class LeavePanel extends javax.swing.JPanel {

    /**
     * Creates new form LeavePanel
     */
    DefaultTableModel leaveHistoryModel; 
    TableRowSorter<DefaultTableModel> leaveHistoryTableSorter;
    
    public LeavePanel() {
        initComponents();
        initTable();
    }

    public void initTable() {
        leaveHistoryTable = new javax.swing.JTable();
        leaveHistoryModel = (new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Leave ID", "Employee ID", "Request Date", "LeaveType", "Start Date", "End Date", "Duration", "Reason", "Status"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        leaveHistoryTableSorter = new TableRowSorter<>(leaveHistoryModel);
        leaveHistoryTableSorter.setComparator(1, Comparator.reverseOrder());
        leaveHistoryTable.setRowSorter(leaveHistoryTableSorter);
    }

    //Getter methods to modify the components

    public DefaultTableModel leaveHistoryModel() {
        return leaveHistoryModel;
    }

    public JButton submitBTN() {
        return submitBTN;
    }

    public JComboBox<String> leaveTypeComboBox() {
        return leaveTypeComboBox;
    }

    public JDateChooser startDateChooser() {
        return startDateChooser;
    }

    public JDateChooser endDateChooser() {
        return endDateChooser;
    }

    public JTextArea leaveReasonsTxtArea() {
        return leaveReasonsTxtArea;
    }

    public JTextField sickLeaveTxtField() {
        return sickLeaveTxtField;
    }

    public JTextField vacationLeaveTxtField() {
        return vaccationLeaveTxtField;
    }

    public JTextField paternityLeaveTxtField() {
        return paternityLeaveTxtField;
    }

    public JTextField bereavementLeaveTxtField() {
        return bereavementLeaveTxtField;
    }

    public JTable getLeaveHistoryTable() {
        return leaveHistoryTable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestLeaveLabel = new javax.swing.JLabel();
        requestLeavePanel = new javax.swing.JPanel();
        leaveTypeLabel = new javax.swing.JLabel();
        leaveTypeComboBox = new javax.swing.JComboBox<>();
        startDateLabel = new javax.swing.JLabel();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        leaveReasonsTxtArea = new javax.swing.JTextArea();
        submitBTN = new javax.swing.JButton();
        leaveCreditsLabel = new javax.swing.JLabel();
        leaveCreditsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        sickLeaveTxtField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        vaccationLeaveTxtField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        paternityLeaveTxtField = new javax.swing.JTextField();
        bereavementLeaveTxtField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        leaveHistoryLabel = new javax.swing.JLabel();
        leaveHistoryPanel = new javax.swing.JScrollPane();
        leaveHistoryTable = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(820, 700));
        setMinimumSize(new java.awt.Dimension(820, 700));
        setPreferredSize(new java.awt.Dimension(820, 700));

        requestLeaveLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        requestLeaveLabel.setText("Request Leave");

        requestLeavePanel.setBackground(new java.awt.Color(153, 153, 153));
        requestLeavePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        requestLeavePanel.setMaximumSize(new java.awt.Dimension(340, 360));
        requestLeavePanel.setMinimumSize(new java.awt.Dimension(340, 360));
        requestLeavePanel.setPreferredSize(new java.awt.Dimension(340, 360));

        leaveTypeLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveTypeLabel.setText("Leave Type");

        leaveTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick Leave", "Vacation Leave", "Paternal Leave", "Bereavement Leave" }));

        startDateLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        startDateLabel.setText("Start date:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("End date:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel10.setText("Reason:");

        leaveReasonsTxtArea.setColumns(20);
        leaveReasonsTxtArea.setRows(5);
        jScrollPane5.setViewportView(leaveReasonsTxtArea);

        submitBTN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        submitBTN.setText("Submit");

        javax.swing.GroupLayout requestLeavePanelLayout = new javax.swing.GroupLayout(requestLeavePanel);
        requestLeavePanel.setLayout(requestLeavePanelLayout);
        requestLeavePanelLayout.setHorizontalGroup(
            requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestLeavePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(submitBTN)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaveTypeLabel)
                    .addGroup(requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                        .addComponent(startDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(endDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        requestLeavePanelLayout.setVerticalGroup(
            requestLeavePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestLeavePanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(leaveTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        leaveCreditsLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveCreditsLabel.setText("Leave Credits");

        leaveCreditsPanel.setBackground(new java.awt.Color(153, 153, 153));
        leaveCreditsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("Sick Leaves:");

        jLabel12.setText("Vacation Leaves:");

        jLabel13.setText("Paternal Leaves:");

        jLabel14.setText("Bereavement Leaves:");

        javax.swing.GroupLayout leaveCreditsPanelLayout = new javax.swing.GroupLayout(leaveCreditsPanel);
        leaveCreditsPanel.setLayout(leaveCreditsPanelLayout);
        leaveCreditsPanelLayout.setHorizontalGroup(
            leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paternityLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(bereavementLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sickLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vaccationLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addGap(62, 62, 62))
        );

        leaveCreditsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel14});

        leaveCreditsPanelLayout.setVerticalGroup(
            leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveCreditsPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sickLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(vaccationLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paternityLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leaveCreditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bereavementLeaveTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        leaveCreditsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bereavementLeaveTxtField, paternityLeaveTxtField, sickLeaveTxtField, vaccationLeaveTxtField});

        leaveCreditsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel14});

        leaveHistoryLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        leaveHistoryLabel.setText("Leave History");

        leaveHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "LeaveID", "Request Date", "Start Date", "End Date", "Status", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leaveHistoryTable.setMaximumSize(new java.awt.Dimension(300, 80));
        leaveHistoryTable.setMinimumSize(new java.awt.Dimension(300, 80));
        leaveHistoryPanel.setViewportView(leaveHistoryTable);
        if (leaveHistoryTable.getColumnModel().getColumnCount() > 0) {
            leaveHistoryTable.getColumnModel().getColumn(1).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(2).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(3).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leaveHistoryLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(leaveHistoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(leaveCreditsLabel)
                    .addComponent(requestLeaveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaveCreditsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestLeavePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leaveCreditsLabel)
                    .addComponent(leaveHistoryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leaveCreditsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(requestLeaveLabel)
                        .addGap(18, 18, 18)
                        .addComponent(requestLeavePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addComponent(leaveHistoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bereavementLeaveTxtField;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel leaveCreditsLabel;
    private javax.swing.JPanel leaveCreditsPanel;
    private javax.swing.JLabel leaveHistoryLabel;
    private javax.swing.JScrollPane leaveHistoryPanel;
    private javax.swing.JTable leaveHistoryTable;
    private javax.swing.JTextArea leaveReasonsTxtArea;
    private javax.swing.JComboBox<String> leaveTypeComboBox;
    private javax.swing.JLabel leaveTypeLabel;
    private javax.swing.JTextField paternityLeaveTxtField;
    private javax.swing.JLabel requestLeaveLabel;
    private javax.swing.JPanel requestLeavePanel;
    private javax.swing.JTextField sickLeaveTxtField;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JButton submitBTN;
    private javax.swing.JTextField vaccationLeaveTxtField;
    // End of variables declaration//GEN-END:variables
}