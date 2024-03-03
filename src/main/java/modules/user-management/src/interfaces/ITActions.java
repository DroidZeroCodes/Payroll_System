package interfaces;

import data.UserCredentials;

public interface ITActions {
    void createUser(UserCredentials userCredentials);
    void updateUsername(String oldUsername, String newUsername);
    void updatePassword(String username, String newPassword);
    void deleteUser(String username);
}
