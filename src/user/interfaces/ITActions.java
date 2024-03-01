package user.interfaces;

public interface ITActions {
    void createUser();
    void updateUsername(String oldUsername, String newUsername);
    void updatePassword(String username, String newPassword);
    void deleteUser(String username);
}
