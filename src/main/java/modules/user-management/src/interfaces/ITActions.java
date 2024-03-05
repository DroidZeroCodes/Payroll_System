package interfaces;

import data.UserCredentials;
import exceptions.UserRecordsException;

public interface ITActions {
    void createUser(UserCredentials userCredentials);

    void updateCredentials(UserCredentials userCredential) throws UserRecordsException;

    //TODO: User data services for this

    void deleteUser(int employeeID) throws UserRecordsException;
}
