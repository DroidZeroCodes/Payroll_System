package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.DataHandlingModule.UserCredentials;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class ITAdmin extends HRAdmin implements ITActions {
    protected UserCredentials userCredentials;
    public ITAdmin(int employeeID) throws IOException, CsvException {
        super(employeeID);
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
