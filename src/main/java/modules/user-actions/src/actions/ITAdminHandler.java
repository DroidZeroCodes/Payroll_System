package actions;

import data.EmployeeRecord;
import data.UserCredentials;
import exceptions.EmployeeRecordsException;
import exceptions.UserRecordsException;
import ui.it.ITAdminUI;
import ui.it.ManageUserPanel;
import user.ITAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;

public class ITAdminHandler extends EmployeeHandler {
    protected ITAdmin itAdmin;
    protected ITAdminUI itAdminUI;
    protected ManageUserPanel manageUserPage;
    protected JButton manageUserBTN;
    private boolean isMngUserColumnRemoved = false;

    public ITAdminHandler(ITAdmin itAdmin, ITAdminUI itAdminUI) {
        super(itAdmin, null);
        this.itAdmin = itAdmin;
        this.itAdminUI = itAdminUI;
        this.generalComponents = itAdminUI;
        initComponents();
        initActions();
        showMyProfilePage();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        this.manageUserPage = itAdminUI.getManageUserPanel();
        this.manageUserBTN = itAdminUI.getMngUserBTN();
    }

    @Override
    protected void initActions() {
        super.initActions();
        manageUserBTN.addActionListener(e -> showUserManagementPage());

        manageUserPage.getClearBTN().addActionListener(e -> resetFieldsInput());

        manageUserPage.getCreateUserBTN().addActionListener(e -> {
            try {
                itAdmin.createUser(getFieldsInput());
            } catch (EmployeeRecordsException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });

        manageUserPage.getUpdateUserBTN().addActionListener(e -> {
            try {
                itAdmin.updateCredentials(getFieldsInput());
            } catch (EmployeeRecordsException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });

        manageUserPage.getDeleteUserBTN().addActionListener(e -> {
            itAdmin.deleteUser(Integer.parseInt(manageUserPage.getEmpIDTxtField().getText()));
        });

        manageUserPage.getSearchBTN().addActionListener(e -> {
            try {
                showFilteredUserTable();
            } catch (EmployeeRecordsException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });

        tableListener();
    }

    private void resetFieldsInput() {
        manageUserPage.getEmpIDTxtField().setText("");
        manageUserPage.getUsernameTxtField().setText("");
        manageUserPage.getPasswordField().setText("");
        manageUserPage.getConfirmPassField().setText("");
        manageUserPage.getRoleDropBox().setSelectedIndex(0);
        manageUserPage.getLastModifiedTxtField().setText("");
    }

    private void showUserManagementPage() {
        resetPanelVisibility();
        manageUserPage.setVisible(true);
        try {
            displayUserRecord();
        } catch (UserRecordsException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void resetPanelVisibility() {
        super.resetPanelVisibility();
        manageUserPage.setVisible(false);
    }

    private UserCredentials getFieldsInput() throws EmployeeRecordsException {
        int employeeID = Integer.parseInt(manageUserPage.getEmpIDTxtField().getText());
        String username = manageUserPage.getUsernameTxtField().getText();
        String password = new String(manageUserPage.getPasswordField().getPassword());
        String confirmPass = new String(manageUserPage.getConfirmPassField().getPassword());
        String role = String.valueOf(manageUserPage.getRoleDropBox().getSelectedItem());
        EmployeeRecord employeeRecord = itAdmin.getEmployeeRecord(employeeID);
        String position = employeeRecord.position();
        String department = employeeRecord.department();

        if (!password.equals(confirmPass)) {
            System.out.println("Error");
            return null;
        }

        return new UserCredentials(
                employeeID,
                username,
                password,
                position,
                department,
                role,
                LocalDateTime.now()
        );
    }

    public void displayUserRecord() throws UserRecordsException {
        List<UserCredentials> userRecords = itAdmin.getUserRecords();

        manageUserPage.getMngUserTableModel().setRowCount(0);

        if (!isMngUserColumnRemoved) {

            var userRecordTable = manageUserPage.getUserCredentialTable();
            var username = userRecordTable.getColumnModel().getColumn(1);
            var password = userRecordTable.getColumnModel().getColumn(2);
            var modifiedTime = userRecordTable.getColumnModel().getColumn(3);

            userRecordTable.removeColumn(username);
            userRecordTable.removeColumn(password);
            userRecordTable.removeColumn(modifiedTime);

            isMngUserColumnRemoved = true;
        }

        if (userRecords == null || userRecords.isEmpty()) {
            UserRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        for (UserCredentials record : userRecords) {
            String[] data = record.toArray();
            manageUserPage.getMngUserTableModel().addRow(data);
        }
    }

    public void tableListener() {
        manageUserPage.getUserCredentialTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = manageUserPage.getUserCredentialTable().getSelectedRow();
                if (row != -1) {
                    int employeeID = Integer.parseInt((String) manageUserPage.getMngUserTableModel().getValueAt(row, 0));
                    Object role = manageUserPage.getMngUserTableModel().getValueAt(row, 5);
                    UserCredentials userCredentials = itAdmin.getUserCredentials(employeeID);

                    manageUserPage.getEmpIDTxtField().setText(String.valueOf(employeeID));
                    manageUserPage.getUsernameTxtField().setText(userCredentials.username());
                    manageUserPage.getPasswordField().setText(userCredentials.password());
                    manageUserPage.getRoleDropBox().setSelectedItem(role);
                    manageUserPage.getLastModifiedTxtField().setText(userCredentials.lastModified().toString());
                }
            }
        });
    }

    private void showFilteredUserTable() throws EmployeeRecordsException {
        TableRowSorter<DefaultTableModel> employeeTableSorter = manageUserPage.getUserTableSorter();

        // Check if employeeTableSorter is null
        if (employeeTableSorter == null) {
            // Handle the situation where employeeTableSorter is null (for example, throw an exception or log an error)
            // Here, I'm throwing an EmployeeRecordsException, but you can adjust this according to your requirements
            System.out.println("employeeTableSorter is null");
            return;
        }

        int empID = 0;

        try {
            // Get the employee ID from the search field
            empID = Integer.parseInt(manageUserPage.getSearchField().getText());
        } catch (NumberFormatException e) {
            // If the entered employee ID is not a number, throw error
            EmployeeRecordsException.throwError_INVALID_SEARCH_FIELD();
            return;
        }

        if (empID <= 0) {
            // Clear the table filter if no employee ID is entered or the entered ID is 0
            employeeTableSorter.setRowFilter(null);
            return;
        }

        if (!itAdmin.getEmployeeIDList().contains(empID)) {
            // If the entered employee ID is not found in the records, throw error and clear the filter
            employeeTableSorter.setRowFilter(null);
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        employeeTableSorter.setRowFilter(RowFilter.regexFilter("^" + empID + "$", 0));

        // Check if any records match the filter
        if (manageUserPage.getUserCredentialTable().getRowCount() == 0) {
            // If no records match the filter, throw error and clear the filter
            EmployeeRecordsException.throwError_NO_RECORD_FOUND();
            employeeTableSorter.setRowFilter(null);
        }
    }

}
