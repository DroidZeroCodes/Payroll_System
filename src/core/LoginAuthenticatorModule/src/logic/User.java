package logic;

import exceptions.SystemLoginException;
import data.service.UserCredentialsDataService;

/**
 * Represents a user entity and provides methods to interact with user credentials.
 * <p>
 * Available methods:
 * <ul>
 *     <li>{@link User#checkPassword(String)}</li>
 * </ul>
 *
 * @author [Author Name]
 */

public class User {
    private final String username;
    private final UserCredentialsDataService userCredentialsDataService;

    /**
     * Constructs a User object with the specified username and user credentials data service.
     *
     * @param username                   the username of the user
     * @param userCredentialsDataService the service for user credentials data
     */
    public User(String username, UserCredentialsDataService userCredentialsDataService) {
        this.username = username;
        this.userCredentialsDataService = userCredentialsDataService;
    }

    /**
     * Checks if the provided password matches the password associated with the user's username.
     *
     * @param password the password to be checked
     * @return true if the provided password matches the user's password, otherwise false
     * @throws SystemLoginException if an error occurs while retrieving user credentials or if the provided username/password is incorrect
     */
    public boolean checkPassword(String password) throws SystemLoginException {
        String passwordFromDB;
        try {
            passwordFromDB = userCredentialsDataService.getUserCredentials_ByUserName(username).password();
        } catch (Exception e) {
            SystemLoginException.throwLoginError_INCORRECT_USERNAME_OR_PASSWORD();
            return false;
        }

        return passwordFromDB.equals(password);
    }
}
