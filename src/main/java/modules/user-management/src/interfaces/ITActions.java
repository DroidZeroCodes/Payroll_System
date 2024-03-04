package interfaces;

import data.UserCredentials;

public interface ITActions {
    void createUser(UserCredentials userCredentials);
    void updateCredentials(UserCredentials userCredential);

    //TODO: User data services for this

    void deleteUser(int employeeID);
}
