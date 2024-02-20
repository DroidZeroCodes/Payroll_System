package com.mmdc_group10_oop.service.actions;

import com.mmdc_group10_oop.service.user.User;

public class LoginAction {

    public String userRole;
    public int employeeID;
    public boolean login(String username, String password) {
        try {
            // Create a new user object with the provided username and password
            User user = new User(username, password);

            // Check if the provided username and password match the user's credentials
            if (user.userExists()) {
                // If the user exists and the password matches, return true
                if (user.checkPassword(password)){
                    setUserRole(user.role);
                    setEmployeeID(user.employeeID);
                    return true;
                } else {
                    // If the password doesn't match, return false
                    return false;
                }
            } else {
                // If the user doesn't exist or the password is incorrect, return false
                return false;
            }
        } catch (Exception e) {
            // If an exception occurs (e.g., user not found, invalid credentials), return false
            return false;
        }
    }

    public String userRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int employeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
