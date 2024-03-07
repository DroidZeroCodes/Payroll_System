/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.hr;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ManageEmpPanel extends javax.swing.JPanel {


    private TableRowSorter<DefaultTableModel> employeeTableSorter;
    private DefaultTableModel employeeTableModel;

    public ManageEmpPanel() {
        initComponents();
        initTable();
    }

    private void initTable() {
        employeeTableModel = new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String[]{
                        "Employee ID", "Last Name", "First Name", "Birthday", "Address",
                        "Phone Number", "SSS No.", "PhilHealth No.", "PagIbig No.", "TIN No.", "Department",
                        "Position", "Supervisor", "Status",
                        "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-Monthly Rate", "Hourly Rate",

                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        employeeTable.setModel(employeeTableModel);
        employeeTableSorter = new TableRowSorter<>(employeeTableModel);
        employeeTable.setRowSorter(employeeTableSorter);

    }

    public TableRowSorter<DefaultTableModel> getEmployeeTableSorter() {
        return employeeTableSorter;
    }

    public DefaultTableModel getEmployeeTableModel() {
        return employeeTableModel;
    }

    public JButton getTerminateEmpBTN() {
        return terminateEmpBTN;
    }

    public JButton getAddEmpBTN() {
        return addEmpBTN;
    }

    public JTable getEmployeeTable() {
        return employeeTable;
    }

    public JButton getSearchBTN() {
        return searchBTN;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getUpdateEmpBTN() {
        return updateEmpBTN;
    }

    public TableRowSorter<DefaultTableModel> empRecordTableSorter() {
        return employeeTableSorter;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        employeeTableScrollPane = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        addEmpBTN = new javax.swing.JButton();
        updateEmpBTN = new javax.swing.JButton();
        terminateEmpBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        myPayslipLabel = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(1135, 720));
        setPreferredSize(new java.awt.Dimension(1135, 720));
        setLayout(new java.awt.GridBagLayout());

        employeeTableScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        employeeTableScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Department", "Position", "Supervisor", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.getTableHeader().setReorderingAllowed(false);
        employeeTableScrollPane.setViewportView(employeeTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 684;
        gridBagConstraints.ipady = 480;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 0, 50);
        add(employeeTableScrollPane, gridBagConstraints);

        addEmpBTN.setText("Add");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 60, 64, 0);
        add(addEmpBTN, gridBagConstraints);

        updateEmpBTN.setText("Update");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 64, 0);
        add(updateEmpBTN, gridBagConstraints);

        terminateEmpBTN.setText("Terminate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 64, 60);
        add(terminateEmpBTN, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

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
        jPanel1.add(myPayslipLabel, gridBagConstraints);

        searchBTN.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 50);
        jPanel1.add(searchBTN, gridBagConstraints);

        searchField.setMinimumSize(new java.awt.Dimension(200, 30));
        searchField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(searchField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmpBTN;
    private javax.swing.JTable employeeTable;
    private javax.swing.JScrollPane employeeTableScrollPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myPayslipLabel;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton terminateEmpBTN;
    private javax.swing.JButton updateEmpBTN;
    // End of variables declaration//GEN-END:variables
}
