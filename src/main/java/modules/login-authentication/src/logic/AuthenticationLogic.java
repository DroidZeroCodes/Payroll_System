package logic;

import exceptions.SystemLoginException;
import interfaces.UserCredentialsDataService;

public class AuthenticationLogic {
    private final UserCredentialsDataService userCredentialsDataService;

    public AuthenticationLogic(UserCredentialsDataService userCredentialsDataService) {
        this.userCredentialsDataService = userCredentialsDataService;
    }

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


    public String getUserRole(String username) {
        return userCredentialsDataService.getUserCredentials_ByUserName(username).role();
    }

    public int getEmployeeID(String username) {
        return userCredentialsDataService.getUserCredentials_ByUserName(username).employeeID();
    }
}
