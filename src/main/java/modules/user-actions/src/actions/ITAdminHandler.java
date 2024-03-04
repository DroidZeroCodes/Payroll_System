package actions;

import data.UserCredentials;
import exceptions.UserRecordsException;
import interfaces.ITAdminActions;
import ui.it.ITAdminUI;
import ui.it.ManageUserPanel;
import user.ITAdmin;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ITAdminHandler extends EmployeeHandler implements ITAdminActions {
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

//        manageUserPage.resetBTN().addActionListener(e -> resetFieldsInput());

        manageUserPage.getCreateUserBTN().addActionListener(e -> {
            itAdmin.createUser(getFieldsInput());
        });

        manageUserPage.getUpdateUserBTN().addActionListener(e -> {
            itAdmin.updateCredentials(getFieldsInput());
        });

        manageUserPage.getDeleteUserBTN().addActionListener(e -> {
            itAdmin.deleteUser(Integer.parseInt(manageUserPage.getEmpIDTxtField().getText()));
        });

        manageUserPage.getSearchBTN().addActionListener(e -> {
            // implement logic
        });

        tableListener();
    }

    private void resetFieldsInput() {
        manageUserPage.getEmpIDTxtField().setText("");
        manageUserPage.getUsernameTxtField().setText("");
        manageUserPage.getPasswordField1().setText("");
        manageUserPage.getPasswordField2().setText("");
        manageUserPage.getRoleDropBox().setSelectedIndex(0);
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

    private UserCredentials getFieldsInput(){
        int employeeID = Integer.parseInt(manageUserPage.getEmpIDTxtField().getText());
        String username = manageUserPage.getUsernameTxtField().getText();
        String password = new String(manageUserPage.getPasswordField1().getPassword());
        String confirmPass = new String (manageUserPage.getPasswordField2().getPassword());
        String role = String.valueOf(manageUserPage.getRoleDropBox().getSelectedItem());

        if (!password.equals(confirmPass)){
            System.out.println("Error");
            return null;
        }

        return new UserCredentials(
                employeeID,
                username,
                password,
                null,
                null,
                    role
        );
    }

    @Override
    public void displayUserRecord() throws UserRecordsException {
        List<UserCredentials> userRecords = itAdmin.getUserRecords();

        manageUserPage.getMngUserTableModel().setRowCount(0);

        if (!isMngUserColumnRemoved) {

            var userRecordTable = manageUserPage.getUserCredentialTable();
            var username = userRecordTable.getColumnModel().getColumn(1);
            var password = userRecordTable.getColumnModel().getColumn(2);

            userRecordTable.removeColumn(username);
            userRecordTable.removeColumn(password);

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

    public void tableListener(){
        manageUserPage.getUserCredentialTable().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int row = manageUserPage.getUserCredentialTable().getSelectedRow();
                if (row != -1){
                    int employeeID = Integer.parseInt((String)manageUserPage.getMngUserTableModel().getValueAt(row, 0));
                    Object role = manageUserPage.getMngUserTableModel().getValueAt(row, 5);
                    UserCredentials userCredentials = itAdmin.getUserCredentials(employeeID);

                    manageUserPage.getEmpIDTxtField().setText(String.valueOf(employeeID));
                    manageUserPage.getUsernameTxtField().setText(userCredentials.username());
                    manageUserPage.getPasswordField1().setText(userCredentials.password());
                    manageUserPage.getRoleDropBox().setSelectedItem(role);
                }
            }
        });
    }
}
