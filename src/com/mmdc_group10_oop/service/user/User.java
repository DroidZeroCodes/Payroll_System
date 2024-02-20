package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.DataHandlingModule.UserCredentials;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
public class User {
    protected UserCredentials user;
    private final String username;
    private final String password;
    public final String role;
    public final int employeeID;
    public User(String username, String password) throws IOException, CsvException {
        this.username = username;
        this.password = password;

        // Determine user role based on username and password
        // Logic to determine user role
        user = new UserCredentials(username);

        this.role = user.role();
        this.employeeID = user.employeeID();

    }

    public void register() {
        // Logic to register a new user
    }

    public void changePassword(String newPassword) {
        // Logic to change password
    }

    public void changeUsername(String newUsername) {
        // Logic to change username
    }

    public boolean login(String username, String password) {
        // Logic to authenticate user
        return true; // Placeholder for successful login
    }

    @Override
    public String toString() {
        return "User{ username = " + username + ", password = " + password + ", role = " + role + ", employeeID = " + employeeID + "}";
    }


}

