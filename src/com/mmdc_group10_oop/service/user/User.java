package com.mmdc_group10_oop.service.user;

import com.mmdc_group10_oop.dataHandlingModule.UserCredentials;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

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


    /**
     * A method to check if a user exists.
     *
     * @throws CsvValidationException  if there is a validation exception
     * @throws IOException             if there is an input/output exception
     * @return                         true if the user exists, false otherwise
     */
    public boolean userExists() throws CsvValidationException, IOException {
        UserCredentials user = new UserCredentials(username);
        return user.doesExist("Username", username);
    }

    /**
     * Check if the provided password matches the user's password.
     *
     * @param  password  the password to be checked
     * @return          true if the provided password matches the user's password, false otherwise
     */
    public boolean checkPassword(String password) throws CsvValidationException, IOException {
        UserCredentials user = new UserCredentials(username);
        return user.password().equals(password);
    }

    @Override
    public String toString() {
        return "User{ username = " + username + ", password = " + password + ", role = " + role + ", employeeID = " + employeeID + "}";
    }
}

