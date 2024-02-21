package com.mmdc_group10_oop.service.actions.interfaces;

public interface ITActions {
    void createUser();
    void updateUsername(String oldUsername, String newUsername);
    void updatePassword(String username, String newPassword);
    void deleteUser(String username);
}
