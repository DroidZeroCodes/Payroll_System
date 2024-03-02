package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.EmployeeRecord;
import com.mmdc_group10_oop.dataHandlingModule.UserCredentials;
import com.mmdc_group10_oop.service.actions.interfaces.ITActions;
import com.mmdc_group10_oop.ui.ITAdminUI.ITAdminUI;
import com.mmdc_group10_oop.ui.ITAdminUI.ManageUserPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        TableListener();
    }

    public void initComponents() {
        myProfilePage = ui.getEmpProfilePanel();
        attendancePage = ui.getEmpAttendancePanel();
        payslipPage = ui.getEmpPayslipPanel();
        leavePage = ui.getEmpLeavePanel();
        mngUserPanel = ui.getManageUserPanel();
    }
    
    public void initDetails() {
        super.initDetails();
        record = new UserCredentials().retrieveAllRecords();
    }

    public void displayUserRecord() {
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

    public void TableListener(){
        
        mngUserPanel.userCredentialTable().addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
               int row = mngUserPanel.userCredentialTable().getSelectedRow();
               if (row != -1){
                   int empolyeeID = Integer.parseInt((String)mngUserPanel.mngUserTableModel().getValueAt(row, 0));
                   String role = (String) mngUserPanel.mngUserTableModel().getValueAt(row, 5);
                   
                   UserCredentials userCredentials = new UserCredentials(empolyeeID);
                   userCredentials.retrieveUsernameAndPass();
        
                   mngUserPanel.empIDTxtField().setText(String.valueOf(empolyeeID));
                   mngUserPanel.usernameTxtField().setText(userCredentials.username());
                   mngUserPanel.passwordField1().setText(userCredentials.password());
                   mngUserPanel.roleDropBox().setSelectedItem(role);
               }
           }
        }); 
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
        String deparment = newUserRecord.department();
        
        if (!newUserRecord.doesExist("EMPLOYEE_NO", employeeID )){
            System.out.println("Employee record does not exist");
            return;
        }
        
        UserCredentials newCredentials = new UserCredentials();
        
        if (newCredentials.doesExist("EMPLOYEE_NO", employeeID )){
            System.out.println("Record already exist");
            return;
        }
        
        if (!password.equals(confirmPass)){
            System.out.println("Password not matching!");
            return;
        }
        
        newCredentials.addRecord(new String[]{
           employeeID,
                username,
                password,
                position,
                deparment,
                role
        }, true);
        record = new UserCredentials().retrieveAllRecords();
        displayUserRecord();
    }
    
    @Override
    public void updateUsername(String newUsername) {
        int employeeID = Integer.parseInt(mngUserPanel.empIDTxtField().getText());
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.updateRecord(employeeID, "USERNAME", newUsername);
    }

    @Override
    public void updatePassword(String newPassword) {
        int employeeID = Integer.parseInt(mngUserPanel.empIDTxtField().getText());
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.updateRecord(employeeID, "PASSWORD", newPassword);
    }

    @Override
    public void deleteUser(String username) {
        
    }
}
