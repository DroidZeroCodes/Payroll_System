package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.UserCredentials;
import com.mmdc_group10_oop.service.actions.interfaces.ITActions;
import com.mmdc_group10_oop.ui.ITAdminUI.ITAdminUI;
<<<<<<< HEAD
import com.mmdc_group10_oop.ui.ITAdminUI.ManageUserPanel;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class ITAdmin extends Employee implements ITActions {
    private List<String[]> record;
    private ITAdminUI ui;
    private ManageUserPanel mngUserPanel;
    private boolean isMngUserColumnRemoved = false;
    public ITAdmin(int employeeID, ITAdminUI ui) throws IOException, CsvException {
=======

public class ITAdmin extends Employee implements ITActions {
    protected UserCredentials userCredentials;
    public ITAdmin(int employeeID, ITAdminUI ui) {
>>>>>>> 2acc7bba2ce4874c7dd6c467d5ab36be5407ae1f
        super(employeeID, null);
    this.ui = ui;
    initComponents();
    initDetails();
    }
    
    public void initComponents(){
        profilePage = ui.getEmpProfilePanel();
        attendancePage = ui.getEmpAttendancePanel();
        payslipPage = ui.getEmpPayslipPanel();
        leavePage = ui.getEmpLeavePanel();
        mngUserPanel = ui.getManageUserPanel();
    }
    
    public void initDetails() throws IOException, CsvException{
        super.initDetails();
        record = new UserCredentials().retrieveAllRecords();
    }
    
    public void displayUserRecord(){
        mngUserPanel.getMngUserTableModel().setRowCount(0);
        
        if (!isMngUserColumnRemoved){
            
            var userRecordTable = mngUserPanel.userCredentialTable();
            var username = userRecordTable.getColumnModel().getColumn(1);
            var password = userRecordTable.getColumnModel().getColumn(2);  
            
            userRecordTable.removeColumn(username);
            userRecordTable.removeColumn(password);
            
            isMngUserColumnRemoved = true;
        }
        
        for (String [] data : record){
            mngUserPanel.getMngUserTableModel().addRow(data);
        }
    }

    @Override
    public void createUser() {

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
