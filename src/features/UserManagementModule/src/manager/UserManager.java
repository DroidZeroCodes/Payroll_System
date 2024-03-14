package manager;

import exceptions.UserRecordsException;
import interfaces.UserCredentialsDataService;
import interfaces.UserManagement;
import records.UserCredentials;

import java.util.List;

public class UserManager implements UserManagement {
    private final UserCredentialsDataService userCredentialsDataService;

    // Constructor
    public UserManager(UserCredentialsDataService userCredentialsDataService) {
        this.userCredentialsDataService = userCredentialsDataService;
    }

    @Override
    public void createUser(UserCredentials userCredentials) {
        System.out.println("Creating service: " + userCredentials);
        if (getAllUserRecords().contains(userCredentials)) {
            System.err.println("Already exist");
            return;
        }

        userCredentialsDataService.addUserCredentials(userCredentials);
        System.out.println("User created");
    }

    @Override
    public void updateCredentials(UserCredentials userCredential) throws UserRecordsException {
        System.out.println("Updating username: " + userCredential);

        if (getAllUserRecords().contains(userCredential)) {
            UserRecordsException.throwError_NOTHING_TO_UPDATE();
            return;
        }

        //update database
        userCredentialsDataService.updateUserCredentials(userCredential);

        System.out.println("User updated");
    }

    @Override
    public void deleteUser(int employeeID) throws UserRecordsException {
        System.out.println("Deleting service: " + employeeID);

        UserCredentials userRecord = getUserRecord(employeeID);
        if (userRecord == null) {
            UserRecordsException.throwError_NO_RECORD_FOUND();
            return;
        }

        if (getAllUserRecords().contains(userRecord)) {
            //update database
            userCredentialsDataService.deleteUserCredentials_ByEmployeeID(String.valueOf(employeeID));
            System.out.println("User deleted");
        } else {
            UserRecordsException.throwError_NO_RECORD_FOUND();
        }
    }

    @Override
    public List<UserCredentials> getAllUserRecords() {
        try {
            return userCredentialsDataService.getAllUserCredentials();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public UserCredentials getUserRecord(int employeeID) {
        try {
            return userCredentialsDataService.getUserCredentials_ByEmployeeID(String.valueOf(employeeID));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}
