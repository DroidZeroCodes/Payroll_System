package actions;

import data.UserCredentials;
import interfaces.ITAdminController;
import ui.GeneralComponents;
import ui.it.ITAdminUI;
import ui.it.ManageUserPanel;
import user.ITAdmin;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ITAdminHandler extends EmployeeHandler implements ITAdminController {
    protected ITAdmin itAdmin;
    protected ITAdminUI itAdminUI;
    protected GeneralComponents generalComponents;
    protected ManageUserPanel manageUserPage;
    protected JButton manageUserBTN;
    private boolean isMngUserColumnRemoved = false;
    public ITAdminHandler(ITAdmin itAdmin, ITAdminUI itAdminUI) {
        super(itAdmin, null);
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
        manageUserBTN.addActionListener(e -> {
            resetPanelVisibility();
            manageUserPage.setVisible(true);
            displayUserRecord();
        });

        manageUserPage.createUserBTN().addActionListener(e -> {
            itAdmin.createUser(getFieldsInput());
        });

        manageUserPage.deleteUserBTN().addActionListener(e -> {
            // implement logic
        });

        manageUserPage.searchBTN().addActionListener(e -> {
            // implement logic
        });
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
                    null,
                    role,
                    null,
                    password
        );
    }

    @Override
    public void displayUserRecord() {
        List<UserCredentials> userRecords = itAdmin.getUserRecords();

        manageUserPage.mngUserTableModel().setRowCount(0);

        if (!isMngUserColumnRemoved) {

            var userRecordTable = manageUserPage.getUserCredentialTable();
            var username = userRecordTable.getColumnModel().getColumn(1);
            var password = userRecordTable.getColumnModel().getColumn(2);

            userRecordTable.removeColumn(username);
            userRecordTable.removeColumn(password);

            isMngUserColumnRemoved = true;
        }

        for (UserCredentials record : userRecords) {
            String[] data = record.toArray();
            manageUserPage.mngUserTableModel().addRow(data);
        }
    }

    public void TableListener(){
        manageUserPage.getUserCredentialTable().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int row = manageUserPage.getUserCredentialTable().getSelectedRow();
                if (row != -1){
                    int employeeID = Integer.parseInt((String)manageUserPage.mngUserTableModel().getValueAt(row, 0));
                    String role = (String) manageUserPage.mngUserTableModel().getValueAt(row, 5);

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
