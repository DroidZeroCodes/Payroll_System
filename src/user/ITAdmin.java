package user;

import service.actions.EmployeeRecord;
import service.actions.UserCredentials;
import user.interfaces.ITActions;
import ui.ITAdminUI.ITAdminUI;
import ui.ITAdminUI.ManageUserPanel;

import java.util.List;

public class ITAdmin extends Employee implements ITActions {
    private List<String[]> record;
    private ITAdminUI ui;
    private ManageUserPanel mngUserPanel;
    private boolean isMngUserColumnRemoved = false;

    public ITAdmin(int employeeID, ITAdminUI ui) {
        super(employeeID, null);
        this.ui = ui;
        initComponents();
        initDetails();
    }

    public void initComponents() {
        myProfilePage = ui.getEmpProfilePanel();
        attendancePage = ui.getEmpAttendancePanel();
        payslipPage = ui.getEmpPayslipPanel();
        leavePage = ui.getEmpLeavePanel();
        mngUserPanel = ui.getManageUserPanel();
    }
    
    public void initDetails() {

    }

    public void displayUserRecord() {
        record = new UserCredentials().retrieveAllRecords();

        mngUserPanel.mngUserTableModel().setRowCount(0);

        if (!isMngUserColumnRemoved) {

            var userRecordTable = mngUserPanel.userCredentialTable();
            var username = userRecordTable.getColumnModel().getColumn(1);
            var password = userRecordTable.getColumnModel().getColumn(2);

            userRecordTable.removeColumn(username);
            userRecordTable.removeColumn(password);

            isMngUserColumnRemoved = true;
        }

        for (String[] data : record) {
            mngUserPanel.mngUserTableModel().addRow(data);
        }
    }

    @Override
    public void createUser() {
        String employeeID = mngUserPanel.empIDTxtField().getText();
        EmployeeRecord newUserRecord = new EmployeeRecord(Integer.parseInt(employeeID));
        // Get data from components
        String username = mngUserPanel.usernameTxtField().getText();
        String password = new String(mngUserPanel.passwordField1().getPassword());
        String confirmPass = new String (mngUserPanel.passwordField2().getPassword());
        String role = String.valueOf(mngUserPanel.roleDropBox().getSelectedItem());
        String position = newUserRecord.position();
        String department = newUserRecord.department();
        
        if (!password.equals(confirmPass)){
            System.out.println("Error");
            return;
        }
        
        if (!newUserRecord.doesExist("EMPLOYEE_NO", employeeID )){
            System.out.println("Employee record does not exist");
            return;
        }
        
        UserCredentials newCredentials = new UserCredentials();
        
        if (newCredentials.doesExist("EMPLOYEE_NO", employeeID )){
            System.out.println("Record already exist");
            return;
        }
        
        newCredentials.addRecord(new String[]{
           employeeID,
                username,
                password,
                position,
                department,
                role
        }, true);
        displayUserRecord();
    }

    @Override
    public void updateUsername(String oldUsername, String newUsername) {

    }

    @Override
    public void updatePassword(String username, String newPassword) {

    }

    @Override
    public void deleteUser(String username) {

    }
}
