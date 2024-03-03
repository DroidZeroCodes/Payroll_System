package logic;

import interfaces.UserCredentialsDataService;

public class AuthenticationLogic {
    private final UserCredentialsDataService userCredentialsDataService;

    public AuthenticationLogic(UserCredentialsDataService userCredentialsDataService) {
        this.userCredentialsDataService = userCredentialsDataService;
    }

    public boolean login(String username, String password) {
        User user = new User(username, userCredentialsDataService);
        return user.checkPassword(password);
    }

    public String getUserRole(String username) {
        return userCredentialsDataService.getUserCredentials_ByUserName(username).role();
    }

    public int getEmployeeID(String username) {
        return userCredentialsDataService.getUserCredentials_ByUserName(username).employeeID();
    }
}
