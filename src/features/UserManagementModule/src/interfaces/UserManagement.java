package interfaces;


import exceptions.UserRecordsException;
import records.UserCredentials;

import java.util.List;

public interface UserManagement {
    void createUser(UserCredentials userCredentials);

    void updateCredentials(UserCredentials userCredential) throws UserRecordsException;

    void deleteUser(int employeeID) throws UserRecordsException;

    List<UserCredentials> getAllUserRecords();

    UserCredentials getUserRecord(int employeeID);
}
