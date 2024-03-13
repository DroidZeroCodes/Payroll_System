package logic;

import exceptions.SystemLoginException;
import interfaces.UserCredentialsDataService;

/**
 * Handles authentication logic such as user login and role retrieval.
 */
public class AuthenticationLogic {
    private final UserCredentialsDataService userCredentialsDataService;

    /**
     * Constructs an AuthenticationLogic object with the specified UserCredentialsDataService.
     *
     * @param userCredentialsDataService the service for user credentials data
     */
    public AuthenticationLogic(UserCredentialsDataService userCredentialsDataService) {
        this.userCredentialsDataService = userCredentialsDataService;
    }

    /**
     * Attempts to log in the user with the provided username and password.
     *
     * @param username the username to log in with
     * @param password the password to log in with
     * @return true if login is successful, otherwise false
     * @throws SystemLoginException if login fails due to missing username/password or incorrect credentials
     */
    public boolean login(String username, String password) throws SystemLoginException {
        if (username.isEmpty() || password.isEmpty()) {
            SystemLoginException.throwLoginError_MISSING_USERNAME_OR_PASSWORD();
        }
        User user = new User(username, userCredentialsDataService);

        if (!user.checkPassword(password)) {
            SystemLoginException.throwLoginError_INCORRECT_USERNAME_OR_PASSWORD();
        }
        return true;
    }

    /**
     * Retrieves the role of the user with the specified username.
     *
     * @param username the username of the user
     * @return the role of the user
     */
    public String getUserRole(String username) {
        return userCredentialsDataService.getUserCredentials_ByUserName(username).role();
    }

    /**
     * Retrieves the employee ID of the user with the specified username.
     *
     * @param username the username of the user
     * @return the employee ID of the user
     */
    public int getEmployeeID(String username) {
        return userCredentialsDataService.getUserCredentials_ByUserName(username).employeeID();
    }
}
