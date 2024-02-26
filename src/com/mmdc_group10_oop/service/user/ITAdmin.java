package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.UserCredentials;
import com.mmdc_group10_oop.service.actions.interfaces.ITActions;
import com.mmdc_group10_oop.ui.ITAdminUI.ITAdminUI;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class ITAdmin extends Employee implements ITActions {
    protected UserCredentials userCredentials;
    public ITAdmin(int employeeID, ITAdminUI ui) throws IOException, CsvException {
        super(employeeID, null);
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
