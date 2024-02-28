package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.UserCredentials;
import com.mmdc_group10_oop.service.actions.interfaces.ITActions;
import com.mmdc_group10_oop.ui.ITAdminUI.ITAdminUI;
import com.mmdc_group10_oop.ui.ITAdminUI.ManageUserPanel;

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
