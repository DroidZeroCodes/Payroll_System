package logic;

import interfaces.UserCredentialsDataService;
import exceptions.SystemLoginException;

public class User {
    private final String username;
    private final UserCredentialsDataService userCredentialsDataService;

    public User(String username, UserCredentialsDataService userCredentialsDataService){
        this.username = username;
        this.userCredentialsDataService = userCredentialsDataService;
    }

    /**
     * Check if the provided password matches the user's password.
     *
     * @param password the password to be checked
     * @return true if the provided password matches the user's password, false otherwise
     */
    public boolean checkPassword(String password) throws SystemLoginException {
        String passwordFromDB = null;
        try {
            passwordFromDB = userCredentialsDataService.getUserCredentials_ByUserName(username).password();
        } catch (Exception e) {
            SystemLoginException.throwLoginError_INCORRECT_USERNAME_OR_PASSWORD();
            return false;
        }

        return passwordFromDB.equals(password);
    }
}

